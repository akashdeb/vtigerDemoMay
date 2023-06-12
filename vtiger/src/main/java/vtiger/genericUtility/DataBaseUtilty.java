package vtiger.genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtilty {
	
	Connection connection;
	public String fetchDataFromDataBase(String sqlQuerry, int cellNo) throws SQLException {
		
		
		ResultSet result = connection.createStatement().executeQuery(sqlQuerry);
		
		while(result.next()) {
			return result.getString(cellNo);
	}
		
		return "";
	}
	
	public void updateDataIntoDataBase(String sqlQuerry) throws SQLException {
		
		 Statement statement = connection.createStatement();
		 int result = statement.executeUpdate(sqlQuerry);
		if(result == 1) {
			System.out.println("The Data base has been updated");
		}
		
		else
			System.out.println("Data base has not been updated");
	}

	}

