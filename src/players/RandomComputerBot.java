package players;

import java.util.List;
import java.util.Map;

import evolution.Board;
import evolution.BoardSquare;
import evolution.BoardState;
import util.Maths;

/**
 * 
 * This is random computer bot, it makes decisions based a random number generator.
 * However the computer cannot make a failed move ie it wont pick an already used
 * square
 * 
 * */
public class RandomComputerBot implements Player {

	private int playerScore;
	
	private BoardState playerSymbol;

	@Override
	public BoardSquare chooseNextPosition(Board board) {
		List<BoardSquare> availableSquares = board.getAvailableSquares();
		int randomInt = Maths.randomInt(0, availableSquares.size());
		BoardSquare chosenPosition= availableSquares.get(randomInt);
		return chosenPosition;
	}

	@Override
	public void onGameEnd(BoardState endGameState) {
		// do nothing, don't need to track the score of computer players		
//		
//		if(endGameState.getValue() == playerSymbol.getValue()) {
//			playerScore++;
//		} else {
//			playerScore--;
//		}
//		
	}

	@Override
	public void resetBot() {
		playerScore = 0;
	}

	@Override
	public void setPlayerSymbol(BoardState playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	@Override
	public BoardState getPlayerSymbol() {
		return playerSymbol;
	}

	@Override
	public void setPlayerScore(int value) {
		this.playerScore = value;		
	}

	@Override
	public int getPlayerScore() {
		return playerScore;
	}

	@Override
	public Map<String, BoardSquare> getMemory() {
		// Do nothing
		return null;
	}
	
	
	
}
