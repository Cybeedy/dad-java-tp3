package game;

public class GooseCell implements CellInterface {
	private int index;
	private Player player;
	
	public GooseCell(int index){
		this.index = index;
	}
	
	public GooseCell(int index, Player player){
		this.index = index;
		this.player = player;
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
		return null;
	}

	public String identificationMessage(){
		return "GooseCell";
	}
	
}
