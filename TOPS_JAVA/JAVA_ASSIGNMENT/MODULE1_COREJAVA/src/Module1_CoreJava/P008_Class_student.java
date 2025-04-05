package Module1_CoreJava;
class Student{
	// Attributes
		String name;
		int age;
//		Constructor
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public void displayDetails(){
			System.out.println("Student Name: "+name);
			System.out.println("Student Age : "+age);
	}
	
	
}
public class P008_Class_student {
	public static void main(String[] args) {
		Student stu = new Student("Utsav",24);
		
		// Displaying student details
		stu.displayDetails();
	}
}
