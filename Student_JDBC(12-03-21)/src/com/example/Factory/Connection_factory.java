package com.example.Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class Connection_factory {
	private static Connection connection;
	private Connection_factory() throws SQLException{
		Properties properties=new Properties();
		properties.setProperty("jdbc.url","jdbc:mysql://localhost:3306/hr");
		properties.setProperty("jdbc.user","root");
		properties.setProperty("jdbc.password","pass@word1");
		
		//step-1 register the driver
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		//step-2 Create connection
		connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.user"),properties.getProperty("jdbc.password"));

		
	}
	public static Connection getMyConnection() throws SQLException {
		
		if(connection==null)
		{
			new Connection_factory();
		}
	return connection;
	

}
}
