package com.game;

public interface ITicTacToe {
	
	boolean fillRows();

	boolean fillDiagonals();

	boolean fillColumns();
	
	boolean isBoardFull();
	
}
