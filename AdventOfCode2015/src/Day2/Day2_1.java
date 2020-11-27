package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day2_1 {
	//Done

	/**
	 * 2.December challenge from www.adventofcode.com
	 *
	 * Part 1
	 *
	 * The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the
	 * dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.
	 *
	 * Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required
	 * wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l.
	 * The elves also need a little extra paper for each present: the area of the smallest side.
	 *
	 * All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?
	 */ 
	public static void main(String[] args) {
		
		int res = 0;
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day2\\input.txt");
		List<String> presents;
		try {
			presents = Files.readAllLines(path);
			
			for (String present : presents) {
				String[] measurements = present.split("x");
				
				res += calculatePackaging(Integer.parseInt(measurements[0]),
						Integer.parseInt(measurements[1]), 
						Integer.parseInt(measurements[2]));
			}
			System.out.println("The amount of giftwrapping needed is: " + res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static int calculatePackaging(int h, int w, int l) {
		int side1 = h * w;
		int side2 = l * w;
		int side3 = l * h;
		int extra = Math.min(side1, Math.min(side2, side3));
		
		return 2 * (side1 + side2 + side3) + extra;
	}

}
