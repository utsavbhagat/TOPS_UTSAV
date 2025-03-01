package Module1_CoreJava;

public class P011_MaxOfThreeNumbers {
	public static int findMax(int num1, int num2, int num3) {
		// Compare the three numbers and return the maximum
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
	}
	public static void main(String[] args) {
		// Test values
        int num1 = 27;
        int num2 = 2;
        int num3 = 15;

        // Calling the findMax method and storing the result
        int max = findMax(num1, num2, num3);

        // Display the result
        System.out.println("The maximum of " + num1 + ", " + num2 + ", and " + num3 + " is: " + max);
    }
	
}
