package transcriptValidation;

import java.util.ArrayList;

public class Student {
	private String student;
	private String grade;
	
	public ArrayList<Course> courses = new ArrayList<Course>();
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

}
