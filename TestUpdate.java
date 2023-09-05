import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		//String sql = "INSERT INTO student VALUES(14,'Kanishk','Kanishkmagare55@gmail.com')";
		//String sql = "DELETE FROM student WHERE id=1";
		String sql = "UPDATE student SET name='abc',email='abc2gmail.com' WHERE id=2";
		
		
		//STEP 1 :Load/Register the driver
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	//STEP 2: Establish connection
	 connection = DriverManager.getConnection(url, username, password);
	
	//STEP 3: ESTABLISH THE STATEMENT
	 Statement statement = connection.createStatement();
	//<----change to exexute.UPdate whn you want to update---->
	// <---------step4----------->
	 	int a = statement.executeUpdate(sql);
	if(a>0) {
		System.out.println("UPDATED");
	}else {
		System.out.println("NOT UPDATED");
	}
	//STEP 4: Execute the statement
	// <-----use change.execute() for delete and save----->
	//statement.execute(sql);
	
	
	
	//STEP 5: Close coonnection
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				System.out.println("All Good");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
}
