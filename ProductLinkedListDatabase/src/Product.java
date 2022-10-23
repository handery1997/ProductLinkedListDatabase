import java.io.Serializable;

public class Product implements Serializable {
    private String bcode;
    private String title;
    private Integer quantity;
    private double price;

    /**

     * Constructor method to initialize a product

     *

     * @param bcode    Product's bar code

     * @param title    Product's title

     * @param quantity Product's quantity

     * @param price    Product's price

     */

    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode=bcode;
        this.title=title;
        this.quantity=quantity;
        this.price=price;
    }

    //Getter and Setter
    public String getBcode() {
        return bcode;
    }

    public String getTitle() {
        return title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    /**

     * Convert this product to String for printing

     */

    @Override

    public String toString() {
        return this.bcode + "  | "+this.title+"    | "+this.quantity+"  | "+this.price;

    }

}