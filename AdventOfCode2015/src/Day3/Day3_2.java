package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Day3_2 {
	//Done

	/*
	 * --- Part Two ---
	 * The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.
	 * Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.
	 * This year, how many houses receive at least one present?
	 * 
	 * For example:
	 * ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south
	 * ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started
	 * ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
	 */
	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day3\\input_day3.txt");
		byte[] bs;
		try {
			bs = Files.readAllBytes(path);
			String input = new String(bs);
			
			Map<String,String> map = new HashMap<String, String>();
			
			short isSanta = 1;
			
			Coordinat positionSanta = new Coordinat();
			Coordinat positionRoboSanta = new Coordinat();
			map.put(positionSanta.getPosition(), "");
			map.put(positionRoboSanta.getPosition(), "");
			
			for (char c : input.toCharArray()) {
				if (isSanta > 0) {
					positionSanta = positionSanta.move(c);
					map.put(positionSanta.getPosition(), "");
				} else {
					positionRoboSanta = positionRoboSanta.move(c);
					map.put(positionRoboSanta.getPosition(), "");
				}
				
				isSanta *= -1;
			}
			
			System.out.println("The amount of unic house visits by Santa is: " + map.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}