import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Import packages
public class OrderApplication extends JFrame implements ActionListener {
	private JLabel itemLable = null; // Item label
	private JComboBox pizzaTypeCombo = null; // Pizza type combo box
	private JComboBox pizzaSizeCombo = null; // Pizza side combo box
	private JComboBox drinkCombo = null; // Drink combo box
	private JTextArea displayTextArea = null; // Text area to display
	// message on screen.
	private JButton addDeliveryCostBtn = null; // Button for add delivery
	// cost.
	private JButton showTotalCostBtn = null; // Button to show total
	// cost.
	private JButton submitOrderBtn = null; // Button to Submit order
	// application.
	private JButton exitBtn = null; // Button to perform Exit.

	private final static List<String> PIZZA_TYPE_ITEMS = new ArrayList<String>(); // Indicate
	// the
	// Pizza
	// types
	private final static List<String> PIZZA_SIZE_ITEMS = new ArrayList<String>(); // Indicate
	// the
	// diffrent
	// size
	// of
	// pizza
	private final static List<String> DRINK_ITEMS = new ArrayList<String>(); // Indicate
	// the
	// Drinks

	private Order order = null;
	// Initialize values in static block. It will load only once in memory.
	static {
		PIZZA_TYPE_ITEMS.add("Select Pizza Type");
		PIZZA_TYPE_ITEMS.add("BBQ Meatlovers");
		PIZZA_TYPE_ITEMS.add("Chicken and Feta");
		PIZZA_TYPE_ITEMS.add("Hawaiian");
		PIZZA_TYPE_ITEMS.add("Vegorama");
		PIZZA_SIZE_ITEMS.add("Select Pizza Size");
		PIZZA_SIZE_ITEMS.add("Large");
		PIZZA_SIZE_ITEMS.add("Medium");
		PIZZA_SIZE_ITEMS.add("Small");
		DRINK_ITEMS.add("Select a Drink");
		DRINK_ITEMS.add("Juice");
		DRINK_ITEMS.add("Water");
		DRINK_ITEMS.add("Coke");
		DRINK_ITEMS.add("Fanta");

	}

	// default constructor.
	public OrderApplication() {
		super();
		order = new Order();
	}

	// Method to create a combo box component.
	private static JComboBox createCombo(List<String> items) {
		JComboBox comboBox = new JComboBox();
		// Adding items to combo box
		for (String item : items) {
			comboBox.addItem(item);
		}
		return comboBox;
	}

	// Method to create Button.
	private static JButton createButton(String label) {
		JButton button = new JButton(label);
		return button;
	}

	// Method to create a lablel
	private static JLabel createLabel(String label) {
		JLabel jLabel = new JLabel(label);
		return jLabel;
	}

	// This method is used to load the User Interface.
	private void loadApplication() {
		this.setTitle("Welcome to online Pizza Shop");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a label and add it to panel
		itemLable = createLabel("Please select item you would like to order: ");
		this.add(itemLable);

		// Create and add Pizza Type combo and add it to main panel
		pizzaTypeCombo = createCombo(PIZZA_TYPE_ITEMS);
		pizzaTypeCombo.addActionListener(this);
		this.add(pizzaTypeCombo);

		// Create a Pizza size combo and add it to main panel
		pizzaSizeCombo = createCombo(PIZZA_SIZE_ITEMS);
		pizzaSizeCombo.addActionListener(this);
		this.add(pizzaSizeCombo);

		// Create a Drink combo and add it to main panel
		drinkCombo = createCombo(DRINK_ITEMS);
		drinkCombo.addActionListener(this);
		this.add(drinkCombo);

		// Create an text area to display message and add it to main panel
		displayTextArea = new JTextArea("", 30, 80);
		displayTextArea.setEditable(false);
		this.add(displayTextArea);

		// Creating and adding Add Delivery Cost button to main panel
		addDeliveryCostBtn = createButton("Add Delivery Cost");
		addDeliveryCostBtn.addActionListener(this);
		this.add(addDeliveryCostBtn);

		// Creating and adding Show Total Cost button to main panel
		showTotalCostBtn = createButton("Show Total Cost");
		showTotalCostBtn.addActionListener(this);
		this.add(showTotalCostBtn);

		// Creating and adding Submit Order button to main panel
		submitOrderBtn = createButton("Submit Order");
		submitOrderBtn.addActionListener(this);
		this.add(submitOrderBtn);

		// Creating and adding Exit button to main panel
		exitBtn = createButton("Exit");
		exitBtn.addActionListener(this);
		this.add(exitBtn);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(new FlowLayout());
		this.setVisible(true);
	}

	// Main method to execute the program
	public static void main(String[] args) {

		//Creating object of OrderApplication
		OrderApplication orderApp = new OrderApplication();
		//Load the application.
		orderApp.loadApplication();
	}


	// This method performs actions according to events happen on UI.
	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == pizzaTypeCombo) {
			if (pizzaTypeCombo.getSelectedItem() != "Select Pizza Type")
				order.setPizzaType(pizzaTypeCombo.getSelectedItem().toString());
			else
				order.setPizzaType(null);
		} else if (ae.getSource() == pizzaSizeCombo) {
			if (pizzaSizeCombo.getSelectedItem() != "Select Pizza Size")
				order.setPizzaSize(pizzaSizeCombo.getSelectedItem().toString());
			else
				order.setPizzaSize(null);
		} else if (ae.getSource() == drinkCombo) {
			if (drinkCombo.getSelectedItem().toString() != "Select a Drink")
				order.setDrink(drinkCombo.getSelectedItem().toString());
			else
				order.setDrink(null);
		} else if (ae.getSource() == addDeliveryCostBtn) {
			if (order.calculateTotalCost() > 0) {
				if (!order.isDelivery())
					order.setDelivery(true);
				displayTextArea
						.setText("Delivery Cost($4) has been added. Plase press 'Submit Order' to complete your order.");
			} else {
				displayTextArea.setText("Please select atleast one item to deliver!");
			}
		} else if (ae.getSource() == showTotalCostBtn) {
			// Display the message to user about total calculated cost.
			if (order.calculateTotalCost() > 0) {
				displayTextArea.setText("Total cost to be paid by you is $" + order.calculateTotalCost());
			} else {
				displayTextArea.setText("Please select atleast one pizza or drink!");
			}
		} else if (ae.getSource() == submitOrderBtn) {

			// created String buffer to arrange display properly.
			if (order.calculateTotalCost() > 0) {
				StringBuffer sb = new StringBuffer();
				sb.append("\tYour Order has been placed. Here is your receipt:");
				sb.append("\n\n");
				sb.append("\t\tOnline Pizza Shop");
				sb.append("\n");
				sb.append("\t--------------------------------------------");
				sb.append("\n");
				if (order.getPizzaType() !=null && order.getPizzaType() != "Select Pizza Type"
						&& order.getPizzaSize()!= null && order.getPizzaSize() != "Select Pizza Size") {
					sb.append("\t"+order.getPizzaType() + " ");
					sb.append(order.getPizzaSize() + " ");
					sb.append("\t$" + order.getPizzaCost());
					sb.append("\n");
				}
				
				if (order.getDrink()!= null && order.getDrink() != "Select a Drink") {
					sb.append("\t"+order.getDrink());
					sb.append("\t\t$" + order.getDrinkCost());
					sb.append("\n");
				}
				
				if (order.isDelivery()) {
					sb.append("\tDelivery\t\t$" + order.getDeliveryCost());
					sb.append("\n");
				}
				
				sb.append("\tTotal Cost:\t\t$" + order.calculateTotalCost());
				sb.append("\n");
				sb.append("\t--------------------------------------------");
				sb.append("\n");
				sb.append("\tABN :92116388374");
				sb.append("\n\n");
				sb.append("\tThank you for shopping at the Online Pizza Shop!");

				// Set String value to text area.
				displayTextArea.setText(sb.toString());

			} else {
				// Validation message
				displayTextArea.setText("Please select atleast one item to place an Order!");
			}
		} else if(ae.getSource() == exitBtn){
			//Validation on Exit.
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "WARNING",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			    // yes option
				System.exit(0);
			} else {
			    // no option
			}
		}
	}
}