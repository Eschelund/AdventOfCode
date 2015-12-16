package Day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16_2 {
	//Done
	
	/*
	 --- Part Two ---

		As you're about to send the thank you note, something in the MFCSAM's instructions catches your eye. Apparently, it has an outdated retroencabulator, and so the output from the machine isn't exact values - some of them indicate ranges.
		
		In particular, the cats and trees readings indicates that there are greater than that many (due to the unpredictable nuclear decay of cat dander and tree pollen), while the pomeranians and goldfish readings indicate that there are fewer than that many (due to the modial interaction of magnetoreluctance).
		
		What is the number of the real Aunt Sue?
	 */

	public static void main(String[] args) {
		Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day16\\input_day16.txt");
		
		List<String> instructions;
		
		Map<String,Integer> compounds = new HashMap<>();
		
		compounds.put("children",3);
		compounds.put("cats",7);
		compounds.put("samoyeds",2);
		compounds.put("pomeranians",3);
		compounds.put("akitas",0);
		compounds.put("vizslas",0);
		compounds.put("goldfish",5);
		compounds.put("trees",3);
		compounds.put("cars",2);
		compounds.put("perfumes",1);
		
		List<Aunt> aunts = new ArrayList<>();
		
		Aunt giftSender = null;

		try {
			instructions = Files.readAllLines(path);
			
			for (String s : instructions) {
				Map<String,Integer> clues = new HashMap<>();
				String[] bits = s.replaceAll(":", "").replaceAll(",", "").split(" ");
				clues.put(bits[2], Integer.parseInt(bits[3]));
				clues.put(bits[4], Integer.parseInt(bits[5]));
				clues.put(bits[6], Integer.parseInt(bits[7]));
				
				aunts.add(new Aunt(Integer.parseInt(bits[1]), clues));
			}
			
			for (Aunt a : aunts) {
				Map<String,Integer> clues = a.getClues();
				int matches = 0;
				for(String s : clues.keySet()) {
					if ((s.equals("cats") || s.equals("trees")) && clues.get(s) > compounds.get(s)) {
						matches++;
					} else if ((s.equals("pomeranians") || s.equals("goldfish")) && clues.get(s) < compounds.get(s)) {
						matches++;
					} else if ((!s.equals("cats") && !s.equals("trees") && !s.equals("pomeranians") && !s.equals("goldfish")) && clues.get(s) == compounds.get(s)) {
						matches++;
					}
				}
				if (matches == 3) {
					giftSender = a;
					break;
				}
			}
			
			System.out.println("Sue number " + giftSender.getNum() + " sent the gift");
			
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

}
