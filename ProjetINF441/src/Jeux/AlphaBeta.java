package Jeux;

import java.util.Set;

public class AlphaBeta<S, A> {

	Jeu jeu;

	public AlphaBeta(Jeu jeu) {
		this.jeu = jeu;
	}

	private int aux(S state, int alpha, int beta, int player) {

		if (jeu.terminal(state))
			return jeu.utility(state);

		else {
			int score = -10000;
			int alphabis = alpha;
			int betabis = beta;
			Set<A> moves = jeu.legalMoves(state);
			for (A move : moves) {
				int value = player
						* aux((S) jeu.result(state, move, player), -betabis,
								-alphabis, -player);
				if (value > score)
					score = value;
				if (score > alphabis)
					alphabis = score;
				if (score >= betabis)
					break;
			}

			return player*score;

		}
	}

	public int AlphaBeta(S state, int player) {
		return aux(state, -10000, 10000, player);
	}
}
