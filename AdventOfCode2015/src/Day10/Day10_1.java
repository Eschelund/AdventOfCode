package Day10;

public class Day10_1 {
	
	/*
	 --- Day 10: Elves Look, Elves Say ---

		Today, the Elves are playing a game called look-and-say. They take turns making sequences by reading aloud the previous sequence and using that reading as the next sequence. For example, 211 is read as "one two, two ones", which becomes 1221 (1 2, 2 1s).
		
		Look-and-say sequences are generated iteratively, using the previous value as input for the next step. For each step, take the previous value, and replace each run of digits (like 111) with the number of digits (3) followed by the digit itself (1).
		
		For example:
		
		1 becomes 11 (1 copy of digit 1).
		11 becomes 21 (2 copies of digit 1).
		21 becomes 1211 (one 2 followed by one 1).
		1211 becomes 111221 (one 1, one 2, and two 1s).
		111221 becomes 312211 (three 1s, two 2s, and one 1).
		Starting with the digits in your puzzle input, apply this process 40 times. What is the length of the result?
		
		Your puzzle input is 1321131112.
	 */

	public static void main(String[] args) {
		StringBuilder input = new StringBuilder();
		input.append("1321131112");
		int prev = 0;
		
		for (int i = 0; i < 40; i++) {
			StringBuilder temp = new StringBuilder();
			int count = 1;
			prev = Integer.parseInt(input.substring(0,1));
			for (int j = 1; j < input.length(); j++) {
				int curr = Integer.parseInt(input.substring(j,j+1));
				if (curr == prev) {
					count++;
				} else {
					temp.append("" + count + prev); 
					prev = curr;
					count = 1;
				}
			}
			temp.append("" + count + prev);
//			System.out.println(i + " : " + temp.toString());
			input = temp;
		}
		
		System.out.println("the last number is: " + input.toString());

	}

}
