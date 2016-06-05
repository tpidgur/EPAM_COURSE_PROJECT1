package MVC.ModelContent;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/**
 *  class specifies the basic characteristics of gems including the price calculation method for a gem depending on
 *  mentioned characteristics of a gem
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class Stone implements Comparator{
    //parameters of gem
    private Colour colour;
    private int hardness;
    private Cut cut;
    private double weight;
    private boolean isPrecious;
    private int level;
    private Material material;

    /**
     * constructor containing the basic features of gem
     * @param colour
     * @param hardness
     * @param cut
     * @param weight
     * @param isPrecious
     * @param level
     * @param material
     */
    public Stone(Colour colour, int hardness, Cut cut, double weight, boolean isPrecious, int level, Material material) {
        this.colour = colour;
        this.hardness = hardness;
        this.cut = cut;
        this.weight = weight;
        this.isPrecious = isPrecious;
        this.level = level;
        this.material = material;
    }



    @Override
    public String toString() {
        return "\nStone{" +
                "colour=" + colour +
                ", hardness=" + hardness +
                ", cut='" + cut + '\'' +
                ", weight=" + weight +
                ", isPrecious=" + isPrecious +
                ", level=" + level +
                ", material='" + material + '\'' +" price= "+price()+
                '}';
    }

    /**
     * calculates the total price of particular gem taking into account the weight and category (valuable or not)
     * @return double price
     */

    public double price() {
        double price = 0;
        double coefficient = 1.5;
        if (isPrecious()) {
            coefficient = 2;
        }
        price = Math.pow(weight, coefficient) * material.getPrice();
        return price;
    }



    @Override
    public int compare(Object o1, Object o2) {
        Stone stone1=(Stone)o1;
        Stone stone2=(Stone)o2;
        if (stone1.price()>stone2.price())return 1;
        if (stone1.price()<stone2.price())return -1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stone stone = (Stone) o;

        if (getHardness() != stone.getHardness()) return false;
        if (Double.compare(stone.getWeight(), getWeight()) != 0) return false;
        if (isPrecious() != stone.isPrecious()) return false;
        if (getLevel() != stone.getLevel()) return false;
        if (getColour() != stone.getColour()) return false;
        if (getCut() != null ? !getCut().equals(stone.getCut()) : stone.getCut() != null) return false;
        return getMaterial() != null ? getMaterial().equals(stone.getMaterial()) : stone.getMaterial() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getColour() != null ? getColour().hashCode() : 0;
        result = 31 * result + getHardness();
        result = 31 * result + (getCut() != null ? getCut().hashCode() : 0);
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isPrecious() ? 1 : 0);
        result = 31 * result + getLevel();
        result = 31 * result + (getMaterial() != null ? getMaterial().hashCode() : 0);
        return result;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public Cut getCut() {
        return cut;
    }

    public void setCut(Cut cut) {
        this.cut = cut;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isPrecious() {
        return isPrecious;
    }

    public void setPrecious(boolean precious) {
        isPrecious = precious;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
