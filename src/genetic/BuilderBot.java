package genetic;

import java.util.ArrayList;
import java.util.List;

public class BuilderBot {

	public List<BabyBot> createBabyBots(int batchSize) {
		List<BabyBot> babyBots = new ArrayList<>();
		for (int i=0 ; i<batchSize ; i++) {
			babyBots.add(new BabyBot());
		}
		return babyBots;
	}
	
}
