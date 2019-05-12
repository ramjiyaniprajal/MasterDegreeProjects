package Server;

import java.io.Serializable;
import java.util.ArrayList;

import Client.Task;

public class CalculatePrime implements Task, Serializable {

	private static final long serialVersionUID = 5260685581382660364L;

	private int number = 0; // Used to limit the generation of prime numbers
	private String result = null; // Used to store the result

	// Constructor to feed value.
	public CalculatePrime(int number) {
		this.number = number;
	}

	// This method check the number is prime or not.
	private boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	// This method is generating prime numbers.
	public ArrayList<Integer> generatePrimeNumbers() {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i = 2; i <= number; i++) {
			if (isPrime(i))
				intList.add(i);
		}

		return intList;
	}

	// this method is just for testing purpose.
	public static void main(String args[]) {
		System.out.println(new CalculatePrime(55).generatePrimeNumbers());
		System.out.println(new CalculatePrime(55).generatePrimeNumbers().size());

	}

	// Override executeTask method of Task class.
	@Override
	public void executeTask() {
		System.out.println("Performing a client task of CalculatePrime - " + number);
		ArrayList<Integer> primeNoList = generatePrimeNumbers();
		result = "The number of primes is: " + primeNoList.size() + ", and they are: "
				+ primeNoList.toString().replace("[", "").replace("]", "");
	}

	// Override executeTask getResult of Task class.
	@Override
	public Object getResult() {
		return result;
	}
}
