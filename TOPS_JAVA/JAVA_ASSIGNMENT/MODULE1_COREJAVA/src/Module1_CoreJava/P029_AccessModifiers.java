package Module1_CoreJava;

public class P029_AccessModifiers {
	// Public member: accessible everywhere
    public String publicVar = "Public Variable";

    // Protected member: accessible within the same package and by subclasses
    protected String protectedVar = "Protected Variable";

    // Default member: accessible only within the same package
    String defaultVar = "Default Variable";

    // Private member: accessible only within this class
    private String privateVar = "Private Variable";

    // Public method
    public void displayPublicVar() {
        System.out.println("Public Variable: " + publicVar);
    }

    // Protected method
    protected void displayProtectedVar() {
        System.out.println("Protected Variable: " + protectedVar);
    }

    // Default method
    void displayDefaultVar() {
        System.out.println("Default Variable: " + defaultVar);
    }

    // Private method
    private void displayPrivateVar() {
        System.out.println("Private Variable: " + privateVar);
    }

    // Method to demonstrate access within the class
    public void demonstrateAccess() {
        // All members are accessible within the same class
        System.out.println(publicVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
        System.out.println(privateVar);
    }
}
