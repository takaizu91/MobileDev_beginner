class Student {
	//what is this instance variable??
	private int studentId;
	private float qualifyingExamMarks;
	private char residentialStatus;
	private int yearOfEngg;
	
	//the studentid to set
	public void setStudentId (int studentId) {
		this.studentId = studentId;
	}
	
	//return the studentid
	public int getStudentId() {
		return studentId;
	}
	
	//the qualifyingExamMarks
	public void setQualifyingExamMarks (float qualifyingExamMarks) {
		this.qualifyingExamMarks = qualifyingExamMarks;
	}
	
	//return the qualifyingExamMarks
	public float getQualifyingExamMarks() {
		return qualifyingExamMarks;
	}
	
	//the residentialStatus to set
	public void setResidentialStatus (char residentialStatus) {
		this.residentialStatus = residentialStatus;
	}
	
	//return the residentialStatus
	public char getResidentialStatus() {
		return residentialStatus;
	}
	
	//the yearOfEngg to set
	public void setYearOfEngg (int yearOfEngg) {
		this.yearOfEngg = yearOfEngg;
	}
	
	//return the yearOfEngg
	public int getYearOfEngg() {
		return yearOfEngg;
	}
}

public class Demo {

	public static void main(String[] args) {
		Student student = new Student();
		student.setStudentId(1001);
		student.setQualifyingExamMarks(95.0f);
		student.setResidentialStatus('D');
		student.setYearOfEngg(2);
		
		System.out.println("Student ID	                :	" + student.getStudentId());
		System.out.println("Qualifying Exam Marks		:	" + student.getQualifyingExamMarks());
		System.out.println("Residential Status	        :	" + student.getResidentialStatus());
		System.out.println("Year of Engineering	        :	" + student.getYearOfEngg());		
	}
}
