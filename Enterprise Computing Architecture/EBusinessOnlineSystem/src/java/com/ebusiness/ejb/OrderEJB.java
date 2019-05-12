package com.ebusiness.ejb;

import com.ebusiness.model.Order;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class OrderEJB {

    @PersistenceContext(unitName = "EBusinessOnlineSystemPU")
    private EntityManager em; //EntityManger Object

    //This method used to find all orders
    public List<Order> findOrders() {
        TypedQuery<Order> query = em.createNamedQuery("Order.findAllOrders", Order.class);
        return query.getResultList();
    }

    //Create order object in database
    public Order createOrder(Order order) {
        //check order should not plaeced again
        if (!em.contains(order)) {
            order = em.merge(order);
        }
        em.merge(order);
        em.persist(order);
        return order;
    }

    //This method used to find the order by given id
    public List<Order> findById(long id) {
        TypedQuery<Order> query = em.createNamedQuery("Order.findById", Order.class);
        //set the id parameter
        query.setParameter("id", id);
        return query.getResultList();
    }

}
