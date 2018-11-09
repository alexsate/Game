package com.game;

import java.util.Random;

public class PlayerAI {
	
	public static char SYMBOL = '*';

	
	public int[] placeAI(TicTacToeBoard board) {

		// System.err.println("marckAi count");
		int rowA = new Random().nextInt(board.size);
		int colA = new Random().nextInt(board.size);

		int[] marckAi = null;
		if (board.board[rowA][colA] == '-') {
			return new int[] { rowA, colA };
		} else {
			marckAi = placeAI(board);
		}

		return marckAi;
	}
}
