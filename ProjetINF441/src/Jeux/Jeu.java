package Jeux;

import java.util.Map;
import java.util.Set;

//Définfition d'un jeu, paramétré par la classe S des posisitions et la classe A des actions

public abstract class Jeu<S, A> {


	S initialState; // Position initiale du jeu
	
	int Player;//Joueur à qui c'est le tour
	
	abstract S result(S state, A action); //Renvoie la position obtenue en
											// appliquant l'action action à la
											// position state

	abstract boolean terminal(S state); //Renvoie true ssi state est un état terminal

	abstract int utility(S state); //Utilité associée à l'état terminal state

	final int WIN = 1;
	final int DRAW = 0;
	final int LOSS =-1;
	
	
}
