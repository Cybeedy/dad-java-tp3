package game;

public abstract class Board {

	private final int nbOfCells;
	private CellInterface Cells[];
	
	public Board(){
		this.nbOfCells = 64;	
	}

	protected abstract void initBoard();

	public int getNbOfCells() {
		return this.nbOfCells;
	}
	
	public CellInterface getCell(int num_cell){
		return this.Cells[num_cell];
	}
	
}
