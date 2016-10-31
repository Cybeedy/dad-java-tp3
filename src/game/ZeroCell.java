package game;

public class ZeroCell implements CellInterface {
	private int index = 0;
	private Player list_players [];
	
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
		return false; // Comme le fait que plusieurs joueurs soient présents dessus ne pose pas de soucis, on pose arbitrairement la vauleur de retour de isBusy à false
	}

	 /**  handles what happens when a player arrives in this cell 
     * @param player the new player in the sell
     */
	public void welcomePlayer(Player player){
		this.list_players.append(player); // à changer !
	}

	/** gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer(){
		return this.list_players[0];
	}
}
