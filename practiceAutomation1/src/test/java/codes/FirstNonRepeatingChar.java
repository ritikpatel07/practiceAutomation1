package codes;


/*
 * Problem- Find First Non repeating char in string
 * */
public class FirstNonRepeatingChar {
	public static void main(String[] args) {
		String s = "swiss";
		
		int idx = findFirstNonRepeatCharInStr(s);
		if(idx != -1) {
			System.out.println("First Non repeating char is found at: "+ idx +" and char is: "+s.charAt(idx));
		}
		else {
			System.out.println("Not found!");
		}
	}
	
	public static int findFirstNonRepeatCharInStr(String s) {
		int hash[] = new int[26];
		for(char c: s.toCharArray()) {
			hash[c-'a']++;
		}
		
		for(int i= 0; i< s.length(); i++) {
			if(hash[s.charAt(i)-'a'] == 1) {
				return i;
			}
		}
		
		return -1;
	}
}
