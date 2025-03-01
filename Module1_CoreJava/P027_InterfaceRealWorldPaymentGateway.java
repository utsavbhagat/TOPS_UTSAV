package Module1_CoreJava;

//Interface: PaymentMethod

interface PaymentMethod {
 void makePayment(double amount);
 void cancelPayment(double amount);
}

// Class: CreditCard (Implements PaymentMethod)
class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String expirationDate;

    public CreditCard(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Charging ₹" + amount + " to credit card " + cardNumber);
    }

    @Override
    public void cancelPayment(double amount) {
        System.out.println("Cancelling payment of ₹" + amount + " on credit card " + cardNumber);
    }
}


// Class: PayPal (Implements PaymentMethod)

class PayPalPayment implements PaymentMethod {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Sending ₹" + amount + " via PayPalPayment to " + email);
    }

    @Override
    public void cancelPayment(double amount) {
        System.out.println("Cancelling PayPalPayment payment of ₹" + amount + " for " + email);
    }
}




public class P027_InterfaceRealWorldPaymentGateway {
	 public static void main(String[] args) {
	        PaymentMethod creditCard = new CreditCard("1234-5678-9012-3456", "12/2025");
	        creditCard.makePayment(60000.0);
	        creditCard.cancelPayment(999.0);

	        PaymentMethod PayPalPayment = new PayPalPayment("bhagatutsav2000@gmail.com");
	        System.out.println();
	        PayPalPayment.makePayment(200000.0);
	        PayPalPayment.cancelPayment(50000.0);
	    }
}
