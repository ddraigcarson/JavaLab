package genetic;

import java.util.Collections;
import java.util.List;

public class GeneticModel {

	private int babyBotBatchSize = 40;
	private int suvivorLimit = 20;
	private int testBatchSize = 10;
	private int evolutionCycles = 10000;
	
	public void execute() {

		BuilderBot builderBot = new BuilderBot();
		TeacherBot teacherBot = new TeacherBot();
		
		List<BabyBot> bots = builderBot.createBabyBots(babyBotBatchSize);
		teacherBot.testBatchSize = testBatchSize;
		teacherBot.testBabyBots(bots);
		
		for (int i=0 ; i<evolutionCycles ; i++) {
			bots = growNewGeneration(bots);
			teacherBot.testBabyBots(bots);
			//System.out.println("Disquals: " + Stats.getInstance().disqualifications);
			Stats.getInstance().disqualifications = 0;
			for (BabyBot bot : bots) {
				System.out.print(bot.score + ",");
			}
			System.out.println();
		}
		System.out.println("FINISH");
	}
	
	private List<BabyBot> growNewGeneration(List<BabyBot> bots) {
		// Clone best bots
		Collections.sort(bots, BabyBot.babyBotComparator());
		for (int i=0 ; i<suvivorLimit ; i++) {
			BabyBot currentBot = bots.get(i);
			BabyBot newBot = bots.get(i + suvivorLimit);
			newBot.strategies.clear();
			newBot.strategies.putAll(currentBot.strategies);
		}
		// Rest are blank bots
		for (int j=2*suvivorLimit ; j<bots.size() ; j++) {
			bots.get(j).strategies.clear();
		}
		Collections.sort(bots, BabyBot.randomComparator());
		// Reset scores
		for (BabyBot bot : bots) {
			bot.score = 0;
		}
		return bots;
	}
	
}
