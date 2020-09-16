import java.util.Scanner;

/**
 *  TicTacToe class creates a game of tictactoe
 *
 *  @author Joel Plotnik, Rebecca Norwood, Ismael Lopez (Izzy), Benjamin Dominguez
 *  @since 09-14-2020
 */
public class TicTacToe
{
    // constant used for dimensions of the board
    private final int BOARDSIZE = 3;

    // Private members
    private enum Status {WIN, CONTINUE, DRAW}
    private final char[][] board;
    private char player;
    private int turn;

    /**
     * Constructor creates an empty board and initializes private variables
     */
    public TicTacToe()
    {
        this.board = new char[BOARDSIZE][BOARDSIZE];
        for(int i = 0; i < BOARDSIZE; i++){
            for(int j = 0; j < BOARDSIZE; j++){
                board[i][j] = ' ';
            }
        }
        this.player = 'X';
        this.turn = 0;
    }

    /**
     * Display the board to the console
     */
    public void printBoard()
    {
        System.out.println();

        for(int i = 0; i < BOARDSIZE; i++){
            for(int j = 0; j < BOARDSIZE; j++){
                System.out.print("| " + " ");
                System.out.print(board[i][j]);
                System.out.print(" " + " |");
            }
            System.out.println();
        }
    }

    /**
     * Run the game
     */
    public void play()
    {
        System.out.println("TicTacToe"); // Display title
        do
        {
            printBoard();           // Print the board
            getMove();              // Get the players move
            turn++;                 // Increase turn count

        } while(checkWinner() == Status.CONTINUE); // Check to see if there is a winner

        // The is a winner
        if (checkWinner() == Status.WIN)
        {
            printBoard();
            System.out.println("Player " + player + " wins!");
        }
        else // There is a draw
        {
            printBoard();
            System.out.println("Draw!");
        }

    }

    /**
     * Get the players move.
     * Allows user to input the row and column they wish to mark.
     */
    public void getMove()
    {

        Scanner input = new Scanner(System.in); // Create Scanner object
        int rowInput; // Hold player row input
        int colInput; // Hold player column input

        // Prompt player for their move
        System.out.println("Player " + player + "'s turn.");
        System.out.print("Enter row (0, 1, or 2): ");

        // Repeat until next item is an integer
        while (!input.hasNextInt())
        {
            System.out.println("\nInvalid row, please try again...\n"); // Re-prompt
            input.next(); // Read and discard offending non-int input
            System.out.print("Please enter row (0, 1, or 2): "); // Re-prompt
        }

        rowInput = input.nextInt(); // store player input

        System.out.print("Enter column (0, 1, or 2): ");

        // Repeat until next item is an integer
        while (!input.hasNextInt())
        {
            System.out.println("\nInvalid column, please try again...\n"); // Re-prompt
            input.next(); // Read and discard offending non-int input
            System.out.print("Please enter column (0, 1, or 2): "); // Re-prompt
        }

        colInput = input.nextInt(); // store player input

        // If the player didn't choose an available spot
        if (!validateInput(rowInput, colInput))
        {
            // Prompt user for another entry and don't let them continue
            // until they choose an open spot
            while (!validateInput(rowInput, colInput))
            {
                System.out.println("\nCannot mark here...");
                System.out.println("try again.\n");
                System.out.print("Please enter row (0, 1, or 2): ");

                // Repeat until next item is an integer
                while (!input.hasNextInt())
                {
                    input.next(); // Read and discard offending non-int input
                    System.out.print("Please enter row (0, 1, or 2): "); // Re-prompt
                }

                rowInput = input.nextInt(); // store player input

                System.out.print("Please enter column (0, 1, or 2): ");

                // Repeat until next item is an integer
                while (!input.hasNextInt())
                {
                    input.next(); // Read and discard offending non-int input
                    System.out.print("Please enter column (0, 1, or 2): "); // Re-prompt
                }

                colInput = input.nextInt(); // store player input
            }

        }

        // Set player marker
        this.board[rowInput][colInput] = player;

        // Change players turn so long as the game hasn't been won
        if (checkWinner() != Status.WIN)
            if (player == 'X')
            {
                player = 'O';
            }
            else
            {
                player ='X';
            }
    }

    /**
     * Validate player input
     * @param rows player row input
     * @param cols player column input
     * @return true or false
     */
    public boolean validateInput(int rows, int cols)
    {
        if ((rows >= 0 && rows <= 2) && (cols >= 0 && cols <= 2))
        {
            // If the spot is available
            if (this.board[rows][cols] == ' ')
            {
                return true;
            }
            else // Spot is not available
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }

    /**
     * Check to see if there is a winner
     * @return Status
     */
    public Status checkWinner()
    {
        if((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||          // horizontal X 1st row
                (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||     //horizontal O 1st row
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||     // horizontal X 2nd row
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||     //horizontal O 2nd row
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||     // horizontal X 3rd row
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||     //horizontal O 3rd row
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||     // vertical X 1st column
                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||     //vertical O 1st column
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||     // vertical X 2nd column
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||     //vertical O 2nd column
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||     // vertical X 3rd column
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||     //vertical O 3rd column
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||     // diagonal X L -> R
                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||     // diagonal O L -> R
                (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') ||     // diagonal X R -> L
                (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'))       // diagonal O R -> L
        {
            return Status.WIN;
        }

        // If a player has not won in 9 turns, its a draw
        if (turn == 9)
        {
            return Status.DRAW;
        }

        // Continue the game
        return Status.CONTINUE;
    }
}
