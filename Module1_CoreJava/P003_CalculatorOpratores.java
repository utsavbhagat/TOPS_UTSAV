package Module1_CoreJava;

import java.util.Scanner;

public class P003_CalculatorOpratores {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= CALCULATOR ========");
		System.out.print("Enter first Value : ");
		int v1 = sc.nextInt();
		System.out.print("Enter second value : ");
		int v2 = sc.nextInt();
		System.out.println("Select option:- 1:+ , 2:- , 3: * ,4: /");
		int option = sc.nextInt();
		if (option == 1) {
			System.out.println(" Addtion of "+v1+"+"+v2+ " : "+(v1+v2) );
		}
		else if (option == 2) {
			System.out.println(" Subtraction of "+v1+"-"+v2+ " : "+(v1+v2) );
		} 
		else if (option == 3) {
			System.out.println(" multiplication of "+v1+"*"+v2+ " : "+(v1*v2) );
		} 
		else if (option == 4) {
			System.out.println(" Devisible of "+v1+"/"+v2+ " : "+(v1/v2) );
		} 
		else {
			System.out.println("Enter valid option");
		}
		
		}
	}

