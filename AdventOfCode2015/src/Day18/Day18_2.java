package Day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day18_2 {
	//Done
	
	/*
	 --- Part Two ---

		You flip the instructions over; Santa goes on to point out that this is all just an implementation of Conway's Game of Life. At least, it was, until you notice that something's wrong with the grid of lights you bought: four lights, one in each corner, are stuck on and can't be turned off. The example above will actually run like this:
		
		Initial state:
		##.#.#
		...##.
		#....#
		..#...
		#.#..#
		####.#
		
		After 1 step:
		#.##.#
		####.#
		...##.
		......
		#...#.
		#.####
		
		After 2 steps:
		#..#.#
		#....#
		.#.##.
		...##.
		.#..##
		##.###
		
		After 3 steps:
		#...##
		####.#
		..##.#
		......
		##....
		####.#
		
		After 4 steps:
		#.####
		#....#
		...#..
		.##...
		#.....
		#.#..#
		
		After 5 steps:
		##.###
		.##..#
		.##...
		.##...
		#.#...
		##...#
		After 5 steps, this example now has 17 lights on.
		
		In your grid of 100x100 lights, given your initial configuration, but with the four corners always in the on state, how many lights are on after 100 steps?
	 */

	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day18\\input_day18.txt");
		
		List<String> instructions;
		
		char[][] currentLights;

		try {
			instructions = Files.readAllLines(path);
			
			currentLights = fillLightArray(instructions);
			
			for (int i = 0; i < 100; i++) {
				currentLights = step(currentLights);
			}
			
			System.out.println("The number of lights that are on after 100 steps are: " + countLightsOn(currentLights));
			
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	private static char[][] step(char[][] lightArray) {
		char[][] resultingArray = new char[100][100];
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				if ((i == 0 && j == 0) || (i == 99 && j == 0) || (i == 0 && j == 99) || (i == 99 && j == 99)) {
					resultingArray[i][j] = '#';
				} else {
					int aliveNeighbors = 0;
					//North
					if (i != 0 && lightArray[i-1][j] == '#') {
						aliveNeighbors++;
					}
					//South
					if (i != 99 && lightArray[i+1][j] == '#') {
						aliveNeighbors++;
					}
					//West
					if (j != 0 && lightArray[i][j-1] == '#') {
						aliveNeighbors++;
					}
					//East
					if (j != 99 && lightArray[i][j+1] == '#') {
						aliveNeighbors++;
					}
					//North-West
					if (i != 0 && j != 0 && lightArray[i-1][j-1] == '#') {
						aliveNeighbors++;
					}
					//North-East
					if (i != 0 && j != 99 && lightArray[i-1][j+1] == '#') {
						aliveNeighbors++;
					}
					//South-West
					if (i != 99 && j != 0 && lightArray[i+1][j-1] == '#') {
						aliveNeighbors++;
					}
					//South-East
					if (i != 99 && j != 99 && lightArray[i+1][j+1] == '#') {
						aliveNeighbors++;
					}
					
					if (lightArray[i][j] == '#' && (aliveNeighbors == 2 || aliveNeighbors == 3)) {
						resultingArray[i][j] = '#';
					} else if (lightArray[i][j] == '.' && aliveNeighbors == 3) {
						resultingArray[i][j] = '#';
					} else {
						resultingArray[i][j] = '.';
					}
				}
			}
		}
		
		return resultingArray;
	}

	private static char[][] fillLightArray(List<String> instructions) {
		char[][] lightArray = new char[100][100];  
		int x = 0;
		int y = 0;
		
		for (String s : instructions) {
			for (char c : s.toCharArray()) {
				lightArray[x][y] = c;
				x++;
			}
			x = 0;
			y++;
		}
		
		return lightArray;
	}

	private static int countLightsOn(char[][] lightArray) {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (lightArray[i][j] == '#') {
					count++;
				}
			}
		}
		return count;
	}
}
