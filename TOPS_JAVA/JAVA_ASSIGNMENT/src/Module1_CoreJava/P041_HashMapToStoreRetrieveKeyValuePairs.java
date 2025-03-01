package Module1_CoreJava;

import java.util.HashMap;
import java.util.Map;

public class P041_HashMapToStoreRetrieveKeyValuePairs {
	public static void main(String[] args) {
        // Create a HashMap
        Map<String, String> keyValuePairs = new HashMap<>();

        // Add key-value pairs to the HashMap
        keyValuePairs.put("name", "Utsav Bhagat");
        keyValuePairs.put("email", "bhagatutsav2000@gmail.com");
        keyValuePairs.put("phone", "9512371008");

        // Retrieve key-value pairs from the HashMap
        System.out.println("Name: " + keyValuePairs.get("name"));
        System.out.println("Email: " + keyValuePairs.get("email"));
        System.out.println("Phone: " + keyValuePairs.get("phone"));

    }
}
