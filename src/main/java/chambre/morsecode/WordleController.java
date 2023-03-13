package chambre.morsecode;

import javax.swing.*;

public class WordleController {
    private final int MAX_SIZE = 5;
    // int to show which row it is on

    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;

    private final JLabel[][] labels;
    private final JButton[] keyboard;

    private final JButton enter;
    private final JButton backspace;

    private CharResult[] guessResult;
    private String theGuess;
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
        if (letter.length() == 1) {
            theGuess += letter;
            labels[rowCounter][columnCounter].setText(letter);
            columnCounter++;
        }
    }

    public void enterGuess() {
        // takes the current letters entered by the user
        // validates them against the WordleGame guess method
        // depending on CharResult []
        // if CharResult == CORRECT
        // GREEN
        // if CharResult == WRONG PLACE
        //  GOLD
        // if CharResult == NOT FOUND
        // GREY
    }

    public void backspace() {
        // remove the letter from currGuess
        // remove the letter from the GUI
    }
}
