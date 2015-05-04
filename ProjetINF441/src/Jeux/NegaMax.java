package Jeux;

import java.util.Iterator;
import java.util.Set;


public class NegaMax<S, A> {

	private Jeu jeu;

	public NegaMax(Jeu jeu) {
		this.jeu = jeu;
	}

	public int NegaMax(S state, int player) {

		if (jeu.terminal(state))
			return player*jeu.utility(state);

		else {
			int score = Integer.MIN_VALUE;
			Set<A> moves = jeu.legalMoves(state);
			for (A move : moves) {
				int value = -NegaMax((S) jeu.result(state, move, player), -player);
				if (value > score)
					score = value;
			}
			
			return score;
		}

	}
}