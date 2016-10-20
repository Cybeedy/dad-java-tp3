package goosegame;

public class RegularCell implements Cell {
	private int index;
	private Player player;
	
	public boolean canBeLeft() {
		return true;
	}

	
	public int getIndex() {
		return index;
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
		System.out.println(player.toString() + "reached cell #" + getIndex());
	}

	public Player getPlayer() {
		return null;
	}

}
