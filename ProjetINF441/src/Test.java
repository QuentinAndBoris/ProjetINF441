import Jeux.MinMax;
import Jeux.NegaMax;
import Jeux.TicTacToe;

public class Test {

	public static void main(String[] args) {

		TicTacToe morpion = new TicTacToe(3, 3, 3);

		int[][] position = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, -1 } };

		morpion.print(position);

		System.out.println(" ");

		MinMax<int[][], int[]> search = new MinMax(morpion);

		int result = search.MinMax(position, -1);
		
		NegaMax<int[][],int []> negaSearch = new NegaMax(morpion);
		
		int negaResult = negaSearch.NegaMax(position, -1);

		System.out.println(result);
		
		System.out.println(negaResult);
	}
}