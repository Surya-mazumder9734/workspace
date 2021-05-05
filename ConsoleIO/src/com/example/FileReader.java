package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File file=new File(args[0]);
			
			BufferedReader bufferedReader=new BufferedReader(new java.io.FileReader(file));
			String s=bufferedReader.readLine();
			while(s!=null)
			{
				System.out.println(s);
				s=bufferedReader.readLine();
				bufferedReader.close();

			}
		}catch(FileNotFoundException fnfe) {
			// TODO: handle exception
						fnfe.printStackTrace();
	}catch(IOException ioe) {
		// TODO: handle exception
					ioe.printStackTrace();
	}
	}
}

