/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.presenter;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prajal
 */
public interface IQueries {
    //Add reservation to the system
   int addReservation(String name, String phone, int passangers, String destination, String date) throws SQLException;
   //Closing the connection object
   void close() throws SQLException;
   //Get all reservations
   List<Reservation> getAllReservations() throws SQLException;
  //Get total flight capacity
   int getFlightCapacity();
   //Get reservation by providing min and maximum passangers. 
   List<Reservation> getReservationsBySize(int n1, int n2) throws SQLException;
   //Get total passanges of given flight details
   int getTotalPassengersOnFlight(String destination, String date) throws SQLException;
   
}
