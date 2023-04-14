import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.ArrayList;
import java.time.Instant;


public class GameWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;
    private JButton greyButton;
    private JLabel trashItem;
    private JLabel score;
    private JButton exitButton;
    private JLabel imageLabel;
    private BinSort binSort;
    private int itemsCycled;
    private ArrayList<Item> randItems;
    private int userScore;
    private Instant start;
    private Instant end;
    private long timeElapsed;
    private double secElapsed;
    private int currHighScore;
    private Image thumbsUp;

    private GUI gui;

    public GameWindow(GUI g, BinSort bs) {
        binSort = bs;
        gui = g;

        setContentPane(mainPanel);
        setTitle("Game Window");
        setSize(1300, 1440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        greyButton.addActionListener(this);
        exitButton.addActionListener(this);

        greenButton.setBackground(Color.green);
        blueButton.setBackground(Color.blue);
        greyButton.setBackground(Color.gray);
        redButton.setBackground(Color.red);

        randItems = binSort.getListOfRandItems();
        itemsCycled = 0;

        start = Instant.now();

        trashItem.setText((itemsCycled + 1) + ". " + randItems.get(itemsCycled).toString());
        imageLabel.setIcon(new ImageIcon(randItems.get(itemsCycled).getImg()));

        currHighScore = gui.getHighScore();

        thumbsUp = new ImageIcon(getClass().getResource("thumbsUp.png")).getImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        JButton b = (JButton) source;
        String colors = "green---blue---red---grey";
        String text = b.getText();

        if(colors.contains(text.toLowerCase())) {

            String selectedColor = b.getText().toLowerCase();


            if (itemsCycled == (randItems.size() - 1)) {

                binSort.checkInput(randItems.get(itemsCycled), selectedColor);
                score.setText("Score: " + binSort.getScore() + "  ");
                itemsCycled++;

                end = Instant.now();

                imageLabel.setIcon(new ImageIcon(thumbsUp));

                userScore = binSort.getScore();

                timeElapsed = Duration.between(start, end).toMillis();

                secElapsed = timeElapsed / 1000.0;

                if(userScore > currHighScore) {
                    gui.updateHighScore(userScore);
                    gui.updateLowestTime(secElapsed);

                } else if (userScore == currHighScore && (secElapsed < gui.getLowestTime())) {
                    gui.updateLowestTime(secElapsed);
                }

                trashItem.setFont(new Font("Consolas", Font.BOLD, 40));

                trashItem.setText("Nice! You got " + userScore + " right and " + (randItems.size() - userScore) + " wrong");
                gui.changeWindowText("Score: " + userScore + "\nThat took you " + secElapsed + " seconds", new Font("Consolas", Font.PLAIN, 36));
                gui.addWindowText("\nThe current high score is " + gui.getHighScore() + " right in " + gui.getLowestTime() + " seconds");
                binSort.resetScore();

            } else if (itemsCycled < (randItems.size() - 1)) {

                binSort.checkInput(randItems.get(itemsCycled), selectedColor);
                score.setText("Score: " + binSort.getScore() + "  ");

                itemsCycled++;

                Item trash = randItems.get(itemsCycled);

                trashItem.setText((itemsCycled + 1) + ". " + trash.toString() + "    "  + trash.getBinColor());
                imageLabel.setIcon(new ImageIcon(randItems.get(itemsCycled).getImg()));

            }

        } else if (text.equals("Exit")) {
            setVisible(false);
        }

    }



}
