package Day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14_2 {
	
	/*
	 --- Part Two ---

		Seeing how reindeer move in bursts, Santa decides he's not pleased with the old scoring system.
		
		Instead, at the end of each second, he awards one point to the reindeer currently in the lead. (If there are multiple reindeer tied for the lead, they each get one point.) He keeps the traditional 2503 second time limit, of course, as doing otherwise would be entirely ridiculous.
		
		Given the example reindeer from above, after the first second, Dancer is in the lead and gets one point. He stays in the lead until several seconds into Comet's second burst: after the 140th second, Comet pulls into the lead and gets his first point. Of course, since Dancer had been in the lead for the 139 seconds before that, he has accumulated 139 points by the 140th second.
		
		After the 1000th second, Dancer has accumulated 689 points, while poor Comet, our old champion, only has 312. So, with the new scoring system, Dancer would win (if the race ended at 1000 seconds).
		
		Again given the descriptions of each reindeer (in your puzzle input), after exactly 2503 seconds, how many points does the winning reindeer have?
	 */

	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day14\\input_day14.txt");
		
		List<String> instructions;
		Map<String, Raindeer> raindeers = new HashMap<String, Raindeer>();
		int traveltime = 2503;
		
		Raindeer leadingRaindeer = new Raindeer("default", 0,0,0);
		
		try {
			instructions = Files.readAllLines(path);
			for (String s : instructions) {
				String[] bits = s.split(" ");
				raindeers.put(bits[0], new Raindeer(bits[0], Integer.parseInt(bits[3]), Integer.parseInt(bits[6]), Integer.parseInt(bits[13])));
			}
			
			for (int i = 1; i <= traveltime; i++) {
				for (Raindeer deer : raindeers.values()) {
					if (deer.calculateRange(i) > leadingRaindeer.getRange()) {
						leadingRaindeer = deer;
					}
				}
				leadingRaindeer.addPoint();
				raindeers.replace(leadingRaindeer.name(), leadingRaindeer);
			}
			
			for (Raindeer d : raindeers.values()) {
				if (d.getPoints() > leadingRaindeer.getPoints()) {
					leadingRaindeer = d;
				}
				System.out.println(d.name() + " : " + d.getPoints());
			}
			
			System.out.println("Most points accumulated after 2503s is: " + leadingRaindeer.getPoints());
		} catch (IOException e) {
			e.printStackTrace();
		};

	}

}
