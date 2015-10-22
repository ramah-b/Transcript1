package transcriptValidation;

//import java.util.ArrayList;



public class Course {
	private String courseNum;
	private int credits;
	private String courseName;
	private String grade;
	
	
	public Course(String courseNum,int credits,String courseName,String grade){
		this.courseNum = courseNum;
		this.credits = credits;
		this.courseName = courseName;
		this.grade = grade;
		
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public String getCourseNum() {
		return courseNum;
		
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
		
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getQualityPoints(String grade) {
		double qltyPnt = 0.0;

		switch (grade) {
		case "A":
			qltyPnt = 4.0;
			break;
		case "B":
			qltyPnt = 3.0;
			break;
		case "C":
			qltyPnt = 2.0;
			break;
		case "D":
			qltyPnt = 1.0;
			break;
		case "F":
			qltyPnt = 0.0;
			break;
		}

		return qltyPnt;
	}

}
