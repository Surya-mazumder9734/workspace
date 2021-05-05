package org.example.demo;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.demo.model.Student;
import org.example.demo.service.StudentService;
import org.example.demo.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class App 
{
	private static Scanner scanner=new Scanner(System.in);

	public static void main( String[] args ) throws SQLException {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");


		StudentService service = context.getBean("studentService", StudentServiceImpl.class);
		int choice = 0;
		do {
			System.out.println("1.Create An Student.");
			System.out.println("2.Display All Students.");
			System.out.println("3.Remove  Students by ID");
			System.out.println("4.Update  Students by ID");
			System.out.println("5.Find   Students by ID");

			System.out.println("0.Exit.");
			System.out.print("Enter Your Choice. ");
			choice = scanner.nextInt();
			switch (choice) {
				case 1:
					try {
						System.out.print("ID: ");
						int id = scanner.nextInt();
						System.out.println("First Name: ");
						String fName = scanner.next();
						System.out.println("last Name: ");
						String lName = scanner.next();
						System.out.println("Email: ");
						String email = scanner.next();
						Student student = service.createStudent(new Student(id, fName, lName, email));
						System.out.println("Student Created Sucessfully..." + student);


					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						List<Student> students = service.getAllStudent();
						for (Student s : students) {
							System.out.println(s);
						}
					} catch (SQLException throwables) {
						throwables.printStackTrace();
					}
					break;
				case 3:
					System.out.println("ID");
					int id = scanner.nextInt();
					try {
						service.removeStudentById(id);

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("ID");
					id=scanner.nextInt();


					System.out.println("First Name: ");
					String fName1 = scanner.next();
					System.out.println("Last Name: ");
					String lName1 = scanner.next();
					System.out.println("Email: ");
					String email1 = scanner.next();
					System.out.println("Salary: ");
					int salary1 = scanner.nextInt();
					System.out.println("Bonus: ");
					int bonus1 = scanner.nextInt();
					Student e2=service.updateStudent(new Student(id, fName1,lName1,email1),id);
					System.out.println("student sucessfully created: "+e2);
					break;

			}


		} while (choice != 0);
	}
}
