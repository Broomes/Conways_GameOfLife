package com.mrbroomes;
public class Board {
	
	char[][] world = new char[40][40];
 
	/**
	 * Checks every spot and changes the spots according number of neighbors
	 */
	public void checkBoard()
	{

		char[][] tempWorld = world;

		for(int i=0;i<world.length;i++)
			for(int j=0;j<world[i].length;j++) {
				
				//counter to track the number of neighbors
				int neighborCount = 0;
				for(int x=i-1;x<=i+1;x++)
					for(int y=j-1;y<=j+1;y++)
					{
						if(x==i&&y==j) {continue;}
						else{neighborCount+=isAlive(tempWorld, x,y);}
					}
				
				if(tempWorld[i][j]=='*')
				{
					if(neighborCount<2||neighborCount>3) {tempWorld[i][j]= '.';}
					if(neighborCount == 2||neighborCount == 3) {tempWorld[i][j]= '*';}
				}
				else{
					if(neighborCount==3) {tempWorld[i][j]= '*';}
				}	
			}

		world = tempWorld;
	}

	/**
	 * Checks whether a cell is alive or dead / if within game bounds.
	 * @param mat board passed in
	 * @param i current row
	 * @param j current column
	 * @return 0 if no neighbor, 1 if a neighbor
	 */
	private int isAlive(char[][] tempWord, int i, int j){
		if(i<0||j<0||i==tempWord.length||j==tempWord[0].length)
			return 0;
		if(tempWord[i][j]=='*')
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
	public void setAlivePlaces()
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
