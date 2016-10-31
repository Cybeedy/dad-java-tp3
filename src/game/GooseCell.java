package game;

public class GooseCell implements CellInterface {
	private int index;
	
	public GooseCell(int index){
		this.index = index;
	}
	
	public boolean canBeLeft() {
		return true;
	}

	public int getIndex() {
		return this.index;
	}

	public int handleMove(int diceThrow) {
		return (this.index + diceThrow);
	}

	public boolean isBusy() {
		return false;
	}

	public void welcomePlayer(Player player) {
		// à commpléter
	}

	public Player getPlayer() {
		return null;
	}

}
