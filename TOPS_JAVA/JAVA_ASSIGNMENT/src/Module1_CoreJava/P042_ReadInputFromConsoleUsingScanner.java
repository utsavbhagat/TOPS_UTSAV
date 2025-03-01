package Module1_CoreJava;

import java.util.Scanner;

public class P042_ReadInputFromConsoleUsingScanner {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("      Welcome  !!   ");
		System.out.println();
		System.out.print("Enter Your Name  :");
		String name = sc.nextLine();
		System.out.print("Enter Your Age   : ");
		int age = sc.nextInt();
		System.out.print("Enter Your Marks :");
		double marks = sc.nextDouble();
		
		// Print the input values
        System.out.println("Name  :" + name);
        System.out.println("Age   :" + age);
        System.out.println("Marks :" + marks);
		if(marks>=28) {
			System.out.println("Congrats "+name+" you passed the exam ." );
		}else {
			System.out.println(name+" You are Failed the exam ." );
		}
	}
}
