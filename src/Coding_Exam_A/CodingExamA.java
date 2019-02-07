package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */

		//int num = 0;
		String colorString = "red";
		Color color = Color.RED;
	//	int sides = 3;
		colorString = JOptionPane.showInputDialog("What color? (red, green, blue)");
		switch(colorString) {
		case "red" : {
			color = Color.RED; 
			break;
		}
		case "green" : {
			color = Color.GREEN; 
			break;
		}
		default : {
			color = Color.BLUE; 
			break;
		}
		
		}
		final int num = Integer.parseInt(JOptionPane.showInputDialog("How many robots"));
		final int sides = Integer.parseInt(JOptionPane.showInputDialog("How many sides"));
		
		ArrayList <Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i < num; i++) {
			Robot r = new Robot(100 + 100 * i , 100);
			r.setPenColor(color);
			r.penDown();
			Thread t1 = new Thread(()-> {
				for(int j = 0; j < sides; j++) {
					r.move(40);
					int h = 180 * (sides - 2) / sides;
					System.out.println(h);
					r.turn(180 - h);
				}
				r.hide();
			});
			threads.add(t1);
		}
		for(Thread t : threads) {
			t.start();
		}
	}
}
