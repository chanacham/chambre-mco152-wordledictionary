package chambre.morsecode;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class WordleGameFrame extends JFrame {
    JTextField[][] fields;
    private int guessCounter;

    public WordleGameFrame(WordleGame currGame) {
        //Board Layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // the main panel has a boarder layout
        // main panel has 2 panels- the center one for the letters with a grid layout - the south panel for the letters
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));

        JTextField guessWord = new JTextField("Type your guess here: ");
        centerPanel.add(guessWord);
        guessWord.setHorizontalAlignment(JTextField.CENTER);

        //holds text/image but you cannot select them
        JLabel output = new JLabel();
        centerPanel.add(output);
        output.setHorizontalAlignment(JTextField.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JButton button = new JButton("GUESS, Guess number: " + guessCounter);
        mainPanel.add(button, BorderLayout.SOUTH);
        button.addActionListener(e -> {
            CharResult[] result = currGame.guess(guessWord.getText());
            output.setText(Arrays.toString(result));
            guessCounter++;
        });

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
