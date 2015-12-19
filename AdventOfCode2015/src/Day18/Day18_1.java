package Day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day18_1 {
	//Done
	
	/*
	 --- Day 18: Like a GIF For Your Yard ---

		After the million lights incident, the fire code has gotten stricter: now, at most ten thousand lights are allowed. You arrange them in a 100x100 grid.
		
		Never one to let you down, Santa again mails you instructions on the ideal lighting configuration. With so few lights, he says, you'll have to resort to animation.
		
		Start by setting your lights to the included initial configuration (your puzzle input). A # means "on", and a . means "off".
		
		Then, animate your grid in steps, where each step decides the next configuration based on the current one. Each light's next state (either on or off) depends on its current state and the current states of the eight lights adjacent to it (including diagonals). Lights on the edge of the grid might have fewer than eight neighbors; the missing ones always count as "off".
		
		For example, in a simplified 6x6 grid, the light marked A has the neighbors numbered 1 through 8, and the light marked B, which is on an edge, only has the neighbors marked 1 through 5:
		
		1B5...
		234...
		......
		..123.
		..8A4.
		..765.
		The state a light should have next is based on its current state (on or off) plus the number of neighbors that are on:
		
		A light which is on stays on when 2 or 3 neighbors are on, and turns off otherwise.
		A light which is off turns on if exactly 3 neighbors are on, and stays off otherwise.
		All of the lights update simultaneously; they all consider the same current state before moving to the next.
		
		Here's a few steps from an example configuration of another 6x6 grid:
		
		Initial state:
		.#.#.#
		...##.
		#....#
		..#...
		#.#..#
		####..
		
		After 1 step:
		..##..
		..##.#
		...##.
		......
		#.....
		#.##..
		
		After 2 steps:
		..###.
		......
		..###.
		......
		.#....
		.#....
		
		After 3 steps:
		...#..
		......
		...#..
		..##..
		......
		......
		
		After 4 steps:
		......
		......
		..##..
		..##..
		......
		......
		After 4 steps, this example has four lights on.
		
		In your grid of 100x100 lights, given your initial configuration, how many lights are on after 100 steps?
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
