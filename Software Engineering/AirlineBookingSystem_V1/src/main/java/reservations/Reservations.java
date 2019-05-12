/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations;

import java.sql.SQLException;
import reservations.model.ReservationsQueries;
import reservations.presenter.ReservationsPresenter;
import reservations.view.ReservationsView;

/**
 *
 * @author Prajal
 */
public class Reservations {
    //This is main method to execute the program
    public static void main(String ar[]){
       
        ReservationsQueries rq = null;
        try {
            rq = new ReservationsQueries();
        } catch (SQLException ex) {
            System.out.println("Error occured while loading ReservationQueries." + ex.getMessage());
            System.exit(1);
        }
        ReservationsPresenter rp = new ReservationsPresenter(rq);
        ReservationsView rv = new ReservationsView(rp);
        rv.setVisible(true);
        rp.bind(rv);
        
    }
}
