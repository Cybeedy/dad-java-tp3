package game;

public class WaitingCell implements CellInterface {
	private int index;
	private int initial_waiting_time; // nombre de tours à attendre avant qu'un joueur ne puisse quitter la case
	private int remaining_waiting_time; // nombre de tours restant avant que l'éventuel joueur présent dans
										// la cellule ne puisse en partir
	private Player player = null;
	
	public WaitingCell(int index, int initial_waiting_time){
		this.index = index;
		this.initial_waiting_time = initial_waiting_time;
		this.remaining_waiting_time = initial_waiting_time;
	}
	
	public int getInitial_waiting_time() {
		return this.initial_waiting_time;
	}
		
	public int getRemaining_waiting_time() {
		return this.remaining_waiting_time;
	}

	public void setRemaining_waiting_time(int remaining_waiting_time) {
		this.remaining_waiting_time = remaining_waiting_time;
	}
	
	public boolean canBeLeft() {
		if (this.remaining_waiting_time == 0){
			return true;
		}
		else return false;
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
		this.setRemaining_waiting_time(this.initial_waiting_time);
		CellInterface previous_cell = player.getCell(); // la case précédemment occupée par le joueur qui arrive
		this.player.setCell(previous_cell); // le joueur actuel recule vers cette dernière
		previous_cell.welcomePlayer(this.player);
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

}
