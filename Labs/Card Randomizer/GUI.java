import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class for GUI
 */
public class GUI extends JFrame implements ActionListener
{
    // constants
    public static final int DECKSIZE = 52;

    // instance variables
    private JLabel[] labels;
    private JButton shuffleBtn;
    private JPanel mainPanel;
    private JFrame frame;
    private CardDeck deck;

    /**
     * Creates a GUI and displays a deck of cards.
     * A user can press a button to shuffle the deck of cards.
     */
    public GUI(int row, int col)
    {
        // create deck of cards object
        deck = new CardDeck();

        // create the frame
        frame = new JFrame("Card Randomizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 700);                       // OPTIONAL (IDK IF WE WANTED FULLSCREEN OR NOT)
        frame.setResizable(false);                                  // OPTIONAL

        //Create mainPanel of Jframe to have 4 rows and 13 columns
        mainPanel = new JPanel(new GridLayout(row, col));
        mainPanel.setBackground(new Color(0, 100, 0));
        frame.add(mainPanel);

        //Create array of JLabels with initial pictures
        Labels_and_Images();

        // create button
        shuffleBtn = new JButton("Shuffle!");
        shuffleBtn.addActionListener(this);
        frame.add(shuffleBtn, BorderLayout.SOUTH);

        // set the frame visible
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }

    /**
     * Initial display for the deck of cards
     */
    public void Labels_and_Images()
    {
        //Label equal to number of pictures uploaded (52)
        labels = new JLabel[DECKSIZE];

        // create a label for each image and add it to the panel
        for(int i = 0; i < DECKSIZE; i++)
        {
            labels[i] = new JLabel(new ImageIcon(deck.getCard(i).getPic().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            mainPanel.add(labels[i]);
        }

    }

    /**
     * actionPerformed checks to see if button has been pressed
     * @param e ActionEvent
     */
    public void actionPerformed(ActionEvent e)
    {
        try {
            CardSelection(e);
        }
        catch(IndexOutOfBoundsException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * CardSelection will determine what to do when the button is pressed
     * @param e ActionEvent
     */
    public void CardSelection(ActionEvent e)
    {
       if (e.getSource() == shuffleBtn)
       {
           // randomize the deck every time button clicked
           System.out.println("Button Clicked!");
           deck.Randomize();

           // create a label for each image and add it to the panel
           for(int i = 0; i < labels.length; i++)
           {
               labels[i].setIcon(new ImageIcon(deck.getCard(i).getPic().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
           }

        }
    }

}
