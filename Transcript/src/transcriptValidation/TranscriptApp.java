package transcriptValidation;

//import java.util.ArrayList;
import java.util.Scanner;

import transcriptValidation.Validator;
import transcriptValidation.Course;
import transcriptValidation.Student;

public class TranscriptApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		Student newStudent = new Student();
		StudentDB studentDB = new StudentDB();
		Course newCourse = new Course();
		TranscriptDB transcriptDB = new TranscriptDB();

		

		String name = Validator.getString(sc, "Enter your Name: ");
		System.out.println("*Welcome to the Transcript Application " + name
				+ "*\n");
		while (choice.equalsIgnoreCase("y")) {
			

			
			

			String student = Validator.getString(sc,
					"Enter the Students Name: ");
			newStudent.setStudent(student);
			
			

			// get the input from the user
			String courseNum = Validator.getString(sc, "Enter your Course #: ");
			newCourse.setCourseNum(courseNum);

			String courseName = Validator.getString(sc,
					"Enter your Course Name: ");
			newCourse.setCourseName(courseName);

			Integer credits = Validator.getInt(sc, "Enter your Credits: ");
			newCourse.setCredits(credits);

			String grade = Validator.getString(sc,
					"Enter the Students Letter Grade:");
			newCourse.setGrade(grade);
			
			
			
			newStudent.courses.add(newCourse);
			
			


			choice = Validator.getString(sc, "Another assignment? (y/n): ");
			System.out.println();

			

		}
		System.out.println("CLASS\t\tCREDITS\t\tGRADE");
		System.out.println("--------\t---------\t---------");
		
		newStudent.getOverallGPA();
		studentDB.addStudent(newStudent);
		
		newStudent= studentDB.getStudentByName(newStudent.getStudent());
		for (int i = 0 ;i< newStudent.courses.size(); i++)
		transcriptDB.addTranscript(newStudent.courses.get(i), newStudent.getStudentid());
		
		for (int j = 0; j < newStudent.courses.size(); j++) {
			Course c = newStudent.courses.get(j);
			
			System.out.println(c.getCourseName()+" "+c.getCourseNum()+"\t   "+c.getCredits()+"\t\t   "+c.getGrade());
			
		}
		System.out.println("Overall GPA: "+ newStudent.getGpa());
		
			
			
			}
}

