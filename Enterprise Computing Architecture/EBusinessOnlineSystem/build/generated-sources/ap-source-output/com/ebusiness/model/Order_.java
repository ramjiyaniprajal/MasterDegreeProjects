package com.ebusiness.model;

import com.ebusiness.model.Customer;
import com.ebusiness.model.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T20:39:47")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Product> product;
    public static volatile SingularAttribute<Order, Integer> quantity;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, Date> orderDate;
    public static volatile SingularAttribute<Order, Customer> customer;

}