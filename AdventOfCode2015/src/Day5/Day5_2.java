package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day5_2 {
	//Done

	/*
	--- Part Two ---
	
	Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.
	
	Now, a nice string is one with all of the following properties:
	
	It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
	It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
	For example:
	
	qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
	xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
	uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
	ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.
	How many strings are nice under these new rules?
	*/
	
	public static void main(String[] args) {
		String ex1 = "qjhvhtzxzqqjkmpb"; 	System.out.println("Ex1 : " + isNice(ex1));
		String ex2 = "xxyxx"; 				System.out.println("Ex2 : " + isNice(ex2));
		String ex3 = "uurcxstgmygtbstg"; 	System.out.println("Ex3 : " + isNice(ex3));
		String ex4 = "ieodomkazucvgmuy"; 	System.out.println("Ex4 : " + isNice(ex4));
		
		int res = 0;
		Path path = Paths.get("D:\\Workspaces\\EclipseWorkspace\\AdventOfCode2015\\src\\Day5\\input_day5.txt");
		
		List<String> names;
		
		try {
			names = Files.readAllLines(path);
			
			for (String name : names) {
				if (isNice(name)) {
					res++;
				}
			}
			System.out.println("The amount of nice strings on the list is: " + res + " the total amount of strings are: " + names.size());
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	private static boolean isNice(String name) {
		return contains2EqualPairs(name) && containsPalindrom(name);
	}

	private static boolean containsPalindrom(String name) {
		for (int i = 0; i < name.length() - 2; i++) {
			if (name.charAt(i) == name.charAt(i+2)) return true;
		}
		return false;
	}

	private static boolean contains2EqualPairs(String name) {
		boolean found = false;
		int i = 0;
		while (!found && i < name.length() - 2) {
			found = name.substring(i+2).contains(name.substring(i, i+2));
			i++;
		}
		return found;
	}

}
