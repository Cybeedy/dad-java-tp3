package game;
import java.util.Random;

/** A class for a randomly generated board
 */
public class RandomBoard extends Board {
	
	private static Random r = new Random();
	
	public RandomBoard(int nb_cells){
		super(nb_cells);
	}
	
	/** This implementation of initBoard randomly sets the cells of the board.
	 */
	public void initBoard() {
		
		this.cells = new CellInterface[this.nb_cells + 1]; 
	
		int type_case;
		CellInterface cell;
		
		System.out.println("Vous avez choisi de cr�er un plateau de jeu g�n�r� al�atoirement � " + this.nb_cells + " cases.");
		
		this.cells[0] = new ZeroCell();
		
		for (int i = 1; i < this.nb_cells; i++){ // on g�n�re al�atoirement toutes les cases sauf la derni�re
			type_case = 1 + r.nextInt(100);
			
			if(type_case < 76){// 75% de chance d'avoir une case standard
					cell = new RegularCell(i);
					this.cells[i] = cell;
			}
			else if(type_case < 86){ // 10% de chance d'avoir une case oie
					cell = new GooseCell(i);
					this.cells[i] = cell;
			}
			else if(type_case < 89){ // 3% de chance d'avoir une case pi�ge
					cell = new TrapCell(i);
					this.cells[i] = cell;
			}
			else if (type_case < 96){// 7 de chance d'avoir une case d'attente
					int initial_waiting_time = 1 + r.nextInt(5); // on limite arbitrairement le nombre de tours d'attente � 5
					cell = new WaitingCell(i, initial_waiting_time);
					this.cells[i] = cell;
			}
			else{ // et 5% de chance d'avoir une case de t�l�portation
					int destination_cell_index = r.nextInt(this.nb_cells); // la case de destination ne peut pas �tre la derni�re case...
					cell = new TeleportingCell(i, destination_cell_index);
					this.cells[i] = cell;
			}				
			this.cells[this.nb_cells] = new RegularCell(this.nb_cells); // la derni�re case doit absolument �tre une case standard.
		}
	}
}
