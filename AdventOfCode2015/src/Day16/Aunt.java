package Day16;

import java.util.Map;

public class Aunt {
	private int num;
	private Map<String, Integer> clues;

	public Aunt(int num, Map<String, Integer> clues) {
		this.num = num;
		this.clues = clues;
	}
	
	public int getNum() {
		return num;
	}

	public Map<String,Integer> getClues() {
		return clues;
	}
}
