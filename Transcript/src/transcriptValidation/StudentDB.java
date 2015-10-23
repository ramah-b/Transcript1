package transcriptValidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class StudentDB {
	
private Connection getConnection() throws SQLException {
	
	Connection connection = null;

	// TODO Auto-generated method stub
	try{
	
	String url = "jdbc:oracle:thin:system/password@localhost"; 
      
    //properties for creating connection to Oracle database
    Properties props = new Properties();
    props.setProperty("user", "testuserdb");
    props.setProperty("password", "password");
  
    //creating connection to Oracle database using JDBC
    connection = DriverManager.getConnection(url,props);
    
    return connection;
	}
	catch(SQLException e)
	{
		System.err.println(e);
		return null;
	}
	}
	public Student getStudent(int studentid){
		
		String sql = "Select studentname,gpa from student where studentid = ?";
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
			ps.setInt(1, studentid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				
				
			
			String studentname = rs.getString("studentname");
			double gpa = rs.getDouble("gpa");
			
			
			Student st = new Student(studentname,gpa);
			TranscriptDB trDB = new TranscriptDB();
			trDB.getCourses(studentid);
			
			rs.close();
			return st;
			
			
			}
			else{
				rs.close();
				return null;
			}
			
				}
		catch(SQLException e){
			System.err.println(e);
			return null;
		}
	}
		public boolean addStudent(Student s){
			String sql = "insert into student(studentname)"+
		"Values (?)";
			try (Connection connection = getConnection();
					PreparedStatement ps = 
							connection.prepareStatement(sql))
							{
				ps.setString(1, s.getStudent());
				//ps.setDouble(2, s.getGpa());
				
				ps.executeUpdate();
	
				return true;
							}
			catch(SQLException e)
			{
				System.err.println(e);
				return false;
			}
		}

		public Student getStudentByName(String studentName){
			
			String sql = "Select * from student where studentname = ?";
			try(Connection connection = getConnection();
					PreparedStatement ps = connection.prepareStatement(sql))
					{
				ps.setString(1, studentName);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					
					
				
				int studentid = rs.getInt("studentid");
				String studentname= rs.getString("studentname");
				double gpa = rs.getDouble("gpa");
				
				TranscriptDB trDB = new TranscriptDB();
				ArrayList<Course> courses = trDB.getCourses(studentid);
				Student st = new Student();
				st.setStudentid(studentid);
				st.setGpa(gpa);
				st.setStudent(studentname);
			
				
				
				rs.close();
				return st;
				
				
				}
				else{
					rs.close();
					return null;
				}
				
					}
			catch(SQLException e){
				System.err.println(e);
				return null;
			}
		
	}
}

