package com.example.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.example.exception.EmployeeNotFoundException;

import com.example.Factory.Connection_factory;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private List<Employee> employees;
	private Connection connection;
	
	{
		employees=new ArrayList<Employee>();
	}


	@Override
	public List<Employee> getAllEmployees()throws SQLException {
		// TODO Auto-generated method stub
		connection=Connection_factory.getMyConnection();
		ResultSet rs;
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from employee");
		while(resultset.next())
		{
			employees.add(new Employee(resultset.getInt("id"),resultset.getString("first_name"),resultset.getString("last_name")
					,resultset.getString("email"), resultset.getInt("salary"),resultset.getInt("bonus")));
		}
		return employees;
	}
	public Employee createEmployees(Employee employee)throws SQLException{
		connection=Connection_factory.getMyConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee(id,first_name,last_name,email,salary,bonus) values"
				+ "(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setInt(5, employee.getSalary());
		preparedStatement.setInt(6, employee.getBonus());
		preparedStatement.executeUpdate();
		return employee;
		
	}
	public  void removeEmployeeById(int id) throws SQLException, EmployeeNotFoundException {
		connection=Connection_factory.getMyConnection();
		StringBuilder sql;
		PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id =?");
		preparedStatement.setInt(1, id);
		int result=preparedStatement.executeUpdate();
		if(result<=0)
		{
			throw new EmployeeNotFoundException("no such record found with id: "+id);
		}
		System.out.println("record removed sucessfully.");


}

	public Employee updateEmployees(Employee employee,int id)throws SQLException{
		connection=Connection_factory.getMyConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update employee"
				+ " set first_name=?,last_name=?,email=?,salary=?,bonus=? "+" where id=?");
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.setInt(4, employee.getSalary());
		preparedStatement.setInt(5, employee.getBonus());
		preparedStatement.setInt(6, id);

		preparedStatement.executeUpdate();
		return employee;

	}

	}
