package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day2_2 {

	/**
	 * Part 2
	 *
	 * The elves are also running low on ribbon. Ribbon is all the same width, so they only have to worry about the length
	 * they need to order, which they would again like to be exact.
	 *
	 * The ribbon required to wrap a present is the shortest distance around its sides, or the smallest perimeter of any
	 * one face. Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect
	 * bow is equal to the cubic feet of volume of the present. Don't ask how they tie the bow, though; they'll never tell.
	 *
	 * How many total feet of ribbon should they order?
	 */
	public static void main(String[] args) {
		
		int res = 0;
		Path path = Paths.get("D:\\Workspaces\\EclipseWorkspace\\AdventOfCode2015\\src\\Day2\\input.txt");
		List<String> presents;
		try {
			presents = Files.readAllLines(path);
			
			for (String present : presents) {
				String[] measurements = present.split("x");
				
				res += calculateRibbon(Integer.parseInt(measurements[0]),
						Integer.parseInt(measurements[1]), 
						Integer.parseInt(measurements[2]));
			}
			System.out.println("The amount of ribbon needed is: " + res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static int calculateRibbon(int h, int w, int l) {
		
		return 2 * (h + w +l) - 2 * (Math.max(h, Math.max(w, l))) + (h * w * l);
	}

}
