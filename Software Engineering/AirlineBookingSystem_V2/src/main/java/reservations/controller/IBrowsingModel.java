/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.controller;

/**
 *
 * @author Prajal-Lenovo
 */
public interface IBrowsingModel {
//Set all reservations to view    
void setAllReservations();
//Set all reservations by given passanger size
void setReservationsBySize(int n1, int n2);
// operations when previous button clicked
void previous();
// operations when next button clicked
void next();


}
