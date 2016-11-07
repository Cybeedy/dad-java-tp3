package game;

/**
 * A class for the special cell 0, on the which every player begins.
 * Actually, this class doesn't have any attribute list_players, since it is not necessary to know
 * the players on this cell. Indeed :
 * - in the Game.play method, the iteration is made on the full player_list...
 * 		- ...which is already an attribute of the Game class
 * 		- ...each player knows on which cell he/she is located.		
 * - the 0 cell is never full. Hence, moving a player to the 0 cell never causes any issue (in the other cells, it is necessary to know if another player is already in it in order to make a switch if that's thecase or simply move the player if not)
 */
public class ZeroCell implements CellInterface {
	private int index = 0;

	public ZeroCell(){
	}
	
	public boolean canBeLeft(){
		return true;
	}

	public int getIndex(){
		return this.index;
	}

	public int handleMove(int diceThrow){
		return this.index;
	}

	public boolean isBusy(){
		return false; // quelque soit le cas de figure, la case 0 n'est jamais pleine, donc on renvoit false.
	}

	public void welcomePlayer(Player player){
		CellInterface previous_cell = player.getCell(); // la case précédemment occupée par le joueur qui arrive
		previous_cell.goodbyePlayer(player); // le joueur qui arrive dans this quitte son ancienne case
		player.setCell(this); // mise à jour de l'attribut cell du joueur.
		
		// Cette méthode, contrairement aux méthodes welcomePlayer des autres classes,
		// ne nécessite pas de mettre à jour un attribut (qui n'existe d'ailleurs pas) list_players (cf. JavaDoc).
	}

	public void goodbyePlayer(Player player){
	}
	
	public String identificationMessage(){
		return "ZeroCell";
	}
	
	public Player getPlayer(){
		return null;
	}
	
}
