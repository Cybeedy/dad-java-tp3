package Questions;

/* Q1 :

	int nb_joueurs_bloques;
	while (la case 63 est vide ET le jeu non bloqu�){
		for (P Player : List){
			cell = P.getCell();
			if(cell.canBeLeft()){
				if (player.getWaitingTime() == 0){
					d = twoDieThrow();
					new_cell_index = cell.getIndex() + d;
					new_cell = board.getCell(new_cell_index); // entre ces �tapes, g�rer l'affichage (demande plus de travail). seul souci pour l'affichage :
					new_cell_index = new_cell.handleMove(d); // l'�change de cases entre 2 joueurs n'est pas explicitement signal� (cela est cependant bien s�r pris en compte dans le jeu)
					proc�der au d�placement du joueur ou au swap des joueurs.
					if (new_cell.getIndex() == nombre_de_cases_hormis_0) break; // il y a un vainqueur.
					}
					
				else (diminuer le temps d'attente du joueur de 1);		
			}	
		}
		
		nb_joueurs_bloques = 0;
		for (P Player : List){
			cell = P.getCell();
			if (cell.canBeLeft()){
			nb_joueurs_bloques += 1;
			}
		}
		
		if (nb_joueurs_bloques == this.list_players.size()){ // tous les joueurs sont bloques
			break;
		}
	}

Q2 :



Q4 :

Nous avons choisi de ne pas mettre d'attribut list_players � la case 0. Cela ne sert � rien de conna�tre
la liste des joueurs dans cette case. En effet :
- la liste compl�te des joueurs est disponible en tant qu'attribut de l'instance de Game, et c'est �videmment sur celle-ci
  que l'on va it�rer (de plus, la liste des joueurs de la case 0 serait tr�s rapidement quasiment tout le temps voire tout le temps vide).
- chaque joueur conna�t la case sur laquelle il se situe, ce qui est le plus important car � chaque tour de jeu, on it�re sur
  la liste des joueurs et non pas la liste des cases.	
- surtout, la case 0 n'est jamais pleine. Ainsi, lorsqu'un nouveau joueur se d�place vers la case 0 (cas rare mais th�oriquement possible, avec la g�n�ration al�atoire de plateaux),
  il n'y a jamais besoin de proc�der � un �change de cases entre joueurs. Conna�tre le joueur d'une case donn�e (autre que 0) est essentiellement important pour cette raison.

 NB : on aurait pu faire de la classe ZeroCell un singleton, mais ici les �ventuels utilisateurs qui ajouteraient de nouvelles 
 classes de plateaux savent qu'il n'y a qu'une seule case 0 (et qu'il faut l'instancier correctement), on leur fait confiance.
 
*/
