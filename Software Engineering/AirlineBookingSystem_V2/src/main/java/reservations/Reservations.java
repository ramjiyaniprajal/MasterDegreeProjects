/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations;

import java.sql.SQLException;
import reservations.model.ReservationsQueries;
import reservations.controller.ReservationsController;
import reservations.model.ReservationBrowsingModel;
import reservations.view.ReservationsView;

/**
 *
 * @author Prajal
 */
public class Reservations {

    //This is main method to execute the program
    public static void main(String ar[]) {
        
        //ReservationsQuery object create
        ReservationsQueries rq = null;
        try {
            rq = new ReservationsQueries();
        } catch (SQLException ex) {
            //Exit System if system is not able to connect database.
            System.out.println("Error occured while loading ReservationQueries." + ex.getMessage());
            System.exit(1);
        }
        //Model class initializtion
        ReservationBrowsingModel model = new ReservationBrowsingModel(rq);

        //Reservation Controller initialization
        ReservationsController rc = new ReservationsController(model, rq);
        //Reservation View initialization
        ReservationsView rv = new ReservationsView(rc);
        //Add observer to model class
        model.addObserver(rv);
        rv.setVisible(true);
        rv.browsing(false);
        rc.bind(rv);

    }
}
