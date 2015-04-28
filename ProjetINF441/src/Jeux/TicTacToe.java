package Jeux;

//Une première définfition naïve d'un TicTacToe, où l'on représente bêtement la grille par une matrice
//et une action par un tableau de taille 2 (coordonnées du prochain coup)

//On représente une croix par un 1, une position indéterminée par un 0 et un rond par un -1

public class TicTacToe extends Jeu<int[][], int[]> {

	private int k;
	private int L;
	private int H;

	public TicTacToe(int k, int L, int H) {

		this.k = k;
		this.L = L;
		this.H = H;

		this.initialState = new int[L][H];
	}

	public TicTacToe(int k, int L, int H, int[][] initialState) {

		assert ((initialState.length == L) && (initialState[0].length == H));

		this.k = k;
		this.L = L;
		this.H = H;

		this.initialState = initialState;
	}

	@Override
	int[][] result(int[][] state, int[] action, int player) {

		assert (player * player == 1);

		if (state[action[1]][action[2]] == 0) {
			int[][] result = state.clone();
			result[action[1]][action[2]] = player;
		}

		return null; // Sortie lorsque l'action n'est pas légale
	}

	@Override
	public boolean terminal(int[][] state) {

		boolean emptyCase = false;
		int joueur = 0;
		int compteur = 0;

		// Vérification des colonnes

		for (int i = 0; i < L; i++) {
			joueur = 0;
			compteur = 0;
			for (int j = 0; j < H; j++) {

				if (joueur != 0) {
					if (state[i][j] == joueur) {
						compteur++;
						if (compteur >= this.k)
							return true;
					} else {
						compteur = 0;
						joueur = state[i][j];
						if (state[i][j] == 0)
							emptyCase = true;
					}
				}

				else {
					joueur = state[i][j];
					if (state[i][j] != 0)
						compteur++;
					else
						emptyCase = true;
				}
			}
		}

		// Vérification des lignes

		for (int j = 0; j < H; j++) {
			joueur = 0;
			compteur = 0;
			for (int i = 0; i < L; i++) {

				if (joueur != 0) {
					if (state[i][j] == joueur) {
						compteur++;
						if (compteur >= this.k)
							return true;
					} else {
						compteur = 0;
						joueur = state[i][j];

					}
				}

				else {
					joueur = state[i][j];
					if (state[i][j] != 0)
						compteur++;
				}
			}
		}

		// Vérification des diagonales

		for (int l = k; l <= Math.min(L, H); l++) {
			joueur = 0;
			compteur = 0;
			for (int i = 0; i < l; i++) {

				if (joueur != 0) {
					if (state[i][l - i - 1] == joueur) {
						compteur++;
						if (compteur >= this.k)
							return true;
					} else {
						compteur = 0;
						joueur = state[i][l - i - 1];
					}
				}

				else {
					joueur = state[i][l - i - 1];
					if (state[i][l - i - 1] != 0)
						compteur++;
				}

			}
		}
		return !emptyCase;
	}

	// Renvoie l'id du joueur gagnant, 0 si match nul et null si pas un état
	// terminal
	@Override
	public int utility(int[][] state) {
		boolean emptyCase = false;
		int joueur = 0;
		int compteur = 0;

		// Vérification des colonnes

		for (int i = 0; i < L; i++) {
			joueur = 0;
			compteur = 0;
			for (int j = 0; j < H; j++) {

				if (joueur != 0) {
					if (state[i][j] == joueur) {
						compteur++;
						if (compteur >= this.k)
							return joueur;
					} else {
						compteur = 0;
						joueur = state[i][j];
						if (state[i][j] == 0)
							emptyCase = true;
					}
				}

				else {
					joueur = state[i][j];
					if (state[i][j] != 0)
						compteur++;
					else
						emptyCase = true;
				}
			}
		}

		// Vérification des lignes

		for (int j = 0; j < H; j++) {
			joueur = 0;
			compteur = 0;
			for (int i = 0; i < L; i++) {

				if (joueur != 0) {
					if (state[i][j] == joueur) {
						compteur++;
						if (compteur >= this.k)
							return joueur;
					} else {
						compteur = 0;
						joueur = state[i][j];

					}
				}

				else {
					joueur = state[i][j];
					if (state[i][j] != 0)
						compteur++;
				}
			}
		}

		// Vérification des diagonales
		//TODO : je n'ai vérifié les diagonales que dans un sens...
		for (int l = k; l <= Math.min(L, H); l++) {
			joueur = 0;
			compteur = 0;
			for (int i = 0; i < l; i++) {

				if (joueur != 0) {
					if (state[i][l - i - 1] == joueur) {
						compteur++;
						if (compteur >= this.k)
							return joueur;
					} else {
						compteur = 0;
						joueur = state[i][l - i - 1];
					}
				}

				else {
					joueur = state[i][l - i - 1];
					if (state[i][l - i - 1] != 0)
						compteur++;
				}

			}
		}
		return emptyCase ? null : 0;
	}

	public void print(int[][] state) {

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < H; j++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.println("");
		}

	}

}
