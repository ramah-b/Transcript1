package transcriptValidation;

import java.util.ArrayList;

public class Student {
	private String student;
	private double gpa;
	
	ArrayList<Course> courses = new ArrayList<Course>();
	
	public Student(String studentname, double gpa2) {
		// TODO Auto-generated constructor stub
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	public double getOverallGPA(){
		double gpa = 0.0;
		int totalCredits = 0; 
		for (int i = 0; i < courses.size(); i++){
			totalCredits += courses.get(i).getCredits();
			gpa += courses.get(i).getCredits() * courses.get(i).getQualityPoints(courses.get(i).getGrade());
		}
		gpa = gpa / totalCredits;
		return gpa;
	}
}
