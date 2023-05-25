package chambre.morsecode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleGameFrame extends JFrame {

    private JLabel[][] mainBoard = new JLabel[6][5];
    private JButton[] keyboard = new JButton[26];
    private JButton enter;
    private JButton backspace;

    private WordleController controller;

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary dictionary) {
        controller = new WordleController(
                wordleGame,
                dictionary,
                mainBoard,
                enter,
                backspace
        );

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(6, 5, 10, 10));
        centerPanel.setPreferredSize(new Dimension(300, 400));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                JLabel letter = new JLabel("");
                letter.setBorder(BorderFactory.createLineBorder(Color.black));
                letter.setHorizontalAlignment(JLabel.CENTER);
                letter.setFont(new Font("Arial", Font.BOLD, 36));
                mainBoard[i][j] = letter;
                centerPanel.add(mainBoard[i][j]);
            }
        }

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        String[] rowOne = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
        String[] rowTwo = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
        String[] rowThree = {"Z", "X", "C", "V", "B", "N", "M"};

        JPanel keyboardPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        keyboardPanel.setPreferredSize(new Dimension(300, 200));

        JPanel kRow1 = new JPanel(new GridLayout(1, 10));
        JPanel kRow2 = new JPanel(new GridLayout(1, 9));
        JPanel kRow3 = new JPanel(new GridLayout(1, 10));


        for (int i = 0; i < rowOne.length; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> {
                mainPanel.requestFocus();
                controller.addLetter(button.getText());
            });

            button.setText(rowOne[i]);
            button.setHorizontalAlignment(JButton.CENTER);
            keyboard[i] = button;
            kRow1.add(keyboard[i]);
        }
        for (int i = 0; i < rowTwo.length; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> {
                mainPanel.requestFocus();
                controller.addLetter(button.getText());
            });
            button.setText(rowTwo[i]);
            button.setHorizontalAlignment(JButton.CENTER);
            keyboard[i] = button;
            kRow2.add(keyboard[i]);
        }
        JButton backspace = new JButton("Back");
        backspace.addActionListener(e -> {
            mainPanel.requestFocus();
            controller.backspace();
        });
        kRow3.add(backspace);

        for (int i = 0; i < rowThree.length; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> {
                mainPanel.requestFocus();
                controller.addLetter(button.getText());
            });
            ;
            button.setText(rowThree[i]);
            button.setHorizontalAlignment(JButton.CENTER);
            keyboard[i] = button;
            kRow3.add(keyboard[i]);
        }

        JButton enter = new JButton("Enter");
        enter.addActionListener(e -> {
            mainPanel.requestFocus();
            controller.enterGuess();
        });
        kRow3.add(enter);


        keyboardPanel.add(kRow1);
        keyboardPanel.add(kRow2);
        keyboardPanel.add(kRow3);

        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();
        mainPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                mainPanel.requestFocus();
                char output = e.getKeyChar();
                if (Character.isAlphabetic(output)) {
                    controller.addLetter(String.valueOf(output));
                } else if (output == KeyEvent.VK_BACK_SPACE) {
                    controller.backspace();
                } else if (output == KeyEvent.VK_ENTER) {
                    controller.enterGuess();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        mainPanel.add(keyboardPanel, BorderLayout.SOUTH);

        setTitle("Wordle Game");
        setSize(500, 700);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
