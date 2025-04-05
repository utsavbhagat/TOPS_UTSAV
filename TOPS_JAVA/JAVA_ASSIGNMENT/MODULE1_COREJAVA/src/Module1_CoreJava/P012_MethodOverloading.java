package Module1_CoreJava;

public class P012_MethodOverloading {
	// Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method to add a string and an integer
    public String add(String a, int b) {
        return a + b;
    }

    // Method to add an integer and a string
    public String add(int a, String b) {
        return a + b;
}
    public static void main(String[] args) {
    	P012_MethodOverloading example = new P012_MethodOverloading();

        // Calling method with integer parameters
        System.out.println("Addition of two integers: " + example.add(5, 10));

        // Calling method with double parameters
        System.out.println("Addition of two doubles: " + example.add(5.5, 10.5));

        // Calling method with a string and an integer
        System.out.println("String and integer concatenation: " + example.add("Hello", 5));

        // Calling method with an integer and a string
        System.out.println("Integer and string concatenation: " + example.add(10, "World"));
    }
}
