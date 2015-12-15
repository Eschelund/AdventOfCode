package Day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day14_1 {
	//Done
	
	/*
	 --- Day 14: Reindeer Olympics ---

		This year is the Reindeer Olympics! Reindeer can fly at high speeds, but must rest occasionally to recover their energy. Santa would like to know which of his reindeer is fastest, and so he has them race.
		
		Reindeer can only either be flying (always at their top speed) or resting (not moving at all), and always spend whole seconds in either state.
		
		For example, suppose you have the following Reindeer:
		
		Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.
		Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.
		After one second, Comet has gone 14 km, while Dancer has gone 16 km. After ten seconds, Comet has gone 140 km, while Dancer has gone 160 km. On the eleventh second, Comet begins resting (staying at 140 km), and Dancer continues on for a total distance of 176 km. On the 12th second, both reindeer are resting. They continue to rest until the 138th second, when Comet flies for another ten seconds. On the 174th second, Dancer flies for another 11 seconds.
		
		In this example, after the 1000th second, both reindeer are resting, and Comet is in the lead at 1120 km (poor Dancer has only gotten 1056 km by that point). So, in this situation, Comet would win (if the race ended at 1000 seconds).
		
		Given the descriptions of each reindeer (in your puzzle input), after exactly 2503 seconds, what distance has the winning reindeer traveled?
	 */

	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day14\\input_day14.txt");
		
		List<String> instructions; 
		int maxDistance = 0;
		int traveltime = 2503;
		
		try {
			instructions = Files.readAllLines(path);
			for (String s : instructions) {
				String[] bits = s.split(" ");
				int distance = new Raindeer(bits[0], Integer.parseInt(bits[3]), Integer.parseInt(bits[6]), Integer.parseInt(bits[13])).calculateRange(traveltime);
				if (distance > maxDistance) maxDistance = distance;
			}
			
			System.out.println("Highest distance reached within 2503s is: " + maxDistance);
		} catch (IOException e) {
			e.printStackTrace();
		};

	}

}
