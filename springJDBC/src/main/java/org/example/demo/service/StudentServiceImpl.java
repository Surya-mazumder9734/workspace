package org.example.demo.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.example.demo.model.Student;


public class StudentServiceImpl implements StudentService {
	
	private List<Student> student;

	private DataSource dataSource;
	

	public StudentServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public StudentServiceImpl() {

	}


	@Override
	public Student createStudent(Student student) throws SQLException {
		
		Connection connection=dataSource.getConnection();
		PreparedStatement pStatement=connection.prepareStatement("insert into student(id,first_name,last_name,email)"
				+ "values(?,?,?,?)");
		pStatement.setInt(1, student.getId());
		pStatement.setString(2, student.getFirstName());
		pStatement.setString(3, student.getLastName());
		pStatement.setString(4, student.getEmail());
		pStatement.executeUpdate();
		return student;
	}
	@Override
	public List<Student> getAllStudent() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=dataSource.getConnection();

			ResultSet rs;
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from student");
		while(resultset.next())
		{
			student.add(new Student(resultset.getInt("id"),resultset.getString("first_name"),resultset.getString("last_name")
					,resultset.getString("email")));
		}
		return student;
	

}
	public  void removeStudentById(int id) throws SQLException {
		Connection connection=dataSource.getConnection();

		StringBuilder sql;
		PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id =?");
		preparedStatement.setInt(1, id);
		int result=preparedStatement.executeUpdate();
		if(result<=0)
		{
			throw new SQLException();
		}
		System.out.println("record removed sucessfully.");


}
	public Student updateStudent(Student student, int id)throws SQLException{
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update student"
				+ " set first_name=?,last_name=?,email=?,salary=?,bonus=? "+" where id=?");
		preparedStatement.setString(1, student.getFirstName());
		preparedStatement.setString(2, student.getLastName());
		preparedStatement.setString(3, student.getEmail());
		preparedStatement.setInt(6, id);

		preparedStatement.executeUpdate();
		return student;

	}

	
	
}
