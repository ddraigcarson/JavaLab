package evolution;

import java.util.concurrent.CountDownLatch;

public class Test implements Runnable {

	Thread runner;
	Board game;
	int gamesPerTest;
	CountDownLatch latch;
	
	public Test(String threadName, Board game, int gamesPerTest, CountDownLatch latch) {
		runner = new Thread(this, threadName);
		this.game = game;
		this.gamesPerTest = gamesPerTest;
		this.latch = latch;
		
		runner.start();
	}

	@Override
	public void run() {
		for (int i=0 ; i<gamesPerTest ; i++) {
			BoardState winner = game.playGame();
			game.getPlayer1().onGameEnd(winner);
			game.getPlayer2().onGameEnd(winner);
		}
		latch.countDown();
	}

}
