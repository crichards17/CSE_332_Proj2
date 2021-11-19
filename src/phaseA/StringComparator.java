package phaseA;
import providedCode.*;


/**
 * Returns a negative number when the first argument to compare comes first alphabetically,
 * 	a positive number when the second argument comes first alphabetically,
 * 	and a 0 when the two arguments are alphabetically equivalent.
 */
public class StringComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		for (int i = 0; i < s1.length(); i++) {
			if (i >= s2.length()) {
				return 1;
			} else if (s1.charAt(i) != s2.charAt(i)) {
				return (s1.charAt(i) - s2.charAt(i)) / Math.abs(s1.charAt(i) - s2.charAt(i));
			}
		}
		if (s1.length() == s2.length()) {
			return 0;
		} else {
			return -1;
		}
	}
}
