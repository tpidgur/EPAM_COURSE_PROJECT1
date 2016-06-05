package MVC.ModelContent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * class NecklaceBuilder has got a stone pool generation, contains the methods for gem selection based
 * on specific criterion
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class NecklaceBuilder {
    /**
     * instance of necklace class that incorporates the  empty collection of gems  for the necklace
     */
    private Necklace necklace = new Necklace();
    /**
     * each time this collection represents the Stone objects   selected for the necklace
     * on different  criteria  (colour,cut etc.)
     */
    private List<Stone> list;
    /**
     * collection of the generated pool of stones
     */
    public static List<Stone> stonePool = new ArrayList<>();

    /**
     * static block involves the generateStonePool() method
     */
    static {
        generateStonePool();
    }

    /**
     * adds all generated gems in the necklace
     */ {
        necklace.chain.addAll(stonePool);
    }

    /**
     * generates the collection of stones with different parameters
     */

    public static void generateStonePool() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double d = (double) random.nextInt(GlobalConstants.MAX_WEIGHT) / 10;
            int val = random.nextInt(GlobalConstants.MIN_CLARITY + 1) + 1;
            stonePool.add(new GemBuilder().buildWeight(d).buildClarity(val).buildTransparent());
            stonePool.add(new GemBuilder().buildMaterial(Material.SAPPHIRE).buildColour(Colour.BLUE).buildHardness(9).buildWeight(d).
                    buildClarity(val).buildTransparent());
            stonePool.add(new GemBuilder().buildMaterial(Material.RUBY).buildCut(Cut.HEART).buildColour(Colour.RED).buildHardness(9).buildWeight(d).
                    buildClarity(val).buildTransparent());
            stonePool.add(new GemBuilder().buildMaterial(Material.GARNET).buildCut(Cut.OVAL).buildColour(Colour.RED).
                    buildHardness(7).buildWeight(d).buildIsPrecious(false).buildLevel(6).buildNontransparent());


        }
    }

    /**
     * provides the condition for the transparent gem selection for the necklace
     *
     * @param filter
     * @return the object itself with updated collection of chain in Necklace class
     */
    public NecklaceBuilder buildTranspByCondition(Predicate<Stone> filter) {
        list = new ArrayList<>();
        Iterator<Stone> itr = necklace.chain.iterator();
        while (itr.hasNext()) {
            Stone stone = itr.next();
            if (filter.test(stone))
                list.add(stone);
        }
        necklace.chain = list;
       // necklace.chain.retainAll(list);
        return this;
    }

    /**
     * provides the condition for the nontransparent gem selection for the necklace
     *
     * @param filter
     * @return
     */
    public NecklaceBuilder buildNontranspByCondition(Predicate<Transparent> filter) {
        list = new ArrayList<>();
        Iterator<Stone> itr = necklace.chain.iterator();
        while (itr.hasNext()) {
            Stone stone = itr.next();
            if (stone instanceof Transparent) {
                if (filter.test((Transparent) stone))
                    list.add(stone);
            }
        }
        necklace.chain.retainAll(list);
        return this;
    }

    /**
     * @return the collection of gems transmitted to the Necklace class
     */
    public Necklace build() {
        return necklace;
    }


    public static List<Stone> getStonePool() {
        return stonePool;
    }

    /**
     * @return the Necklace  object after all gems have been selected on Predicate condition
     */

    public Necklace getNecklace() {
        return necklace;
    }


}
