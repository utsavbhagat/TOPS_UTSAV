package Module1_CoreJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Students implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name,course;
	private int age;
	public Students(String name, String course, int age) {
		super();
		this.name = name;
		this.course = course;
		this.age = age;
	}
	
	public void displayStudent() {
		System.out.println("Student Name: "+ name);
		System.out.println("Age: "+ age);
		System.out.println("Course: "+ course);
	}
	
}
public class P038_SerializationAndDeserialization {
	public static void main(String[] args) {
		String filename = "Student.txt";
		Students stud1 = new Students("Utsav Bhagat","Java Developer", 24);
		
//		Serialization
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(stud1);
			System.out.println("Object serialized and saved to "+ filename);
		} catch (Exception e) {
			// TODO: handle exception
            e.printStackTrace();
		}
//		Deserialization
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Students deserializedStudent  = (Students) ois.readObject();
			System.out.println("\n Object Deserializes: ");
			deserializedStudent.displayStudent();
		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
            e.printStackTrace();

		}
	}
}
