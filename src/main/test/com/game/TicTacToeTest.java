package com.game;

public class TicTacToeTest extends GameAbstractTest {

	public TicTacToeTest(int size, char[] players) {
		super(size, players);
	}

	private static final char[] PLAYERS = new char[] { 'x', 'o' };

	public static void main(String[] args) {

		TicTacToeTest test = new TicTacToeTest(3, PLAYERS);

		test.fillRowsTest();
		test.fillRowsFailTest();
		test.fillColumnsTest();
		test.fillColumnsFailTest();
		test.fillDiagonalsTest();
		test.fillDiagonalsFailTest();

	}

	private void fillRowsTest() {

		resetBoard();
		placeSymbol(0, 0);
		placeSymbol(0, 1);
		placeSymbol(0, 2);

		System.out.println(" FillRowsTest "+ ( fillRows() ? "Success" : "Fail"));

	}

	private void fillRowsFailTest() {

		resetBoard();
		placeSymbol(0, 0);
		placeSymbol(1, 1);
		placeSymbol(0, 2);

		System.out.println(" FillRowsTest "+ ( !fillRows() ? "Success" : "Fail"));

	}

	private void fillColumnsTest() {

		resetBoard();
		placeSymbol(0, 1);
		placeSymbol(1, 1);
		placeSymbol(2, 1);

		System.out.println(" FillColumnsTest "+ ( fillColumns() ? "Success" : "Fail"));

	}
	
	private void fillColumnsFailTest() {

		resetBoard();
		placeSymbol(0, 1);
		placeSymbol(2, 1);
		placeSymbol(3, 1);

		System.out.println(" FillColumnsFailTest "+ ( !fillColumns() ? "Success" : "Fail"));

	}
	
	private void fillDiagonalsTest() {

		resetBoard();
		placeSymbol(0, 0);
		placeSymbol(1, 1);
		placeSymbol(2, 2);

		System.out.println(" FillDiagonalsTest "+ ( fillDiagonals() ? "Success" : "Fail"));

	}
	
	private void fillDiagonalsFailTest() {

		resetBoard();
		placeSymbol(0, 1);
		placeSymbol(1, 1);
		placeSymbol(2, 2);

		System.out.println(" FillDiagonalsFailTest "+ ( !fillDiagonals() ? "Success" : "Fail"));

	}

}
