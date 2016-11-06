package game;

public class RegularCell implements CellInterface{
	private int index;
	private Player player;
	
	public RegularCell(int index){
		this.index = index;
	}
	
	public RegularCell(int index, Player player){
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
		return getIndex();
	}

	public boolean isBusy() {
		if (this.getPlayer() == null){
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
		return "RegularCell";
	}
	
}
