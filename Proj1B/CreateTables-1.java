package stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
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
			stmt.addBatch("create table students(\r\n"
					+ "	snum integer,\r\n"
					+ "    ssn integer,\r\n"
					+ "    name varchar(10),\r\n"
					+ "    gender varchar(1),\r\n"
					+ "    dob datetime,\r\n"
					+ "    c_addr varchar(20),\r\n"
					+ "    c_phone varchar(10),\r\n"
					+ "    p_addr varchar(20),\r\n"
					+ "    p_phone varchar(10),\r\n"
					+ "    primary key (ssn),\r\n"
					+ "    unique (snum)\r\n"
					+ "    );");
			stmt.addBatch("create table departments(\r\n"
					+ "	code integer,\r\n"
					+ "    name varchar(50),\r\n"
					+ "    phone varchar(10),\r\n"
					+ "    college varchar(20),\r\n"
					+ "    primary key (code),\r\n"
					+ "    unique (name)\r\n"
					+ "	);");
			stmt.addBatch("create table degrees(\r\n"
					+ "	name varchar(50),\r\n"
					+ "    level varchar(5),\r\n"
					+ "    department_code integer,\r\n"
					+ "    primary key (name, level),\r\n"
					+ "    foreign key (department_code) references departments(code)\r\n"
					+ "	);");
			stmt.addBatch("create table courses(\r\n"
					+ "	number integer,\r\n"
					+ "    name varchar(50),\r\n"
					+ "    description varchar(50),\r\n"
					+ "    credithours integer,\r\n"
					+ "    level varchar(20),\r\n"
					+ "    department_code integer,\r\n"
					+ "    primary key (number),\r\n"
					+ "    foreign key (department_code) references departments(code)\r\n"
					+ "	);");
			stmt.addBatch("create table register(\r\n"
					+ "	snum integer,\r\n"
					+ "    course_number integer,\r\n"
					+ "    regtime varchar(20),\r\n"
					+ "    grade integer,\r\n"
					+ "    primary key (snum, course_number),\r\n"
					+ "    foreign key (snum) references students(snum),\r\n"
					+ "    foreign key (course_number) references courses(number)\r\n"
					+ "	);");
			stmt.addBatch("create table major(\r\n"
					+ "	snum integer,\r\n"
					+ "    name varchar(50),\r\n"
					+ "    level varchar(5),\r\n"
					+ "    primary key (snum, name, level),\r\n"
					+ "    foreign key (snum) references students(snum),\r\n"
					+ "    foreign key (name, level) references degrees(name, level)\r\n"
					+ "	);");
			stmt.addBatch("create table minor(\r\n"
					+ "	snum integer,\r\n"
					+ "    name varchar(50),\r\n"
					+ "    level varchar(5),\r\n"
					+ "    primary key (snum, name, level),\r\n"
					+ "    foreign key (snum) references students(snum),\r\n"
					+ "    foreign key (name, level) references degrees(name, level)\r\n"
					+ "	);");
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
