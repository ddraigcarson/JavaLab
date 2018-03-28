package db;

import java.sql.*;

public class JDBC {

	public void makeConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(
					DatabaseProperties.CONNECTION.getValue(),
					DatabaseProperties.USER.getValue(),
					DatabaseProperties.PW.getValue()
					);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from task");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
