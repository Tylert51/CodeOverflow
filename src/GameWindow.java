import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;
    private JButton greyButton;
    private JLabel trashItem;
    private JLabel score;
    private JButton exitButton;
    private BinSort binSort;
    private int itemsCycled;
    private ArrayList<Item> randItems;
    private int userScore;

    GUI gui;

    public GameWindow(GUI g) {
        binSort = new BinSort();
        gui = g;

        setContentPane(mainPanel);
        setTitle("GameWin");
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        greyButton.addActionListener(this);
        exitButton.addActionListener(this);

        randItems = binSort.getListOfRandItems();
        itemsCycled = 0;

        trashItem.setText((itemsCycled + 1) + ". " + randItems.get(itemsCycled).toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        JButton b = (JButton) source;
        String colors = "green---blue---red---grey";
        String text = b.getText();

        if(colors.contains(text.toLowerCase())) {

            String selectedColor = b.getText().toLowerCase();


            if (itemsCycled == 9) {

                binSort.checkInput(randItems.get(itemsCycled), selectedColor);
                score.setText("Score: " + binSort.getScore() + "  ");
                itemsCycled++;

                userScore = binSort.getScore();

                trashItem.setFont(new Font("Consolas", Font.BOLD, 25));

                trashItem.setText("Done! Press exit to see your final score");
                gui.changeWindowText("Nice! You got " + userScore + " right and " + (10 - userScore) + " wrong", new Font("Consolas", Font.PLAIN, 36));

            } else if (itemsCycled < 9) {

                binSort.checkInput(randItems.get(itemsCycled), selectedColor);
                score.setText("Score: " + binSort.getScore() + "  ");

                itemsCycled++;

                Item trash = randItems.get(itemsCycled);

                trashItem.setText((itemsCycled + 1) + ". " + trash.toString());

            } else {

            }

        } else if (text.equals("Exit")) {
            setVisible(false);
        }


    }

    public int getUserScore() {
        return userScore;
    }
}
