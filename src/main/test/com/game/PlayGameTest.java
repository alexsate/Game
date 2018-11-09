package com.game;

public class PlayGameTest extends GameAbstractTest {

	public PlayGameTest(int size, char[] players) {
		super(size, players);
	}

	private static final char[] PLAYERS = new char[] { 'x', 'o' };

	public static void main(String[] args) {

		PlayGameTest test = new PlayGameTest(3, PLAYERS);

		test.firstRowWinTest();
		test.secondRowWinTest();
		test.diagonalTest();

	}

	/*-
	 * -------------
	 * | x | x | x | 
	 * -------------
	 * | o | o | - | 
	 * -------------
	 * | * | * | - | 
	 * -------------
	 * X has won!
	 * 
	 */
	private void firstRowWinTest() {

		resetBoard();
		int SIZE = 3;

		for (int i = 0; i < SIZE; i++) {

			placeTest(0, i);

			if (!finished())
				break;

			placeTest(1, i);
			placeTest(2, i);

		}

		checkWin();
		if (fillForWin() && currentSymbol == 'x') {
			System.out.println("FirstRowWinTest Success!");
		} else {
			System.out.println("FirstRowWinTest Fail!");
		}

	}

	/*-
	 * -------------
	 * | x | x | - | 
	 * -------------
	 * | o | o | o | 
	 * -------------
	 * | * | * | x | 
	 * -------------
	 * O has won!
	 */
	private void secondRowWinTest() {

		resetBoard();
		placeTest(0, 0);
		placeTest(1, 0);
		placeTest(2, 0);

		placeTest(0, 1);
		placeTest(1, 1);
		placeTest(2, 1);

		placeTest(2, 2);
		placeTest(1, 2);

		if (!finished()) {

			checkWin();

			if (fillForWin() && currentSymbol == 'o') {
				System.out.println("SecondRowWinTest Success!");
			} else {
				System.out.println("SecondRowWinTest Fail!");
			}
		}

	}

	/*-
	 * -------------
	 * | o | * | x | 
	 * -------------
	 * | - | x | - | 
	 * -------------
	 * | x | - | * | 
	 * -------------
	 * X has won!
	 */
	private void diagonalTest() {

		resetBoard();

		placeTest(0, 2);
		placeTest(0, 0);
		placeTest(0, 1);

		placeTest(1, 1);
		placeTest(0, 2);
		placeTest(2, 2);

		placeTest(2, 0);

		if (!finished()) {

			checkWin();

			if (fillForWin() && currentSymbol == 'x') {
				System.out.println("DiagonalTest Success!");
			} else {
				System.out.println("DiagonalTest Fail!");
			}
		}

	}

}
