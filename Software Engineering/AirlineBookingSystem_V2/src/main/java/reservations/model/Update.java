/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.model;

/**
 *
 * @author Prajal-Lenovo
 */
public class Update {

    private String message;// Used to display Message on text area
    private Reservation reservation; //Used to hanlde corrent Reservation object

    //parameterized constructor to feed the class
    public Update(String message, Reservation reservation) {
        this.message = message;
        this.reservation = reservation;
    }
    
    //below are getter methods to get values from this class
    public String getMessage() {
        return message;
    }

    public Reservation getReservation() {
        return reservation;
    }

}
