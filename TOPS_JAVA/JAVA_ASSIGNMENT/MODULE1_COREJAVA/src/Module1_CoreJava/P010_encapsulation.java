package Module1_CoreJava;

public class P010_encapsulation {
	public static void main(String[] args) {
	     // Create an instance of Person
	     Person person = new Person("John Doe", 30);

	     // Accessing and modifying attributes using getters and setters
	     System.out.println("Name: " + person.getName());
	     System.out.println("Age: " + person.getAge());

	     // Changing the name and age using setters
	     person.setName("Jane Doe");
	     person.setAge(25);	

	     // Displaying updated values
	     System.out.println("Updated Name: " + person.getName());
	     System.out.println("Updated Age: " + person.getAge());
	 }

}
//Simple Java class demonstrating encapsulation
 class Person {
 // Private fields (attributes)
 private String name;
 private int age;

 // Constructor to initialize the attributes
 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Getter method for 'name'
 public String getName() {
     return name;
 }

 // Setter method for 'name'
 public void setName(String name) {
     this.name = name;
 }

 // Getter method for 'age'
 public int getAge() {
     return age;
 }

 // Setter method for 'age'
 public void setAge(int age) {
     // Check if the age is valid (non-negative)
     if (age >= 0) {
         this.age = age;
     } else {
         System.out.println("Age cannot be negative.");
     }
 }

 // Main method to test the Person class
 
}
