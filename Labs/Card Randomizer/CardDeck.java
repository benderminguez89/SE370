import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * Class for CardDeck
 */
public class CardDeck
{
    // instance variables
    private static ArrayList<Card> deck = new ArrayList<Card>();

    /**
     * Creates a deck of cards from an input file
     */
    public CardDeck()
    {
        // locate the source of the images
        File path = new File("CardDeck");
        File [] files = path.listFiles();
        Arrays.sort(files);                             // sort the list of files

        // get the number of cards (should be 52)
        int numOfCards = files.length;

        // create array of the images and their name
        BufferedImage[] images = new BufferedImage[numOfCards];
        String[] names = new String[numOfCards];

        // populate the array with our card images
        for (int i = 0; i < numOfCards; i++)
        {
            if (files[i].isFile())                      // this line weeds out other directories/folders
            {
                try
                {
                    images[i] = ImageIO.read(files[i]); // returning a buffered image
                    names[i] = files[i].toString();     // associating each specific name of each photo to keep track
                }
                catch (IOException e)
                {
                    e.printStackTrace();                // print out where error is, if any
                }
            }
        }

        // add cards to our deck
        for(int i = 0; i < numOfCards; i++)
        {
            // if the file isn't an image, skip over it
            // otherwise add a card to the deck
            if (!names[i].contains(".png"))
                continue;
            deck.add(new Card(images[i], names[i]));
        }
    }

    /**
     * Shuffles the deck of cards
     */
    public static void Randomize()
    {
        Collections.shuffle(deck);
    }

    /**
     * Returns a card in the deck specified at index i
     */
    public static Card getCard(int i)
    {
        return deck.get(i);
    }

}
