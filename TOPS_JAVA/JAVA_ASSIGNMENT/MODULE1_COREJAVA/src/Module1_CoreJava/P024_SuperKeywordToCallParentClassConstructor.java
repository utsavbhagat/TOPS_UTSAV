package Module1_CoreJava;

class Parent {
    public Parent() {
        System.out.println("Parent class constructor called.");
    }
    public void display() {
        System.out.println("Method from the Parent class.");
    }
}

class Child extends Parent {
    public Child() {
        super();
        System.out.println("Child class constructor called.");
    }
    public void display() {
        super.display();
        System.out.println("Method from the Child class.");
    }
}

public class P024_SuperKeywordToCallParentClassConstructor {
	public static void main(String[] args) {
        Child child = new Child();
        child.display();
    }

}