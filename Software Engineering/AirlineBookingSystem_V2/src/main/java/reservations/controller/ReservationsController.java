/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.controller;

import java.sql.SQLException;

/**
 *
 * @author Prajal
 */
public class ReservationsController {

    IBrowsingModel model; //IBrowsingModel Object
    IQueries queries; //Iqueries Object
    IView view; //IView object

    //Initialize the queries oject using constructor
    public ReservationsController(IBrowsingModel bm, IQueries q) {
        model = bm;
        queries = q;
    }

    //Binding the view with presentor.
    public void bind(IView v) {
        view = v;
    }

    //handles call when All reservations is clicked
    public void allReservations() {
        //Enable Navigation Buttons
        view.browsing(true);
        model.setAllReservations();
    }

    //This method create reservation entry with given data.
    public void book(String name, String phone, int passengers, String destination, String date) {
        try {
            //Sops just for debug and error check
            System.out.println("FlightCapacity " + queries.getFlightCapacity());
            System.out.println("TotalPassengers " + queries.getTotalPassengersOnFlight(destination, date));
            System.out.println("Passengers " + passengers);
            //Condtion to check the availability of seats on that flight.
            if ((queries.getFlightCapacity() - queries.getTotalPassengersOnFlight(destination, date)) >= passengers) {
                //Adding reservation to the system
                int result = queries.addReservation(name, phone, passengers, destination, date);
                //show appropriate message according to the operation result
                if (result == 1) {
                    view.display("Reservation Added!");
                } else {
//Error message
                    view.display("Error occured while adding Reservation!");
                }
            } else {
                //Error message when desire seats are not available.
                view.display("Sorry insufficient seats available for booking!");
            }
 
        } catch (SQLException ex) {
            System.out.println("Error in Book()");
            ex.printStackTrace();
        }
    }

    //Closing the database connection
    public void close() {
        try {
            if (queries != null) {
                queries.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //This method is used to display reservations by passenger size.
    public void reservationBySize(int n1, int n2) {
        //Enable Navigation buttons
        view.browsing(true);
        model.setReservationsBySize(n1, n2);
    }

    //This method is used to display total number of passengers in Flight.
    public void totalPassengersOnFlight(String destination, String date) {
        int results = 0;
        try {
            //Disable Previous and Next button
            view.browsing(false);
            //Find the total passengers
            results = queries.getTotalPassengersOnFlight(destination, date);
            //Display result
            view.display("Total no of Passangers on Flight is " + results);
        } catch (SQLException ex) {
            System.out.println("Error occured while displaying total passengers. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //Method perform previous desired action
    public void previous() {
        model.previous();
    }
    //Method perform next desired action
    public void next() {
        model.next();
    }

}
