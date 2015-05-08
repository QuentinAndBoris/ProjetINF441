package Jeux;

import java.util.Iterator;
import java.util.Set;


public class NegaMax<S, A> {

	private Jeu jeu;

	public NegaMax(Jeu jeu) {
		this.jeu = jeu;
	}

	//Renvoie l'identité du joueur qui gagne dans la posistion state, le premier à jouer étant player
	public int NegaMax(S state, int player) {

		if (jeu.terminal(state))
			return jeu.utility(state);

		else {
			int score = Integer.MIN_VALUE;
			Set<A> moves = jeu.legalMoves(state);
			for (A move : moves) {
				int value = player*NegaMax((S) jeu.result(state, move, player), -player);
				if (value > player*score)
					score = player*value;
			}
			
			return score;
		}

	}
}