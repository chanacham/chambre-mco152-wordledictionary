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
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                JLabel letter = new JLabel("");
                letter.setBorder(BorderFactory.createLineBorder(Color.black));
                letter.setHorizontalAlignment(JLabel.CENTER);
                mainBoard[i][j] = letter;
                centerPanel.add(mainBoard[i][j]);

            }
        }

        JPanel keyboardPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(keyboardPanel, BorderLayout.SOUTH);

        for (int i = 0; i < keyboard.length; i++) {
            JButton nBu = new JButton();
            nBu.setText("++");
            keyboard[i] = nBu;
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

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
