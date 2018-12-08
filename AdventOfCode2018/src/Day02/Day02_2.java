package Day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day02_2 {
	//DONE

	/*
	 * --- Part Two --- Confident that your list of box IDs is complete, you're
	 * ready to find the boxes full of prototype fabric.
	 * 
	 * The boxes will have IDs which differ by exactly one character at the same
	 * position in both strings. For example, given the following box IDs:
	 * 
	 * abcde fghij klmno pqrst fguij axcye wvxyz The IDs abcde and axcye are
	 * close, but they differ by two characters (the second and fourth).
	 * However, the IDs fghij and fguij differ by exactly one character, the
	 * third (h and u). Those must be the correct boxes.
	 * 
	 * What letters are common between the two correct box IDs? (In the example
	 * above, this is found by removing the differing character from either ID,
	 * producing fgij.)
	 */

	public static void main(String[] args) {

		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2018\\src\\Day02\\input.txt");
		try {
			List<String> boxIdList = Files.readAllLines(path);

			System.out.println("The common letters of the correct box IDs are : " + findCommonLetters(boxIdList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String findCommonLetters(List<String> boxIdList) {
		for (String boxId : boxIdList) {
			for (String boxId2 : boxIdList) {
				if (compareId(boxId, boxId2) == 1) {
					return removeDiffChars(boxId, boxId2);
				}
			}
		}
		return null;
	}

	private static String removeDiffChars(String boxId1, String boxId2) {
		String result = "";
		for (int i = 0; i < boxId1.length(); i++) {
			if (boxId1.charAt(i) == boxId2.charAt(i)) {
				result += boxId1.charAt(i);
			}
		}
		return result;
	}

	private static int compareId(String boxId1, String boxId2) {
		int diffCount = 0;
		for (int i = 0; i < boxId1.length(); i++) {
			if (boxId1.charAt(i) != boxId2.charAt(i)) {
				diffCount++;
			}
		}
		return diffCount;
	}
}
