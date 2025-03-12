package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Parent_Statement_API {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/JDBC_ConnectionDB?user=root&password=pass@word1";
		
		try {
			
			conn = DriverManager.getConnection(dbURL);
			
		    String sql = "Update employee set first_name=? where id=? ";
			
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1,"Poorni");
		    pstmt.setInt(2, 233);
		    
		    int rows = pstmt.executeUpdate();
		    
		    String selectSQL = "SELECT * from employee where id=?";
		    
		    pstmt = conn.prepareStatement(selectSQL);
		    pstmt.setInt(1, 233);
		    
		    rs = pstmt.executeQuery();
		    
		    System.out.println("ID\tFirst_name\tlast_name\tdesignation\n");
		    System.out.println("==================================================\n");
		    
		    
		    while(rs.next()) {
		    	System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) );
		    }
		    
		}
		catch( SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
