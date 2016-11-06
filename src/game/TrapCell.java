package game;

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
		return "TrapCell";
	}
	
}
