package MVC.ModelContent;

import java.util.Comparator;

/**
 *  provides the comparator based on the price criterion
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class PriceStoneComparator implements Comparator <Stone> {
    @Override
    public int compare(Stone o1, Stone o2) {
        return Double.compare(o1.price(),o2.price());
    }
}
