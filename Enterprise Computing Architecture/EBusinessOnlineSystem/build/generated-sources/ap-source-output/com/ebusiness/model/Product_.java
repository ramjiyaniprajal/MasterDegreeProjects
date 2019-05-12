package com.ebusiness.model;

import com.ebusiness.model.Order;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T20:39:47")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Long> stockNumber;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, String> company;
    public static volatile ListAttribute<Product, Order> orders;
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SingularAttribute<Product, String> title;
    public static volatile SingularAttribute<Product, String> classification;
    public static volatile SingularAttribute<Product, String> platform;

}