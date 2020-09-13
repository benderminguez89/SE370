import java.util.Scanner;

public class TicTacToe
{
    // constants
    private final int BOARDSIZE = 3;

    // instance variables
    private enum Status {WIN, DRAW, CONTINUE};
    private char [][]board;
    private boolean firstPlayer;
    private boolean gameOver;
    private int playerTurn = 1;

    public TicTacToe()
    {
        board = new char[BOARDSIZE][BOARDSIZE];
        firstPlayer = true;
        gameOver = false;
    }

    public void play()
    {
        Scanner keyboard = new Scanner(System.in);

        // state which player's turn it is
        if (firstPlayer)
            System.out.println("Player X's turn.");
        else
            System.out.println("Player O's turn.");

        // get the user's input for row & col
        System.out.print("Enter row: 0, 1, 2: ");
        int row = keyboard.nextInt();

        System.out.print("Enter col: 0, 1, 2: ");
        int col = keyboard.nextInt();

        System.out.println();


        // make sure their move is valid
        // otherwise re-prompt the user for input
        if (!validMove(row, col))
        {
            System.out.print("This is an invalid move, try again.\n");
            play();
        }
        else
            {
                // firstPlayer = X
                // secondPlayer = O
                if (firstPlayer)
                {
                    board[row][col] = 'X';
                    firstPlayer = false;
                }
                else {
                    board[row][col] = 'O';
                    firstPlayer = true;
                }
            }
    }

    public void printBoard()
    {
        for(int i = 0; i < BOARDSIZE; i++) {
            System.out.print("| ");
            for(int j = 0; j < BOARDSIZE; j++) {
                System.out.print(printSymbol(i, j));
                System.out.print(" |" + " ");
            }
            System.out.println();
        }
    }

    private char printSymbol(int row, int col)
    {
        return board[row][col];
    }

    private boolean validMove(int row, int col)
    {
        // if the row/col is not empty return false
        // otherwise return true
        if (board[row][col] != '\0')
        {
            return false;
        }
        return true;
        //return row >= 0 && row < BOARDSIZE && column >= 0 && column < BOARDSIZE;
    }
}
