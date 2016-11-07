package game;

/**
 * Interface for the cells of the "jeu de l'oie" game. <br/> Note that there can be only 
 * one player by cell, the starting cell (index 0) excepted.
 */
public interface CellInterface {
	/**
	 * @return <tt>true</tt> if and only if the player in this cell can freely
	 *  leaves the cell, else he must wait for another player to reach this cell 
	 *  or wait a given number of turns
	 */
	public boolean canBeLeft();

	/** returns the index of this cell */
	public int getIndex();

	  /**
     * returns the index of the cell really reached by a player when the player
     *    reaches this cell.  For normal cells, the returned value equals
     *   <code>getIndex()</code> and is thus independent from
     *   <code>diceThrow</code>.
     * @param diceThrow the result of the dice when the player reaches this cell
     * @return the index of the actual cell where the player eventually
     * arrives when the given throw of dice sends the player in this cell
     */
	public int handleMove(int diceThrow);

	/** returns <tt>true</tt> iff a player is in this cell */
	public boolean isBusy();

	 /**  handles what happens when a player arrives in this cell
     * @param player the new player in the sell
     */
	public void welcomePlayer(Player player);

	/** empties the cell (player). only used it the welcomePlayer methods of this and the others classes.
	 */
	
	public void goodbyePlayer(Player player);
	
	/** gets the player in this cell <tt>null</tt> if none
	 * In the case of ZeroCell (only used for the cell 0), this method always returns null.
	 */
	public Player getPlayer();
	
	/** returns a message allowing to distinguish the different classes implementing this interface.
	 * this will be used in the play method of the Game class. Indeed, after a player has reached a cell, 
	 * it is necessary to know the type of the cell so the progress of the game can be correctly described.
	 * For example, for the GooseCell class, this method will simply return "GooseCell".
	 * @return
	 */
	public String identificationMessage();
	
	
}// Cell
