package Module1_CoreJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class P039_ArrayListAndLinkedList {
public static void main(String[] args) {
	List<String> arrayList = new ArrayList<>();
	arrayList.add("Red");
	arrayList.add("Green");
	arrayList.add("Bule");
	arrayList.add("Yellow");
	
	System.out.println("ArrayList elements: " + arrayList);
	arrayList.remove("Blue");
	System.out.println("After removing 'Green' from ArrayList: "+arrayList);
	
	System.out.println("Iterating ArrayList: ");
	for(String color : arrayList) {
		System.out.println(color);
	}
	
	List<String> linkedList = new LinkedList<>();
	linkedList.add("Dog");
	linkedList.add("Cow");
	linkedList.add("Lion");
	linkedList.add("Tiger");
	
	System.out.println("\nLinkedList element: "+linkedList);
	linkedList.remove(2);
	System.out.println("After removing element at index 2 from LinkedList: " + linkedList);
	
	System.out.println("Interating over LinkedList: ");
	Iterator<String> iterator = linkedList.iterator();
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
}
}
