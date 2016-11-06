package game;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ZeroCell implements CellInterface {
	private int index = 0;
	private ArrayList<Player> list_players;
	
	public ZeroCell(){
	}
	
	public ZeroCell(List<Player> list_players){
		this.list_players = new ArrayList<Player>(list_players);
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
		CellInterface previous_cell = player.getCell(); // la case précédemment occupée par le joueur qui arrive
		previous_cell.goodbyePlayer(player);
		this.list_players.add(player);
		player.setCell(this);
	}

	public void goodbyePlayer(Player player){
		index = this.list_players.indexOf(player);
		if (index != -1){
			this.list_players.remove(index);
		}
	}
	
	public String identificationMessage(){
		return "ZeroCell";
	}
	
	
	/** gets the first player who came in this cell <tt>null</tt> if none */
	public Player getPlayer(){
		Iterator<Player> it = this.list_players.iterator();
		if (it.hasNext()) return it.next();
		else return null;
	}
	
}
