package chambre.morsecode;

import javax.swing.*;
import java.awt.*;

public class WordleController {
    final StringBuilder theGuess = new StringBuilder();
    private final int MAX_SIZE = 5;
    private final int NUM_GUESSES = 6;
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;
    private final JLabel[][] labels;
    private final JButton enter;
    private final JButton backspace;
    private int columnCounter = 0;
    private int rowCounter = 0;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.enter = enter;
        this.backspace = backspace;
    }

    public void addLetter(String letter) {
        if (letter.length() == 1 && columnCounter < MAX_SIZE) {
            theGuess.append(letter.toUpperCase());
            labels[rowCounter][columnCounter].setText(letter.toUpperCase());
            columnCounter++;
        }
    }

    public void enterGuess() {
        if (theGuess.length() == 5) {
            String currentWord = theGuess.toString().toUpperCase();
            if (wordleGame.getFives().contains(currentWord)) {
                CharResult[] guessResult = wordleGame.guess(theGuess.toString());
                for (int i = 0; i < theGuess.length(); i++) {
                    CharResult curr = guessResult[i];
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
                theGuess.delete(0, MAX_SIZE);
                columnCounter = 0;
                rowCounter++;
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Word not in dictionary, please try a different word");
            }
        }
        if (rowCounter == NUM_GUESSES) {
            System.out.println(wordleGame.getWordleWord());
            JOptionPane.showMessageDialog(null, "The Wordle Word of today was:  " + wordleGame.getWordleWord());
        }
    }

    public void backspace() {
        theGuess.deleteCharAt(theGuess.length() - 1);
        columnCounter--;
        labels[rowCounter][columnCounter].setText("");
    }
}
