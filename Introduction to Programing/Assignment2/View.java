import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

	private Scanner scan = null; // Scanner object create
	private GradeBook gradeBook = new GradeBook(); // Grade book object
													// initialization

	// Constructor
	public View(GradeBook gb) {
		gradeBook = gb;
	}

	// This method generate the UI and allow user to select respective function.
	void commandLoop() {
		System.out
				.println("--------------------------------------------------------------------------------------------");
		System.out.println("1.	Display the record for a specified student");
		System.out.println("2.	Display records for all students with total marks within a specified range.");
		System.out.println("3.	Display the minimum, maximum and average total marks");
		System.out.println("4.	Exit the application");
		System.out
				.println("--------------------------------------------------------------------------------------------");
		System.out.println("Enter your choice :");

		scan = new Scanner(System.in);
		int choice = 0;
		try {
			// get user input to operate the application.
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				// get StudentId from user
				System.out.print("Please Enter the StudentId:");
				Record record = gradeBook.find(scan.next());
				// Displaying record if record is available for student
				if (record != null) {
					System.out.println("StudentId Assignment Exam Total Grade");
					System.out.println(record);
				} else {
					// Error Message when no student exists with given student
					// id
					System.out.print("There is no Student Exists with given Student id!");
				}
				// Clear screen to make display clean
				clearScreen();
				// Back to main screen
				commandLoop();
				break;
			case 2:
				// getting minimum and maximum total mark rage from user
				System.out.print("Please Enter Start Range:");
				int startRange = scan.nextInt();
				System.out.print("Please Enter End Range:");
				int endRange = scan.nextInt();
				if (startRange > endRange) {
					// Error Message for Invalid Input
					System.out.println("End Range should not be less than Start Range!");
				} else if (startRange >= 0 && startRange <= 100 && endRange >= 0 && endRange <= 100) {
					// To get all student with above given range and get it
					// stored
					// in ArrayList object
					ArrayList<Record> recordArrayList = gradeBook.find(startRange, endRange);
					// Displaying search result
					if (recordArrayList != null && !recordArrayList.isEmpty()) {
						System.out.println("StudentId Assignment Exam Total Grade");
						for (Record rec : recordArrayList) {
							System.out.println(rec.getStudentId() + "\t  " + rec.getAssignment() + "\t     "
									+ rec.getExam() + "\t   " + rec.getTotal() + "\t" + rec.getGrade());
						}
					} else {
						// Error message when no student exists in given range
						// of
						// marks
						System.out.print("There is no Student Exists with given range of marks!");
					}
				} else {
					// Error Message for Invalid input.
					System.out.println("Please Enter valid input for Start and End Range! It should be between 0-100");
				}

				// Clear screen to make display clean
				clearScreen();
				// Back to main screen
				commandLoop();
				break;
			case 3:
				// To calculate the Minimum Marks
				System.out.println("Minimum Marks : " + gradeBook.lowestMark());
				// To calculate the Maximum Marks
				System.out.println("Maximum Marks : " + gradeBook.highestMark());
				// To calculate the Average Marks
				System.out.println("Average Marks : " + gradeBook.averageMark());
				// Clear screen to make display clean
				clearScreen();
				// Back to main screen
				commandLoop();
				break;
			case 4:
				// Exiting program
				System.exit(0);
				break;
			default:
				// display message when user make wrong choice
				System.out.println("Please make a good choice!");
				// Clear screen to make display clean
				clearScreen();
				// Back to main screen
				commandLoop();
			}
		} catch (Exception e) {
			System.out.println("Error occured while executing commandLoop method! " + e.getMessage());
			e.printStackTrace();
		}
	}

	// This method is used to clear console again to look system good.
	private void clearScreen() throws InterruptedException, IOException {
		System.out.println();
		System.out.println("Press any key to continue . . . ");
		System.in.read();
		// Clear cmd console
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}
