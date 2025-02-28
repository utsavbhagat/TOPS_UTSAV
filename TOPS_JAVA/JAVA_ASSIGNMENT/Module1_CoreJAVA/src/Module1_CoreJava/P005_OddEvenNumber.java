package Module1_CoreJava;

import java.util.Scanner;

public class P005_OddEvenNumber {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Find your Number is Odd Or Even");
	System.out.println("-------------------------------");
	System.out.print("Enter Your number :");
	int number = sc.nextInt();
		if (number % 2 == 0) {
			System.out.println(number+" is even number");
		} else {
			System.out.println(number+" is odd number");
		}
	}
}
