package com.game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	public TicTacToeBoard board;
	public PlayerAI playerAI;
	public ScreenBoard screenBoard;

	public Main(int size, char[] players) {

		this.board = new TicTacToeBoard(size, players);
		this.playerAI = new PlayerAI();
		this.screenBoard = new ScreenBoard();
	}

	public static void main(String[] args) {

		Properties props = new Properties();

		try {

			/*
			 * ClassLoader loader = Thread.currentThread().getContextClassLoader();
			 * try(InputStream resourceStream = loader.getResourceAsStream("config.ini")) {
			 * props.load(resourceStream); }
			 */
			FileInputStream fileInputStream = new FileInputStream("./config.ini");

			props.load(fileInputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		int boradSquareSize = Integer.valueOf(props.getProperty("boardSquareSize"));
		System.out.println(boradSquareSize);
		char player1 = props.getProperty("player1").toString().charAt(0);
		char player2 = props.getProperty("player2").toString().charAt(0);

		char[] players = new char[] { player1, player2 };
		new Main(boradSquareSize, players).run();

	}

	private void run() {

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Current board layout:");
			this.screenBoard.printBoard(board);
			int row;
			int col;
			do {

				if (board.currentSymbol == PlayerAI.SYMBOL) {

					int[] colRoe = playerAI.placeAI(this.board);

					row = colRoe[0];
					col = colRoe[1];

				} else {

					System.out.println("Player " + board.currentSymbol
							+ ", enter an empty(-) row and column to place a position!");
					String nextLine = scan.nextLine();
					String[] split = nextLine.split(",");
					row = Integer.parseInt(split[0]) - 1;
					col = Integer.parseInt(split[1]) - 1;

				}

			} while (!board.placeSymbol(row, col));

			board.changePlayer();

		} while (!board.fillForWin() && !board.isBoardFull());

		if (board.isBoardFull() && !board.fillForWin()) {
			System.out.println("Tie! Game Over.");
		} else {
			this.screenBoard.printBoard(board);
			board.changePlayer();
			board.changePlayer();
			System.out.println(Character.toUpperCase(board.currentSymbol) + " Wins!");
		}

	}

}