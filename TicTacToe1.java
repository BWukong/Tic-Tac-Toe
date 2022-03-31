import java.util.Scanner;

public class TicTacToe1 {
	
    public static void displayBoard(String[] board) {
		for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
				System.out.print(board[j + (3 * i)] + "|");
    		}
			System.out.println("");
			System.out.println("-----");
		}
    }
    
    public static boolean makeMove(String player, int move, String[] board) {
		if (board[move - 1].equals("X") || board[move - 1].equals("O")) {
			return false;
		} else {
			board[move -1] = player;
			return true;
    	}
    }
    
    public static boolean isGameOver(String[] board) {
    	// Check horizontals
    	if (board[0].equals(board[1]) && board[1].equals(board[2])) {
    		return true;
    	} else if (board[3].equals(board[4]) && board[4].equals(board[5])) {
    		return true;
    	} else if (board[6].equals(board[7]) && board[7].equals(board[8])) {
    		return true;
    	} else if (board[0].equals(board[3]) && board[3].equals(board[6])) {
    		return true;
    	} else if (board[1].equals(board[4]) && board[4].equals(board[7])) {
    		return true;
    	} else if (board[2].equals(board[5]) && board[5].equals(board[8])) {
    		return true;
    	} else if (board[0].equals(board[4]) && board[4].equals(board[8])) {
    		return true;
    	} else if (board[2].equals(board[4]) && board[4].equals(board[5])) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		Scanner keyboard = new Scanner(System.in);
		String player = "X";
		
		displayBoard(board);
		
		while (!isGameOver(board)) {
			System.out.println("Player " + player + " make your move!");
			if (!makeMove(player, Integer.parseInt(keyboard.nextLine()), board)) {
				System.out.println("Invalid move!");	
				continue;
			} else {
				displayBoard(board);
				player = player.equals("X") ? "O" : "X";
			}
		}
		System.out.println("Player " + (player.equals("X") ? "O" : "X") + " has won!");
    }
}
