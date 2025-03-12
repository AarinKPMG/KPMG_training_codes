package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Operations {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rs = null ;
		
		String dbURL = "jdbc:mysql://localhost:3306/JDBC_ConnectionDB?user=root&password=pass@word1";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
//			String dropSQL = "DROP TABLE EMPLOYEE";
//			int i= stmt.executeUpdate(dropSQL);
//			
//			if( i==0 ) {
//				System.out.println("Employee table dropped");
//			}
//			else {
//				System.out.println("Employee table don\'t exist in JDBC_ConnectionDB database");
//			}
			
			int i=0 ;
//			
//			String createQuery = "create table employee("+
//					"ID int not null primary key ,"+
//					"first_name varchar(200) ,"+
//					"last_name varchar(200) ,"+
//					"designation varchar(200) "+
//					")";
//			
//			i = stmt.executeUpdate(createQuery);
//			System.out.println("Creation i value "+ i);
//			
//			if(i==0) System.out.println("Table Created successfully");
//			else System.out.println("Table not created");
//			
//			
//			String insertQuery = "insert into employee values ("+
//							     " 111,'Aarin','Sheik','SDE')";
//			
//			i = stmt.executeUpdate(insertQuery);
//			System.out.println("\ninsertion i value "+ i);
//			
//			if(i!=0) System.out.println("Row inserted successfully");
//			else System.out.println("Row insertion failed");
//			
//			conn.commit();
			
			String updateQuery = "update employee set designation='Graduate Analyst' "+
							     " where ID=111";
			
			i = stmt.executeUpdate(updateQuery);
			System.out.println("\nUpdated i value "+ i);
			
			if(i!=0) System.out.println("Row update successfully");
			else System.out.println("Row update failed");

			conn.commit();
			
			
			
			String selectQuery = "Select * from employee";
			rs = stmt.executeQuery(selectQuery);
			
			while(rs.next()) {
				System.out.println("\nID : "+rs.getInt(1));
				System.out.println("First Name : "+rs.getString(2));
				System.out.println("Last Name : "+rs.getString(3));
				System.out.println("Designation : "+rs.getString(4));
			}
			
		}
		catch( SQLException e) {
			e.printStackTrace();
		}
	}
	
}
