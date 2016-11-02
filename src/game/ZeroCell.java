package game;
import java.util.List;
import java.util.Iterator;

public class ZeroCell implements CellInterface {
	private int index = 0;
	private List<Player> list_players;
	private int nb_players_on; // Nombre de joueurs actuellement sur la case.
	
	public ZeroCell(){
	}
	
	public ZeroCell(List<Player> list_players){
		this.list_players = list_players;
		this.nb_players_on = list_players.size();
	}
		
	public List<Player> getList_players() {
		return this.list_players;
	}

	public void setList_players(List<Player> list_players) {
		this.list_players = list_players;
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

	/** returns <tt>true</tt> iff a player is in this cell */
	public boolean isBusy(){
		return false; // quelque soit le cas de figure, la case 0 n'est jamais pleine, donc on renvoit false.
	}

	 /**  handles what happens when a player arrives in this cell 
     * @param player the new player in the sell
     */
	public void welcomePlayer(Player player){
		this.list_players.add(player);
	}

	/** gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer(){
		Iterator<Player> it = this.list_players.iterator();
		return it.next();
	}
	
}
