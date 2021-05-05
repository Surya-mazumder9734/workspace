package com.example.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import com.example.model.*;
import com.example.Factory.*;

public class StudentServiceImpl implements StudentService {
	private List<Student> student;
	
private Connection connection;
	
	{
		student=new ArrayList<Student>();
	}

	@Override
	public List<Student> getAllStudent() throws SQLException {
		// TODO Auto-generated method stub
		connection=Connection_factory.getMyConnection();

		connection=Connection_factory.getMyConnection();
		ResultSet rs;
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from student");
		while(resultset.next())
		{
			student.add(new Student(resultset.getInt("id"),resultset.getString("first_name"),resultset.getString("last_name")
					,resultset.getString("email"), resultset.getDouble("gpa")));
		}
		return student;
	}
	public Student createStudent(Student student)throws SQLException{
		connection=Connection_factory.getMyConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into student(id,first_name,last_name,email,gpa) values"
				+ "(?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getFirstName());
		preparedStatement.setString(3, student.getLastName());
		preparedStatement.setString(4, student.getEmail());
		preparedStatement.setDouble(5, student.getGpa());
		preparedStatement.executeUpdate();
		return student;
		
	}

}
