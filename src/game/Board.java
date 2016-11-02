package game;

public abstract class Board {

	private final int nb_cells;
	private CellInterface cells[];
	
	public Board(CellInterface cells[]){
		this.cells = cells;
		this.nb_cells = this.cells.length;
	}

	protected abstract void initBoard();

	public int getNbOfCells() {
		return this.nb_cells;
	}
	
	public CellInterface getCell(int num_cell){
		return this.cells[num_cell];
	}
	
}
