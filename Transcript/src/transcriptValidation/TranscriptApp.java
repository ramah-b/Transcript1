package transcriptValidation;

import java.util.ArrayList;
import java.util.Scanner;

import transcriptValidation.Validator;
import transcriptValidation.Course;
import transcriptValidation.Student;

public class TranscriptApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		Course c = new Course();
		
		ArrayList<Course> courses = new ArrayList<Course>();

		

		String name = Validator.getString(sc, "Enter your Name: ");
		System.out.println("*Welcome to the Transcript Application " + name
				+ "*\n");
		while (choice.equalsIgnoreCase("y")) {
			

			Course newCourse = new Course();
			Student newStudent = new Student();

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
			newStudent.setGrade(grade);

			newCourse.students.add(newStudent);
			courses.add(newCourse);
			


			choice = Validator.getString(sc, "Another assignment? (y/n): ");
			System.out.println();

			

		}
		System.out.println("CLASS\t\tCREDITS\t\tGRADE");
		System.out.println("--------\t---------\t---------");
		
		for (int j = 0; j < courses.size(); j++) {
			c = courses.get(j);
			
			System.out.println(c.getCourseName()+" "+c.getCourseNum()+"\t   "+c.getCredits()+"\t\t   "+c.students.get(0).getGrade());
		}
		
			
			
			}
	public static double gpa(String grade){
		switch(grade){
		case "A":return 4.0;
		case "B":return 3.0;
		case "C":return 2.0;
		case "D":return 1.0;
		case "F":return 0.0;
		default:return 0.0;
		
		}
	
		
			
		}
	
	}

		

	




// 
			// System.out.println(c.getCourseNum());
