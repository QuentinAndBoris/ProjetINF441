import Jeux.TicTacToe;

public class Test {

	

	public static void main(String[] args) {
		
		TicTacToe morpion = new TicTacToe(3, 3, 3);

		int[][] position = { { -1, 1, 1 }, { 1, -1, 1 }, { -1, 1, -1 } };
		
		morpion.print(position);

		System.out.println(morpion.terminal(position));
		System.out.println(morpion.utility(position));

	}
}