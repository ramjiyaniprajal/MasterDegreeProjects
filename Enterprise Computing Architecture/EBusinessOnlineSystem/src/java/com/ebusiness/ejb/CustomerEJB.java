package com.ebusiness.ejb;

import com.ebusiness.model.Customer;
import com.ebusiness.model.Order;
import com.ebusiness.model.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerEJB {

    @PersistenceContext(unitName = "EBusinessOnlineSystemPU")
    private EntityManager em; //EnityManager object

    //This method used to find all customers that exists in database
    public List<Customer> findCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAllCustomers", Customer.class);
        return query.getResultList();
    }

    //This method save the customer to the database
    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }
//This method find the customers by given name

    public List<Customer> findByName(String name) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByName", Customer.class);
        //set the name parameter
        query.setParameter("name", name.toUpperCase());
        return query.getResultList();
    }
//This method find the customer by given customer id

    public Customer findById(long id) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findById", Customer.class);
        //set the id parameter
        query.setParameter("id", id);
        List<Customer> customers = query.getResultList();
        if (customers.isEmpty()) {
            return null;
        } else {
            return customers.get(0);
        }
    }

    //This method used to update the orders in customer
    public void updateOrder(Order order, long id) {
        //find the customer
        Customer customer = (Customer) em.find(Customer.class, id);
        //add order in customer
        customer.addOrder(order);

    }
    
     public void removeOrder(Order order,long id) {
       Customer customer = (Customer) em.find(Customer.class, id);
        //update product stock
        customer.getOrders().remove(order);
    }

}
