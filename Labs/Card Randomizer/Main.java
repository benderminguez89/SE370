public class Main {

    /**
     * Main method for the random bar chart
     *
     * @author Joel Plotnik, Rebecca Norwood, Ismael Lopez (Izzy), Benjamin Dominguez
     * @since 09-25-2020
     * @param args String
     */
    public static void main(String[] args)
    {
        //Creating arraylist of card objects with buffered image and string parameter
        DisplayGUI();

    }

    /**
     * Creates a GUI object with specified row/col values
     */
    private static void DisplayGUI()
    {
        //Create gui with four rows and 13 columns
        GUI gui = new GUI(4, 13);
    }

}
