# Conway's Game Of Life
Solution to the game of life written in java. This is a console based solution, with dots representing dead and zeros representing alive.
John Conway’s game of Life is a type of cellular automata that demonstrates how simple rules can lead to complex patterns or behaviors.
In Life, the “world” is simulated on a large, two-dimensional grid, with each cell in the grid either empty or occupied by an “organism.” In the course of a turn, the contents of each cell are determined by looking at the eight cells surrounding it. In the basic game, an organism in one cell will be born, or live, or die, according to the following rules:

1. A live cell with < 2 neighbors will die (due to under population).
2. A live cell 2-3 neighbors lives on to the next generation.
3. A live cell with > 3 neighbors dies (due to overpopulation).
4. An empty cell with 3 neighbors becomes a live cell (from reproduction).

The Model for this game might take a number of forms depending on how you choose to code it: a boolean grid with live cells true and empty cells false; a char or String array with “.” and “0”; an int array with 0s and 1s. This Model of the game is internal, and isn’t something that the user will have any direct interaction with.
The View for the game that the user sees is also up to you: a text-based version might simply display the strings in your array, or display characters based on the true-false values in a boolean array; a graphics- version will take the cells and display them as pixels, or perhaps as squares in a grid.
Running a simulation consists of establishing a “board” for the grid of cells, populating the cells with an initial “seed” generation, and then watching the population on the board evolve over time as successive generations are produced according to the population rules above.
