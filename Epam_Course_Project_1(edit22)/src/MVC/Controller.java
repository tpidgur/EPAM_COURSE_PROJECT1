package MVC;
/**
 * Class controller can send commands to the model to update the model's state.
 * It can also send commands to its associated view to change the view's presentation of the model
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */


import java.util.Scanner;


public class Controller {
    /**
     * the regular expression for Integer selection with spaces
     */
    private static String INTEGER_DELIMITERS = "^[\\d\\s]{1,20}$";
    /**
     * the regular expression for Double selection with spaces
     */
    private static String DOUBLE_DELIMITERS = "^(\\d+(\\.\\d*)?)(\\s*\\d+(\\.\\d*)?)*\\s*$";
    Scanner sc = new Scanner(System.in);

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    /**
     * The Work method
     * runs the gem pool generation  and invokes the main menu
     */
    public void processUser() {
        view.printMessage(View.GEM_POOL + model.getStonePool());
        chooseMenuOption(chooseParameters(INTEGER_DELIMITERS, View.INPUT_PARAMETERS, true));


    }

    /**
     * checks whether the input data are numbers separated by space
     *
     * @param regex   for Integer and Double separation
     * @param message invitation for entering data
     * @param flag    (true stands for Integer data, false for Double)
     * @return array of Number
     */

    public Number[] chooseParameters(String regex, String message, boolean flag) {
        view.printMessage(message);
        Number[] array = null;
        while (true) {
            try {
                array = parseNumberWithSpace(inputNumbersMatchingRegex(regex), flag);
                view.printMessage(view.APPROVAL);
                break;
            } catch (Exception ex) {
                view.printMessage(view.WRONG_INPUT_DATA);
            }
        }
        return array;
    }

    /**
     * inputs String with Scanner that matches the regex
     *
     * @param regex Integer or Double
     * @return String that matches the regex
     */
    public String inputNumbersMatchingRegex(String regex) {
        String input;
        while (true) {
            input = sc.nextLine();
            if (!input.matches(regex)) {
                view.printMessage(view.WRONG_INPUT_DATA);
            } else {
                break;
            }
        }
        return input;
    }

    /**
     * @param input String splits into Integer  or Double
     * @param flag  corresponds to Integer (true) or Double (false)
     * @return the array of Numbers (Doubles or Integers)
     */
    public Number[] parseNumberWithSpace(String input, boolean flag) {
        String[] strings = input.split(" ");
        Number[] numbers = new Number[strings.length];
        for (int i = 0; i < numbers.length; i++)
            if (flag) {
                numbers[i] = Integer.parseInt(strings[i]);
            } else {
                numbers[i] = Double.parseDouble(strings[i]);
            }
        return numbers;
    }

    /**
     * @param array of input Number
     * @param value
     * @return true if any element in input Number array corresponds to the given value (characteristic
     * of stone: colour,material etc.)
     */
    private boolean findNumberInArray(Number[] array, Number value) {
        for (Number element : array) {
            if (element.toString().equals(value.toString())) return true;
        }
        return false;
    }

    /**
     * forms the chain of requests to the stones to be selected for the necklace based on the options
     *as a result the gems for the necklace are selected, their total price and weight have been calculated,
     * gems have been sorted according to their price
     * @param options correspond to the specific section of the predicate chaining sent to the model
     *                option0: colour filter
     *                option1: material filter
     *                option2: cut filter
     *                option3: weight filter
     *                option4: clarity filter
     *                option5: break
     */
    public void chooseMenuOption(Number[] options) {
        for (int i = 0; i < options.length; i++) {
            switch (options[i].intValue()) {
                case 0:
                    //returns the entered from console Number array corresponding to specific input colour
                    Number[] numbers = chooseParameters(INTEGER_DELIMITERS, View.INPUT_COLOUR, true);
                    //if there are any values corresponding to the ordinal of Colour enum,
                    // the  predicate chaining is passed to the model
                    model.setFilterPredicate(s -> findNumberInArray(numbers, s.getColour().ordinal()));
                    break;
                case 1:
                    numbers = chooseParameters(INTEGER_DELIMITERS, View.MATERIAL_RANGE, true);
                    model.setFilterPredicate(s -> findNumberInArray(numbers, s.getMaterial().ordinal()));
                    break;
                case 2:
                    numbers = chooseParameters(INTEGER_DELIMITERS, View.CUT_RANGE, true);
                    model.setFilterPredicate(s -> findNumberInArray(numbers, s.getCut().ordinal()));
                    break;
                case 3:
                    numbers = chooseParameters(DOUBLE_DELIMITERS, View.WEIGHT_RANGE, false);
                    model.setFilterPredicate(s -> findNumberInArray(numbers, s.getWeight()));
                    break;
                case 4:
                    numbers = chooseParameters(INTEGER_DELIMITERS, View.CLARITY_RANGE, true);
                    model.setTranspFilterPredicate(s -> findNumberInArray(numbers, s.getClarity()));
                    break;
                case 5:
                    view.printMessage(View.BREAK);
                    return;
            }
        }
        model.build();
        view.printMessage(View.SELECTED_GEMS + model.getChain() +
                View.NECKLACE_WEIGHT + model.calculateWeight() +
                View.NECKLACE_PRICE + model.calculatePrice());
        model.sortGems();
        view.printMessage(View.SORT_ON_PRICE + model.getChain());

    }


}