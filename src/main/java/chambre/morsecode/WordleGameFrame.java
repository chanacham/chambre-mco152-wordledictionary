package chambre.morsecode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        mainPanel.add(keyboardPanel, BorderLayout.SOUTH);
        keyboardPanel.setPreferredSize(new Dimension(300, 300));

        JButton button = null;
        for (int i = 0; i < rowOne.length; i++) {
            button = new JButton();
            button.setText(rowOne[i]);
            keyboard[i] = button;
            keyboardPanel.add(keyboard[i]);
        }
        for (int i = 0; i < rowTwo.length; i++) {
            button = new JButton();
            button.setText(rowTwo[i]);
            keyboard[i] = button;
            keyboardPanel.add(keyboard[i]);
        }
        for (int i = 0; i < rowThree.length; i++) {
            button = new JButton();
            button.setText(rowThree[i]);
            keyboard[i] = button;
            keyboardPanel.add(keyboard[i]);
        }

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

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
