package game;

public class TeleportingCell implements CellInterface {
	private int index;
	private int destination_cell_index;
	
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
	}

	public Player getPlayer() {
		return null;
	}

}
