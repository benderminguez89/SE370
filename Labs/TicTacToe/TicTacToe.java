import java.util.Scanner;

public class TicTacToe
{
    private enum Status{WIN, CONTINUE, DRAW}
    private final int BOARDSIZE = 3;
    private char[][] board;
    private boolean firstPlayer;
    private boolean gameOver;
    private char empty = ' ';
    private Status status;
    private int turnCount;
    private int row;
    private int col;

    public TicTacToe()
    {
        turnCount = 0;
        firstPlayer = true;
        gameOver = false;
        this.status = Status.CONTINUE;

        this.board = new char[BOARDSIZE][BOARDSIZE];

        for(int i = 0; i < BOARDSIZE; i++){
            for(int j = 0; j < BOARDSIZE; j++){
                board[i][j] = empty;
            }
        }

    }

    public void play()
    {
        Scanner keyboard = new Scanner(System.in);

        while(gameOver == false){
            if(turnCount %2 == 0){
                System.out.println("\n" + "Player X's turn");
                firstPlayer = true;
            }
            else{
                System.out.println("\n" + "Player O's turn");
                firstPlayer = false;
            }
            try{
                System.out.println("Enter row: 0, 1, 2");
                row = keyboard.nextInt();
                System.out.println();

                System.out.println("Enter col: 0, 1, 2");
                col = keyboard.nextInt();

                if(validMove(row, col) == true){
                    printSymbol(row, col);
                    printBoard();
                    gameStatus();
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("The row and column you have chosen in out of bounds");
                System.out.println("Try again");
            }

            gameStatus();
            printStatus();
        }

    }

    private void printStatus()
    {
        if(gameOver == true){
            if(firstPlayer == true){
                System.out.println("Player X " + gameStatus().toString());
            }
            else{
                System.out.println("Player 0 " + gameStatus().toString());
            }
        }
        else{
            System.out.println(gameStatus().toString());
        }
    }

    private Status gameStatus()
    {
        if(((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||// horizontal X 1st row
                (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')) || //horizontal O 1st row
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||// horizontal X 2nd row
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||//horizontal O 2nd row
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||// horizontal X 3rd row
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')||//horizontal O 3rd row
                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||// vertical X 1st column
                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') || //vertical O 1st column
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||// vertical X 2nd column
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||//vertical O 2nd column
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||// vertical X 3rd column
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||//vertical O 3rd column
                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||// diagonal X L -> R
                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||// diagonal O L -> R
                (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') ||// diagonal X L -> R
                (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')) // diagonal O L -> R
        {
            gameOver = true;
            this.status = Status.WIN;
        }
        else{
            this.status = Status.CONTINUE;
        }


        return status;
    }

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

    private void printSymbol(int row, int col)
    {
        if(firstPlayer == true){
            board[row][col] = 'X';
        }
        else{
            board[row][col] = 'O';
        }
    }

    private boolean validMove(int row, int column)
    {
        turnCount++;
        return board[row][column] == empty;
    }
}
