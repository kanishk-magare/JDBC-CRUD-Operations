
	import java.util.Scanner;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class TestSave {
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your id: ");
			String id = sc.nextLine();
			System.out.println("Enter your Name: ");
			String name = sc.nextLine();
			System.out.println("Enter your Email: ");
			String Email = sc.nextLine();
			String query = "INSERT INTO student (id, name, Email) VALUES ('" + id + "', '" + name + "', '" + Email + "')";
		
			
			
			String url = "jdbc:mysql://localhost:3306/javabatch";
			String username = "root";
			String password = "root";
			//String sql = "INSERT INTO student VALUES(1,'Kanishk','Kanishkmagare55@gmail.com')";
			
			//STEP 1 :Load/Register the driver
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
		//STEP 2: Establish connection
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//STEP 3: ESTABLISH THE STATEMENT
		Statement statement = connection.createStatement();
		
		//STEP 4: Execute the statement
		statement.execute(query);
	
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


