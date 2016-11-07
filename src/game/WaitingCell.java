package game;

/**
 * A class for waiting cells, in the which a player will be trapped for a given number of rounds.
 */
public class WaitingCell implements CellInterface {
	private int index;
	private int initial_waiting_time; // nombre de tours à attendre avant qu'un joueur ne puisse quitter la case
	private Player player = null;
	
	public WaitingCell(int index, int initial_waiting_time){
		this.index = index;
		this.initial_waiting_time = initial_waiting_time;
	}

	public int getInitial_waiting_time() {
		return initial_waiting_time;
	}

	public boolean canBeLeft() {
			return true;
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
		this.player.setWaiting_time(this.initial_waiting_time); // le joueur va devoir attendre initial_waiting_time tours.
	}

	public void goodbyePlayer(Player player){
		this.player = null;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	public String identificationMessage(){
		return "WaitingCell";
	}
	
}
