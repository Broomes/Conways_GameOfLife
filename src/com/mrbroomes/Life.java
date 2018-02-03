package com.mrbroomes;


public class Life {
	public static void main(String[] args) {
		
		Board game=new Board();
		game.setBoard();
		game.setAlivePlacesManually();
		game.displayBoard();
		
		while(true)
		{
			game.checkBoard();
			game.displayBoard();
			game.slowGame();
		}
	}

}
