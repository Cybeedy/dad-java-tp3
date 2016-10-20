/* Algorithme
Q1 :
play()
	while (la cell 63 est vide){
		for (P Player : List){
			cell = P.getCell;
			if(cell.canBeLeft()){
				d = twoDieThrow();
				cell.handleMove(d);
				if (cell.getIndex() == 63) 
					BREAK	
		}
		}
	}


Q4 : Nous allons utiliser le concept de singleton pour la classe zeroCell afin de l'unicité de la case 0 sur un plateau donné.
*/