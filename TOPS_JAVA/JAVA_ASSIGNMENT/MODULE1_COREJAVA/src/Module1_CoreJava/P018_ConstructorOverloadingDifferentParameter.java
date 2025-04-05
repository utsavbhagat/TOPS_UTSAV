package Module1_CoreJava;

//Class demonstrating constructor overloading
class Book {

 // Fields of the class
 String title;
 String author;
 int pages;
 double price;

 // Constructor with no parameters (default constructor)
 public Book() {
     title = "Unknown";
     author = "Unknown";
     pages = 0;
     price = 0.0;
 }

 // Constructor with two parameters (title and author)
 public Book(String title, String author) {
     this.title = title;
     this.author = author;
     this.pages = 0;
     this.price = 0.0;
 }

 // Constructor with three parameters (title, author, and pages)
 public Book(String title, String author, int pages) {
     this.title = title;
     this.author = author;
     this.pages = pages;
     this.price = 0.0;
 }

 // Constructor with all parameters (title, author, pages, and price)
 public Book(String title, String author, int pages, double price) {
     this.title = title;
     this.author = author;
     this.pages = pages;
     this.price = price;
 }

 // Method to display book details
 public void displayBookDetails() {
     System.out.println("Title: " + title);
     System.out.println("Author: " + author);
     System.out.println("Pages: " + pages);
     System.out.println("Price: $" + price);
     System.out.println("------------");
 }
}

public class P018_ConstructorOverloadingDifferentParameter {
	public static void main(String[] args) {
        // Creating objects using different constructors

        // Using the default constructor
        Book book1 = new Book();
        book1.displayBookDetails();

        // Using the constructor with title and author
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        book2.displayBookDetails();

        // Using the constructor with title, author, and pages
        Book book3 = new Book("1984", "George Orwell", 328);
        book3.displayBookDetails();

        // Using the constructor with all parameters (title, author, pages, and price)
        Book book4 = new Book("Java Programming", "John Doe", 500, 29.99);
        book4.displayBookDetails();
    }
}
