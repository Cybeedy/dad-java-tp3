package goosegame;

public class TeleportingCell implements Cell {
	private int index;
	private int indexTeleport;
	@Override
	public boolean canBeLeft() {
		return true;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int handleMove(int diceThrow) {
		
		return indexTeleport;
	}

	@Override
	public boolean isBusy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void welcomePlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}
