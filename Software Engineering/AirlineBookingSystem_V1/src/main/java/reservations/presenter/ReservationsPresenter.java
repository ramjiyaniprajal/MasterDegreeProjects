/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.presenter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prajal
 */
public class ReservationsPresenter {

    IQueries queries; //Iqueries Object
    IView view; //IView object

    //Initialize the queries oject using constructor
    public ReservationsPresenter(IQueries q) {
        queries = q;
    }

    //Binding the view with presentor.
    public void bind(IView v) {
        view = v;
    }

    //This method is used to display all reservations to output window.
    public void allReservations() {
        try {
            List<Reservation> results = new ArrayList<Reservation>();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            results = queries.getAllReservations();
            if (results != null && results.size() > 0) {
                for (Reservation rs : results) {
                    sb.append("<" + count + "," + rs.toString() + ">" + "\n");
                    count++;
                }
                view.display(sb.toString());
            } else {
                view.display("There is no Reservation!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //This method create reservation entry with given data.
    public void book(String name, String phone, int passangers, String destination, String date) {
        try {
            int result = queries.addReservation(name, phone, passangers, destination, date);
            if (result == 1) {
                view.display("Reservation Added!");
            } else {
                view.display("Error occured while adding Reservation!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Closing the database connection
    public void close() {
        try {
            queries.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //This method is used to display reservations by passenger size.
    public void reservationBySize(int n1, int n2) {
        try {
            List<Reservation> results = new ArrayList<Reservation>();
            StringBuilder sb = new StringBuilder();
            int count = 1;

            results = queries.getReservationsBySize(n1, n2);
            if (results != null && results.size() > 0) {
                for (Reservation rs : results) {
                    sb.append("<" + count + "," + rs.toString() + ">" + "\n");
                    count++;
                }
                view.display(sb.toString());
            } else {
                view.display("There is no Reservation exists with given input!");
            }
        } catch (SQLException ex) {
            System.out.println("Error occured while displaying reservations By Size. "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    //This method is used to display total number of passengers in Flight.
    public void totalPassengersOnFlight(String destination, String date) {
        try {
            int results = 0;
            results = queries.getTotalPassengersOnFlight(destination, date);
            view.display("Total no of Passangers on Flight is " + results);
        } catch (SQLException ex) {
            System.out.println("Error occured while displaying total passengers. "+ex.getMessage());
            ex.printStackTrace();
        }
    }

}
