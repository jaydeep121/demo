package com.thinkexam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.Reporter;

public class Database {
	private String db_host="jdbc:mysql://192.168.0.250:3306/yuwamclasses_prod_3mar";
	private String user_name="thinkexam";
	private String password="123456";
	private String[] resultSet= new String[10];
	
	public Database(){
		
	}
	public void connectDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Reporter.log("Driver is loaded",true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection conobj=DriverManager.getConnection(db_host,user_name,password);
			Reporter.log("Connection Established",true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Reporter.log("Connection Established",true);
        
	}
	
	
}
	
