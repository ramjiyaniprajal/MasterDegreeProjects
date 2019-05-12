/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.model;

import reservations.controller.IQueries;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * This class deal with database to store and retrieve the records.
 *
 * @author Prajal
 */
public class ReservationsQueries implements IQueries {

    //Connection related constatnts.
    private final String URL = "jdbc:derby://localhost:1527/AirlineBookingSystemDB";
    private final String PASSWORD = "sample";
    private final String USERNAME = "sample";

    //Connection object
    private Connection connection = null;
    //Default capacity of passangers for flight.
    private final int capacity = 20;

    //Prepared statement objects.
    private PreparedStatement insertReservation = null; // Prepared Stmt for insert reservation
    private PreparedStatement selectAllReservations = null; //Prepared stmt to select all reservations
    private PreparedStatement selectReservationBySize = null; //Prepared stmt to fetch reservation by size
    private PreparedStatement selectTotalPassengersOnFlight = null; //Prepared stmt to get total passangers on flight

    //Default constructor
    public ReservationsQueries() throws SQLException {
        //Creating connection
        connection
                = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // create query that selects all entries in the Reservations
        selectAllReservations
                = connection.prepareStatement("SELECT * FROM Reservations");

        // create query that selects entries with a specific passengers size
        selectReservationBySize = connection.prepareStatement(
                "select * from RESERVATIONS where passengers between ? and ?");

        // create insert that adds a new entry into the database
        insertReservation = connection.prepareStatement(
                "INSERT INTO Reservations "
                + "(LastName, Phone, Passengers, Destination,Dateofflight ) "
                + "VALUES ( ?, ?, ?, ? ,? )");

        //Create query that identify the total number of passanger in flight
        selectTotalPassengersOnFlight = connection.prepareStatement("select sum(PASSENGERS) AS count from RESERVATIONS where upper(Destination) = upper(?) AND Dateofflight = ?");

    }

    //This method used to create an reservation for passenger.
    @Override
    public int addReservation(String name, String phone, int passengers, String destination, String date) throws SQLException {
        int result = 0;

        // set parameters, then execute insertReservation
        insertReservation.setString(1, name);
        insertReservation.setString(2, phone);
        insertReservation.setInt(3, passengers);
        insertReservation.setString(4, destination);
        insertReservation.setString(5, date);

        // insert the new entry; returns # of rows updated
        result = insertReservation.executeUpdate();
        return result;
    }

    //This method used to close connection.
    @Override
    public void close() throws SQLException {
        if (connection != null) {
            //Clossing connection
            connection.close();
        }
    }

    //This method retrieves the all reservations.
    @Override
    public List<Reservation> getAllReservations() throws SQLException {
        List< Reservation> results = null;
        ResultSet resultSet = null;

        // executeQuery returns ResultSet containing matching all entries
        resultSet = selectAllReservations.executeQuery();
        results = new ArrayList< Reservation>();
        int n = 0;
        //Getting values from resultset
        while (resultSet.next()) {
            results.add(new Reservation(resultSet.getString("lastname"),
                    resultSet.getString("phone"),
                    resultSet.getInt("passengers"),
                    resultSet.getString("destination"),
                    resultSet.getString("dateofflight")));
        } // end while
       
        return results;
    }

    // Return the flight capacity.
    @Override
    public int getFlightCapacity() {
        return capacity;
    }

    //Filter reservations by given passenger size.
    @Override
    public List<Reservation> getReservationsBySize(int n1, int n2) throws SQLException {
        List< Reservation> results = null;
        ResultSet resultSet = null;

        //Feeding values to the prepared statement.
        selectReservationBySize.setInt(1, n1);
        selectReservationBySize.setInt(2, n2);
        // executeQuery returns ResultSet containing matching entries
        resultSet = selectReservationBySize.executeQuery();

        results = new ArrayList< Reservation>();
        int n = 0;
        //Getting values from result set
        while (resultSet.next()) {
            results.add(new Reservation(resultSet.getString("lastname"),
                    resultSet.getString("phone"),
                    resultSet.getInt("passengers"),
                    resultSet.getString("destination"),
                    resultSet.getString("dateofflight")));
        } // end while
        return results;
    }

    //this method is to get the total passengers by destination and date.
    @Override
    public int getTotalPassengersOnFlight(String destination, String date) throws SQLException {
        int results = 0;
        ResultSet resultSet = null;

        //Set parameter to the select query
        selectTotalPassengersOnFlight.setString(1, destination);
        selectTotalPassengersOnFlight.setString(2, date);
        //Execute the query
        resultSet = selectTotalPassengersOnFlight.executeQuery();

        //get the result from query
        if (resultSet.next()) {
            results = resultSet.getInt("count");
        }
        return results;
    }

}
