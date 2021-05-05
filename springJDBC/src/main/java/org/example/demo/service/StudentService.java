package org.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.example.demo.model.Student;

public interface StudentService {
	
	public Student createStudent(Student student) throws SQLException;
	public List<Student> getAllStudent() throws SQLException;
	public  void removeStudentById(int id) throws SQLException ;
	public Student updateStudent(Student student, int id)throws SQLException;



	}