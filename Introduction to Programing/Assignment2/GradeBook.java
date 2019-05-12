import java.util.ArrayList;
import java.util.List;

public class GradeBook {
	private Record[] gradeBook; // Record object declaration
	private int nrecords; // Indicate the number of records

	// Default constructor
	public GradeBook() {
		// Read the data from table once and load in memory
		loadFromTables();
		sortById();
	}

	// This method is used to find student record by given studentId
	public Record find(String id) {
		// go through all records and search student record for given student id
		for (int i = 0; i < gradeBook.length; i++) {
			// Compare the student id with records student id
			if (gradeBook[i].getStudentId().equalsIgnoreCase(id)) {
				return gradeBook[i];
			}
		}
		return null;
	}

	// Get list of student records which is filter by given mark range.
	public ArrayList<Record> find(int mark1, int mark2) {
		// Initialize the records
		ArrayList<Record> recordArrayList = new ArrayList<Record>();
		// go through all records and add records to the list which are in given
		// range
		for (int i = 0; i < gradeBook.length; i++) {
			if (gradeBook[i].getTotal() >= mark1 && gradeBook[i].getTotal() <= mark2) {
				recordArrayList.add(gradeBook[i]);
			}
		}
		return recordArrayList;
	}

	// Fetch the lowest mark from all student records
	public int lowestMark() {
		int lowestMark = 100;
		List<Integer> markList = getMarkList();
		if (markList != null) {
			for (Integer mark : markList) {
				if (mark < lowestMark) {
					lowestMark = mark;
				}
			}
		}
		return lowestMark;
	}

	// Fetch the highest mark from all student records
	public int highestMark() {
		int highestMark = 0;
		List<Integer> markList = getMarkList();
		if (markList != null) {
			for (Integer mark : markList) {
				if (mark > highestMark) {
					highestMark = mark;
				}
			}
		}
		return highestMark;
	}

	// Fetch the average mark from all student records
	public double averageMark() {
		int averageMark = 0;
		int totalMarks = 0;
		List<Integer> markList = getMarkList();
		for (Integer mark : markList) {
			totalMarks += mark;
		}
		if (totalMarks > 0)
			averageMark = totalMarks / nrecords;
		return averageMark;
	}

	// Sort the records in ascending order of studentId with using selection
	// sort algorithm
	private void sortById() {
		// Selection Sort : ascending order of StudentIds
		for (int i = 0; i < gradeBook.length - 1; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < gradeBook.length; ++j) {
				if (gradeBook[j].getStudentId().compareTo(gradeBook[minIndex].getStudentId()) < 0) {
					minIndex = j;
				}
			}
			Record tempRecord = gradeBook[i];
			gradeBook[i] = gradeBook[minIndex];
			gradeBook[minIndex] = tempRecord;
		}
	}

	// Feed value to the record object which includes Student Id, Assignment,
	// Exam data.
	private void loadFromTables() {
		String[] students = { "S10", "S20", "S30", "S40", "S50", "S60", "S08", "S18", "S28", "S38", "S48", "S58",
				"S06", "S16", "S26", "S36", "S46", "S56" };
		int[] assignment = { 0, 10, 20, 30, 30, 40, 0, 10, 20, 30, 30, 40, 0, 10, 20, 30, 30, 40 };
		int[] exam = { 0, 39, 44, 44, 54, 59, 1, 40, 45, 45, 55, 60, 2, 41, 46, 46, 56, 58 };

		nrecords = students.length;
		gradeBook = new Record[nrecords];
		for (int i = 0; i < nrecords; i++) {
			int totalMarks = assignment[i] + exam[i];
			String grade = calculateGrade(totalMarks);
			Record record = new Record(students[i], assignment[i], exam[i], totalMarks, grade);
			gradeBook[i] = record;
		}
	}

	// Calculate the grade based on given total marks
	private String calculateGrade(int total) {
		if (total == 0) {
			return "AF";
		} else if (total > 0 && total < 50) {
			return "F";
		} else if (total > 49 && total < 65) {
			return "P";
		} else if (total > 64 && total < 75) {
			return "C";
		} else if (total > 74 && total < 85) {
			return "D";
		} else if (total > 84 && total < 101) {
			return "HD";
		}
		return "N/A";
	}

	// get Mark list from records.
	private List<Integer> getMarkList() {
		List<Integer> markList = new ArrayList<Integer>();
		for (int i = 0; i < gradeBook.length; i++) {
			markList.add(gradeBook[i].getTotal());
		}
		return markList;
	}

}
