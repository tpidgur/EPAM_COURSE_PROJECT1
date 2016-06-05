package MVC;

import MVC.ModelContent.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * In this class the program logic is demonstrated.
 * This class accumulates  data about gems and sends them to the classes that process operations on gems
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class Model {
    /**
     * instances of NecklaceBuilder and Necklace classes
     */
    NecklaceBuilder necklaceBuilder = new NecklaceBuilder();
    Necklace necklace;
    /**
     * filterPredicate is the condition of nontransparent gem selection passed to the NecklaceBuilder
     */
    private Predicate<Stone> filterPredicate = (i) -> true;
    /**
     * transpFilterPredicate is the condition of transparent gem selection passed to the NecklaceBuilder
     */
    private Predicate<Transparent> transpFilterPredicate = (i) -> true;

    /**
     * forms tha chain of filters on nontransparent gem selection and passes to buildTranspByCondition that if true
     * adds the selected gem to the necklace
     *
     * @param newfilter
     */
    public void setFilterPredicate(Predicate<Stone> newfilter) {
        filterPredicate = filterPredicate.and(newfilter);
        necklaceBuilder.buildTranspByCondition(filterPredicate);
    }

    /**
     * forms tha chain of filters on transparent gem selection and passes to buildTranspByCondition that if true
     * adds the selected gem to the necklace
     *
     * @param newfilter
     */
    public void setTranspFilterPredicate(Predicate<Transparent> newfilter) {
        transpFilterPredicate = transpFilterPredicate.and(newfilter);
        necklaceBuilder.buildNontranspByCondition(transpFilterPredicate);
    }


    /**
     * returns the necklace object with selected gem collection in Necklace class
     */
    public void build() {
        necklace = necklaceBuilder.build();
    }

    /**
     * calls the method from Necklace class  that calculates the total price of necklace
     *
     * @return
     */
    public double calculatePrice() {
        return necklace.calculateChainPrice();
    }

    /**
     * sorts gems on the price
     */

    public void sortGems() {
        Collections.sort(necklace.getChain(), new PriceStoneComparator());
    }

    /**
     * calls the method from Necklace class  that calculates the total weight of necklace
     *
     * @return
     */

    public double calculateWeight() {
        return necklace.calculateGeneralWeight();
    }

    /**
     * @return collection of generated gems
     */

    public List<Stone> getStonePool() {
        return necklaceBuilder.getStonePool();
    }

    /**
     * @return the necklace
     */
    public List<Stone> getChain() {
        return necklaceBuilder.getNecklace().getChain();
    }
}