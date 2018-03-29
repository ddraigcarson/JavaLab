package genetic;

import java.util.HashMap;
import java.util.Map;

import util.Maths;

public class BabyBot {

	public int symbol;
	public int score;
	
	Map<String, Integer> strategies = new HashMap<>();

	public int chooseStrategy(int[] board) {
		return Maths.randomInt(0, 8);
	}
	
	public void onResult(int result) {
		if (result == symbol) {
			score++;
		}
	}
	
}
