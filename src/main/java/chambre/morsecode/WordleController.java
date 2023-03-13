package chambre.morsecode;

import javax.swing.*;
import java.awt.*;

public class WordleController {
    private final int MAX_SIZE = 5;
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;

    private final JLabel[][] labels;
    private final JButton[] keyboard;

    private final JButton enter;
    private final JButton backspace;
    private final StringBuilder theGuess = new StringBuilder();
    private CharResult[] guessResult;
    private int columnCounter = 0;
    private int rowCounter = 0;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
    }

    public void addLetter(String letter) {
        theGuess.append(letter);

        if (letter.length() == 1 && columnCounter < MAX_SIZE) {
            labels[rowCounter][columnCounter].setText(letter);
            columnCounter++;
        } else if (columnCounter > MAX_SIZE) {
            rowCounter++;
            columnCounter = 0;
        }
    }

    public void enterGuess() {
        CharResult[] answer = wordleGame.guess(String.valueOf(theGuess));
        for (int i = 0; i < theGuess.length(); i++) {
            CharResult curr = answer[i];
            if (curr == CharResult.Correct) {
                labels[rowCounter][i].setOpaque(true);
                labels[rowCounter][i].setBackground(new Color(0, 204, 0));
            } else if (curr == CharResult.WrongPlace) {
                labels[rowCounter][i].setOpaque(true);
                labels[rowCounter][i].setBackground(new Color(213, 228, 13));
            } else if (curr == CharResult.NotFound) {
                labels[rowCounter][i].setOpaque(true);
                labels[rowCounter][i].setBackground(new Color(155, 155, 155));
            }
        }

    }

    public void backspace() {
        // remove the letter from currGuess
        // remove the letter from the GUI

    }
}
