package game;
import java.io.IOException;
import util.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// On va commencer par créer la liste de joueurs.
		
				System.out.println("Welcome. How many players will play (minimum 1, maximum 10)?");
				
				int nb_joueurs = ask_int_user(1, 11); // On limite arbitrairement le nombre de joueurs à 10
				boolean success;
				
				List<Player> the_players = new ArrayList<Player>();
				
				for (int i = 1; i <= nb_joueurs; i++){
					success = false;
					String nom_joueur;
					System.out.println("Player " + i + ", please choose a name (16 characters max)");
					while (success == false){
						nom_joueur = Input.readString(); 
						if (nom_joueur.length() < 17){
							success = true;
							Player player = new Player(nom_joueur); // on utilise le constructeur ne nécessitant pas de connaître la cellule de départ.
							the_players.add(player);
						}
						else System.out.println("Invalid input (16 characters max), please choose again.");
					}
				}
				
		
		// On va ensuite créer le plateau de jeu.
		
		// Quel type de plateau souhaite utiliser le joueur ?
			
			System.out.println("Which game board would you like to use?\n" + 
			"1 --> Original 63-cell board\n" +
					"2 --> Randomly created board\n" +
					"3 --> Manually created board (extremely fastidious for now)");
			
			int type_plateau = ask_int_user(1, 4);
			Board board;
			int nb_cases;
			
			switch (type_plateau){
				case 1:
					board = new ClassicBoard(63);
					board.initBoard();
					break;
				case 2:
					System.out.println("\nHow many cells do you want in your board (between 32 and 128 included)?");
					nb_cases = ask_int_user(32,129);
					board = new RandomBoard(nb_cases);
					board.initBoard();
					break;
				case 3:
					System.out.println("\nHow many cells do you want in your board (between 32 and 128 included)?");
					nb_cases = ask_int_user(32,129);
					board = new ManualBoard(nb_cases);
					board.initBoard();
					break;
				default: // Ce cas ne se produira jamais, mais sans le default,
						 // Eclipse suggère que board pourrait ne pas être initialisé, ce qui n'est pourtant pas le cas.
					board = new ClassicBoard(63);
					board.initBoard();
					break;
			}
			
		// On va mettre à jour la case de chaque joueur, actuellement à null.
			
		Iterator<Player> it = the_players.iterator();
		while (it.hasNext()){
			it.next().setCell(board.getCell(0));
		}
			
		// Il ne reste plus qu'à créer le jeu.
		
		Game game = new Game(the_players, board);
		game.play();
		
	}

	/** asks the user for an integer between borne_inf (included) and borne_sup (excluded)
	* and won't return 
	* @param borne_inf : the minimum tolerated value
	* @param borne_sup : borne_sup - 1 is the maximum tolerated value (borne_sup is excluded)
	* @return the integer chosen by the user, between borne_inf (included) and borne_sup (excluded)
	*/
	
	public static int ask_int_user(int borne_inf, int borne_sup){
		boolean success = false;
		int result = 0;
		while (success == false){
			try{
				result = Input.readInt();
			}
			catch (IOException e){
				System.out.println("Invalid input. The int value must be between " + borne_inf + " and " + (borne_sup - 1));
				continue;
			}
			if (result >=  borne_inf && result < borne_sup){
				success = true;
			}
		}
		return result;
	}
}

