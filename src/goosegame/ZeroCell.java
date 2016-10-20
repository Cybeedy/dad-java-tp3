package goosegame;

public class ZeroCell implements Cell {
	private int index = 0;
	private Player ListP [];
	
	public boolean canBeLeft(){
		return true;
	}

	/** returns the index of this cell */
	public int getIndex(){
		return index;
	}

	  /**
     * returns the index of the cell really reached by a player when the player
     *    reaches this cell.  For normal cells, the returned value equals
     *   <code>getIndex()</code> and is thus independent from
     *   <code>diceThrow</code>.
     * @param diceThrow the result of the dice when the player reaches this cell
     * @return the index of the actual cell where the player eventually
     * arrives when the given throw of dice sends the player in this cell
     */
	public int handleMove(int diceThrow){
		return diceThrow;
	}

	/** returns <tt>true</tt> iff a player is in this cell */
	public boolean isBusy(){
		return false; // Comme le fait que plusieurs joueurs soient présents dessus ne pose pas de soucis, on pose arbitrairement la vauleur de retour de isBusy à false
	}

	 /**  handles what happens when a player arrives in this cell 
     * @param player the new player in the sell
     */
	public void welcomePlayer(Player player){
		
	}

	/** gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer(){
		return ListP[0];
	}
}
