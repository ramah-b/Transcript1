package transcriptValidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class TranscriptDB {

	public boolean addTranscript(Course t,int Studentid){
		System.out.println("in addTranscript(_). studentid= "+Studentid);
		String sql = "insert into transcript " + "(coursenum,coursename,credits,grade,studentid)"+
	"Values (?,?,?,?,?)";
		try (Connection connection = getConnection();
				PreparedStatement ps = 
						connection.prepareStatement(sql))
						{
			ps.setString(1, t.getCourseNum());
			ps.setString(2, t.getCourseName());
			ps.setInt(3, t.getCredits());
			ps.setString(4, t.getGrade());
			ps.setInt(5, Studentid);
			
			ps.executeUpdate();
			return true;
						}
		catch(SQLException e)
		{
			System.err.println(e);
			return false;
		}
	}

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
	public ArrayList<Course> getCourses (int studentid) {
		ArrayList<Course> c_list = new ArrayList<Course>();
		String sql = "Select coursenum,coursename,credits,grade "+
		"from transcript where transcript.studentid = ?";
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
			ps.setInt(1,studentid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				
				while(rs.next())
			{
			String courseNum = rs.getString("coursenum");
			String courseName = rs.getString("coursename");
			int credits = rs.getInt("credits");
			String grade = rs.getString("grade");
			
			Course c = new Course(courseNum,credits,courseName,grade);
			c_list.add(c);
			}rs.close();
			return c_list;
			
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

