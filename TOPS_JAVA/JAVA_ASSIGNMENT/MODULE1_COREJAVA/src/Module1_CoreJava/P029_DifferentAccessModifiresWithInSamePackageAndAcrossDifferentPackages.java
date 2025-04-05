package Module1_CoreJava;
import Module1_CoreJava.P028_UserDefinedPackageCalculator;
public class P029_DifferentAccessModifiresWithInSamePackageAndAcrossDifferentPackages {
	public static void main(String[] args) {

		P029_AccessModifiers obj = new P029_AccessModifiers();

        // Can access public members from another package
        System.out.println(obj.publicVar);  // Accessible
        obj.displayPublicVar();            // Accessible

        // Cannot access protected, default, or private members directly
        // System.out.println(obj.protectedVar);  // Not accessible
        // System.out.println(obj.defaultVar);    // Not accessible
        // System.out.println(obj.privateVar);    // Not accessible

        // Cannot call the protected method directly in a different package (unless subclass)
        // obj.displayProtectedVar(); // Not accessible

        // obj.displayPrivateVar(); // Not accessible
    }
}
