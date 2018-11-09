package com.game;

public class ScreenBoard {

	
	public void printBoard(TicTacToeBoard board) {

		System.out.println(String.format("%" + board.size * 4 + "s", "").replace(' ', '-') + "-");

		for (int i = 0; i < board.size; i++) {
			System.out.print("| ");
			for (int j = 0; j < board.size; j++) {
				System.out.print(board.board[i][j] + " | ");
			}
			System.out.println();
			System.out.println(String.format("%" + board.size * 4 + "s", "").replace(' ', '-') + "-");
		}
	}
}
