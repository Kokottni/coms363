package stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
	private static Connection connect = null;

	public static void main(String[] args) {
		try {
			String userName = "coms363";
			String password = "password";
			String dbServer = "jdbc:mysql://localhost:3306/project1";
			connect = DriverManager.getConnection(dbServer, userName, password);

		} catch (Exception e) {
			System.out.println("Connection Failed\n" + e.getMessage());
		}
		Statement stmt = null;
		try {
			ResultSet resultSet = null;
			String output = "";

			System.out.println("Query 1: Calculate average grade for courses");
			
			String sql1 = "SELECT c.number, c.name, AVG(r.grade) AS avGrade FROM courses c JOIN register r ON c.number = r.course_number GROUP BY c.number, c.name";

			stmt = connect.createStatement();
			resultSet = stmt.executeQuery(sql1);

			while (resultSet.next()) {
				output += resultSet.getInt("number") + " ";
				output += resultSet.getString("name") + " ";
				output += "Average grade: " + resultSet.getDouble("avGrade") + "\n";
			}
			System.out.println(output);

			output = "";
			System.out.println("Q2");
			String sql2 = "SELECT COUNT(DISTINCT s.snum) AS num_female_students FROM students s WHERE s.snum IN (SELECT snum FROM major WHERE name IN ('Computer Science', 'Applied Mathematics') UNION SELECT snum FROM minor WHERE name IN ('Computer Science', 'Applied Mathematics')) AND s.gender = 'F'";

			stmt = connect.createStatement();
			resultSet = stmt.executeQuery(sql2);

			while (resultSet.next()) {
				output += "Number of female students: " + resultSet.getInt("num_female_students") + "\n";
			}
			System.out.println(output);
			
			output = "";
			System.out.println("Q3");
			
			String sql3 = "SELECT d.name FROM degrees d LEFT JOIN major m ON d.name = m.name AND d.level = m.level LEFT JOIN minor r ON d.name = r.name AND d.level = r.level LEFT JOIN students s ON m.snum = s.snum OR r.snum = s.snum GROUP BY d.name HAVING SUM(CASE WHEN s.gender = 'M' THEN 1 ELSE 0 END) > SUM(CASE WHEN s.gender = 'F' THEN 1 ELSE 0 END) OR SUM(CASE WHEN s.gender = 'F' THEN 1 ELSE 0 END) IS NULL;";
			stmt = connect.createStatement();
			resultSet = stmt.executeQuery(sql3);
			while (resultSet.next()) {
				output += resultSet.getString("name") + "\n";
			}
			System.out.println(output);

			output = "";
			System.out.println("Q4");
			
			String sql4 = "SELECT m.name AS degree_name, s.name AS student_name FROM major m JOIN students s ON s.snum = m.snum WHERE s.dob = (SELECT MIN(dob) FROM students);";


			stmt = connect.createStatement();
			resultSet = stmt.executeQuery(sql4);

			while (resultSet.next()) {
				output += resultSet.getString("degree_name") + "....";
				output += resultSet.getString("student_name");
			}
			System.out.println(output);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
