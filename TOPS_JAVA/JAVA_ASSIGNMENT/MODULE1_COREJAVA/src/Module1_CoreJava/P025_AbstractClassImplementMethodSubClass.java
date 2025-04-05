package Module1_CoreJava;

abstract class Parent1{
	abstract void display();
}

class FirstSubClass extends Parent1{
	void display() {
		System.out.println("This is First Subclass");
		
	}
}

class SecondSubClass extends Parent1{
	void display() {
		System.out.println("This is second subclass");
	}
}
public class P025_AbstractClassImplementMethodSubClass {
	public static void main(String[] args) {
		Parent1 p1 = new FirstSubClass();
		Parent1 p2 = new SecondSubClass();
		p1.display();
		p2.display();
	}
}
