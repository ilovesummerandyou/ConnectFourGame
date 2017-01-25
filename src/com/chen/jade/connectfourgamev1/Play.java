package com.chen.jade.connectfourgamev1;

import java.util.Scanner;

public class Play {
	static int count;
	public static void shoot(String player, String[][] b){
		Scanner scan = new Scanner(System.in);
		System.out.print("Choose a column: ");
		int c = scan.nextInt();
		if (c < 0 || c > 6) {
			System.out.print("Wrong column. Choose a column: ");
			c = scan.nextInt();
		}
		goToCell(player,  b,  c);
		count++;
	}
	
	public static void playNow(String[][] b){
		while(!hasWon("X", b) && !hasWon("O", b)) {
			shoot("X", b);
			Board.printBoard(b);
			if(hasWon("X", b)){
				break;
			}
			shoot("O", b);
			Board.printBoard(b);
			if(hasWon("O", b)){
				break;
			}
		}
		
		playAgain(b);
		
	}
	
	public static void playAgain(String[][] b){
		Scanner scan = new Scanner(System.in);
		System.out.print("Play again? enter Y or any key else to exit: ");
		String answer = scan.next().toUpperCase();
		if ("Y".equals(answer)){
			b= Board.makeBoard();
			Board.printBoard(b);
			playNow(b);
		} else {
			System.out.println("Bye");
			System.exit(1);
		}	
	}
	
	public static void goToCell(String player, String[][] b, int c){
		for (int row =5; row >=0; row--){
			if (b[row][c].equals("B")){
				b[row][c] = player;
				break;
			}
		}
	}
	
	public static boolean hasWon(String player, String[][] b) {
		for (int r = 0; r < 6; r++){
			for (int c = 0; c < 7; c++){
				if(hasWon(r, c, player, b)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasWon(int r, int c, String player, String[][] b) {
		// check each row
		for (int col = 0; col < 4; col++){
			if (b[r][col].equals(player) && b[r][col+1].equals(player) && b[r][col+2].equals(player) && b[r][col+3].equals(player)){
				System.out.println(player + " won!");
				return true;
			}
		}
		
		// check each column
		for (int row = 0; row < 3; row++){
			if (b[row][c].equals(player) && b[row+1][c].equals(player) && b[row+2][c].equals(player) && b[row+3][c].equals(player)){
				System.out.println(player + " won!");
				return true;
			}
		}
		
		// check dioagnal
		 for (int row = 0; row < 3; row++){
			 for (int col = 0; col <4; col++){
				 if(b[row][col].equals(player) && b[row + 1][col + 1].equals(player) && b[row+ 2][col+ 2].equals(player) && b[row+ 3][col+ 3].equals(player)){
					 System.out.println(player + " won!");
						return true;
				 }
			 }
		 }
		 
		// check anti-dioagnal
		 for (int row = 5; row >2; row--){
			 for (int col = 0; col <4; col++){
				 if(b[row][col].equals(player) && b[row - 1][col + 1].equals(player) && b[row - 2][col+ 2].equals(player) && b[row- 3][col+ 3].equals(player)){
					 System.out.println(player + " won!");
						return true;
				 }
			 }
		 }
		 
		 //check draw
		 if (count == 42){
			 System.out.println("a draw");
				return true;
		 }
		 
		 return false;
		 
	}

}
