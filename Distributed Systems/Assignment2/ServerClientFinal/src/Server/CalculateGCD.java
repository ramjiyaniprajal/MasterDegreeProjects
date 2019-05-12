package Server;

import java.io.Serializable;

import Client.Task;

public class CalculateGCD implements Task, Serializable {

	private static final long serialVersionUID = 6700320794449455221L;
	private long digit1 = 0; // Digit 1 for input
	private long digit2 = 0; // Digit 2 for input
	private String result = null; // Handle result object

	// Constructor to feed values.
	public CalculateGCD(long digit1, long digit2) {
		this.digit1 = digit1;
		this.digit2 = digit2;
	}

	// Method to perform GCD Task
	public long performGCDTask() {
		if (digit1 == 0)
			return digit2;
		else {
			while (digit2 != 0) {
				if (digit1 > digit2)
					digit1 = digit1 - digit2;
				else
					digit2 = digit2 - digit1;
			}
			return digit1;
		}
	}

	// This method is just for testing purpose.
	public static void main(String ar[]) {
		System.out.println(new CalculateGCD(48, 18).performGCDTask());
	}

	// Override executeTask method of Task class.
	@Override
	public void executeTask() {
		System.out.println("Performing a client task of CalculateGCD for " + digit1 + " and " + digit2);
		result = "The Greatest Common Divisor of "+ digit1 +" and "+digit2 +" is "+performGCDTask();

	}

	// Override getResult method of Task class.
	@Override
	public Object getResult() {
		return result;
	}

}
