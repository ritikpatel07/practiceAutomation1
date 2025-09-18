package codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem - Given a map of Key & value pairs
 * Task is to sort the map by it's values
 * */
public class MapExercise1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("jackFruit", 3);
		map.put("strawberry", 1);
		map.put("cherry", 20);
		map.put("banana", 50);
		map.put("apple", 40);

		// Way 1
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		// Sorting 1
//		list.sort(Map.Entry.comparingByValue());
		
		// Sorting 2
//		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//				return (o1.getValue()).compareTo(o2.getValue());
//			}
//		});

		Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

		System.out.println("Sorted by value:");
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		
		// Way 2 -- Idea is to sort the keys by there corresponding values in map
//		List<String> keys = new ArrayList<>(map.keySet());
//		keys.sort((o1, o2) -> map.get(o2) - map.get(o1));
//		for (String k : keys) {
//			System.out.println(k + ": " + map.get(k));
//		}

	}
}
