public class Record {
	// this Class is POJO class with setter and getter methods.

	private String studentId;
	private int assignment;
	private int exam;
	private int total;
	private String grade;

	// parameterized constructor to feed value while creating objects
	public Record(String studentId, int assignment, int exam, int total, String grade) {
		super();
		this.studentId = studentId;
		this.assignment = assignment;
		this.exam = exam;
		this.total = total;
		this.grade = grade;
	}

	public String getStudentId() {
		return studentId;
	}

	public int getAssignment() {
		return assignment;
	}

	public int getExam() {
		return exam;
	}

	public int getTotal() {
		return total;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return studentId + "\t  " + assignment + "\t     " + exam + "\t   " + total + "\t" + grade;
	}

}
