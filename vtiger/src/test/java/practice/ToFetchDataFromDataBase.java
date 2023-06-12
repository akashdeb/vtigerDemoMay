package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ToFetchDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		
		ResultSet result = connection.createStatement().executeQuery("select * from lead;");
		
		while(result.next()) {
			System.out.println("FirstName : "+result.getString(1));
			System.out.println("LastName : "+result.getString(2));
			
		}
		
		connection.close();

	}

}
