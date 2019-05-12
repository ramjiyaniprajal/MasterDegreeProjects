public class Grader {

	//Default constructor
	public Grader() {
	}
	
	// This method calculate the grade based on given mark.
	public String grade(int mark) {
		
		// Below conditions to check mark and return appropriate grade.
		if (mark > -1 && mark < 50) {
			return "F";
		} else if (mark > 49 && mark < 65) {
			return "P";
		} else if (mark > 64 && mark < 75) {
			return "C";
		} else if (mark > 74 && mark < 85) {
			return "D";
		} else if (mark > 84 && mark < 101) {
			return "HD";
		}
		return "N/A";
	}
	
    // This method Indicate the student is Pass or not based on given mark.
	public Boolean pass(int mark) {
		// Below condition to check Student pass or failed based on mark.
		if (mark >= 50 && mark <= 100) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}
