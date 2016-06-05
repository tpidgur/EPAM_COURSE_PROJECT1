package MVC.ModelContent;

import java.util.*;

/**
 * class Necklace has got a  collection with selected for the necklace gems
 * that are produced from NecklaceBuilder class
 * the  price and weight of the necklace has been calculated
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class Necklace {
    /**
     * gem collection  selected for the necklace
     */
    public List<Stone> chain = new ArrayList<>();


    /**
     * calculates the total price of the stones in the necklace
     *
     * @return double value of price
     */
    public double calculateChainPrice() {
        double price = 0;
        Iterator<Stone> itr = chain.iterator();
        while (itr.hasNext()) {
            Stone stone = itr.next();
            price += stone.price();
        }
        return price;
    }

    /**
     * calculates the total weight of  stones in the necklace
     *
     * @return double value of weight
     */
    public double calculateGeneralWeight() {
        double weight = 0;
        Iterator<Stone> itr = chain.iterator();
        while (itr.hasNext()) {
            Stone stone = itr.next();
            weight += stone.getWeight();
        }
        return weight;
    }


    public List<Stone> getChain() {
        return chain;
    }


}
