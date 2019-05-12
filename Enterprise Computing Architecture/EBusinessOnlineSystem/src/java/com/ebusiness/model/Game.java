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
    @NamedQuery(name = "Game.findAllGames", query = "SELECT g FROM Game g")
    ,
     @NamedQuery(name = "Game.findById", query = "SELECT g from Game g where g.id = :id")
    ,
    @NamedQuery(name = "Game.findByTitle", query = "SELECT g from Game g where UPPER(g.title) = :title")
})

public class Game extends Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private String hdVideoOutput; //Game support HD video outout.
    private long hardDriveSpace; // How much space requred to store/run game.
    private int noOfCoPlayers; // How many number of player can play the game at a time.

    //Default constructor
    public Game() {
    }

    
    //Getter and setter methods
    public String getHdVideoOutput() {
        return hdVideoOutput;
    }

    public void setHdVideoOutput(String hdVideoOutput) {
        this.hdVideoOutput = hdVideoOutput;
    }

    public long getHardDriveSpace() {
        return hardDriveSpace;
    }

    public void setHardDriveSpace(long hardDriveSpace) {
        this.hardDriveSpace = hardDriveSpace;
    }

    public int getNoOfCoPlayers() {
        return noOfCoPlayers;
    }

    public void setNoOfCoPlayers(int noOfCoPlayers) {
        this.noOfCoPlayers = noOfCoPlayers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.hdVideoOutput);
        hash = 11 * hash + (int) (this.hardDriveSpace ^ (this.hardDriveSpace >>> 32));
        hash = 11 * hash + this.noOfCoPlayers;
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
        final Game other = (Game) obj;
        if (this.hardDriveSpace != other.hardDriveSpace) {
            return false;
        }
        if (this.noOfCoPlayers != other.noOfCoPlayers) {
            return false;
        }
        if (!Objects.equals(this.hdVideoOutput, other.hdVideoOutput)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "hdVideoOutput=" + hdVideoOutput + ", hardDriveSpace=" + hardDriveSpace + ", noOfCoPlayers=" + noOfCoPlayers + '}';
    }

}
