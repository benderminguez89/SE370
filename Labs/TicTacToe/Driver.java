/**
 * TicTacToe -
 * The game contains a private 3-by-3 two-dimensional array for representing board elements.
 * An enumeration is used to represent the status of the final game result. The enumeration’s
 * constants are named WIN, DRAW, and CONTINUE.
 * The game allows two human players to play the game. Whenever the first player moves, an X
 * is placed in the specified square, and an O is placed wherever the second player moves.
 * Each move must be to an empty square. After each move, it is determined whether the game
 * has been won or if there was a draw.
 *
 * @author Joel Plotnik, Rebecca Norwood, Ismael Lopez (Izzy), Benjamin Dominguez
 * @since 09-14-2020
 * @param args String
 */
public class Driver
{
    public static void main(String[] args)
    {
        // Create a TicTacToe Object
        TicTacToe game = new TicTacToe();

        game.play();                        // Play the game
        System.out.println("Game Over");    // display that the game is over
    }
}
