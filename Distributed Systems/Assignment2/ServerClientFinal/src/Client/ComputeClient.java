package Client;import java.io.IOException;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.net.Socket;import java.util.Scanner;import Server.CalculateGCD;import Server.CalculatePi;import Server.CalculatePrime;public class ComputeClient {	//Main method to start Computer Client	public static void main(String args[]) {		Socket socket = null; // Used to create socket connection		Scanner scan = null; // Used to get user inputs		try {			while (true) {				int serverPort = Integer.parseInt(args[1]); // defining server connection port				socket = new Socket(args[0], serverPort);				ObjectInputStream in = null;				ObjectOutputStream out = null;				out = new ObjectOutputStream(socket.getOutputStream());				in = new ObjectInputStream(socket.getInputStream());				int input = -1;				//Below Statements generate UI.				System.out.println("****************************************");				System.out.println("Calculate Pi...........................1");				System.out.println("Calculate Primes.......................2");				System.out.println("Calculate Greatest Common Divisor......3");				System.out.println("Exit...................................4");				System.out.println("****************************************");				System.out.println("\n\nEnter your Option:");				// Scan User input				scan = new Scanner(System.in);				input = scan.nextInt();				//Switch Case to handle user choice.				switch (input) {				case 1: //Calculate Pi					System.out.println("Enter the number of digits after the decimal point of Pi:");					input = scan.nextInt();					CalculatePi pi = new CalculatePi(input);					out.writeObject(pi);					Task piTask = (Task) in.readObject();					System.out.println(piTask.getResult());					break;				case 2: //Calculate Primes					System.out.println("Enter the number till whill prime numbers are calculated:");					input = scan.nextInt();					CalculatePrime prime = new CalculatePrime(input);					out.writeObject(prime);					Task primeTask = (Task) in.readObject();					System.out.println(primeTask.getResult());					break;				case 3: //Calculate Greatest Common Divisor					System.out.println("Enter the first Integer :");					int digit1 = scan.nextInt();					System.out.println("Enter the second Integer :");					int digit2 = scan.nextInt();					CalculateGCD gcd = new CalculateGCD(digit1, digit2);					out.writeObject(gcd);					Task gcdTask = (Task) in.readObject();					System.out.println(gcdTask.getResult());					break;				case 4: // Exit					System.exit(0);				default:					//Error Message for invalid input					System.out.println("Invalid Input!");				}				System.out.println("\n");							}		} catch (Exception e) {			e.printStackTrace();			System.out.println("Error while getting user input:"+e.getMessage());		} finally {			if (socket != null) {				try {					socket.close();				} catch (IOException e) {					System.out.println("close:" + e.getMessage());				}			}			if (scan != null) {				try {					scan.close();				} catch (Exception e) {					System.out.println("close:" + e.getMessage());				}			}		}	}}