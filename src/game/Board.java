package game;
import java.util.List;

public abstract class Board {

	protected final int nb_cells;
	protected CellInterface cells[];
	
	public Board(int nb_cells){
		this.nb_cells = nb_cells;
	}

	protected abstract void initBoard(List<Player> the_players);

	public int getNbCells() {
		return this.nb_cells;
	}
	
	public CellInterface getCell(int num_cell){
		return this.cells[num_cell];
	}
}
