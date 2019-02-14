package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {
	public static void main(String[] args) {
		String todos = "";
		try {
			FileReader fr = new FileReader("src/Coding_Exam_B/classes/RayTracer.java");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				System.out.println("running");
				System.out.println(line);
				if(line.length() > 7) {
					for(int i = 0; i < line.length() - 7; i++) {
						if(line.substring(i, i+7).equals("//TODO:")) {
							todos += line;
						}
					}
					
				}
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("todos:" + todos);
		
		try {
			FileWriter fw = new FileWriter("src/Coding_Exam_B/classes/TODO_Log.txt");
			fw.write("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
