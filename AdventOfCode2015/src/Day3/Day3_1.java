package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Day3_1 {
	//Done

	/*
	 * Santa is delivering presents to an infinite two-dimensional grid of houses.
	 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.
	 * However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?
	 * 
	 * For example:
	 * > delivers presents to 2 houses: one at the starting location, and one to the east.
	 * ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
	 * ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
	 */
	public static void main(String[] args) {
		Path path = Paths.get("D:\\Workspaces\\EclipseWorkspace\\AdventOfCode2015\\src\\Day3\\input_day3.txt");
		byte[] bs;
		try {
			bs = Files.readAllBytes(path);
			String input = new String(bs);
			
			Map<String,String> map = new HashMap<String, String>();
			
			Coordinat position = new Coordinat();
			map.put(position.getPosition(), "");
			
			for (char c : input.toCharArray()) {
//				System.out.println(position.getPosition());
				position = position.move(c);
				map.put(position.getPosition(), "");
			}
			
			System.out.println("The amount of unic house visits by Santa is: " + map.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}