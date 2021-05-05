package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class FileReadReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File file=new File(args[0]);
			ArrayList list=new ArrayList();
			
			
			BufferedReader bufferedReader=new BufferedReader(new java.io.FileReader(file));
		//	String s=bufferedReader.readLine();
			String line;
			while((line=bufferedReader.readLine())!= null)
			{
			//	System.out.println(s);
//				s=bufferedReader.readLine();
				list.add(line);
				
				
			}
			bufferedReader.close();

			
			Collections.reverse(list);
			PrintWriter output=new PrintWriter(new BufferedWriter(new java.io.FileWriter(args[1])));
			for(Iterator i=list.iterator();i.hasNext();) {
				output.println((String)i.next());
			}
			output.close();
		}catch(FileNotFoundException fnfe) {
			// TODO: handle exception
						fnfe.printStackTrace();
	}catch(IOException ioe) {
		// TODO: handle exception
					ioe.printStackTrace();
	}
	}
	}


