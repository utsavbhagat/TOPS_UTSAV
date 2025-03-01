package Module1_CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P040_RemoveDuplicateElementUsingHashSet {
	public static void main(String[] args) {
		
        // Create a list with duplicate elements
		List<String> list = new ArrayList<>(Arrays.asList("Book","Pencile","Pens","Book","TextBooks","Lab Manual "));
		System.out.println("Original List: " + list);
        // Convert the list to a set to remove duplicates
		HashSet<String> set = new HashSet<>(list);
		
		System.out.println("Set: "+ set);
		
		// Convert to List
        List<String> newlist = new ArrayList<>(set);
        System.out.println("New List Elements: "+ newlist);
	}
}
