package evolution;

import java.util.List;

import players.Player;

public class Evolution {

	private final int botBatchSize= 100;
	private final int gamesPerTest = 100;
	private final int evolutionCycles = 5;
	
	public Evolution() {
	}

	public void execute() {
		Timings timings = Timings.getInstance();
		timings.addEvent(TimingEvent.START);
		
		BuilderBot builderBot = new BuilderBot();
		TeacherBot teacherBot = new TeacherBot(gamesPerTest);
		
		timings.addEvent(TimingEvent.CREATE_BOTS_START);
		List<Player> bots = builderBot.createPlayerBotBatch(botBatchSize);
		timings.addEvent(TimingEvent.CREATE_BOTS_END);
		
		timings.addEvent(TimingEvent.CREATE_BOARDS_START);
		List<Board> tests = teacherBot.createTests(bots);
		timings.addEvent(TimingEvent.CREATE_BOARDS_END);

		timings.addEvent(TimingEvent.TEST_START);
		teacherBot.executeTests(tests);
		timings.addEvent(TimingEvent.TEST_END);
		Player bestBot = builderBot.findBestBot(bots);
		
		for (int i=0 ; i<evolutionCycles ; i++) {
			System.out.println("Generation: " + i);
			//bots = builderBot.createPlayerBotBatch(botBatchSize, bestBot);
			timings.addEvent(TimingEvent.RESET_BOTS_START);
			bots = builderBot.createBestBotBatch(bots, bestBot);
			timings.addEvent(TimingEvent.RESET_BOTS_END);
			
			timings.addEvent(TimingEvent.RESET_BOARDS_START);
			tests = teacherBot.resetTests(tests, bots);
			timings.addEvent(TimingEvent.RESET_BOARDS_END);
		
			timings.addEvent(TimingEvent.TEST_START);
			teacherBot.executeTests(tests);		
			timings.addEvent(TimingEvent.TEST_END);
			
			bestBot = builderBot.findBestBot(bots);
		}		
		
		timings.addEvent(TimingEvent.END);
		
		printLatestRoundSummary(bots);
		//printBotAvgScores(bots);
		timings.printTimings(150);
	}
	
	private void printLatestRoundSummary(List<Player> bots){
		double runningTotal = 0;
		double minValue = -gamesPerTest;
		for (Player bot : bots) {
			runningTotal += bot.getPlayerScore();
			if(bot.getPlayerScore() > minValue) {
				minValue = bot.getPlayerScore();
			}
		}
		double averageScore =  Math.abs(runningTotal)/gamesPerTest;
		double lowestLossRate = Math.abs(minValue);
		System.out.println("Average score:\t\t" + averageScore);
		System.out.println("Lowest loss rate:\t" + lowestLossRate);
	}
	
	@SuppressWarnings("unused")
	private void printBotAvgScores(List<Player> bots) {
		for (Player bot : bots) {
			System.out.println((Math.abs((double)bot.getPlayerScore())/gamesPerTest)*100); 
		}		
	}
	
}
