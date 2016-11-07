package game;

/** An abstract class for a board in the goose game.
 * Different derived classes will implement different types of boards (classic, randomly generated, etc.)
 * through the implementation of the initBoard method.
 */

public abstract class Board {

	protected final int nb_cells;
	protected CellInterface cells[];
	
	public Board(int nb_cells){
		this.nb_cells = nb_cells;
	}

	/** A method to set the cells vector. The behavior of this method
	 * determines the type of board that will be played with.
	 */
	protected abstract void initBoard();

	public int getNbCells() {
		return this.nb_cells;
	}
	
	public CellInterface getCell(int num_cell){
		return this.cells[num_cell];
	}
}
