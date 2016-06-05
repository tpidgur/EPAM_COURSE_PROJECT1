package MVC.ModelContent;

/**
 * defines the  characteristics of transparent gems
 *
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public class Transparent extends Stone {

    private int clarity;


    public Transparent(Colour colour, int hardness, Cut cut, double weight, boolean isPrecious, int level, Material material, int clarity) {
        super(colour, hardness, cut, weight, isPrecious, level, material);
        this.clarity = clarity;
    }

    /**
     *
     * @return the price taking into account the clarity parameter for transparent gems
     */
    @Override
    public double price() {
        return super.price() / clarity;
    }

    public int getClarity() {
        return clarity;
    }


    @Override
    public String toString() {
        return super.toString() + "\t" +
                "clarity=" + clarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Transparent that = (Transparent) o;

        return getClarity() == that.getClarity();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getClarity();
        return result;
    }
}
