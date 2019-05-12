/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations.view;

import javax.swing.JFrame;
import reservations.presenter.IView;
import reservations.presenter.ReservationsPresenter;

/**
 *
 * @author Prajal
 */
public class ReservationsView extends JFrame implements IView {

    private ReservationsPresenter presenter;
    //This is auto generated code from UI design
    // Variables declaration - do not modify                     
    private javax.swing.JButton allReservationBtn; //Used to get all reservations.
    private javax.swing.JButton bookBtn; // Used to book flight reservation
    private javax.swing.JLabel dateLabel; // Label for date
    private javax.swing.JTextField dateTextField; // Date text field
    private javax.swing.JLabel destinationLabel; // Destination label
    private javax.swing.JTextField destinationTextField; //Destination text field
    private javax.swing.JButton exitBtn; // Used for exit functinality.
    private javax.swing.JPanel inputPanel; // Panel that contains the input related components
    private javax.swing.JScrollPane jScrollPane1; // scroll panel for output text area
    private javax.swing.JTextArea outputTextArea; // output window text area
    private javax.swing.JLabel nameLabel; //Label for name
    private javax.swing.JTextField nameTextField; // Name text field
    private javax.swing.JPanel outputPanel; // Panel that contains the ouput related components
    private javax.swing.JLabel passangerLabel; // Label for passangers
    private javax.swing.JTextField passengersTextField2; // passanger left text field
    private javax.swing.JTextField passengersTextField1; // passanger right text field
    private javax.swing.JLabel phoneLabel; // Phone Label
    private javax.swing.JTextField phoneTextField; // Phone text field
    private javax.swing.JButton reservationBySizeBtn; // Reservation by size button
    private javax.swing.JButton totalPassOnFlightBtn; // Total Passangers on Flight button
    private javax.swing.JLabel inputLable; // Input label that indicate the input panel
    private javax.swing.JLabel outputLabel; // Output label taht indicate the output panel

    // End of variables declaration              
    public ReservationsView(ReservationsPresenter rp) {
        presenter = rp;

        //Below code are auto generated from UI designer.
        exitBtn = new javax.swing.JButton();
        inputPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        passangerLabel = new javax.swing.JLabel();
        destinationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        passengersTextField1 = new javax.swing.JTextField();
        destinationTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        passengersTextField2 = new javax.swing.JTextField();
        bookBtn = new javax.swing.JButton();
        reservationBySizeBtn = new javax.swing.JButton();
        totalPassOnFlightBtn = new javax.swing.JButton();
        allReservationBtn = new javax.swing.JButton();
        outputPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        inputLable = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        nameLabel.setText("Name");

        phoneLabel.setText("Phone");

        passangerLabel.setText("Passengers");

        destinationLabel.setText("Destination");

        dateLabel.setText("Date");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
                inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(destinationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(destinationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                        .addComponent(dateTextField))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addComponent(passangerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passengersTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(passengersTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(inputPanelLayout.createSequentialGroup()
                                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneTextField)
                                                        .addComponent(nameTextField)))))
        );
        inputPanelLayout.setVerticalGroup(
                inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneLabel)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passangerLabel)
                                        .addComponent(passengersTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passengersTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(destinationLabel)
                                        .addComponent(destinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(64, Short.MAX_VALUE))
        );

        bookBtn.setText("Book");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        reservationBySizeBtn.setText("Reservation By Size");
        reservationBySizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationBySizeBtnActionPerformed(evt);
            }
        });

        totalPassOnFlightBtn.setText("Total Passengers On Flight");
        totalPassOnFlightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPassOnFlightBtnActionPerformed(evt);
            }
        });

        allReservationBtn.setText("All Reservations");
        allReservationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allReservationBtnActionPerformed(evt);
            }
        });

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
                outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outputPanelLayout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        outputPanelLayout.setVerticalGroup(
                outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        inputLable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        inputLable.setText("Input");

        outputLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        outputLabel.setText("Output");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(reservationBySizeBtn)
                                                        .addComponent(totalPassOnFlightBtn)
                                                        .addComponent(allReservationBtn))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bookBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(exitBtn)
                                                .addGap(53, 53, 53))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inputLable)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(outputLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inputLable)
                                        .addComponent(outputLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(allReservationBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalPassOnFlightBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reservationBySizeBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookBtn)
                                        .addComponent(exitBtn))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        //End of Autogenerated code.
    }

    //Displaying the text to the ouput window.
    @Override
    public void display(String s) {
        outputTextArea.setText(s);
    }

    // This method perfom the reservation search when reservation by size button is clicked.
    private void reservationBySizeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (passengersTextField1.getText() != null && passengersTextField1.getText().trim().length() > 0 && passengersTextField2.getText() != null && passengersTextField2.getText().trim().length() > 0) {
            int no1 = Integer.parseInt(passengersTextField1.getText());
            int no2 = Integer.parseInt(passengersTextField2.getText());
            if (no1 <= no2) {
                presenter.reservationBySize(no1, no2);
            } else {
                //Error message
                outputTextArea.setText("Invalid Input!");
            }
        } else if (passengersTextField1.getText() != null && passengersTextField1.getText().trim().length() > 0) {
            passengersTextField2.setText(passengersTextField1.getText());
            int no1 = Integer.parseInt(passengersTextField1.getText());
            presenter.reservationBySize(no1, no1);

        } else if (passengersTextField2.getText() != null && passengersTextField2.getText().trim().length() > 0) {
            passengersTextField1.setText("0");
            int no2 = Integer.parseInt(passengersTextField2.getText());
            presenter.reservationBySize(0, no2);
        } else {
            //Error message
            outputTextArea.setText("No Values Specified");
        }
    }

    //Exit button event method to exit the application
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    //Fetch all reservation when all resercation button clicked
    private void allReservationBtnActionPerformed(java.awt.event.ActionEvent evt) {
        presenter.allReservations();
    }

    //Fetch total passangers on flight when total passanger on flight button clicked.
    private void totalPassOnFlightBtnActionPerformed(java.awt.event.ActionEvent evt) {
        //Destination and Date
        if (destinationTextField.getText() != null && destinationTextField.getText().trim().length() > 0
                && dateTextField.getText()
                != null && dateTextField.getText().trim().length() > 0) {
            presenter.totalPassengersOnFlight(destinationTextField.getText(), dateTextField.getText());
        } else {
            //Error message
            outputTextArea.setText("Please enter destination and date!");
        }
    }

// This method create reservation for the given data by user
    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {

        if (nameTextField.getText() != null && nameTextField.getText().trim().length() > 0
                && phoneTextField.getText() != null && phoneTextField.getText().trim().length() > 0
                && passengersTextField1.getText() != null && passengersTextField1.getText().trim().length() > 0
                && destinationTextField.getText() != null && destinationTextField.getText().trim().length() > 0
                && dateTextField.getText() != null && dateTextField.getText().trim().length() > 0) {
            if (isNumeric(passengersTextField1.getText())) {
                presenter.book(nameTextField.getText(), phoneTextField.getText(), Integer.valueOf(passengersTextField1.getText()), destinationTextField.getText(), dateTextField.getText());
                //Displaying success message
                outputTextArea.setText("Successfully Booked!");
            } else {
                //Error message 
                outputTextArea.setText("Please enter valid passengers in number!");
            }
        } else {
            //Error message 
            outputTextArea.setText("All fields are mandatory except right passenger input window!");
        }
    }

    //this method used to check the number in string
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
