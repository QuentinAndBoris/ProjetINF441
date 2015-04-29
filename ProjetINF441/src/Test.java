import Jeux.TicTacToe;

public class Test {

	

	public static void main(String[] args) {
		
		TicTacToe morpion = new TicTacToe(3, 3, 3);

		int[][] position = { { 1, 1, 0 }, { 1, -1, 1 }, { -1, 1, -1 } };
		
		morpion.print(position);

		System.out.println(morpion.terminal(position));
		
		int[] action = {0,2};

		System.out.println(position[action[0]][action[1]]);
		
		int[][] newPosition = morpion.result(position, action, 1);
		
		morpion.print(newPosition);
		
		System.out.println(morpion.utility(newPosition));
	}
}