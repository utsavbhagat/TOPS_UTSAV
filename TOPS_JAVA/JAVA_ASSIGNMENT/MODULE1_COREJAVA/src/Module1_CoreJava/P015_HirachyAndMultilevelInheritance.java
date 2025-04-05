package Module1_CoreJava;

class Animal {
	 void eat() {
	     System.out.println("Animal eats");
	 }
	}

	class Mammal extends Animal {
	 void walk() {
	     System.out.println("Mammal walks");
	 }
	}

	class Dog extends Mammal {
	 void bark() {
	     System.out.println("Dog barks");
	 }
	}

public class P015_HirachyAndMultilevelInheritance {
	public static void main(String[] args) {
		  
	     Dog myDog = new Dog();
	     myDog.eat();   
	     myDog.walk();  
	     myDog.bark();  
	 }

}
