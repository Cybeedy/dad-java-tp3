package game;

/** A class for the classic 63-cell board
 */
public class ClassicBoard extends Board {
	
	public ClassicBoard(int nb_cells){
		super(nb_cells);
	}
	
	/** This implementation of initBoard sets the (63 + 1) cells of the classic board.
	 */
	public void initBoard() {
		this.cells = new CellInterface[this.nb_cells + 1]; // Création du tableau de cases (nb_cases + 1, on compte la case 0)
		
		this.cells[0] = new ZeroCell();
		this.cells[1] = new RegularCell(1);
		this.cells[2] = new RegularCell(2);
		this.cells[3] = new RegularCell(3);
		this.cells[4] = new RegularCell(4);
		this.cells[5] = new RegularCell(5);
		this.cells[6] = new TeleportingCell(6, 12);
		this.cells[7] = new RegularCell(7);
		this.cells[8] = new RegularCell(8);
		this.cells[9] = new GooseCell(9);
		this.cells[10] = new RegularCell(10);
		this.cells[11] = new RegularCell(11);
		this.cells[12] = new RegularCell(12);
		this.cells[13] = new RegularCell(13);
		this.cells[14] = new RegularCell(14);
		this.cells[15] = new RegularCell(15);
		this.cells[16] = new RegularCell(16);
		this.cells[17] = new RegularCell(17);
		this.cells[18] = new GooseCell(18);
		this.cells[19] = new WaitingCell(19, 2);
		this.cells[20] = new RegularCell(20);
		this.cells[21] = new RegularCell(21);
		this.cells[22] = new RegularCell(22);
		this.cells[23] = new RegularCell(23);
		this.cells[24] = new RegularCell(24);
		this.cells[25] = new RegularCell(25);
		this.cells[26] = new RegularCell(26);
		this.cells[27] = new GooseCell(27);
		this.cells[28] = new RegularCell(28);
		this.cells[29] = new RegularCell(29);
		this.cells[30] = new RegularCell(30);
		this.cells[31] = new TrapCell(31);
		this.cells[32] = new RegularCell(32);
		this.cells[33] = new RegularCell(33);
		this.cells[34] = new RegularCell(34);
		this.cells[35] = new RegularCell(35);
		this.cells[36] = new GooseCell(36);
		this.cells[37] = new RegularCell(37);
		this.cells[38] = new RegularCell(38);
		this.cells[39] = new RegularCell(39);
		this.cells[40] = new RegularCell(40);
		this.cells[41] = new RegularCell(41);
		this.cells[42] = new TeleportingCell(42, 30);
		this.cells[43] = new RegularCell(43);
		this.cells[44] = new RegularCell(44);
		this.cells[45] = new GooseCell(45);
		this.cells[46] = new RegularCell(46);
		this.cells[47] = new RegularCell(47);
		this.cells[48] = new RegularCell(48);
		this.cells[49] = new RegularCell(49);
		this.cells[50] = new RegularCell(50);
		this.cells[51] = new RegularCell(51);
		this.cells[52] = new TrapCell(52);
		this.cells[53] = new RegularCell(53);
		this.cells[54] = new GooseCell(54);
		this.cells[55] = new RegularCell(55);
		this.cells[56] = new RegularCell(56);
		this.cells[57] = new RegularCell(57);
		this.cells[58] = new TeleportingCell(58, 1);
		this.cells[59] = new RegularCell(59);
		this.cells[60] = new RegularCell(60);
		this.cells[61] = new RegularCell(61);
		this.cells[62] = new RegularCell(62);
		this.cells[63] = new RegularCell(63);
	}
}
