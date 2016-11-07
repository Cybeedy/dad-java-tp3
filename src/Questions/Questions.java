package Questions;

/* Q1 :

	int nb_joueurs_bloques;
	while (la case 63 est vide ET le jeu non bloqué){
		for (P Player : List){
			cell = P.getCell();
			if(cell.canBeLeft()){
				if (player.getWaitingTime() == 0){
					d = twoDieThrow();
					new_cell_index = cell.getIndex() + d;
					new_cell = board.getCell(new_cell_index); // entre ces étapes, gérer l'affichage (demande plus de travail). seul souci pour l'affichage :
					new_cell_index = new_cell.handleMove(d); // l'échange de cases entre 2 joueurs n'est pas explicitement signalé (cela est cependant bien sûr pris en compte dans le jeu)
					procéder au déplacement du joueur ou au swap des joueurs.
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

Nous avons choisi de ne pas mettre d'attribut list_players à la case 0. Cela ne sert à rien de connaître
la liste des joueurs dans cette case. En effet :
- la liste complète des joueurs est disponible en tant qu'attribut de l'instance de Game, et c'est évidemment sur celle-ci
  que l'on va itérer (de plus, la liste des joueurs de la case 0 serait très rapidement quasiment tout le temps voire tout le temps vide).
- chaque joueur connaît la case sur laquelle il se situe, ce qui est le plus important car à chaque tour de jeu, on itère sur
  la liste des joueurs et non pas la liste des cases.	
- surtout, la case 0 n'est jamais pleine. Ainsi, lorsqu'un nouveau joueur se déplace vers la case 0 (cas rare mais théoriquement possible, avec la génération aléatoire de plateaux),
  il n'y a jamais besoin de procéder à un échange de cases entre joueurs. Connaître le joueur d'une case donnée (autre que 0) est essentiellement important pour cette raison.

 NB : on aurait pu faire de la classe ZeroCell un singleton, mais ici les éventuels utilisateurs qui ajouteraient de nouvelles 
 classes de plateaux savent qu'il n'y a qu'une seule case 0 (et qu'il faut l'instancier correctement), on leur fait confiance.
 
*/
