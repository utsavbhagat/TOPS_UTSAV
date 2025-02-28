//Create multiple constructors in a class and demonstrate constructor overloading
package Module1_CoreJava;
	class ClassStudent{
		String name;
		int age;
		String course;
		public ClassStudent() {
			this.name = "Unknown";
			this.age = 0;
			this.course = "Not Assigned";
			System.out.println("Default Constructor Called !");
		}
		
		public ClassStudent(String name, int age) {
			this.name = name;
			this.age = age;
			this.course = "Not Assign";
			System.out.println("Constructor with Name and AGE called!");
		}
		
		// Constructor with all attributes (name, age, course)
	    public ClassStudent(String name, int age, String course) {
	        this.name = name;
	        this.age = age;
	        this.course = course;
	        System.out.println("Constructor with Name, Age, and Course Called!");
	    }

	    // Method to display student details
	    public void displayDetails() {
	        System.out.println("Name  : " + name);
	        System.out.println("Age   : " + age);
	        System.out.println("Course: " + course);
	        System.out.println();
	    }

	}
public class P009_Constructor_Overloading {
	public static void main(String[] args) {
		// Default constructor
		ClassStudent student1 = new ClassStudent();
        student1.displayDetails();

        // Constructor with name and age
        ClassStudent student2 = new ClassStudent("Alice", 22);
        student2.displayDetails();

        // Constructor with name, age, and course
        ClassStudent student3 = new ClassStudent("Bob", 25, "Computer Science");
        student3.displayDetails();
	}

}
