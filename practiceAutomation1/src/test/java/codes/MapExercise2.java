package codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Given a list of Strings
 * TAsk is to group the string by their length
 * Return a map containing length, all strings of that length in sorted order
*/
public class MapExercise2 {
	public static void main(String[] args) {
		List<String> inputList = List.of("azure", "abc", "cat", "abcd", "jira", "citadel", "amazon");
		
		Map<Integer, List<String>> output = groupStrings(inputList);
		
		System.out.println(output);
	}

	private static Map<Integer, List<String>> groupStrings(List<String> list) {
		Map<Integer, List<String>> result = new HashMap<>();
		for(String s: list) {
			int len = s.length();
			
			// Storing length if not present
			result.putIfAbsent(len, new ArrayList<String>());
			// Adding that string to desired length
			result.get(len).add(s);
			
			// Sorting the generate group of string
			Collections.sort(result.get(len));
		}
		
		return result;
	}
}
