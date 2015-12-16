package Day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16_1 {
	//Done
	
	/*
	 --- Day 16: Aunt Sue ---

		Your Aunt Sue has given you a wonderful gift, and you'd like to send her a thank you card. However, there's a small problem: she signed it "From, Aunt Sue".
		
		You have 500 Aunts named "Sue".
		
		So, to avoid sending the card to the wrong person, you need to figure out which Aunt Sue (which you conveniently number 1 to 500, for sanity) gave you the gift. You open the present and, as luck would have it, good ol' Aunt Sue got you a My First Crime Scene Analysis Machine! Just what you wanted. Or needed, as the case may be.
		
		The My First Crime Scene Analysis Machine (MFCSAM for short) can detect a few specific compounds in a given sample, as well as how many distinct kinds of those compounds there are. According to the instructions, these are what the MFCSAM can detect:
		
		children, by human DNA age analysis.
		cats. It doesn't differentiate individual breeds.
		Several seemingly random breeds of dog: samoyeds, pomeranians, akitas, and vizslas.
		goldfish. No other kinds of fish.
		trees, all in one group.
		cars, presumably by exhaust or gasoline or something.
		perfumes, which is handy, since many of your Aunts Sue wear a few kinds.
		In fact, many of your Aunts Sue have many of these. You put the wrapping from the gift into the MFCSAM. It beeps inquisitively at you a few times and then prints out a message on ticker tape:
		
		children: 3
		cats: 7
		samoyeds: 2
		pomeranians: 3
		akitas: 0
		vizslas: 0
		goldfish: 5
		trees: 3
		cars: 2
		perfumes: 1
		You make a list of the things you can remember about each Aunt Sue. Things missing from your list aren't zero - you simply don't remember the value.
		
		What is the number of the Sue that got you the gift?
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
					if (clues.get(s) == compounds.get(s)) {
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
