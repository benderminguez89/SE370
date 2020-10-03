import java.awt.image.BufferedImage;

/**
 * Card class
 */
public class Card {

    // instance variables
    private BufferedImage pic;
    private String id;

    /**
     * Constructor
     */
    public Card(BufferedImage pic, String id)
    {
        this.pic = pic;
        this.id = id;
    }

    /**
     * Returns the image of a card
     */
    public BufferedImage getPic()
    {
        return pic;
    }

}
