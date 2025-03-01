package Module1_CoreJava;

class Vehicles {
    private String brand;
    private String model;

    public Vehicles(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

}


// Car Class (Child)

class Cars extends Vehicles {
    private int numberOfDoors;

    public Cars(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    public void displayCarDetails() {
        displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    
}


// Motorcycle Class (Child)

class Motorcycle extends Vehicles {
    private int engineCapacity;

    public Motorcycle(String brand, String model, int engineCapacity) {
        super(brand, model);
        this.engineCapacity = engineCapacity;
    }

    public void displayMotorcycleDetails() {
        displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
    }

}


// Main Class

public class P022_InheritanceUsingExtendsKeyword {
    public static void main(String[] args) {
        Cars car = new Cars("BMW", "X3", 4);
        car.displayCarDetails();
   

        Motorcycle motorcycle = new Motorcycle("Hyundai", "I20", 500);
        motorcycle.displayMotorcycleDetails();
        
    }
}