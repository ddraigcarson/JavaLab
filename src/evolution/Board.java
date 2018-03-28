package evolution;

import java.util.ArrayList;
import java.util.List;

import players.Player;
import util.Maths;

public class Board {

	/**
	 * 
	 * The TicTac board
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 * 
	 * 
	 * Use a byte array for board as it is the smallest memory primitive which
	 * should hopefully help if i do millions of iterations in an evolutionary model
	 * 
	 * */
	
	private final int boardLimit = 9;	
	private byte[] board = new byte[boardLimit];
	private Player player1; 
	private Player player2; 
	private boolean evenTurn; 
	
	public Board(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		player1.setPlayerSymbol(BoardState.TIC);
		player2.setPlayerSymbol(BoardState.TAC);
	}

	public void clearBoard() {
		board = new byte[boardLimit];
	}
	
	public void resetBoard(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		player1.setPlayerSymbol(BoardState.TIC);
		player2.setPlayerSymbol(BoardState.TAC);
		board = new byte[boardLimit];
	}
	
	public BoardState playGame() {
		BoardState winner = BoardState.NUL;
		while (winner == BoardState.NUL) {
			winner = takeTurn();
		}
		clearBoard();
		return winner;
	}
	
	public BoardState takeTurn(){
		Player currentPlayer = evenTurn ? player2 : player1;
		Player offPlayer = evenTurn ? player1 : player2;
		
		BoardSquare choice = currentPlayer.chooseNextPosition(this);
		
		if (board[choice.getValue()] != BoardState.NUL.getValue() ) {
			// Illegal choice
			// System.out.println("Illegal move, game lost for current player");
			return offPlayer.getPlayerSymbol();
		} 
		
		board[choice.getValue()] = currentPlayer.getPlayerSymbol().getValue();
		evenTurn = !evenTurn;		
		return checkForWinner();
	}	
	
	public List<BoardSquare> getAvailableSquares(){
		List<BoardSquare> availableSquares = new ArrayList<BoardSquare>();
		for (BoardSquare pos : BoardSquare.values()) {
			if(board[pos.getValue()] == BoardState.NUL.getValue()) {
				availableSquares.add(pos);
			}
		}
		return availableSquares;
	}
	
	public void printBoard() {
		System.out.print("[" + turnByteToDisplay(board[0]) + "]\t" + "[" + turnByteToDisplay(board[1]) + "]\t" + "[" + turnByteToDisplay(board[2]) + "]\n");
		System.out.print("[" + turnByteToDisplay(board[3]) + "]\t" + "[" + turnByteToDisplay(board[4]) + "]\t" + "[" + turnByteToDisplay(board[5]) + "]\n");
		System.out.print("[" + turnByteToDisplay(board[6]) + "]\t" + "[" + turnByteToDisplay(board[7]) + "]\t" + "[" + turnByteToDisplay(board[8]) + "]\n");
	}
	
	private String turnByteToDisplay(byte value){
		if (value == BoardState.TIC.getValue()) {
			return BoardState.TIC.getDisplay();
		}
		if (value == BoardState.TAC.getValue()) {
			return BoardState.TAC.getDisplay();
		}
		return BoardState.NUL.getDisplay();
	}

	private BoardState checkForWinner(){
		for (WinCondition win: WinCondition.values()) {
			int[] positions = win.getPositions();
			if (board[positions[0]] != BoardState.NUL.getValue() 
					&& board[positions[0]] == board[positions[1]]
							&& board[positions[1]] == board[positions[2]]) {
				
				if (board[positions[0]] == BoardState.TIC.getValue()) {
					return BoardState.TIC;
				} else {
					return BoardState.TAC;
				}
			}
		}
		List<BoardSquare> availableSquares = getAvailableSquares();
		if(availableSquares.isEmpty()) {
			return BoardState.DRAW;
		}
		
		return BoardState.NUL;
	}
	
	public byte[] getBoard() {
		return board;
	}

	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
}
