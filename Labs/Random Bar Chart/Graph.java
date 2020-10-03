import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Graph class
 */
public class Graph extends JPanel implements ActionListener
{
    // constants
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    // instance variables
    private final JButton redrawBtn;
    private final JFrame frame;
    private Grid grid;

    /**
     * Creates JFrame using Graphics to show a graph that randomizes their height
     * and color when the user clicks the only button: "Redraw"
     */
    public Graph()
    {
        frame = new JFrame();                       // create a new frame
        frame.setResizable(false);                  // don't allow user to resize the frame
        frame.setTitle("Random Bar Chart");         // title the frame
        frame.setSize(WIDTH, HEIGHT);               // set the size of the frame

        redrawBtn = new JButton("Redraw");      // create a button
        redrawBtn.addActionListener(this);        // receive user input
        frame.add(redrawBtn, BorderLayout.SOUTH);   // add button the the bottom of the frame

        grid = new Grid();                          // create a new grid
        frame.add(grid, BorderLayout.CENTER);       // add the grid to the center of the frame
        grid.setBackground(Color.LIGHT_GRAY);       // set background color of the grid

        frame.setVisible(true);                                 // set visibility
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // exit on close
    }

    /**
     * actionPerformed checks to see if button has been pressed
     * @param e ActionEvent
     */
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            // button pressed
            buttonPressed(e);
        }
        catch(IndexOutOfBoundsException e1)
        {
            e1.printStackTrace();
        }
    }

    /**
     * buttonPressed will create a new random bar chart
     * @param e1 ActionEvent
     */
    public void buttonPressed(ActionEvent e1)
    {
        // gets the source of the action
        // (useful if there are more than 1 buttons)
        JButton src = (JButton) e1.getSource();

        // if the source was from the Redraw button,
        // create a new randomized bar chart
        if(src == redrawBtn)
        {
            grid = new Grid();                      // create a new grid
            frame.add(grid, BorderLayout.CENTER);   // add the grid to the center of the frame
            grid.setBackground(Color.LIGHT_GRAY);   // set background color of the grid

            frame.setVisible(true);                                 // set visibility
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // exit on close
        }
    }
}
