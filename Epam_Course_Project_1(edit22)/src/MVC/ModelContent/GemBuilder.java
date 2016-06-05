package MVC.ModelContent;

/**
 * gem creation with different parameters
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class GemBuilder {
    //default values of parameters
    private Colour colour = Colour.WHITE;
    private int hardness = GlobalConstants.MAX_HARDNESS;
    private Cut cut = Cut.CIRCLE;
    private double weight = 1;
    private boolean isPrecious = true;
    private int level = GlobalConstants.MAX_PRECIUS_LEVEL;
    private Material material = Material.DIAMOND;
    private int clarity = GlobalConstants.MAX_CLARITY;

    /**
     * defines the colour of gem to be generated
     *
     * @param colour
     * @return
     */
    GemBuilder buildColour(Colour colour) {
        this.colour = colour;
        return this;
    }

    /**
     * defines the hardness of gem to be generated
     *
     * @param hardness
     * @return
     */

    GemBuilder buildHardness(int hardness) {
        this.hardness = hardness;
        return this;
    }

    /**
     * defines the  cut of gem to be generated
     *
     * @param cut
     * @return
     */
    GemBuilder buildCut(Cut cut) {
        this.cut = cut;
        return this;
    }

    /**
     * defines the  weight of gem to be generated
     *
     * @param weight
     * @return
     */
    GemBuilder buildWeight(double weight) {
        this.weight = weight;
        return this;
    }

    /**
     * defines whether precious or not the  gem is
     *
     * @param isPrecious
     * @return
     */
    GemBuilder buildIsPrecious(boolean isPrecious) {
        this.isPrecious = isPrecious;
        return this;
    }

    /**
     * defines the level of value of the  gem
     *
     * @param level
     * @return
     */
    GemBuilder buildLevel(int level) {
        this.level = level;
        return this;
    }

    /**
     * defines the material of the  gem
     *
     * @param material
     * @return
     */
    GemBuilder buildMaterial(Material material) {
        this.material = material;
        return this;
    }

    /**
     * defines the clarity of the  gem
     *
     * @param clarity
     * @return
     */
    GemBuilder buildClarity(int clarity) {
        this.clarity = clarity;
        return this;
    }

    /**
     * builds the transparent gem
     *
     * @return
     */
    Transparent buildTransparent() {
        Transparent transparent = new Transparent(colour, hardness, cut, weight, isPrecious, level, material, clarity);
        return transparent;
    }

    /**
     * builds the non-tansparent gem
     *
     * @return
     */
    Stone buildNontransparent() {
        Stone stone = new Stone(colour, hardness, cut, weight, isPrecious, level, material);
        return stone;
    }

}
