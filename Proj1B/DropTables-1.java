package stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTables {
	private static Connection connect = null;
	
	public static void main(String[] args) {
		try {
			String userName = "coms363";
			String password = "password";
			String dbServer = "jdbc:mysql://localhost:3306/project1";
			connect = DriverManager.getConnection(dbServer, userName, password);
		
		}catch (Exception e) {
			
		}
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
			String sql = "DROP TABLE IF EXISTS register";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS major";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS minor";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS courses";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS degrees";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS students";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS departments";
			stmt.executeUpdate(sql);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if( connect != null) {
					connect.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
