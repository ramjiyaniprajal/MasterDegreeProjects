package com.ebusiness.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ebusiness.ejb.CustomerEJB;
import com.ebusiness.ejb.OrderEJB;
import com.ebusiness.ejb.ProductEJB;
import com.ebusiness.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Prajal-Lenovo
 */
@Named(value = "orderController")
@ManagedBean
@RequestScoped
public class OrderController {

    @EJB
    private OrderEJB orderEJB; //Order EJB object
    @EJB
    private CustomerEJB customerEJB; //Customer EJB object
    @EJB
    private ProductEJB productEJB; //Product EJB object

    private Order order = new Order(); //Order Object to handle orders
    private List<Order> orderList = new ArrayList<Order>(); //List of Orders
    private int totalOrderCount = 0; //Total number of orders
    // ======================================
    // =           Public Methods           =
    // ======================================

    //This method is used to create an order
    public String doCreateOrder() {
        //Checking for avilable quantity
        if (order.getQuantity() <= order.getProduct().getStockNumber()) {
            //Update customer to maintain bidirectional
            customerEJB.updateOrder(order, order.getCustomer().getId());
            //Update product quantity to maintain bidirectional
            productEJB.updateProductQuantity(order.getProduct().getId(), order.getProduct().getStockNumber() - order.getQuantity());
            //Order creation
            order = orderEJB.createOrder(order);
            //get all orders
            orderList = orderEJB.findOrders();
            //set the total no of orders
            if (orderList != null) {
                totalOrderCount = orderList.size();
            }
            return "listOrders.xhtml";
        } else {
            //Show error when avilable quantity exceed
            return "orderErrorMessage.xhtml";
        }

    }

    //This method used to search an order
    public String doSearchOrder() {
        //Get the order list by given order id
        orderList = orderEJB.findById(order.getId());
        //set the order count
        if (orderList != null) {
            totalOrderCount = orderList.size();
        }
        return "searchOrder.xhtml";
    }

    //get the current order
    public Order getOrder() {
        return order;
    }

    //set the order
    public void setOrder(Order order) {
        this.order = order;
    }

    //This method return the list of all orders
    public List<Order> getOrderList() {
        return orderList;
    }

    //this method used to get order count
    public int getTotalOrders() {
        return totalOrderCount;
    }

    //this method is used to set all orders
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    //this method is used to set customer in current order
    public void setCustomer(int id) {
        order.setCustomer(customerEJB.findById(id));
    }

    //This method removed the order by given order id
    public String removeOrder(int id) {
        //get the order by order id
        Order deleteOrder = orderEJB.findById(id).get(0);
        //update the quanity of product
        productEJB.updateProductQuantity(deleteOrder.getProduct().getId(), deleteOrder.getProduct().getStockNumber() + deleteOrder.getQuantity());
        //Remove Order from customer
        customerEJB.removeOrder(deleteOrder, deleteOrder.getCustomer().getId());
        //load updated order list
        return onLoad();
    }

    //This method is used to load the all orders
    public String onLoad() {
        //getting orders
        orderList = orderEJB.findOrders();
        if (orderList != null) {
            //set the total order count
            totalOrderCount = orderList.size();
        }
        return "listOrders.xhtml";
    }

}
