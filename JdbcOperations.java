import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcOperations {
	static String query;
	static int input;
	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose your Operation");
		System.out.println("Type 1 : Insert in Database");
		System.out.println("Type 2 : Delete from Database");
		System.out.println("Type 3 : Update in Database");
		System.out.println("Type 4 : GetAll from Database");
		System.out.println("Type 5 : Exit");
		 input = sc.nextInt();
		
		
	}
	
	
	
	
	public static void save() {
		Scanner sc = new Scanner(System.in);
		System.out.println("For saving in Database");
		System.out.println("Enter your id: ");
		String id = sc.nextLine();
		System.out.println("Enter your Name: ");
		String name = sc.nextLine();
		System.out.println("Enter your Email: ");
		String Email = sc.nextLine();
		 query = "INSERT INTO student (id, name, Email) VALUES ('" + id + "', '" + name + "', '" + Email + "')";
		 System.out.println("Saved");
	
	}
	
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("For Deleting From Database");
		System.out.println("Enter your id: ");
		String id = sc.nextLine();
		 query = "DELETE FROM student WHERE id=" + id;
		 System.out.println("Deleted");
	}
	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("For Updating Database");
		System.out.println("Enter your id: ");
		String id = sc.nextLine();
		System.out.println("Enter your Name: ");
		String name = sc.nextLine();
		System.out.println("Enter your Email: ");
		String email = sc.nextLine();
		 query = "UPDATE student SET name='"+name+"',email='"+email+"' WHERE id="+id;
		 System.out.println("Updated");

	}
	
	public static void getAll() {
		Scanner sc = new Scanner(System.in);
		System.out.println("For Showing From Database");
		 query= "SELECT * FROM student";
		 System.out.println("Done");
	}
	
	
	
	public static void main(String[] args) {
		
		menu();
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Choose your Operation");
//		System.out.println("Type 1 : Insert in Database");
//		System.out.println("Type 2 : Delete from Database");
//		System.out.println("Type 3 : Update in Database");
//		int input = sc.nextInt();
		
		
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
	if(input==1) {
		
		save();	
		statement.execute(query);
		menu();
	
	}else if(input==2) {
	
		delete();
		statement.execute(query);
		menu();
		
	}else if(input==3) {
	
		update();
		statement.execute(query);
		menu();		
	}else if(input==4){
		getAll();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println("======================");
		 }
		menu();
	}else if(input==5) {
		System.out.println("Bye...!");
	}
	
	
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
