package Jeux;

import java.util.Iterator;
import java.util.Set;

public class MinMax<S, A> {

	private Jeu jeu;
	final int MAX = 1;
	final int MIN = -1;

	public MinMax(Jeu jeu) {
		this.jeu = jeu;
	}

	
	//Renvoie l'identité du joueur qui gagne dans la posistion state, le premier à jouer étant player
	public int MinMax(S state, int player) {

		if (jeu.terminal(state))
			return jeu.utility(state);

		else if (player == MAX) {
			int score = Integer.MIN_VALUE;
			Set<A> moves = jeu.legalMoves(state);
			for (A move : moves) {
				int value = MinMax((S) jeu.result(state, move, MAX), MIN);
				if (value > score)
					score = value;
			}
			return score;

		} else if (player == MIN) {
			int score = Integer.MAX_VALUE;
			Set<A> moves = jeu.legalMoves(state);
			for (A move : moves) {
				int value = MinMax((S) jeu.result(state, move, MIN), MAX);
				if (value < score)
					score = value;
			}

			return score;
		}

		return 0;
	}

}
