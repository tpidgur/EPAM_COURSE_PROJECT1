package MVC;

import java.util.Arrays;
import java.util.Scanner;

/**
 * a starting point of the program
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();


    }

}
