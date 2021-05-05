package com.example;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.omg.CORBA.portable.InputStream;


public class FileWriter {

	

	public static void main(String[] args)throws IOException {
		boolean bool=false;
		// TODO Auto-generated method 
		try {
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader bw=new BufferedReader(isr);
			PrintWriter fout=null;
			fout=new PrintWriter(new File(args[0]));
			File file=new File("test.txt");
			String St;
			do {
			St=bw.readLine();
			fout.write(St);
			
			System.out.println(St);
			fout.close();
			bool=file.exists();
			if(bool) {
				System.out.print(bool);
			}
			
		}while(!St.equals("exit"));

	}catch(IOException e) {
		e.printStackTrace();
	}

}
}
