import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Empolyee {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		String emp = "INSERT INTO student VALUES(6,'Kanishk','Kanishkmagare55@gmail.com')";
		
		//STEP 1 :Load/Register the driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	//STEP 2: Establish connection
	Connection connection = DriverManager.getConnection(url, username, password);
	
	//STEP 3: ESTABLISH THE STATEMENT
	Statement statement = connection.createStatement();
	
	//STEP 4: Execute the statement
	statement.execute(emp);
	
	//STEP 5: Close coonnection
	connection.close();
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
