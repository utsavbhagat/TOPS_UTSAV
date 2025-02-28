package Module1_CoreJava.Module1_CoreJava_TaskAssgn;

import java.util.Scanner;

public class P001_PizzaMenu {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int sTotal =0;
	int midTotal =0;
	int lTotal =0;
	int monTotal =0;
	int sFreeCoke = 0;
	int midFreeCoke = 0;
	int lFreeCoke = 0;
	int monFreeCoke = 0;

	System.out.println("             PIZZA Zone    ");
	System.out.println("           ..............  ");
	
	while (true) {

		System.out.print("You Want Pizza (Yes/No) : ");
		String WantPizza = sc.next();
			if (WantPizza.equalsIgnoreCase("Yes")) {
				System.out.println("\n   -> PLEASE SELECT PIZZA'S... ");
				System.out.println("------------------------------------- ");
				System.out.println("|  SrNo.   |    SIZE     |   PRICE  |");
				System.out.println("|-----------------------------------|");
				System.out.println("|    1     |    Small    |    150   |");
				System.out.println("|    2     |    Medium   |    250   |");
				System.out.println("|    3     |    Large    |    400   |");
				System.out.println("|    4     |    Monster  |    600   |");
				System.out.println("------------------------------------- ");
				System.out.print("Which Size of Pizza you Want : ");
				String MenuChoise = sc.next();
				if (MenuChoise.equalsIgnoreCase("small")) {
					System.out.println("If you order 4 pizza We offer you 1L FREE COKE");
					System.out.print("Enter Quantity : ");
					int sQuntity = sc.nextInt();
					sFreeCoke = sQuntity/4;
					if (sFreeCoke > 0) {
						System.out.println("You get "+sFreeCoke+" FREE COKE OF 1L");
					}
					sTotal = sQuntity * 150;
					System.out.println("Your Bill for "+MenuChoise+" Pizza is : "+sTotal);
					
				} 
				else if(MenuChoise.equalsIgnoreCase("Medium")){
					System.out.println("If you order 3 pizza We offer you 1L FREE COKE");
					System.out.print("Enter Quantity : ");
					int midQuntity = sc.nextInt();
					midFreeCoke = midQuntity/3;
					if (midFreeCoke > 0) {
						System.out.println("You get "+midFreeCoke+" FREE COKE OF 1L");
					}
					midTotal = midQuntity * 250;
					System.out.println("Your Bill for "+MenuChoise+" Pizza is : "+midTotal);
				}
				else if (MenuChoise.equalsIgnoreCase("Large")) {
					System.out.println("If you order 3 pizza We offer you FREECOKE 2L");
					System.out.print("Enter Quantity : ");
					int lQuntity = sc.nextInt();
					lFreeCoke = lQuntity/3;
					if (lFreeCoke > 0) {
						System.out.println("You get "+lFreeCoke+" FREE IceCream ");
					}
					lTotal = lQuntity * 400;
					System.out.println("Your Bill for "+MenuChoise+" Pizza is : "+lTotal);
				} 
				else if(MenuChoise.equalsIgnoreCase("Monster")) {
					System.out.println("If you order 3 pizza We offer you FREECOKE 1l");
					System.out.print("Enter Quantity : ");
					int monQuntity = sc.nextInt();
					monFreeCoke = monQuntity/1;
					if (monFreeCoke > 0) {
						System.out.println("You get "+monFreeCoke+" FREECOKE 1l");
					}
					monTotal = monQuntity * 600;
					System.out.println("Your Bill for "+MenuChoise+" Pizza is : "+monTotal);
				}
				else {
					System.out.println("Please Select Valid Pizza");
					break;
				}
				int totalPizzaBill = sTotal+midTotal+lTotal+monTotal;
				int totalFreeCoke = sFreeCoke+midFreeCoke+lFreeCoke+monFreeCoke;
				System.out.println("--------------------------------------");
				System.out.println("| On your Order 'You get "+totalFreeCoke+" FreeCoke'|");
				System.out.println("| You Pizza Bill is :    "+totalPizzaBill+" Rs      |");
				System.out.println("--------------------------------------");
			} 
			else 
			{
				System.out.println("Sir/Mam Are You Want To Order Some Pizza ...");
				break;
			}
	}//while
	

	}
}
