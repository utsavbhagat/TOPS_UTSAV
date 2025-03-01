//Implement a simple menu-driven program using a switch-case.
package Module1_CoreJava;

import java.util.Scanner;

public class P006_MenuDrivenProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu-Driven");
		
		System.out.println("Menu:");
        System.out.println("1. Add two numbers");
        System.out.println("2. Subtract two numbers");
        System.out.println("3. Multiply two numbers");
        System.out.println("4. Divide two numbers");
        System.out.println("5. Exit");
        
        System.out.print("Enter your choice (1-5): ");
        int Menu_choise = sc.nextInt();
        
        	switch (Menu_choise) {
			case 1:
                System.out.print("Enter First numbers: ");
                System.out.print("Enter Second numbers: ");
                double num1 = sc.nextDouble();
                double num2 = sc.nextDouble();
                System.out.println("Sum: "+(num1+num2));
				break;
			case 2:
				System.out.print("Enter First numbers: ");
                System.out.print("Enter Second numbers: ");
                double num3 = sc.nextDouble();
                double num4 = sc.nextDouble();
                System.out.println("Sub : "+(num3-num4));
				break;
			case 3:
				System.out.print("Enter First numbers: ");
                System.out.print("Enter Second numbers: ");
                double num5 = sc.nextDouble();
                double num6 = sc.nextDouble();
                System.out.println("Multi: "+(num5*num6));
				break;
			case 4:
				System.out.print("Enter First numbers: ");
                System.out.print("Enter Second numbers: ");
                double num7 = sc.nextDouble();
                double num8 = sc.nextDouble();
                if (num8 != 0) {
                    System.out.println("Quotient: " + (num7 / num8));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
			case 5:
				System.out.println("Exit the program");
				break;
			default:
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");

				break;
			}
	}
}
