package genetic;

import java.util.List;

public class GeneticModel {

	private int babyBotBatchSize = 100;
	private int testBatchSize = 100;
	
	public void execute() {

		BuilderBot builderBot = new BuilderBot();
		TeacherBot teacherBot = new TeacherBot();
		
		List<BabyBot> bots = builderBot.createBabyBots(babyBotBatchSize);
		teacherBot.testBatchSize = testBatchSize;
		teacherBot.testBabyBots(bots);
		
		for (BabyBot bot : bots) {
			System.out.print(bot.score + ",");
		}
		System.out.println();
		System.out.println("Draws: " + Stats.getInstance().draws + "\tDisquals: " + Stats.getInstance().disqualifications);
	}
	
}
