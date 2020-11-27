package Day1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day1_1 {
	//Done

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int res = 0;
			Path path = Paths.get("D:\\Repositories\\AdventOfCode\\AdventOfCode2015\\src\\Day1\\input.txt");
			byte[] bs = Files.readAllBytes(path);
			String input = new String(bs);
			
			for	(char c : input.toCharArray()) {
				if (c == '(') {
					res++;
				}
				if (c == ')') {
					res--;
				}
			}
			System.out.println("The trail ends at floor: " +res);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
