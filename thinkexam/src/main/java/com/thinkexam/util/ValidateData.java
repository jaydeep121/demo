package com.thinkexam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.thinkexam.base.TestBase;
public class ValidateData extends TestBase {
	@Test
	public void testData() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Reporter.log("Driver is loaded",true);
				//Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.250:3306/yuwamclasses_prod_3mar", "thinkexam","123456");
				Connection con=DriverManager.getConnection(prop.getProperty("dbhost"),prop.getProperty("root"),prop.getProperty("dbpassword"));
				Reporter.log("Connection Established",true);
				Statement st = con.createStatement();	
				ResultSet rs=st.executeQuery("SELECT * FROM RESULT_EXAMINATION where test_id=33");
				System.out.println(rs);
				while(rs.next()) {
					String totalMarks=rs.getString("TOTAL_MARKS");
					Reporter.log("Student Total Marks is : "+totalMarks,true);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
