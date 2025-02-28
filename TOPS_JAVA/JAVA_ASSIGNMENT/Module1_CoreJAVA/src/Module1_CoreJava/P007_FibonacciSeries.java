//Write a program to display the Fibonacci series using a loop
package Module1_CoreJava;

import java.util.Scanner;

public class P007_FibonacciSeries {
	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Term : ");
		int term = sc.nextInt();
		for(int i = 0; i <= term; i++) {
			System.out.println(a+" ");
			int c = a+b;
			a = b;
			b = c;
			
		}
	}
}
