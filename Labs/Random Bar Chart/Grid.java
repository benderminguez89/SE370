import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Creates a grid and bars for the bar chart
 */
public class Grid extends JPanel
{
    /**
     * Override the paintComponent(Graphics g) method, draws background 10X10 grid, and
     * draws lines of random lengths and colors (thickness be 15f). Uses the method
     * draw of class Graphics2D to draw the lines;
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g)
    {
        // set up components to create grid
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int size = Math.min(getWidth() - 4, getHeight() - 4) / 10;
        int y = (getHeight() - (size * 10)) / 2;

        // create the grid
        for (int horz = 0; horz < 10; horz++)
        {
            int x = (getWidth() - (size * 10)) / 2;

            for (int vert = 0; vert < 10; vert++)
            {
                g.drawRect(x, y, size, size);
                x += size;
            }

            y += size;
        }

        // create a random object
        Random rand = new Random();

        // min 20 (so that the bars don't go up past the grid
        int min = 20;

        // max 436 so that the bars line up with the bottom of the grid
        int max = 436;

        // create bars with stroke of 15 (10 felt a little too small)
        g2d.setStroke(new BasicStroke(15));

        // first bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(52, (int) (Math.random() * (max - min + 1) + min), 52, 436);

        // second bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(95, (int) (Math.random() * (max - min + 1) + min), 95, 436);

        // third bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(140, (int) (Math.random() * (max - min + 1) + min), 140, 436);

        // fourth bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(185, (int) (Math.random() * (max - min + 1) + min), 185, 436);

        // fifth bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(230, (int) (Math.random() * (max - min + 1) + min), 230, 436);

        // sixth bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(272, (int) (Math.random() * (max - min + 1) + min), 272, 436);

        // seventh bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(318, (int) (Math.random() * (max - min + 1) + min), 318, 436);

        // eighth bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(360, (int) (Math.random() * (max - min + 1) + min), 360, 436);

        // ninth bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(405, (int) (Math.random() * (max - min + 1) + min), 405, 436);

        // tenth bar
        g2d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        g2d.drawLine(448, (int) (Math.random() * (max - min + 1) + min), 448, 436);

        g2d.dispose(); // dispose of the graphics context and release any system resources that it is using
    }
}
