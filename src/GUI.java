import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton instructionsButton;
    private JTextArea welcomeTextArea;
    private JButton startGameButton;
    private BinSort binSort;

    public GUI() {

        binSort = new BinSort();

        setContentPane(mainPanel);
        setTitle("Test");
        setSize(1160, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        welcomeTextArea.setEditable(false);

        instructionsButton.addActionListener(this);
        startGameButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = null;
        String text = "";

        if(source instanceof JButton) {
            button = (JButton) source;
            text = button.getText();
        }

        if (text.equals("Instructions")) {

                welcomeTextArea.setFont(new Font("Consolas", Font.PLAIN, 17));
                welcomeTextArea.setText(binSort.getInstructions());
                button.setText("Back to Welcome Screen");

        } else if (text.equals("Back to Welcome Screen")) {

            welcomeTextArea.setFont(new Font("Consolas", Font.PLAIN, 36));
            welcomeTextArea.setText("Welcome!!!!!!!");
            button.setText("Instructions");

        } else if (text.equals("Start Game")) {

            GameWindow gw = new GameWindow(this);

        }
    }

    public void changeWindowText(String str, Font font) {
        welcomeTextArea.setFont(font);
        welcomeTextArea.setText(str);
    }
}
