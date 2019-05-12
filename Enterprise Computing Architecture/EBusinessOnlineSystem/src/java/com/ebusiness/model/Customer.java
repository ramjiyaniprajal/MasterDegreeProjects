/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebusiness.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Prajal-Lenovo
 */
@Entity
//Named Queries
@NamedQueries({
    @NamedQuery(name = "Customer.findAllCustomers", query = "SELECT c FROM Customer c")
    ,
    @NamedQuery(name = "Customer.findById", query = "select c from Customer c where c.id = :id")
    ,
    @NamedQuery(name = "Customer.findByName", query = "select c from Customer c where UPPER(c.name) = :name")
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Customer id
    private String name; // Customer Name
    private String address; //Customer Address
    private long phone; //Customer mobile number
    private String email; //Customer Email address
    @OneToMany(cascade = ALL, mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<Order>(0); // the order(s) customer has made

    //Default constructor
    public Customer() {

    }

    //Parameterized constructor to feed the data
    public Customer(String name, String address, long phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.address);
        hash = 31 * hash + (int) (this.phone ^ (this.phone >>> 32));
        hash = 31 * hash + Objects.hashCode(this.email);
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
        final Customer other = (Customer) obj;
        if (this.phone != other.phone) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

}
