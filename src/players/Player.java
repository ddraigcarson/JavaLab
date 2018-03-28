package players;

import java.util.Map;

import evolution.Board;
import evolution.BoardSquare;
import evolution.BoardState;

public interface Player {

	public BoardState playerSymbol = BoardState.NUL;
	
	public BoardSquare chooseNextPosition(Board board);
	
	public void onGameEnd(BoardState endGameState);
	
	public void resetBot();
	
	public void setPlayerSymbol(BoardState value);
	
	public BoardState getPlayerSymbol();
	
	public void setPlayerScore(int value);
	
	public int getPlayerScore();

	public Map<String, BoardSquare> getMemory();
	
}
