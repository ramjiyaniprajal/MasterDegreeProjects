package com.ebusiness.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ebusiness.ejb.CustomerEJB;
import com.ebusiness.model.Customer;
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
@Named(value = "customerController")
@ManagedBean
@RequestScoped
public class CustomerController {

    @EJB
    private CustomerEJB customerEJB; //Customer EJB Object
    private Customer customer = new Customer(); //Customer Object
    private List<Customer> customerList = new ArrayList<Customer>(); //Customer list to store the customers
    private int totalCustomerCount = 0; //Used to handle the customer total no of customer.

    // ======================================
    // =           Public Methods           =
    // ======================================
    //This method used to create Customer
    public String doCreateCustomer() {
        //Creating customer object
        customer = customerEJB.createCustomer(customer);
        //get all customers
        getAllCustomers();
        return "listCustomers.xhtml";
    }

    //This method used to search customer(s) by name
    public String doSearchCustomer() {
        //Finding customer(s) by name
        customerList = customerEJB.findByName(customer.getName());
        if (customerList != null) {
            //get the total number of customer
            totalCustomerCount = customerList.size();
        }
        return "searchCustomer.xhtml";
    }

    //This method used to retrive Customer
    public Customer getCustomer() {
        return customer;
    }

    //This method used to set customer
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //This method is used to get allcustomer list object
    public List<Customer> getCustomerList() {
        return customerList;
    }

    //This method used to load all customers in to customer list object
    public List<Customer> getAllCustomers() {
        //get all customers
        customerList = customerEJB.findCustomers();
        if (customerList != null) {
            // set the customer total count
            totalCustomerCount = customerList.size();
        }
        return customerList;
    }

    //This method used to retrive the customer total count
    public int getTotalCustomers() {
        return totalCustomerCount;
    }

    //This method used to get total number of orders he/she made.
    public int getTotalNoOfOrders() {
        if (customer != null && customer.getOrders() != null) {
            return customer.getOrders().size();
        } else {
            return 0;
        }
    }

    //This method used to set customer list object
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    //This method load the all customer when page is load
    public String onLoad() {
        getAllCustomers();
        return "listCustomers.xhtml";
    }
    
// This method used to navigate to customer detail page.
    public String showCustomerDetailsPage(long id) {
        return "customerDetails.xhtml?customerId=" + id;
    }

    //Update customer object by given customer Id
    public void customerById(long customerid) {
        //Getting Customer object
        customer = customerEJB.findById(customerid);
    }

}
