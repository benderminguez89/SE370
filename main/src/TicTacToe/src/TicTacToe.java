import java.util.Scanner;

public class TicTacToe 
{
	private final int BOARDSIZE = 3; 
	private enum Status {WIN, DRAW, CONTINUE}; 
	private char [][]board; 
	private boolean firstPlayer; 
	private boolean gameOver; 
	private int turn = 0; 
	
	TicTacToe()
	{
		this.board = new char[BOARDSIZE][BOARDSIZE]; 
		firstPlayer = false; 
		gameOver = false; 
	}
	
	public void play()
	{	
		Scanner keyboard = new Scanner(System.in); 
		
		firstPlayer = true; 
		
		System.out.println("Enter row: 0, 1, 2"); 
		
		int row = keyboard.nextInt(); 
		System.out.println(); 
		
		System.out.println("Enter col: 0, 1, 2"); 
		int col = keyboard.nextInt(); 
		
		boolean move = validMove(row, col); 
		printBoard(); 
	}

	public void printBoard()
	{
		for(int i = 0; i < BOARDSIZE; i++) {
			System.out.print("| ");
			for(int j = 0; j < BOARDSIZE; j++) {
				System.out.print(" |" + " ");
			}
			System.out.println(); 
		}
	}
	
	private boolean validMove(int row, int column)
	{
		return row >= 0 && row < BOARDSIZE && column >= 0 && column < BOARDSIZE; 
	}
}
