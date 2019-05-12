import java.util.Scanner;

public class Assignment1 {
	
	public static void main(String[] args) {
		int N = 10; //Number of Students
		int lowestMark = 100; // Indicate the lowest mark
		int highestMark = 0; // Indicate the highest mark
		int totalMarks = 0; // Indicate the total marks
		int passedCount = 0; // Passed Student count
		int failedCount = 0; // Failed Student count
		
		System.out.println("######## Welcome to the Grade System ############");
		//Creating the object of scanner to get input from Students
		Scanner scan = new Scanner(System.in);
		
		// Loop to feed N number of Student's Marks and calculate the required data.
		for (int i = 1; i <= N; i++) {
			int mark = 0;
			// Create an object of Grader to access the properties of it.
			Grader grader = new Grader();
			System.out.print("Mark of Student " + i + ":");
			// Getting mark as an input from Student.
			mark = scan.nextInt();
			// Calculating and display the grade of Student.
			System.out.println("Grade for Student " + i + ":" + grader.grade(mark));
			// Calculating lowest Mark
			if (mark < lowestMark) {
				lowestMark = mark;
			}
			// Calculating highest Mark.
			if (mark > highestMark) {
				highestMark = mark;
			}
			// Counting the passed and failed students.
			if (mark >= 50) {
				passedCount++;
			} else {
				failedCount++;
			}
			// Counting the total marks.
			totalMarks += mark;
		}
		
		// Closing the scanner Object.
		scan.close();
		
		System.out.println("----------------Summary-------------");
		// Displaying the Summary
		System.out.println("Lowest Mark:" + lowestMark);
		System.out.println("Highest Mark:" + highestMark);
		System.out.println("Average Mark:" + (totalMarks / N));
		System.out.println("Number passed:" + passedCount);
		System.out.println("Number failed:" + failedCount);
		System.out.println("Thanks for visiting!");
	}
}
