package genetic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import util.Maths;

public class BabyBot {

	public int symbol;
	public int score;
	
	public Map<String, Integer> strategies = new HashMap<>();

	public int chooseStrategy(int[] board) {
		String boardState = Arrays.toString(board);
		Integer rememberedStrategy = strategies.get(boardState);
		
		if(rememberedStrategy != null) {
//			System.out.println("Remembered");
			return rememberedStrategy;
		} else {
//			System.out.println("NEW");
			int randomMove = Maths.randomInt(0, 8);
			strategies.put(boardState, randomMove);
			return randomMove;
		}
	}
	
	public static Comparator<BabyBot> babyBotComparator() {
		Comparator<BabyBot> comp = new Comparator<BabyBot>() {
			@Override
			public int compare(BabyBot o1, BabyBot o2) {
				return Integer.compare(o2.score, o1.score);
			}
		};
		return comp;
	}
	
	public static Comparator<BabyBot> randomComparator() {
		Comparator<BabyBot> comp = new Comparator<BabyBot>() {
			@Override
			public int compare(BabyBot o1, BabyBot o2) {
				int r1 = Maths.randomInt(0, 9);
				int r2 = Maths.randomInt(0, 1);
				int r3 = Maths.randomInt(1, 5);
				int i1 = r1;
				int i2 = r1;
				if (r2 == 0) {
					i2 += r3;
				} else {
					i2 -= r3;
				}
				return Integer.compare(i1, i2);
			}
		};
		return comp;
	}
	
}
