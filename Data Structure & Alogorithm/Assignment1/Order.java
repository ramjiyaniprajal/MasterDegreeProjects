import java.util.HashMap;

public class Order {
	// Indicate the Pizza Type
	private String pizzaType;
	// Indicate the Pizza Size
	private String pizzaSize;
	// Indicate the Drink
	private String drink;
	// Delivery information
	private boolean delivery = false;
	//To  maintain the item price list
	private final static HashMap<String, Double> ITEM_PRICE_MAP = new HashMap<String, Double>();
	// Constant to indicate delivery cost
	private final static int DELIVERY_COST = 4;
	
	// load Item price once when class is loaded in memory.
	static {
		ITEM_PRICE_MAP.put("BBQ Meatlovers", 7.00);
		ITEM_PRICE_MAP.put("Chicken and Feta", 6.50);
		ITEM_PRICE_MAP.put("Hawaiian", 6.90);
		ITEM_PRICE_MAP.put("Vegorama", 6.70);
		ITEM_PRICE_MAP.put("Juice", 2.50);
		ITEM_PRICE_MAP.put("Water", 1.00);
		ITEM_PRICE_MAP.put("Coke", 3.00);
		ITEM_PRICE_MAP.put("Fanta", 3.00);
		ITEM_PRICE_MAP.put("Large", 2.00);
		ITEM_PRICE_MAP.put("Medium", 1.00);
		ITEM_PRICE_MAP.put("Small", 0.00);
	}

	// Default constructor.
	public Order() {
	}

	// This Method calculate the total cost according to selected pizza and drink.
	public double calculateTotalCost() {
		double totalCost = 0.0;
		if (pizzaType != null && pizzaSize != null) {
			totalCost += getPizzaCost();
		}
		if (drink != null) {
			totalCost += getDrinkCost();
		}
		if (totalCost > 0) {
			totalCost += getDeliveryCost();
		}
		return totalCost;
	}

	// Calculate pizza cost according to its size and type.
	public double getPizzaCost() {
		return (ITEM_PRICE_MAP.get(pizzaType) + ITEM_PRICE_MAP.get(pizzaSize));
	}
	// Calculate the drink cost
	public double getDrinkCost() {
		return ITEM_PRICE_MAP.get(drink);
	}

	// Calculate the delivery cost
	public double getDeliveryCost() {
		return delivery ? DELIVERY_COST : 0.0;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public String getPizzaSize() {
		return pizzaSize;
	}

	public String getDrink() {
		return drink;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

}
