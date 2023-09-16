package com.khadri.spring.mvc.jdbc.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {
	public Connection createConnection() {
		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties properties = new Properties();
			properties.load(new FileReader(new File("E:\\khadri\\gitprojects\\A2022_Spring_MVC_LMS\\src\\main\\resources\\DB.properties")));

			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/2022batch_association", properties);
			
		} catch (SQLException sql) {
			System.out.println("Exception Occured " + sql.getMessage());
		} catch (FileNotFoundException fnfe) {
			System.out.println("Exception Occured " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Exception Occured " + ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Exception Occured " + cnfe.getMessage());
		}

		return con;

	}
}
