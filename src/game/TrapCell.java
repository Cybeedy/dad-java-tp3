package game;
/**
 * A class for trap cells, on the which a player will stay trapped until another player takes his/her place.
 */
public class TrapCell implements CellInterface {
	private int index;
	private Player player = null;
	
	public TrapCell(int index){
		this.index = index;
	}
	
	public boolean canBeLeft() {
		return false;
	}

	public int getIndex() {
		return this.index;
	}

	public int handleMove(int diceThrow) {
		return this.index;
	}

	public boolean isBusy() {
		if (this.player == null){
			return false;
		}
		else return true;
	}

	public void welcomePlayer(Player player) {
		CellInterface previous_cell = player.getCell(); // la case précédemment occupée par le joueur qui arrive
		previous_cell.goodbyePlayer(player); // le joueur qui arrive dans this doit d'abord quitter sa case
		if (this.isBusy()){ // si this est occupé
			previous_cell.welcomePlayer(this.player); // la case précédente du joueur qui arrive reçoit le joueur déjà présent dans la case this (on procède à un échange)
		}
		this.player = player; // this reçoit le joueur qui arrive
		this.player.setCell(this); // on met à jour la case du joueur qui vient d'arriver dans this
	}

	public void goodbyePlayer(Player player){
		this.player = null;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	public String identificationMessage(){
		return "TrapCell";
	}
	
}
