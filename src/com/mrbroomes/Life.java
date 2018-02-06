package com.mrbroomes;

/**
 * @author Granville Broomes
 * @version 1.0
 */
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
