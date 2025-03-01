package Module1_CoreJava;

import java.util.Scanner;
import Module1_CoreJava.P028_UserDefinedPackageCalculator;
public class P028_UseeDefinedPackageImportIntoAnotherProgram {
	public static void main(String[] args) {
	        // Create an object of the Calculator class
			P028_UserDefinedPackageCalculator calc = new P028_UserDefinedPackageCalculator();

	        // Perform some calculations
	        int sum = calc.add(10, 20);
	        int difference = calc.subtract(20, 10);
	        int product = calc.multiply(10, 5);
	        double quotient = calc.divide(20, 5);

	        // Output the results
	        System.out.println("Sum: " + sum);
	        System.out.println("Difference: " + difference);
	        System.out.println("Product: " + product);
	        System.out.println("Quotient: " + quotient);
		
	}
}
