package game;

public class TeleportingCell implements CellInterface {
	private int index;
	private int destination_cell_index;
	private Player player;
	
	public TeleportingCell(int index, int destination_cell_index){
		this.index = index;
		this.destination_cell_index = destination_cell_index;
	}
	
	public boolean canBeLeft() {
		return true;
	}

	public int getIndex() {
		return this.index;
	}

	public int handleMove(int diceThrow) {
		return this.destination_cell_index;
	}

	public boolean isBusy() {
		return false;
	}

	public void welcomePlayer(Player player) {
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
		return "TeleportingCell";
	}
	
}
