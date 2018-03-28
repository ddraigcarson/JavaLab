package evolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import players.Player;
import players.RandomComputerBot;

/**
 * 
 * Teacher bot is designed to test the player bots
 * In this case testing is creating computers for them to play against and
 * checking if they win
 * 
 * */
public class TeacherBot {

	private final int gamesPerTest;
	private final Player computerBot = new RandomComputerBot();
	
	public TeacherBot(int gamesPerTest) {
		this.gamesPerTest = gamesPerTest;
	}
	
	public List<Board> createTests(List<Player> bots) {
		List<Board> tests = new ArrayList<Board>();
		for (Player playerBot : bots) {
			Board test = new Board(playerBot, computerBot);
			tests.add(test);
		}
		return tests;
	}

	public List<Board> resetTests(List<Board> tests, List<Player> bots) {
		for (int i=0 ; i<tests.size() ; i++) {
			tests.get(i).resetBoard(bots.get(i), computerBot);
		}
		return tests;
	}

	public void executeTests(List<Board> tests){
		for (Board test : tests) {
			normalTest(test);
		}
	}
	
	private void normalTest(Board test) {
		for (int i=0 ; i<gamesPerTest ; i++) {
			BoardState winner = test.playGame();
			test.getPlayer1().onGameEnd(winner);
			test.getPlayer2().onGameEnd(winner);
		}
	}
}
