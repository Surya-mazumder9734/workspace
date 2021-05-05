package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//step-1 Register The Driver
			DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
			//Step-2 Create Connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "pass@word1");
			//Step-3 Create A statement object
			Statement statement=connection.createStatement();
			//step-4 execute the query
			ResultSet resultSet=statement.executeQuery("select * from student");
			System.out.println("ID\tFIRST NAME\tLASTNAME\tEMAIL\t\tGPA");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("id")+"\t"+resultSet.getString("first_name")
				+"\t\t"+resultSet.getString("last_name")+"\t\t"+resultSet.getString("email")+
				"\t"+resultSet.getDouble("gpa"));
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
		
	}


