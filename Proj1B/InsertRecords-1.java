package stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecords {
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
			String sql = "insert into students values (1001,654651234,'Randy','M','2000-12-01','301 E Hall','5152700988','121 Main','7083066321')";
			stmt.executeUpdate(sql);
			sql = "insert into students values (1002,123097834,'Victor','M','2000-05-06','270 W Hall','5151234578','702 Walnut','7080366333')";
			stmt.executeUpdate(sql);
			sql = "insert into students values (1003,978012431,'Kevin','M','1999-07-08','201 W Hall','5154132805','888 University','5152012011')";
			stmt.executeUpdate(sql);
			sql = "insert into students values (1004,746897816,'Seth','M','1998-12-30','199 N Hall','5158891504','21 Green','5154132907')";
			stmt.executeUpdate(sql);
			sql = "insert into students values (1005,186032894,'Nicole','F','2001-04-01','178 S Hall','5158891155','13 Gray','5157162071')";
			stmt.executeUpdate(sql);
			sql = "insert into students values (1006,534218752,'Becky','F','2001-05-16','12 N Hall','5157083698','189 Clark','2034367632')";
			stmt.executeUpdate(sql);
			sql = "insert into students values (1007,432609519,'Kevin','M','2000-08-12','75 E Hall','5157082497','89 National','7182340772')";
			stmt.executeUpdate(sql);
			sql = "insert into departments values (401,'Computer Science','5152982801','LAS')";
			stmt.executeUpdate(sql);
			sql = "insert into departments values (402,'Mathematics','5152982802','LAS')";
			stmt.executeUpdate(sql);
			sql = "insert into departments values (403,'Chemical Engineering','5152982803','Engineering')";
			stmt.executeUpdate(sql);
			sql = "insert into departments values (404,'Landscape Architect','5152982804','Design')";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Computer Science','BS',401)";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Software Engineering','BS',401)";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Computer Science','MS',401)";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Computer Science','PhD',401)";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Applied Mathematics','MS',402)";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Chemical Engineering','BS',403)";
			stmt.executeUpdate(sql);
			sql = "insert into degrees values ('Landscape Architect','BS',404)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (113,'Spreadsheet','Microsoft Excel and Access',3,'Undergraduate',401)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (311,'Algorithm','Design and Analysis',3,'Undergraduate',401)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (531,'Theory of Computation','Theorem and Probability',3,'Graduate',401)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (363,'Database','Design Principle',3,'Undergraduate',401)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (412,'Water Management','Water Management',3,'Undergraduate',404)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (228,'Special Topics','Interesting Topics about CE',3,'Undergraduate',403)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (101,'Calculus','Limit and Derivative',4,'Undergraduate',402)";
			stmt.executeUpdate(sql);
			sql = "insert into courses values (102,'Calculus','Limit and Derivative',4,'Undergraduate',402)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1001,363,'Fall2020',3)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1002,311,'Fall2020',4)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1003,228,'Fall2020',4)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1004,363,'Spring2021',3)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1005,531,'Spring2021',4)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1006,363,'Fall2020',3)";
			stmt.executeUpdate(sql);
			sql = "insert into register values (1007,531,'Spring2021',4)";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1001,'Computer Science','BS')";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1002,'Software Engineering','BS')";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1003,'Chemical Engineering','BS')";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1004,'Landscape Architect','BS')";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1005,'Computer Science','MS')";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1006,'Applied Mathematics','MS')";
			stmt.executeUpdate(sql);
			sql = "insert into major values (1007,'Computer Science','PhD')";
			stmt.executeUpdate(sql);
			sql = "insert into minor values (1007,'Applied Mathematics','MS')";
			stmt.executeUpdate(sql);
			sql = "insert into minor values (1005,'Applied Mathematics','MS')";
			stmt.executeUpdate(sql);
			sql = "insert into minor values (1001,'Software Engineering','BS')";
			stmt.executeUpdate(sql);
			sql = "insert into minor values (1006,'Software Engineering','BS')";
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
