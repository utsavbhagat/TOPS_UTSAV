package Module1_CoreJava;

class Employee{  
	 float salary = 50000;  
}  

public class P014_SingleInheritance extends Employee{  
	 int bonus=35000;  
	 public static void main(String args[]){  
		 P014_SingleInheritance p=new P014_SingleInheritance();  
	   System.out.println("Employee salary is:"+p.salary);  
	   System.out.println("Bonus of Employee is:"+p.bonus);  
	 }  
}

