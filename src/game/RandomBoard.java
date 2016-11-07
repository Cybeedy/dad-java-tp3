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
		
		System.out.println("Vous avez choisi de créer un plateau de jeu généré aléatoirement à " + this.nb_cells + " cases.");
		
		this.cells[0] = new ZeroCell();
		
		for (int i = 1; i < this.nb_cells; i++){ // on génére aléatoirement toutes les cases sauf la dernière
			type_case = 1 + r.nextInt(100);
			
			if(type_case < 76){// 75% de chance d'avoir une case standard
					cell = new RegularCell(i);
					this.cells[i] = cell;
			}
			else if(type_case < 86){ // 10% de chance d'avoir une case oie
					cell = new GooseCell(i);
					this.cells[i] = cell;
			}
			else if(type_case < 89){ // 3% de chance d'avoir une case piège
					cell = new TrapCell(i);
					this.cells[i] = cell;
			}
			else if (type_case < 96){// 7 de chance d'avoir une case d'attente
					int initial_waiting_time = 1 + r.nextInt(5); // on limite arbitrairement le nombre de tours d'attente à 5
					cell = new WaitingCell(i, initial_waiting_time);
					this.cells[i] = cell;
			}
			else{ // et 5% de chance d'avoir une case de téléportation
					int destination_cell_index = r.nextInt(this.nb_cells); // la case de destination ne peut pas être la dernière case...
					cell = new TeleportingCell(i, destination_cell_index);
					this.cells[i] = cell;
			}				
			this.cells[this.nb_cells] = new RegularCell(this.nb_cells); // la dernière case doit absolument être une case standard.
		}
	}
}
