package com.programming.class1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsWork {

	public static void main(String[] args) {

		List<String> countries = new ArrayList<>();
		countries.add("India");
		countries.add("England");
		countries.add("Australia");

		Collections.sort(countries);
		
		//using for loop :
		for (String co : countries) {
			co = co.toUpperCase();

			if (!co.startsWith("E")) {
				System.out.println(co);
			}
		}
		
		//using streams :
		countries.stream()
				.map(s -> s.toUpperCase())
				.filter(s -> !s.startsWith("E"))
				.sorted()
				.forEach(s -> System.out.println(s));
		
		//Either you can create stream by using stream function on collections object
		//like we have done above or we can create streams like this also
		
		Stream<String> fruitstream = Stream.of("apple","papaya","jack fruit","dragon fruit");
		System.out.println(fruitstream.collect(Collectors.toList()) );
		
		Stream<String> fstr = Stream.of("apple","papaya","jack fruit","dragon fruit");
		
		Predicate<String> noFruitWordFilter = name->!name.contains("fruit");
		Predicate<String> noYLetter = name->!name.contains("y");
		
		List<String> filteredStream = fstr.filter(noFruitWordFilter)
												.filter(noFruitWordFilter)
												.filter(noYLetter)
												.collect(Collectors.toList());
		
		System.out.println(filteredStream);
		
		List<String> shoppingList = new ArrayList<>();
		
		shoppingList.add("Pampers");
		shoppingList.add("Vim");
		shoppingList.add("Zandu boam");
		shoppingList.add("Parachut");
		
		Collections.sort(shoppingList);
		for(String items : shoppingList ){
			System.out.println(items);
		}
		
		
	}

}
