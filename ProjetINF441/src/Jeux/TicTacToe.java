package Jeux;

//Une première définfition naïve d'un TicTacToe, où l'on représente bêtement la grille par une matrice
//et une action par un tableau de taille 2 (coordonnées du prochain coup)

//On représente une croix par un 1, une position indéterminée par un 0 et un rond par un -1

public class TicTacToe extends Jeu<int[][], int[]> {

	private int k;
	private int L;
	private int H;

	TicTacToe(int k, int L, int H) {

		this.k = k;
		this.L = L;
		this.H = H;

		this.initialState = new int[L][H];
	}

	TicTacToe(int k, int L, int H, int[][] initialState) {

		assert ((initialState.length == L) && (initialState[0].length == H));

		this.k = k;
		this.L = L;
		this.H = H;

		this.initialState = initialState;
	}

	@Override
	int[][] result(int[][] state, int[] action) {

		return null; // Sortie lorsque l'action n'est pas légale
	}

	@Override
	boolean terminal(int[][] state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int utility(int[][] state) {
		// TODO Auto-generated method stub
		return 0;
	}

}
