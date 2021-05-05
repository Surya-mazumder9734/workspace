
package com.example.service;
import java.sql.SQLException;
import java.util.List;
import com.example.model.*;

public interface StudentService  {
	public List<Student> getAllStudent() throws SQLException;
}
