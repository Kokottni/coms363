package stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyRecords {
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
		ResultSet resultSet = null;
		String change = "";
		try {
			stmt = connect.createStatement();
			String sql = "update students s set name='Scott' where s.ssn=746897816";
			stmt.executeUpdate(sql);
			change = "select * from project1.students;";
			resultSet = stmt.executeQuery(change);
			change = "";
			while(resultSet.next()) {
				change += resultSet.getInt("snum") + ", ";
				change += resultSet.getInt("ssn") + ", ";
				change += resultSet.getString("name") + ", ";
				change += resultSet.getString("gender") + ", ";
				change += resultSet.getString("dob") + ", ";
				change += resultSet.getString("c_addr") + ", ";
				change += resultSet.getString("c_phone") + ", ";
				change += resultSet.getString("p_addr") + ", ";
				change += resultSet.getString("p_phone") + "\n";
			}
			System.out.println(change + "\n");
			sql = "update major m, students s set m.name='Computer Science', m.level='MS' where m.snum=s.snum and s.ssn=746897816";
			stmt.executeUpdate(sql);
			change = "";
			change = "select * from project1.major;";
			resultSet = stmt.executeQuery(change);
			change = "";
			while(resultSet.next()) {
				change += resultSet.getInt("snum") + ", ";
				change += resultSet.getString("name") + ", ";
				change += resultSet.getString("level") + "\n";
			}
			System.out.println(change + "\n");
			sql = "delete from register where regtime='Spring2021'";
			stmt.executeUpdate(sql);
			change = "select * from project1.register;";
			resultSet = stmt.executeQuery(change);
			change = "";
			while(resultSet.next()) {
				change += resultSet.getInt("snum") + ", ";
				change += resultSet.getString("course_number") + ", ";
				change += resultSet.getString("regtime") + ", ";
				change += resultSet.getInt("grade") + "\n";
			}
			System.out.println(change + "\n");
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
