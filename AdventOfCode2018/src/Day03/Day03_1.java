package Day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day03_1 {
	//DONE
	
	/*
	--- Day 3: No Matter How You Slice It ---
	The Elves managed to locate the chimney-squeeze prototype fabric for Santa's suit (thanks to someone who helpfully wrote its box IDs on the wall of the warehouse in the middle of the night). Unfortunately, anomalies are still affecting them - nobody can even agree on how to cut the fabric.

	The whole piece of fabric they're working on is a very large square - at least 1000 inches on each side.

	Each Elf has made a claim about which area of fabric would be ideal for Santa's suit. All claims have an ID and consist of a single rectangle with edges parallel to the edges of the fabric. Each claim's rectangle is defined as follows:

	The number of inches between the left edge of the fabric and the left edge of the rectangle.
	The number of inches between the top edge of the fabric and the top edge of the rectangle.
	The width of the rectangle in inches.
	The height of the rectangle in inches.
	A claim like #123 @ 3,2: 5x4 means that claim ID 123 specifies a rectangle 3 inches from the left edge, 2 inches from the top edge, 5 inches wide, and 4 inches tall. Visually, it claims the square inches of fabric represented by # (and ignores the square inches of fabric represented by .) in the diagram below:

	...........
	...........
	...#####...
	...#####...
	...#####...
	...#####...
	...........
	...........
	...........
	The problem is that many of the claims overlap, causing two or more claims to cover part of the same areas. For example, consider the following claims:

	#1 @ 1,3: 4x4
	#2 @ 3,1: 4x4
	#3 @ 5,5: 2x2
	Visually, these claim the following areas:

	........
	...2222.
	...2222.
	.11XX22.
	.11XX22.
	.111133.
	.111133.
	........
	The four square inches marked with X are claimed by both 1 and 2. (Claim 3, while adjacent to the others, does not overlap either of them.)

	If the Elves all proceed with their own plans, none of them will have enough fabric. How many square inches of fabric are within two or more claims?
*/
	private static Map<String, String> coordinateMap =  new HashMap<>();

	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2018\\src\\Day03\\input.txt");

		try {
			List<String> claims = Files.readAllLines(path);

			for (String claim : claims) {
				handleClaim(claim);
			}
			
			System.out.println("Square inches of overlapping fabric: " + coordinateMap.values().stream().filter(s -> s.length() > 1).count());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void handleClaim(String claim) {
		String[] bits = claim.split(" ");
		
		int offSetX = Integer.parseInt(bits[2].split(",")[0]);
		int offSetY = Integer.parseInt(bits[2].split(",")[1].replace(":", ""));
		
		int width = Integer.parseInt(bits[3].split("x")[0]);
		int hight = Integer.parseInt(bits[3].split("x")[1]);
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < hight; j++) {
				handleCoordinate(offSetX + i, offSetY + j);
			}
		}		
	}
	
	private static void handleCoordinate(int x, int y) {
		String key = x + ":" + y;
		
		coordinateMap.merge(key, "x", String::concat);
	}

}
