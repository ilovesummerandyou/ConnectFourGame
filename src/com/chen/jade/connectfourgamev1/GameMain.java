package com.chen.jade.connectfourgamev1;

public class GameMain {

	public static void main(String[] args) {
		String[][] b = Board.makeBoard();
		Board.printBoard(b);
		Play.playNow(b);

	}

}
