/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.controller;

/**
 *
 * @author Prajal
 */
public interface IView {
    //Display the output string into the output window.
    void display(String s);
    // Make component non-editable/editable while performing search operations.
    void browsing(boolean flag);
}
