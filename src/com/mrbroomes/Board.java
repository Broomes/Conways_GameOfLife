package com.mrbroomes;
public class Board {
	
	private char[][] world = new char[40][40];
	private int[][] neighborBoard = new int[40][40];
 
	/**
	 * Checks every spot and saves it's number of neighbor in the a neighborBoard[][].
	 * Then runs the neighborChecker() at the end to update the main world[][].
	 */
	public void checkBoard()
	{
		for(int i=0;i<world.length;i++) {
			for(int j=0;j<world[i].length;j++) {

				//counter to track the number of neighbors
				int neighborCount = 0;
				for(int x=i-1;x<=i+1;x++) {
					for(int y=j-1;y<=j+1;y++)
					{
						if(x==i&&y==j) {continue;}
						else{neighborCount+=isAlive(x,y);}
					}
				}
				neighborBoard[i][j]= neighborCount;

			}
		}
		neighborChecker();
	}

	/**
	 * method checks neighborBoard[][] and applies the game's rules to the main world[][]
	 */
	public void neighborChecker() {

		for(int i=0;i<world.length;i++) {
			for(int j=0;j<world[i].length;j++) {

				if(world[i][j]=='*')
				{
					if(neighborBoard[i][j]<2||neighborBoard[i][j]>3) {world[i][j]= '.';}
					if(neighborBoard[i][j] == 2||neighborBoard[i][j] == 3) {world[i][j]= '*';}
				}
				else{
					if(neighborBoard[i][j]==3) {world[i][j]= '*';}
				}
			}
		}
	}

	/**
	 * Checks whether a cell is alive or dead / if within game bounds.
	 * @param i current row
	 * @param j current column
	 * @return 0 if no neighbor, 1 if a neighbor
	 */
	private int isAlive(int i, int j){
		if(i<0||j<0||i==world.length||j==world[0].length)
			return 0;
		if(world[i][j]=='*')
			return 1;
		return 0;
	}
	
	/**
	 * This method sets the entire board to dead.
	 */
	public void setBoard() {
		for(int i=0;i<world.length;i++)
		for(int j=0;j<world[i].length;j++)
		{
				world[i][j]='.';
		}
	}
	
	/**
	 * This method manually sets alive spots on the board.
	 */
	public void setAlivePlacesManually()
	{
		world[30][20]='*';
		world[30][21]='*';
		world[30][22]='*';
		world[30][23]='*';
		world[30][24]='*';
		world[30][25]='*';
		world[30][26]='*';
		world[30][27]='*';
		world[29][28]='*';
		world[30][29]='*';
		world[29][30]='*';
		world[30][31]='*';
		world[30][32]='*';
		world[29][33]='*';
		world[30][34]='*';
		world[10][35]='*';
		world[30][36]='*';

	}

	/**
	 * prints the entire 2d array to console.
	 */
	public void displayBoard() {
		for(int i = 0; i < world.length; i++) {
			for(int j = 0; j < world[i].length; j++) {
				System.out.print(world[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Slows pauses the program for 100 milliseconds
	 */
	public void slowGame() {
		try
		{
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			System.out.println("Something went horribly wrong.");
		}
	}
	
	/**
	 * Randomly fills 10% of the board with alive spots
	 */
	public void setBoardRandomly()
	{
		for(int i=0;i<world.length;i++)
			for(int j=0;j<world[i].length;j++)
			{
				if(Math.random()<0.10f)
					world[i][j]='*';
				else
					world[i][j]='_';
			}
	}
}
