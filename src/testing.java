import javax.swing.*;
import java.awt.*;

public class testing extends JFrame {
    private JPanel mainPanel;
    private JLabel imageLabel;
    private Image coffeeGrounds;

    public testing () {

        setContentPane(mainPanel);
        setTitle("Test");
        setSize(1160, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        coffeeGrounds = new ImageIcon(getClass().getResource("coffeeGrounds.png")).getImage();

        imageLabel.setIcon(new ImageIcon(coffeeGrounds));



    }
}
