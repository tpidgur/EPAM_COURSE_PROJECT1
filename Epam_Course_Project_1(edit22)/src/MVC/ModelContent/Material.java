package MVC.ModelContent;

/**
 * list of materials and their prices per 1 Ct
 * @author Pidhurska Tetiana
 * @version 1 (created on 01.06.16)
 */
public enum Material {DIAMOND(27000),SAPPHIRE(20000),RUBY(442), GARNET(50);
    private double price;

    Material(double price) {
        this.price = price;
    }

    /**
     *
     * @return the price of the specified material per 1 Ct
     */
    public double getPrice() {
        return price;
    }
}


