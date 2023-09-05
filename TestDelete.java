import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDelete {
	public static void main(String[] args) {
		
		
		
		
		
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		String sql = "DELETE FROM student WHERE id=5";
		
		//STEP 1 :Load/Register the driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	//STEP 2: Establish connection
	Connection connection = DriverManager.getConnection(url, username, password);
	
	//STEP 3: ESTABLISH THE STATEMENT
	Statement statement = connection.createStatement();
	
	//STEP 4: Execute the statement
	statement.execute(sql);
	
	//STEP 5: Close coonnection
	System.out.println("All Good");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
