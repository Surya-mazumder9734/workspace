import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;


public class App {
	public static void main(String []args) throws SQLException {
		Scanner scanner = new Scanner(System.in);

	
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		int choice = 0;
		do {
			System.out.println("1.Create An Employee.");
			System.out.println("2.Display All Employees.");
			System.out.println("3.Remove  Employees by ID");
			System.out.println("4.Update  Employees by ID");
			System.out.println("0.Exit.");
			System.out.print("Enter Your Choice. ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("ID: ");
				int id = scanner.nextInt();
				System.out.println("First Name: ");
				String fName = scanner.next();
				System.out.println("Last Name: ");
				String lName = scanner.next();
				System.out.println("Email: ");
				String email = scanner.next();
				System.out.println("Salary: ");
				int salary = scanner.nextInt();
				System.out.println("Bonus: ");
				int bonus = scanner.nextInt();
				Employee e1=service.createEmployees(new Employee(id, fName, lName, email, salary, bonus));
				System.out.println("employee sucessfully created: "+e1);
				break;

			case 2:
				EmployeeService employeeService = new EmployeeServiceImpl();
				try {
					List<Employee> employees = employeeService.getAllEmployees();
					for (Employee e : employees) {
						System.out.println(e);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("ID");
				id=scanner.nextInt();
				try{
					employeeService = new EmployeeServiceImpl();
					employeeService.removeEmployeeById(id);
				}catch (SQLException e){
					e.printStackTrace();
				}catch (EmployeeNotFoundException e) {
					System.err.println(e.getMessage());

				}
				
			case 4:
				System.out.println("ID");
				id=scanner.nextInt();

				employeeService=new EmployeeServiceImpl();

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
				Employee e2=service.updateEmployees(new Employee(id, fName1,lName1,email1,salary1,bonus1),id);
				System.out.println("employee sucessfully created: "+e2);
				break;
			case 5:
				System.out.println("ID");
				id=scanner.nextInt();
				
				
				case 0:
				System.out.println("Bye....!");
				System.exit(0);
			
			default:
				System.out.println("Invalid Choice");
				break;
			}

		} while (choice != 0);


}
}
