import java.util.Scanner;

public class TicTacToe
{
    // constants
    private final int BOARDSIZE = 3;

    // instance variables
    private enum Status{WIN, CONTINUE, DRAW}    // required
    private char[][] board;                     // required
    private boolean firstPlayer;                // required
    private boolean gameOver;                   // required
    private char empty = ' ';                   // used to populate the game board
    private Status status;
    private int turnCount;                      // used to indicate who's turn it is
    private int row;
    private int col;

    /**
     * constructor for TicTacToe objects
     */
    public TicTacToe()
    {
        // initialize variables
        turnCount = 0;
        firstPlayer = true;
        gameOver = false;
        this.status = Status.CONTINUE;
        this.board = new char[BOARDSIZE][BOARDSIZE];

        // populate the board with a blank space ' '
        for(int i = 0; i < BOARDSIZE; i++){
            for(int j = 0; j < BOARDSIZE; j++){
                board[i][j] = empty;
            }
        }
    }

    /**
     * allows for a player to take their turn
     * player can pick a row and column to insert their symbol
     * firstPlayer = X
     * secondPlayer = O
     */
    public void play()
    {
        // allow for user input
        Scanner keyboard = new Scanner(System.in);

        // allow the user to play while the game is not over
        // while (gameOver == false)
        while(!gameOver)
        {
            // turnCount = 0 indicates it is the firstPlayer's turn
            if(turnCount % 2 == 0){
                System.out.println("Player X's turn");
                firstPlayer = true;
            }
            else{
                System.out.println("Player O's turn");
                firstPlayer = false;
            }
            try
            {
                // let player enter a row
                System.out.print("Enter row: 0, 1, 2: ");
                row = keyboard.nextInt();

                // let player enter a column
                System.out.print("Enter col: 0, 1, 2: ");
                col = keyboard.nextInt();
                System.out.println();

                // if it is not a valid move, have them try again
                if( !validMove(row, col) )
                {
                    System.out.print("Spot already taken, try again.\n");
                    play();
                }
                // else, it is a valid move & place the user's symbol on the board
                else {
                    printSymbol(row, col);
                    printBoard();
                    turnCount++;
                    printStatus(turnCount);
                }

            }
            // catch user's input that is out of bounds
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("The row and column you have chosen are out of bounds...");
                System.out.println("Try again.\n");
            }
            // catch for when user doesn't enter an int
            catch(Exception e)
            {
                System.out.println("\nMust enter a number...");
                System.out.println("Try again.\n");
                keyboard.next();
            }
        }
    }

    /**
     * Prints the entire board
     */
    public void printBoard()
    {
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
     * Prints the status of the game
     *
     * Parameter: the current players
     */
    private void printStatus(int player)
    {
        // if the game is over
        if(gameOver)
        {
            // if it was firstPlayer's turn
            if(player % 2 == 0)
            {
                System.out.println("Player X: " + gameStatus().toString());
            }
            else
            {
                System.out.println("Player 0: " + gameStatus().toString());
            }
        }
        else {
            System.out.println(gameStatus().toString());
        }
    }

    /**
     * Determines if the game is over
     */
    private Status gameStatus()
    {
        if(((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||         // horizontal X 1st row
                (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')) ||    // horizontal O 1st row
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||     // horizontal X 2nd row
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||     // horizontal O 2nd row
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||     // horizontal X 3rd row
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')||      // horizontal O 3rd row
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||     // vertical X 1st column
                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||     // vertical O 1st column
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||     // vertical X 2nd column
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||     // vertical O 2nd column
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||     // vertical X 3rd column
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||     // vertical O 3rd column
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||     // diagonal X L -> R
                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||     // diagonal O L -> R
                (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') ||     // diagonal X R -> L
                (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'))       // diagonal O R -> L
        {
            // if any of the cases above are true, the game is over
            // and the status is WON
            gameOver = true;
            status = Status.WIN;
        }
        // else if every turn has been used, the board is full
        // and the game is a DRAW
        else if (turnCount >= 9)
        {
            gameOver = true;
            status = Status.DRAW;
        }
        // else the game is not over, so CONTINUE
        else
        {
            status = Status.CONTINUE;
        }

        // return the status of the game
        return status;
    }

    /**
     * Enters the symbol of the player
     * onto the board
     */
    private void printSymbol(int row, int col)
    {
        // if it is the first player's turn (firsPlayer == true)
        // fill their spot with an X
        if(firstPlayer)
        {
            board[row][col] = 'X';
        }
        // otherwise it is the second player's turn
        else{
            board[row][col] = 'O';
        }
    }

    /**
     * Determines if the move of a player is valid
     */
    private boolean validMove(int row, int column)
    {
        // returns true if the spot is empty, false if not
        return board[row][column] == empty;
    }
}
