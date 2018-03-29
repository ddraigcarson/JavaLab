package genetic;

import java.util.Arrays;

public class Test {

	private int[] board = new int[9];
	
	private BabyBot player1;
	private BabyBot player2;

	private BabyBot currentPlayer;
	private BabyBot offTurnPlayer;

	public void setPlayer1(BabyBot player1) {
		this.player1 = player1;
		this.player1.symbol = 1;
	}
	
	public void setPlayer2(BabyBot player2) {
		this.player2 = player2;
		this.player2.symbol = 2;
	}
	
	public int run() {
		Arrays.fill(board, 0);
		currentPlayer = player1;
		offTurnPlayer = player2;
		
		int winner = 0;
		while(winner == 0) {
			int playerChoice = currentPlayer.chooseStrategy(board);
			if (board[playerChoice] == 0) {
				board[playerChoice] = currentPlayer.symbol;
//				System.out.println(Arrays.toString(board));
			} else {
				Stats.getInstance().disqualifications++;
				return offTurnPlayer.symbol;
			}
			
			BabyBot temp = currentPlayer;
			currentPlayer = offTurnPlayer;
			offTurnPlayer = temp;
			
			winner = checkForWinner();
		}
		return winner;
	}
	
	public boolean checkForDraw(){
		boolean isDraw = true;
		for (int i=0 ; i<board.length ; i++) {
			if (board[i] == 0) {
				isDraw = false;
			}
		}
		return isDraw;
	}
	
	public int checkForWinner(){
		if (checkForDraw()) {
			return 3;
		}
		for (WinCondition condition : WinCondition.values()) {
			int[] winPositions = condition.getPositions();
			if (board[winPositions[0]] != 0
					&& board[winPositions[0]] == board[winPositions[1]]
							&& board[winPositions[1]] == board[winPositions[2]]) {
				return board[winPositions[0]]; 
			}
		}
		return 0; // no winner yet
	}
}
