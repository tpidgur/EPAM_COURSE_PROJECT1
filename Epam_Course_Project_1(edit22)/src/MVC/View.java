package MVC;

/**
 * A view generates an output presentation to the user based on changes in the model.
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class View {
    // Text's constants
    public static final String INPUT_COLOUR = "\nChoose one or several colours for your necklace:" +
            "\n0.White" +
            "\n1.Red" +
            "\n2.Blue" +
            "\nExample: 1 or 0 1 2  ";
    public static final String INPUT_PARAMETERS = "\nWhat parameters would you like to be involved for your necklace:\n" +
            "Choose one or several (between 0 and 4) or press 5 for break" +
            "\n0.Colour" +
            "\n1.Material" +
            "\n2.Cut" +
            "\n3.Weight" +
            "\n4.Clarity" +
            "\nExample: 5 or 0 1 2 3 4 ";

    public static final String MATERIAL_RANGE = "Enter the number of material you want to use in the necklace:" +
            "\n0.Diamond" +
            "\n1.Sapphire" +
            "\n2.Ruby" +
            "\n3.Garnet" +
            "\nExample: 0 or 0 1 2 3  ";
    public static final String CUT_RANGE = "Enter the cut you want to use in the necklace:" +
            "\n0.Circle" +
            "\n1.Heart" +
            "\n2.Oval" +
            "\nExample: 0 or 0 1 2 ";
    public static final String WEIGHT_RANGE = "Enter the weight of gem in Ct  you want to use in the necklace: (between 0.1 and 10)" +
            "\nExample: 1.5 or  1.5 2 3.2 ";
    public static final String CLARITY_RANGE = "Enter the clarity values of material (from 1 to 10) you want to use in the necklace:" +
            "\nExample: 1 or  1 2 3 ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String RANGE = " Correct range is: ";
    public static final String APPROVAL = "Got it!";
    public static final String SELECTED_GEMS = "Selected gems for the necklace based on your request  are:\n";
    public static final String GEM_POOL = "The available gem pool includes:\n";
    public static final String NECKLACE_PRICE = "\nNecklace price is: ";
    public static final String NECKLACE_WEIGHT = "\nNecklace weight is: ";
    public static final String SORT_ON_PRICE = "\nSorted necklace on price is: ";
    public static final String BREAK = "Break!!! ";

    public void printMessage(Object message) {
        System.out.println(message);
    }

}
