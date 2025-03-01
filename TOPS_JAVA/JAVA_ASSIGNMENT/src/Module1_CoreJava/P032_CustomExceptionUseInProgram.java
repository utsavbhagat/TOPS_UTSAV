package Module1_CoreJava;

import java.util.Scanner;

//Custom exception class
class InvalidAgeException extends Exception {
 // Constructor to pass a custom message to the exception
 public InvalidAgeException(String message) {
     super(message);
 }
}

public class P032_CustomExceptionUseInProgram {
	 // Method to check voting eligibility
    public static void checkVotingEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throwing the custom exception if age is less than 18
            throw new InvalidAgeException("Age is less than 18. You are not eligible to vote.");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter your age: ");
			int age = scanner.nextInt();
			
			try {
			    // Calling the method to check eligibility
			    checkVotingEligibility(age);
			} catch (InvalidAgeException e) {
			    // Catching and handling the custom exception
			    System.out.println(e.getMessage());
			}
		}
    }
}
