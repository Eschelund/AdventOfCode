package Day11;

public class Day11_2 {
	//Done
	
	/*
	 --- Part Two ---

		Santa's password expired again. What's the next one?
		
		Your puzzle input is still vzbxkghb.
	 */

	public static void main(String[] args) {
		String inputPassword = "vzbxkghb";

		System.out.println("second new password : " + createNewPassword(createNewPassword(inputPassword)));
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
