package game;
import java.util.List;
import java.util.Random;

public class RandomBoard extends Board {
	
	private static Random r = new Random();
	
	public RandomBoard(int nb_cells){
		super(nb_cells);
	}
	
	public void initBoard(List<Player> the_players) {
			
		this.cells = new CellInterface[this.nb_cells + 1]; 
	
		int type_case;
		CellInterface cell;
		
		System.out.println("Vous avez choisi de créer un plateau de jeu généré aléatoirement à " + this.nb_cells + " cases.");
		
		this.cells[0] = new ZeroCell(the_players);
		
		for (int i = 1; i < this.nb_cells + 1; i++){
			type_case = 1 + r.nextInt(5);
			
			switch (type_case){
				case 1: // case standard
					cell = new RegularCell(i);
					this.cells[i] = cell;
					break;
				case 2: // case oie
					cell = new GooseCell(i);
					this.cells[i] = cell;
					break;
				case 3: // case piège
					cell = new TrapCell(i);
					this.cells[i] = cell;
					break;
				case 4: // case d'attente
					int initial_waiting_time = 1 + r.nextInt(5); // on limite arbitrairement le nombre de tours d'attente à 5
					cell = new WaitingCell(i, initial_waiting_time);
					this.cells[i] = cell;
					break;
				case 5: // case téléportante
					int destination_cell_index = r.nextInt(this.nb_cells); // la case de destination ne peut pas être la dernière case...
					cell = new TeleportingCell(i, destination_cell_index);
					this.cells[i] = cell;
					break;
			}				
		}
	}
}
