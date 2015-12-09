package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day6_1 {
	//Done
	
	/*
	 --- Day 6: Probably a Fire Hazard ---

		Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.
		
		Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.
		
		Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.
		
		To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.
		
		For example:
		
		turn on 0,0 through 999,999 would turn on (or leave on) every light.
		toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
		turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
		After following the instructions, how many lights are lit?
	 */

	private static int[][] map = new int[1000][1000];
	
	public static void main(String[] args) {
		Path path = Paths.get("D:\\Workspaces\\EclipseWorkspace\\AdventOfCode2015\\src\\Day6\\input_day6.txt");
		
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
						map[i][j] = 1;
						break;
					case TURNOFF :
						map[i][j] = 0;
						break;
					case TOGGLE :
						if(map[i][j] == 1) {
							map[i][j] = 0;
						} else {
							map[i][j] = 1;
						}
				}
			}
		}
	}
}
