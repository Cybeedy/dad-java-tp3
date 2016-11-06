package game;

import java.util.List;

public class ManualBoard extends Board {

	public ManualBoard(int nb_cells){
		super(nb_cells);
	}
	
	public void initBoard(List<Player> the_players) {
		this.cells = new CellInterface[this.nb_cells + 1]; // Création du tableau de cases (nb_cases + 1, on compte la case 0)
		
		// Il choisit ensuite le type de chaque case 
		// (extrêmement lourd pour l'utilisateur en l'état, mais ce n'est pas l'intérêt du TP)
	
		int type_case;
		CellInterface cell;
		
		System.out.println("Vous avez choisi de créer un plateau de jeu à " + this.nb_cells + " cases. Vous allez" +
		"désormais choisir les cases une par une (désolé, c'est faute de mieux pour l'instant). " +
				"Les types de cases sont les suivants :\n1 --> case standard\n2 --> case oie\n3 --> case piège\n" +
		" 4 --> case d'attente\n5 --> case téléportante");
		
		this.cells[0] = new ZeroCell(the_players);
		
		for (int i = 1; i < this.nb_cells + 1; i++){
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
					int initial_waiting_time = Main.ask_int_user(1, 6); // on limite arbitrairement le nombre de tours d'attente à 5
					cell = new WaitingCell(i, initial_waiting_time);
					this.cells[i] = cell;
					break;
				case 5: // case téléportante
					int destination_cell_index = Main.ask_int_user(0, this.nb_cells + 1);
					cell = new TeleportingCell(i, destination_cell_index);
					this.cells[i] = cell;
					break;
			}				
		}
	}

}