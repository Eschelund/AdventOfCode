package Day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Day7.LogicOperators;
import Day7.LogicWireNote;

public class Day12_1 {
	//Done
	
	/*
	 --- Day 12: JSAbacusFramework.io ---

		Santa's Accounting-Elves need help balancing the books after a recent order. Unfortunately, their accounting software uses a peculiar storage format. That's where you come in.
		
		They have a JSON document which contains a variety of things: arrays ([1,2,3]), objects ({"a":1, "b":2}), numbers, and strings. Your first job is to simply find all of the numbers throughout the document and add them together.
		
		For example:
		
		[1,2,3] and {"a":2,"b":4} both have a sum of 6.
		[[[3]]] and {"a":{"b":4},"c":-1} both have a sum of 3.
		{"a":[-1,1]} and [-1,{"a":1}] both have a sum of 0.
		[] and {} both have a sum of 0.
		You will not encounter any strings containing numbers.
		
		What is the sum of all numbers in the document?
	 */
	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day12\\input_day12.txt");
		
		List<String> instructions;

		try {
			instructions = Files.readAllLines(path);
			int num = 0;
			for (String s : instructions) {
				Matcher matcher = Pattern.compile("(-?\\d+)").matcher(s);
				while (matcher.find())
				{
					num += Integer.parseInt(matcher.group());
				}
			}
			
			System.out.println("The total number is: " + num);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

}
