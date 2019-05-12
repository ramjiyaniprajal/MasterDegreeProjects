/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebusiness.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Prajal-Lenovo
 */
@Entity
//Named Queries
@NamedQueries({
    @NamedQuery(name = "Movie.findAllMovies", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m from Movie m where m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m from Movie m where UPPER(m.title) = :title")
})
public class Movie extends Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private String specialFeatures; //Sepecial features that Movie has
    private int duration; // total duration of movie

    //Default constructor
    public Movie() {
    }

    //Getter and Setter Methods
    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.specialFeatures);
        hash = 89 * hash + Objects.hashCode(this.duration);
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
        final Movie other = (Movie) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "specialFeatures=" + specialFeatures + ", duration=" + duration + '}';
    }

}
