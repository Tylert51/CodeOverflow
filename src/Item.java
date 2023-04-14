import java.awt.*;

public class Item {
    //instance
    private String name;
    private String binColor;
    private Image img;

    //constructor
    public Item (String n, String b, Image img) {
        name = n;
        binColor = b;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getBinColor() {
        return binColor;
    }

    public String toString() {
        return name;
    }

    public Image getImg() {
        return img;
    }


}