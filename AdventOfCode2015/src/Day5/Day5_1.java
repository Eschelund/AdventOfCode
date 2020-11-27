package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5_1 {
	//Done

	/*
	Santa needs help figuring out which strings in his text file are naughty or nice.

	A nice string is one with all of the following properties:

	It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
	It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
	It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
	For example:

	ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
	aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
	jchzalrnumimnmhp is naughty because it has no double letter.
	haegwjzuvuyypxyu is naughty because it contains the string xy.
	dvszwmarrgswjxmb is naughty because it contains only one vowel.
	How many strings are nice?
	*/
	
	public static void main(String[] args) {
		int res = 0;
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day5\\input_day5.txt");
		
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
		return containsThreeVowels(name) && containsDoubleLetter(name) && !containsNaughtyPair(name);
	}

	private static boolean containsDoubleLetter(String name) {
		for (int i = 0; i < name.length() - 1; i++) {
			if (name.charAt(i) == name.charAt(i+1)) return true;
		}
		return false;
	}

	private static boolean containsThreeVowels(String name) {
		int count = 0;
		Pattern vowelPattern = Pattern.compile("[aeiou]");
		Matcher vowelMatcher = vowelPattern.matcher(name);
		
		while (vowelMatcher.find()) 
			count++;
		
		return count >= 3;
	}

	private static boolean containsNaughtyPair(String name) {
		return name.contains("ab") || name.contains("cd") || name.contains("pq") || name.contains("xy");
	}

}
