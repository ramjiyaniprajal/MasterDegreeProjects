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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Prajal-Lenovo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//Named Queries
@NamedQueries({
    @NamedQuery(name = "Product.findAllProduct", query = "SELECT p FROM Product p")
    ,
     @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p where p.id = :id")
    ,
    @NamedQuery(name = "Product.findByTitle", query = "select p from Product p where p.title = :title")
})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Auto generated product id
    @Column(nullable = false)
    private String title; // Product Title
    private String company; //Company name
    private String platform; //Platform on which Product is developed
    private String classification; //Classification details
    @Column(length = 2000)
    private String description; //Detail description of Product
    private double price; // Price of Product
    private long stockNumber; // Available stock
    @OneToMany(cascade = ALL, mappedBy = "product", orphanRemoval = true)
    private List<Order> orders = new ArrayList<Order>(0); //Associated orders with this product

    //Getter and setter methods
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //Default constructor
    public Product() {

    }

    //Parameterized counstructor to feed to data
    public Product(String title, String company, String platform, String classification, String description, double price, long stockNumber) {
        this.title = title;
        this.company = company;
        this.platform = platform;
        this.classification = classification;
        this.description = description;
        this.price = price;
        this.stockNumber = stockNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(long stockNumber) {
        this.stockNumber = stockNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.company);
        hash = 79 * hash + Objects.hashCode(this.platform);
        hash = 79 * hash + Objects.hashCode(this.classification);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 79 * hash + (int) (this.stockNumber ^ (this.stockNumber >>> 32));
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
        final Product other = (Product) obj;
        if (this.price != other.price) {
            return false;
        }
        if (this.stockNumber != other.stockNumber) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        if (!Objects.equals(this.classification, other.classification)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title=" + title + ", company=" + company + ", platform=" + platform + ", classification=" + classification + ", description=" + description + ", price=" + price + ", stockNumber=" + stockNumber + '}';
    }

}
