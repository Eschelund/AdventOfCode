package Day11;

public class Day11_1 {
	//Done
	
	/*
	 --- Day 11: Corporate Policy ---

		Santa's previous password expired, and he needs help choosing a new one.
		
		To help him remember his new password after the old one expires, Santa has devised a method of coming up with a password based on the previous one. Corporate policy dictates that passwords must be exactly eight lowercase letters (for security reasons), so he finds his new password by incrementing his old password string repeatedly until it is valid.
		
		Incrementing is just like counting with numbers: xx, xy, xz, ya, yb, and so on. Increase the rightmost letter one step; if it was z, it wraps around to a, and repeat with the next letter to the left until one doesn't wrap around.
		
		Unfortunately for Santa, a new Security-Elf recently started, and he has imposed some additional password requirements:
		
		Passwords must include one increasing straight of at least three letters, like abc, bcd, cde, and so on, up to xyz. They cannot skip letters; abd doesn't count.
		Passwords may not contain the letters i, o, or l, as these letters can be mistaken for other characters and are therefore confusing.
		Passwords must contain at least two different, non-overlapping pairs of letters, like aa, bb, or zz.
		For example:
		
		hijklmmn meets the first requirement (because it contains the straight hij) but fails the second requirement requirement (because it contains i and l).
		abbceffg meets the third requirement (because it repeats bb and ff) but fails the first requirement.
		abbcegjk fails the third requirement, because it only has one double letter (bb).
		The next password after abcdefgh is abcdffaa.
		The next password after ghijklmn is ghjaabcc, because you eventually skip all the passwords that start with ghi..., since i is not allowed.
		Given Santa's current password (your puzzle input), what should his next password be?
		
		Your puzzle input is vzbxkghb.
	 */

	public static void main(String[] args) {
		String inputPassword = "vzbxkghb";

		System.out.println("new password : " + createNewPassword(inputPassword));
	}
	
	private static String createNewPassword(String oldPassword) {
		String tmpPW = oldPassword;
		boolean found = false;
		while (!found) {
			tmpPW = incrementTmpPW(tmpPW);
			if (isValidPW(tmpPW)) {
				found = true;
			}
		}
		return tmpPW;
	}

	private static boolean isValidPW(String tmpPW) {
		if (tmpPW.matches("(iol)")) {
			return false;
		}
		if (!alphabetCheck(tmpPW)) {
			return false;
		}
		if (!hasTwoDoubleChars(tmpPW)) {
			return false;
		}
		return true;
	}

	private static boolean hasTwoDoubleChars(String tmpPW) {
		int count = 0;
		char[] charPW = tmpPW.toCharArray();
		for (int i = 0; i < tmpPW.length()-1; i++) {
			if (charPW[i] == charPW[i+1]) {
				count++;
				i++;
			}
		}
		return count >= 2;
	}

	private static boolean alphabetCheck(String tmpPW) {
		char[] charPW = tmpPW.toCharArray();
		for (int i = 0; i < tmpPW.length()-2; i++) {
			if (charPW[i] == charPW[i+1]-1 && charPW[i] == charPW[i+2]-2) {
				return true;
			}
		}
		return false;
	}

	private static String incrementTmpPW(String tmpPW) {
		char[] charPW = tmpPW.toCharArray();
		int carryover = 0;
		for (int i = tmpPW.length()-1; i >= 0; i--) {
			if (charPW[i] == 'z') {
				charPW[i] = 'a';
			} else {
				charPW[i] += 1;
				break;
			}
		}
		
		return new String(charPW);
	}

}
