/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.presenter;

/** This is POJO class for reservation.
 *
 * @author Prajal
 */
public class Reservation {

    private String date; // Indicate the reservation date
    private String destination; // indicate the destination
    private int id; // Id of reservation
    private String name; //Indicate person name 
    private int passangers; //Indicate the total no of passangers
    private String phone; // Indicate the phone number.

    //Constructor with fields to feed data.
    public Reservation(String name, String phone, int passangers, String destination, String date) {
        this.date = date;
        this.destination = destination;
        this.name = name;
        this.passangers = passangers;
        this.phone = phone;
    }

    //Below are getter methods.
    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPassangers() {
        return passangers;
    }

    public String getPhone() {
        return phone;
    }

    //To string menthod to display Reservation details.
    @Override
    public String toString() {
        return name+","+phone+","+passangers+","+destination+","+date;
    }

}
