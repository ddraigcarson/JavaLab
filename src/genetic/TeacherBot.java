package genetic;

import java.util.List;

public class TeacherBot {

	public int testBatchSize = 1;
	
	public void testBabyBots(List<BabyBot> babyBots) {
		
		for (int i=0 ; i<babyBots.size() ; i++) {
			Test test = new Test();
			ComputerBot player1 = new ComputerBot();
			BabyBot player2 = babyBots.get(i);
			
			test.setPlayer1(player1);
			test.setPlayer2(player2);
			
			for (int j=0 ; j<testBatchSize ; j++) {
				int gameResult = test.run();
				
				if(gameResult == 3) {
					Stats.getInstance().draws++;
				}
				
				if (player1.symbol == gameResult) {
					player1.score++;
				}
				if (player2.symbol == gameResult) {
					player2.score++;
				}
			}
			
		}
		
		
	}
	
}
