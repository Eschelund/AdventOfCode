package Day10;

public class Day10_2 {
	//Done
	
	/*
	 --- Part Two ---

		Neat, right? You might also enjoy hearing John Conway talking about this sequence (that's Conway of Conway's Game of Life fame).
		
		Now, starting again with the digits in your puzzle input, apply this process 50 times. What is the length of the new result?
		
		Your puzzle input is still 1321131112.
	 */

	public static void main(String[] args) {
		StringBuilder input = new StringBuilder();
		input.append("1321131112");
		int prev = 0;
		
		for (int i = 0; i < 50; i++) {
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
			input = temp;
		}
		
		System.out.println("the lenght of the last number is: " + input.toString().length());

	}

}
