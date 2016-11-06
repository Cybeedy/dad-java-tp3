package game;

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
		player.setWaiting_time(this.getInitial_waiting_time());
		CellInterface previous_cell = player.getCell(); // la case précédemment occupée par le joueur qui arrive
		previous_cell.goodbyePlayer(player);
		if (this.isBusy()){
			previous_cell.welcomePlayer(this.player);
		}
		
		this.player = player;
		this.player.setCell(this);
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
