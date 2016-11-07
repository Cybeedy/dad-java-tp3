package game;
import java.util.List;
import java.util.Iterator;


/** A class to play the goose game.
 */
public class Game {

	private List<Player> the_players;
	private Board board;
	
	public Game(List<Player> thePlayers, Board board){
		this.the_players = thePlayers;
		this.board = board;
	}
	
	public void addPlayer(Player player){
		this.the_players.add(player);
	}
	
	public void play(){
		int end_cell_index = this.board.getNbCells(); // Numéro de la dernière case
		System.out.println(end_cell_index);
		CellInterface end_cell = board.getCell(end_cell_index); // La dernière case
		boolean game_blocked = false; // Malgré les consignes, on vérifiera que la partie n'est pas bloquée (tous les joueurs prisonniers)
		int nb_players_blocked; // Après chaque itération sur l'ensemble des joueurs, on regarde si le nombre de joueurs bloqués est égal au nombre de joueurs (partie bloquée)
		Iterator<Player> it;
		Player player;
		String name_player;
		CellInterface old_cell;
		int old_cell_index;
		String old_cell_identification_message;
		CellInterface new_cell;
		int new_cell_index;
		String new_cell_identification_message;
		int two_dice_throw;
		while (end_cell.isBusy() == false && game_blocked == false){ // On arrête la partie si un joueur atteint la dernière case ou si la partie est bloquée.
			it = this.the_players.iterator();
			while (it.hasNext()){
				player = it.next();
				name_player = player.getName();
				old_cell = player.getCell();
				old_cell_index = old_cell.getIndex();
				old_cell_identification_message = old_cell.identificationMessage();
				
				System.out.print(name_player + " is in cell " + old_cell_index);
				
				switch (old_cell_identification_message){
					case "RegularCell":
						System.out.print(" (regular), ");
						break;
					case "GooseCell":
						System.out.print(" (goose), ");
						break;
					case "TeleportingCell":
						System.out.print(" (teleporting), ");
						break;
					case "WaitingCell":
						if (player.getWaiting_time() == 0){
							System.out.print(" (waiting), but can now play : ");
						}
						else System.out.print(" (waiting), and will have to wait for " + player.getWaiting_time() + " turn(s)\n");
						break;
					case "TrapCell":
						System.out.print(" (trap), and cannot play\n");
						break;
					case "ZeroCell":
						System.out.print(", ");
				}
				
				if (old_cell.canBeLeft()){
					if (player.getWaiting_time() == 0){
						two_dice_throw = player.twoDiceThrow();
						new_cell_index = old_cell_index + two_dice_throw;
						System.out.print("throws " + two_dice_throw + ", ");
						if (new_cell_index > end_cell_index){
							new_cell_index = 2*end_cell_index - new_cell_index;
							System.out.print("exceeds the number of cells, so goes back to cell ");
							player.setGoingFoward(false);
						}
						else System.out.print("reaches cell ");
						
						System.out.print(new_cell_index);
						new_cell = board.getCell(new_cell_index);
						new_cell_identification_message = new_cell.identificationMessage();
						new_cell_index = new_cell.handleMove(two_dice_throw);
						
						switch (new_cell_identification_message){
							case "RegularCell":
								System.out.print(" (regular)\n");
								break;
							case "GooseCell":
								System.out.print(" (goose), ");
								if (!player.isGoingForward()){	
									new_cell_index -= 2 * two_dice_throw;
									System.out.print("and goes back to cell " + new_cell_index);
								}
								else{ 
									if (new_cell_index > end_cell_index){
									new_cell_index = 2*end_cell_index - new_cell_index;
									System.out.print("exceeds the number of cells, so goes back to cell " + new_cell_index + "\n");;
									}
									else System.out.print("jumps to cell " + new_cell_index + "\n");
								}
								break;
							case "TeleportingCell":
								System.out.print(" (teleporting), is teleported to cell " + new_cell_index + "\n");
								break;
							case "WaitingCell":
								System.out.print(" (waiting), and will have to wait.\n");
								break;
							case "TrapCell":
								System.out.print(" (trap), and is now blocked.\n");
								break;
							case "ZeroCell":
								System.out.print(", and is back to the 0 cell.\n");
						}
						new_cell = board.getCell(new_cell_index);
						new_cell.welcomePlayer(player);
						
						if (new_cell_index == end_cell_index){
							break;
						}
					}
					else player.setWaiting_time(player.getWaiting_time() - 1);
					
				}
					player.setGoingFoward(true);
			}
			
			it = this.the_players.iterator();
			nb_players_blocked = 0;
			while (it.hasNext()){
				player = it.next();
				if (player.getCell().canBeLeft() == false){
					nb_players_blocked += 1;
				}
			}
			
			if (nb_players_blocked == this.the_players.size()){
				game_blocked = true;
			}
		}
		
		if (end_cell.isBusy() == true){
			String winner_name = end_cell.getPlayer().getName();
			System.out.println("Bravo " + winner_name + ", vous avez gagné !");
		}
		
		if (game_blocked == true){
			System.out.println("Tous les joueurs sont bloqués, fin de la partie.");
		}
	}
}
