package com.game;

public abstract class GameAbstractTest extends TicTacToeBoard {

	public GameAbstractTest(int size, char[] players) {
		super(size, players);
	}

	protected void placeTest(TicTacToeBoard board, int col, int row) {
		board.placeSymbol(col, row);
		board.changePlayer();
	}

	protected void placeTest(int col, int row) {
		placeSymbol(col, row);
		changePlayer();
	}

	protected void resetBoard() {
		this.currentSymbol = 'x';
		initializeBoard();
	}

	protected void checkWin() {
		if (isBoardFull() && !fillForWin()) {
			// System.out.println("The game was a tie!");
		} else {
			// new ScreenBoard().printBoard(this);

			changePlayer();
			changePlayer();
//			/System.out.println(Character.toUpperCase(currentSymbol) + " has won!");
		}
	}

	protected boolean finished() {
		return !fillForWin() && !isBoardFull();

	}

}
