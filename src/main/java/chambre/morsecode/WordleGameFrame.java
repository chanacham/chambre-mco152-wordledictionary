package chambre.morsecode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class WordleGameFrame extends JFrame {
    JTextField[][] fields;

    public WordleGameFrame(WordleGame currGame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));
        mainPanel.setLayout(new GridLayout(3, 1));

        JTextField guessWord = new JTextField("Type your guess here: ");
        centerPanel.add(guessWord);

        JLabel output = new JLabel();
        centerPanel.add(output);

        mainPanel.add(centerPanel, BorderLayout.NORTH);

        JButton button = new JButton("GUESS");
        mainPanel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharResult[] result = currGame.guess(String.valueOf(guessWord));
                output.setText(Arrays.toString(result));
            }
        });

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game ");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
