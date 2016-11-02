package game;
import java.io.IOException;
import util.Input;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// On va commencer par créer le plateau de jeu.
		// Le joueur veut-il jouer avec le plateau original ou non ?
		
		Board board; // Déclaration du plateau qui sera l'argument à l'instanciation de la classe Game
		CellInterface cells[]; // Déclaration du tableau de cases qui servira d'argument à l'instanciation du plateau
		
		System.out.println("Bienvenue dans ce jeu de l'oie. Voulez-vous jouer au jeu original (plateau de 63 cases) ? " +
		 "(o/O pour oui)");
		
		boolean original_game;
		boolean success;
		
		String choix = Input.readString();
		if (choix.toUpperCase() == "O"){
			original_game = true;
		}
		else original_game = false;
		
		// S'il ne le veut pas, il va créer le plateau manuellement.
		
		if (original_game == false){
			
			// Il choisit d'abord le nombre de cases
		
			success = false;
			int nb_cases = ask_int_user(16, 257); // nombre de cases entre 16 et 256
		
			cells = new CellInterface[nb_cases + 1]; // Création du tableau de cases (nb_cases + 1, on compte la case 0)
			
			// Il choisit ensuite le type de chaque case 
			// (extrêmement lourd pour l'utilisateur en l'état, mais ce n'est pas l'intérêt du TP)
		
			int type_case;
			CellInterface cell;
			
			System.out.println("Vous avez choisi de créer un plateau de jeu à " + nb_cases + " cases. Vous allez" +
			"désormais choisir les cases une par une (désolé, c'est faute de mieux pour l'instant). " +
					"Les types de cases sont les suivants :\n1 --> case standard\n2 --> case oie\n3 --> case piège\n" +
			" 4 --> case d'attente\n5 --> case téléportante");
			
			cells[0] = new ZeroCell();
			
			for (int i = 1; i < nb_cases; i++){
				type_case = ask_int_user(1, 6);
				
				switch (type_case){
					case 1: // case standard
						cell = new RegularCell(i);
						cells[i] = cell;
						break;
					case 2: // case oie
						cell = new GooseCell(i);
						cells[i] = cell;
						break;
					case 3: // case piège
						cell = new TrapCell(i);
						cells[i] = cell;
						break;
					case 4: // case d'attente
						int initial_waiting_time = ask_int_user(1, 21); // on limite arbitrairement le nombre de tours d'attente à 20
						cell = new WaitingCell(i, initial_waiting_time);
						cells[i] = cell;
						break;
					case 5: // case téléportante
						int destination_cell_index = ask_int_user(0, nb_cases + 1);
						cell = new TeleportingCell(i, destination_cell_index);
						cells[i] = cell;
						break;
				}				
			}
			
		}
		
		// si le joueur veut jouer avec le plateau original
			
		else{ // if original_game == true
		
			cells = new CellInterface[64];
			cells[0] = new ZeroCell();
			cells[1] = new RegularCell(1);
			cells[2] = new RegularCell(2);
			cells[3] = new RegularCell(3);
			cells[4] = new RegularCell(4);
			cells[5] = new RegularCell(5);
			cells[6] = new TeleportingCell(6, 12);
			cells[7] = new RegularCell(7);
			cells[8] = new RegularCell(8);
			cells[9] = new GooseCell(9);
			cells[10] = new RegularCell(10);
			cells[11] = new RegularCell(11);
			cells[12] = new RegularCell(12);
			cells[13] = new RegularCell(13);
			cells[14] = new RegularCell(14);
			cells[15] = new RegularCell(15);
			cells[16] = new RegularCell(16);
			cells[17] = new RegularCell(17);
			cells[18] = new GooseCell(18);
			cells[19] = new WaitingCell(19, 2);
			cells[20] = new RegularCell(20);
			cells[21] = new RegularCell(21);
			cells[22] = new RegularCell(22);
			cells[23] = new RegularCell(23);
			cells[24] = new RegularCell(24);
			cells[25] = new RegularCell(25);
			cells[26] = new RegularCell(26);
			cells[27] = new GooseCell(27);
			cells[28] = new RegularCell(28);
			cells[29] = new RegularCell(29);
			cells[30] = new RegularCell(30);
			cells[31] = new TrapCell(31);
			cells[32] = new RegularCell(32);
			cells[33] = new RegularCell(33);
			cells[34] = new RegularCell(34);
			cells[35] = new RegularCell(35);
			cells[36] = new GooseCell(36);
			cells[37] = new RegularCell(37);
			cells[38] = new RegularCell(38);
			cells[39] = new RegularCell(39);
			cells[40] = new RegularCell(40);
			cells[41] = new RegularCell(41);
			cells[42] = new TeleportingCell(42, 30);
			cells[43] = new RegularCell(43);
			cells[44] = new RegularCell(44);
			cells[45] = new GooseCell(45);
			cells[46] = new RegularCell(46);
			cells[47] = new RegularCell(47);
			cells[48] = new RegularCell(48);
			cells[49] = new RegularCell(49);
			cells[50] = new RegularCell(50);
			cells[51] = new RegularCell(51);
			cells[52] = new TrapCell(52);
			cells[53] = new RegularCell(53);
			cells[54] = new GooseCell(54);
			cells[55] = new RegularCell(55);
			cells[56] = new RegularCell(56);
			cells[57] = new RegularCell(57);
			cells[58] = new TeleportingCell(58, 1);
			cells[59] = new RegularCell(59);
			cells[60] = new RegularCell(60);
			cells[61] = new RegularCell(61);
			cells[62] = new RegularCell(62);
			cells[63] = new RegularCell(63);
		}
			
		// On va désormais créer la liste de joueurs.
		
		System.out.println("How many players will play (minimum 1, maximum 10)?");
		
		success = false;
		int nb_joueurs = -1048576;
		
		while (success == false){
			try {
				nb_joueurs = Input.readInt();
			} 
			catch (IOException e) {
				System.out.println("Invalid input, please choose again (a number!).");
			}
			if (nb_joueurs > 0 && nb_joueurs < 11){
				success = true;
			}	
			else if (nb_joueurs != -1048576){
				System.out.println("Invalid input, please choose again (a number between 1 and 10 included).");
			}
		}
		
		List<Player> list_players= new ArrayList<Player>();
		for (int i = 1; i < nb_joueurs + 1; i++){
			success = false;
			String nom_joueur;
			System.out.println("Player " + i + ", please choose a name (16 characters max");
			while (success == false){
				nom_joueur = Input.readString(); 
				if (nom_joueur.length() < 17){
					success = true;
				}
				else System.out.println("Invalid input (16 characters max), please choose again.");
			}
			Player player = new Player(nom_joueur); // on utilise le constructeur ne nécessitant pas de connaître la cellule de départ.
			list_players.add(player);
		}
		
	}

	/** asks the user for an integer between borne_inf (included) and borne_sup (excluded)
	* and won't return 
	* @param borne_inf : the minimum tolerated value
	* @param borne_sup : borne_sup - 1 is the maximum tolerated value (borne_sup is excluded)
	* @return the integer chosen by the user, between borne_inf (included) and borne_sup (excluded)
	*/
	
	private static int ask_int_user(int borne_inf, int borne_sup){
		boolean success = false;
		int result = 0;
		while (success == false){
			try{
				result = Input.readInt();
			}
			catch (IOException e){
				System.out.println("Incorrect. Vous devez choisir un entier entre " + borne_inf + " et " + (borne_sup - 1));
				continue;
			}
			if (result >=  borne_inf && result < borne_sup){
				success = true;
			}
		}
		return result;
	}
}

