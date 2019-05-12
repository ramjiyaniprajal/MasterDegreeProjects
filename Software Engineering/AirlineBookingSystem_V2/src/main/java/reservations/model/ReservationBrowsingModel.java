/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import reservations.controller.IBrowsingModel;
import reservations.controller.IQueries;

/**
 *
 * @author Prajal-Lenovo
 */
public class ReservationBrowsingModel extends Observable implements IBrowsingModel {

    IQueries iQueries; //Query object
    List<Reservation> reservations; //List of resercations
    Reservation current; // Indicate the current reservation object
    int index; //Current index of reservation
    int numberOfRecords; // Total number of resercation records

    //Parameterised Constructor to set query object and initialize the other objects
    public ReservationBrowsingModel(IQueries q) {
        super();
        iQueries = q;
        index = -1;
        numberOfRecords = 0;
        reservations = null;
        current = null;
    }

    //Handle call when All Reservations button is clicked
    @Override
    public void setAllReservations() {
        try {
            //getting all reservation from database
            reservations = iQueries.getAllReservations();
            setModelState();
        } catch (SQLException ex) {
            System.out.println("Error in setAllReservations ");
            ex.printStackTrace();
            //Closing system
             System.exit(1);
        }
    }

      //Handle call when Reservation by Size button is clicked
    @Override
    public void setReservationsBySize(int n1, int n2) {
        try {
// getting Reservations by given size
            reservations = iQueries.getReservationsBySize(n1, n2);
            //Set the current state to UI
            setModelState();
        } catch (SQLException ex) {
            System.out.println("Error in setReservationsBySize ");
            ex.printStackTrace();
            //Closing Application
            System.exit(1);
        }
    }

      //Handle call when Previous button is clicked
    @Override
    public void previous() {
        index--;
        // wrap around
        if (index < 0) {
            index = numberOfRecords - 1;
        }
        current = reservations.get(index);
        setChanged();
        //Notifying observaer class to update UI
        notifyObservers(new Update("Record "+(index+1)+ " of "+numberOfRecords, current));
    }

      //Handle call when Next button is clicked
    @Override
    public void next() {
        index++;
        // wrap around
        if (index >= numberOfRecords) {
            index = 0;
        }
        //Set current reservation
        current = reservations.get(index);
        setChanged();
        //Notify the observer class to update UI
         notifyObservers(new Update("Record "+(index+1)+ " of "+numberOfRecords, current));
    }

    //Set all the current object value to the Observer object
    private void setModelState() {
        numberOfRecords = reservations.size();
        if (numberOfRecords > 0) {
            index = 0;
            current = reservations.get(index);
        } else {
            index = -1;
            current = null;
        }
        setChanged();
        //Notifiying observer for change.
        notifyObservers(new Update("Record "+(index+1)+ " of "+numberOfRecords, current));
    }
}
