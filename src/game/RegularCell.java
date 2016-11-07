package game;

/**
 * A class for regular cells, with no special behavior.
 */
public class RegularCell implements CellInterface{
	private int index;
	private Player player;
	
	public RegularCell(int index){
		this.index = index;
	}
	
	public RegularCell(int index, Player player){
		this.index = index;
		this.player = player;
	}
	
	public boolean canBeLeft() {
		return true;
	}

	public int getIndex() {
		return this.index;
	}
	
	public int handleMove(int diceThrow) {
		return getIndex();
	}

	public boolean isBusy() {
		if (this.getPlayer() == null){
			return false;
		}
		else return true;
	}
	
	public void welcomePlayer(Player player) {
		CellInterface previous_cell = player.getCell(); // la case pr�c�demment occup�e par le joueur qui arrive
		previous_cell.goodbyePlayer(player); // le joueur qui arrive dans this doit d'abord quitter sa case
		if (this.isBusy()){ // si this est occup�
			previous_cell.welcomePlayer(this.player); // la case pr�c�dente du joueur qui arrive re�oit le joueur d�j� pr�sent dans la case this (on proc�de � un �change)
		}
		this.player = player; // this re�oit le joueur qui arrive
		this.player.setCell(this); // on met � jour la case du joueur qui vient d'arriver dans this
	}

	public void goodbyePlayer(Player player){
		this.player = null;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	public String identificationMessage(){
		return "RegularCell";
	}
	
}
