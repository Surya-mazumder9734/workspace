package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) {
		
		try {
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("ID: ");
			int id=Integer.parseInt(bufferedReader.readLine());
			System.out.print("First Name: ");
			String firstName=bufferedReader.readLine();
			System.out.print("Last Name: ");
			String lastName=bufferedReader.readLine();
			System.out.print("email: ");
			String email=bufferedReader.readLine();
			Customer customer=new Customer(id,firstName,lastName,email);
			System.out.println(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}