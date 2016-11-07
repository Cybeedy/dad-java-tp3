package game;

/** A class for a manually created board
 */
public class ManualBoard extends Board {

	public ManualBoard(int nb_cells){
		super(nb_cells);
	}
	
	/** This implementation of initBoard asks the player to manually set the cells.
	 */
	public void initBoard() {
		this.cells = new CellInterface[this.nb_cells + 1]; // Création du tableau de cases (nb_cases + 1, on compte la case 0)
		
		// Il choisit ensuite le type de chaque case 
		// (extrêmement lourd pour l'utilisateur en l'état)
	
		int type_case;
		CellInterface cell;
		
		System.out.println("Vous avez choisi de créer un plateau de jeu à " + this.nb_cells + " cases. Vous allez" +
		"désormais choisir les cases une par une (désolé, c'est faute de mieux pour l'instant). " +
				"Les types de cases sont les suivants :\n1 --> case standard\n2 --> case oie\n3 --> case piège\n" +
		"4 --> case d'attente\n5 --> case téléportante\n");
		
		this.cells[0] = new ZeroCell();
		
		for (int i = 1; i < this.nb_cells; i++){
			System.out.println("Case n°" + i + " :");
			type_case = Main.ask_int_user(1, 6);
			
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
					System.out.println("Temps d'attente de cette case d'attente (maximum 5 tours) ?");
					int initial_waiting_time = Main.ask_int_user(1, 6); // on limite arbitrairement le nombre de tours d'attente à 5
					cell = new WaitingCell(i, initial_waiting_time);
					this.cells[i] = cell;
					break;
				case 5: // case téléportante
					System.out.println("Case de destination lorsque l'on arrive sur cette case téléportation (entre 0 et " + (this.nb_cells - 1) + ") ?");
					int destination_cell_index = Main.ask_int_user(0, this.nb_cells);
					cell = new TeleportingCell(i, destination_cell_index);
					this.cells[i] = cell;
					break;
			}				
		}
		this.cells[this.nb_cells] = new RegularCell(this.nb_cells); // la dernière case doit absolument être une case standard.
	}

}