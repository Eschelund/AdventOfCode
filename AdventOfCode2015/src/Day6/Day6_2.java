package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day6_2 {
	//Done
	
	/*
	 --- Part Two ---

		You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from Ancient Nordic Elvish.
		
		The light grid you bought actually has individual brightness controls; each light can have a brightness of zero or more. The lights all start at zero.
		
		The phrase turn on actually means that you should increase the brightness of those lights by 1.
		
		The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of zero.
		
		The phrase toggle actually means that you should increase the brightness of those lights by 2.
		
		What is the total brightness of all lights combined after following Santa's instructions?
		
		For example:
		
		turn on 0,0 through 0,0 would increase the total brightness by 1.
		toggle 0,0 through 999,999 would increase the total brightness by 2000000.
	 */

	private static int[][] map = new int[1000][1000];
	
	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day6\\input_day6.txt");
		
		List<String> instructions;

		try {
			instructions = Files.readAllLines(path);
			
			for (String line : instructions) {
				String[] commands = line.split(" ");
				if (commands[0].equals("toggle")) {
					String from = commands[1];
					String to = commands[3];
					handleLight(from.split(","), to.split(","), HandleType.TOGGLE);
				} else {
					String from = commands[2];
					String to = commands[4];
					if (commands[1].equals("on")) {
						handleLight(from.split(","), to.split(","), HandleType.TURNON);
					} else {
						handleLight(from.split(","), to.split(","), HandleType.TURNOFF);
					}
				}
			}
			
			int lightsOn = 0;
			for (int i = 0; i < 1000; i++) {
				for (int j = 0; j < 1000; j++) {
					lightsOn += map[i][j];
				}
			}
			System.out.println("The amount of lit lights are: " + lightsOn);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	private static void handleLight(String[] start, String[] end, HandleType action) {
		for (int i = Integer.parseInt(start[0]); i <= Integer.parseInt(end[0]); i++ ) {
			for (int j = Integer.parseInt(start[1]); j <= Integer.parseInt(end[1]); j++) {
				switch (action) {
					case TURNON :
						map[i][j] += 1;
						break;
					case TURNOFF :
						if (map[i][j] > 0)
						map[i][j] -= 1;
						break;
					case TOGGLE :
						map[i][j] += 2;
						break;
				}
			}
		}
	}
}
