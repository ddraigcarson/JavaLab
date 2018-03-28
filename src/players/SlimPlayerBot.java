package players;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import evolution.Board;
import evolution.BoardSquare;
import evolution.BoardState;
import evolution.TimingEvent;
import evolution.Timings;
import util.Maths;

/**
 * 
 * The bot makes a move, it then remembers how the board now looks and the move it made.
 * If it remembers a move then it makes it else it takes a guess (random move) 
 * 
 * */
public class SlimPlayerBot implements Player {

	private int playerScore;
	
	private BoardState playerSymbol;
	
	private Map<String, BoardSquare> memory; 
	
	public SlimPlayerBot() {
		memory = new HashMap<String, BoardSquare>();
	}

	@Override
	public BoardSquare chooseNextPosition(Board board) {
		String boardState = Arrays.toString(board.getBoard());	
		BoardSquare rememberedMove = memory.get(boardState);
		
		if (rememberedMove != null) {
			return rememberedMove;
		} else {
			BoardSquare[] squares = BoardSquare.values();
			BoardSquare newMove = squares[Maths.randomInt(0, squares.length)];
			memory.put(Arrays.toString(board.getBoard()), newMove);
			return newMove;
		}
	}
	
	@Override
	public void onGameEnd(BoardState endGameState) {
		if(endGameState.getValue() == playerSymbol.getValue()) {
			playerScore++;
		} else {
			playerScore--;
		}
	}

	@Override
	public void resetBot() {
		memory.clear();
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
		return memory;
	}
	
}
