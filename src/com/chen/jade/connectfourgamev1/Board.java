package com.chen.jade.connectfourgamev1;

public class Board {
	
	public static String[][] makeBoard(){
		String[][] b = new String[6][7];
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 7; j++ ){
				b[i][j] = "B";
			}
		}
		return b;
	}
	
	public static void printBoard(String[][] b){
		for (int i = 0; i < 7; i++){
			System.out.printf("%-4d", i);
		}
		System.out.println();
		
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 7; j++ ){
				if (b[i][j].equals("B") ){
					System.out.printf("%-4s", "-");
				}else {
					System.out.printf("%-4s", b[i][j]);
				}
			}
			System.out.println();
		}
	}

}
