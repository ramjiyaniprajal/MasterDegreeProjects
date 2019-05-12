public class Marks {

	// Main method to execute the program
	public static void main(String ar[]) {
		// Creating an instance of GradeBook class
		GradeBook gradeBook = new GradeBook();
		// Creating an instance of view class and pass the object of gradBook.
		View view = new View(gradeBook);
		// calling commandLoop method to display program functions.
		view.commandLoop();
	}
}
