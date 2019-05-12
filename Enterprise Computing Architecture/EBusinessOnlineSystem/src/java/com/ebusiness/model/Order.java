/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebusiness.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Prajal-Lenovo
 */
@Entity
@Table(name = "CustomerOrder")
//Named Queries
@NamedQueries({
    @NamedQuery(name = "Order.findAllOrders", query = "SELECT o FROM Order o")
    ,
    @NamedQuery(name = "Order.findById", query = "SELECT o from Order o where o.id = :id")
    ,
    @NamedQuery(name = "Order.findById", query = "SELECT o from Order o where o.id = :id")
})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Order id

    @ManyToOne(optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer; //Customer accociated with order
    @ManyToOne(optional = false)
    private Product product; //Product that accociated with order
    private int quantity; //Quantity of product ordered

    private Date orderDate = new Date(); //Order creation time stemp

    //Default constructor
    public Order() {

    }

    //Parameterized constructor to feed data
    public Order(Customer custmer, Product product, int quantity) {
        this.customer = custmer;
        this.product = product;
        this.quantity = quantity;
    }

//Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer custmer) {
        this.customer = custmer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.customer);
        hash = 67 * hash + Objects.hashCode(this.product);
        hash = 67 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", custmer=" + customer + ", product=" + product + ", quantity=" + quantity + '}';
    }

}
