package genetic;

import java.util.ArrayList;
import java.util.List;

import util.Maths;

public class ComputerBot extends BabyBot {

	@Override
	public int chooseStrategy(int[] board) {
		List<Integer> availableMoves = new ArrayList<Integer>();
		for (int square: board) {
			if (square == 0) {
				availableMoves.add(square);
			}
		}
		return availableMoves.get(Maths.randomInt(0, availableMoves.size()));
	}

	


}
