package Day8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8_1 {
	
	
	/*
	--- Day 8: Matchsticks ---
	Space on the sleigh is limited this year, and so Santa will be bringing his list as a digital copy. He needs to know how much space it will take up when stored.

	It is common in many programming languages to provide a way to escape special characters in strings. For example, C, JavaScript, Perl, Python, and even PHP handle special characters in very similar ways.

	However, it is important to realize the difference between the number of characters in the code representation of the string literal and the number of characters in the in-memory string itself.

	For example:

	"" is 2 characters of code (the two double quotes), but the string contains zero characters.
	"abc" is 5 characters of code, but 3 characters in the string data.
	"aaa\"aaa" is 10 characters of code, but the string itself contains six "a" characters and a single, escaped quote character, for a total of 7 characters in the string data.
	"\x27" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using hexadecimal notation.
	Santa's list is a file that contains many double-quoted string literals, one on each line. The only escape sequences used are \\ (which represents a single backslash), \" (which represents a lone double-quote character), and \x plus two hexadecimal characters (which represents a single character with that ASCII code).

	Disregarding the whitespace in the file, what is the number of characters of code for string literals minus the number of characters in memory for the values of the strings in total for the entire file?

	For example, given the four strings above, the total number of characters of string code (2 + 5 + 10 + 6 = 23) minus the total number of characters in memory for string values (0 + 3 + 7 + 1 = 11) is 23 - 11 = 12.
	*/
	
	public static void main(String[] args) {
		Path expath = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day8\\ex_day8.txt");
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day8\\input_day8.txt");
		
		List<String> codeLines;
		int result = 0;
		
		try {
			List<String> exLines = Files.readAllLines(expath);
			for (String s : exLines) {
				System.out.println("Ex:" + calcCodeCharMinusMemChar(s));
			}
			
			codeLines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
			
			
			
			for (String codeLine : codeLines) {
				result += calcCodeCharMinusMemChar(codeLine);
			}
			
			System.out.println("The amount of characters of code - characters in memory is: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		};

	}

	private static int calcCodeCharMinusMemChar(String codeLine) {
		int codeCharCount = codeLine.length();
		Pattern pHex = Pattern.compile("[\\][x][\\d\\w][\\d\\w]");
		Pattern pEscapedQuote = Pattern.compile("[\\][\"]");
		Pattern pBslash = Pattern.compile("[\\]{2}");
		
		String memLine = codeLine.substring(1,codeCharCount - 1);
		
		Matcher mHex = pHex.matcher(memLine);
		Matcher mEscapeQuote = pEscapedQuote.matcher(memLine);
		Matcher mBslash = pBslash.matcher(memLine);
	
		int memCharCount = memLine.length();
		while (mHex.find()) memCharCount -= 3;
		while (mEscapeQuote.find()) memCharCount--;
		while (mBslash.find()) memCharCount--;
		
		return codeCharCount - memCharCount;
	}

}
