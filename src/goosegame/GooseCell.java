package goosegame;

public class GooseCell implements Cell {
	private int index;
	
	public GooseCell(){
		
	}
	
	@Override
	public boolean canBeLeft() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int handleMove(int diceThrow) {
		// TODO Auto-generated method stub
		return 0;
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
