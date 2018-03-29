package genetic;

import java.util.List;

public class TeacherBot {

	public int testBatchSize = 1;
	
	public void testBabyBots(List<BabyBot> babyBots) {
		
		for (int i=0 ; i<babyBots.size() ; i+=2) {
			Test test = new Test();
			BabyBot player1 = babyBots.get(i);
			BabyBot player2 = babyBots.get(i+1);
			
			test.setPlayer1(player1);
			test.setPlayer2(player2);
			
			for (int j=0 ; j<testBatchSize ; j++) {
				int gameResult = test.run();
				
				if(gameResult == 3) {
					Stats.getInstance().draws++;
				}
				
				player1.onResult(gameResult);
				player2.onResult(gameResult);	
			}
			
		}
		
		
	}
	
}
