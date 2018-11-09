package com.game;

public class TicTacToeBoard implements IBoard, ITicTacToe {
	
	public char[][] board;
	public int size;
	public char currentSymbol;
	private char[] players;
	
	public TicTacToeBoard(int size, char[] players) {
		
		this.players = players;
		this.size = size;
		board = new char[size][size];
		currentSymbol = players[0];
		initializeBoard();
	}

	@Override
	public void initializeBoard() {

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {
				board[i][j] = '-';
			}
		}
	}

	@Override
	public boolean isBoardFull() {
		boolean isFull = true;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == '-') {
					isFull = false;
				}
			}
		}
		
		return isFull;
	}

	public boolean fillForWin() {
		return (fillRows() || fillColumns() || fillDiagonals());
	}

	@Override
	public boolean fillRows() {

		boolean checked = false;
		for (int i = 0; i < size; i++) {

			char[] row = new char[size];
			for (int j = 0; j < size; j++) {
				row[j] = board[i][j];
			}

			if (fillRowCol(row)) {
				checked = true;
				break;
			}

		}

		return checked;
	}

	@Override
	public boolean fillColumns() {

		boolean checked = false;
		for (int i = 0; i < size; i++) {

			char[] col = new char[size];
			for (int j = 0; j < size; j++) {
				col[j] = board[j][i];
			}

			if (fillRowCol(col)) {
				checked = true;
				break;
			}
		}

		return checked;
	}

	@Override
	public boolean fillDiagonals() {

		char[] diag1 = new char[size];
		for (int i = 0; i < size; i++) {
			diag1[i] = board[i][i];
		}

		char[] diag2 = new char[size];
		int icol = 0;
		for (int irow = size - 1; irow >= 0; irow--) {
			diag2[irow] = board[icol][irow];
			icol++;
		}

		return fillRowCol(diag1) || fillRowCol(diag2);
	}

	private boolean fillRowCol(char... rowCol) {

		boolean checked = false;
		for (int i = 0; i < rowCol.length; i++) {
			if (rowCol[i] == '-' || (i > 0 && !checked)) {
				return false;
			} else if (i + 1 < rowCol.length) {
				checked = rowCol[i] == rowCol[i + 1];
			}
		}

		return checked;
	}

	public void changePlayer() {
		if (currentSymbol == this.players[0]) {
			currentSymbol = this.players[1];
		} else if (currentSymbol == this.players[1]) {
			currentSymbol = PlayerAI.SYMBOL;
		} else if (currentSymbol == PlayerAI.SYMBOL) {
			currentSymbol = this.players[0];
		}
	}

	@Override
	public boolean placeSymbol(int row, int col) {

		if ((row >= 0) && (row < size)) {
			if ((col >= 0) && (col < size)) {
				if (board[row][col] == '-') {
					board[row][col] = currentSymbol;
					return true;
				}
			}
		}

		return false;
	}
	
}
