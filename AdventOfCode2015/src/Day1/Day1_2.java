package Day1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day1_2 {
	//Done

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int res = 0;
			int pos = 0;
			Path path = Paths.get("D:\\Workspaces\\EclipseWorkspace\\AdventOfCode2015\\src\\Day1\\input.txt");
			byte[] bs = Files.readAllBytes(path);
			String input = new String(bs);
			
			for	(char c : input.toCharArray()) {
				pos++;
				if (c == '(') {
					res++;
				}
				if (c == ')') {
					res--;
				}
				if (res < 0) {
					System.out.println("Basement reached at position:" + pos);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
