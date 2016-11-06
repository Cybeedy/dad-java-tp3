package game;
import java.util.Random;
/** A player in the "jeu de l'oie" game */
public class Player {
    private static Random random = new Random();
	/** current cell of the player */
    protected CellInterface cell;
    /** name of the player*/
    protected String name;
    private int waiting_time;
    private boolean going_forward;
    
	/** 
     * @param name the name of this player
     * @param cell the starting cell of this player
    */
    public Player (String name, CellInterface cell){
        this.name = name;
        this.cell = cell;
        this.waiting_time = 0;
        this.going_forward = true;
    }
    /**  A player with no current cell (== null)
     * @param name the name of this player
     * 
    */
    public Player (String name){
        this(name, null);
    }
    
    public String getName() { 
    	return this.name; 
    }
    
    /** returns the current cell of the player 
     *  @return the current cell of the player 
     */
    public CellInterface getCell() { 
        return this.cell ; 
     }
     /** changes the cell of the player 
      * @param newCell the new cell
     */
     public void setCell(CellInterface newCell) { 
        this.cell = newCell; 
     }
    
    public int getWaiting_time() {
		return waiting_time;
	}
	public void setWaiting_time(int waiting_time) {
		this.waiting_time = waiting_time;
	}

	public boolean isGoingForward() {
		return this.going_forward;
	}
	public void setGoingFoward(boolean going_forward) {
		this.going_forward = going_forward;
	}
	
	/** result of a 1d6 throw
     * @return random result of a 1d6 throw 
    */
    private int oneDieThrow() {	
       return (Player.random.nextInt(6) + 1); 
    }
    /** result of a 2d6 throw 
      * @return random result of a 2d6 throw
    */ 	
    public int twoDiceThrow() {
        int result = this.oneDieThrow() + this.oneDieThrow();
        return result;
    }
}// Player
