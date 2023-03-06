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

    private CharResult[] guessResult;
    private String theGuess;

    private WordleController controller;

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary dictionary) {
        setTitle("Wordle Game");
        setSize(300, 400);
        controller = new WordleController(
                wordleGame,
                dictionary,
                mainBoard,
                keyboard,
                enter,
                backspace
        );

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(6, 5));
        centerPanel.setPreferredSize(new Dimension(300, 400));
        mainPanel.add(centerPanel, BorderLayout.CENTER);
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

        String[] rowOne = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
        String[] rowTwo = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
        String[] rowThree = {"Z", "X", "C", "V", "B", "N", "M"};

        JPanel keyboardPanel = new JPanel(new GridLayout(3, 1));
        JPanel kRow1 = new JPanel(new GridLayout(1, 10));
        JPanel kRow2 = new JPanel(new GridLayout(1, 9));
        JPanel kRow3 = new JPanel(new GridLayout(1, 10));

        mainPanel.add(keyboardPanel, BorderLayout.SOUTH);
        keyboardPanel.setPreferredSize(new Dimension(300, 300));

        for (int i = 0; i < rowOne.length; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> onScreenClick(button));
            button.setText(rowOne[i]);
            button.setHorizontalAlignment(JButton.CENTER);
            keyboard[i] = button;
            kRow1.add(keyboard[i]);
        }
        for (int i = 0; i < rowTwo.length; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> onScreenClick(button));
            button.setText(rowTwo[i]);
            button.setHorizontalAlignment(JButton.CENTER);
            keyboard[i] = button;
            kRow2.add(keyboard[i]);
        }
        JButton backspace = new JButton("Back");
        kRow3.add(backspace);
        for (int i = 0; i < rowThree.length; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> onScreenClick(button));
            button.setText(rowThree[i]);
            button.setHorizontalAlignment(JButton.CENTER);
            keyboard[i] = button;
            kRow3.add(keyboard[i]);
        }

        JButton enter = new JButton("Enter");
        kRow3.add(enter);
        keyboardPanel.add(kRow1);
        keyboardPanel.add(kRow2);
        keyboardPanel.add(kRow3);

        // action listener and keyboard listener
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if (Character.isAlphabetic(character)) {
                    controller.addLetter(String.valueOf(e.getKeyChar()));
                } else if (character == KeyEvent.VK_BACK_SPACE) {
                    //...
                } else if (character == KeyEvent.VK_ENTER) {
                    //...
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void onScreenClick(JButton button) {
    }
}
