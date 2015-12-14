package Day12;

import java.net.MalformedURLException;
import java.net.URL;

public class Day12_2 {

	
	/*
	 --- Part Two ---

		Uh oh - the Accounting-Elves have realized that they double-counted everything red.
		
		Ignore any object (and all of its children) which has any property with the value "red". Do this only for objects ({...}), not arrays ([...]).
		
		[1,2,3] still has a sum of 6.
		[1,{"c":"red","b":2},3] now has a sum of 4, because the middle object is ignored.
		{"d":"red","e":[1,2,3,4],"f":5} now has a sum of 0, because the entire structure is ignored.
		[1,"red",5] has a sum of 6, because "red" in an array has no effect.
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day12\\input_day12.txt");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
