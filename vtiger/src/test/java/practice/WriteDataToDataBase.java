package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class WriteDataToDataBase {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		
		int result = connection.createStatement().executeUpdate("insert into lead values('Prashant', 'Kumar', 'Jspiders');");
		
		if(result == 1) {
			System.out.println("The Data base has been updated");
		}
		
		else
			System.out.println("Data base has not been updated");
	}

}
