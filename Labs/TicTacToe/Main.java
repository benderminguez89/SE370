public class Main {

    public static void main(String[] args)
    {
        // write your code here
        System.out.println("TicTacToe\n");

        // create a new TicTacToe object
        TicTacToe t = new TicTacToe();

        // print the empty board for the first time
        t.printBoard();

        // play the game
        t.play();

        // once the game is over
        // display message
        System.out.println("Game Over!");
    }
}


