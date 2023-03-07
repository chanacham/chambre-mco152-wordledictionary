package chambre.morsecode;

import javax.swing.*;

public class WordleController {
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;

    private final JLabel[][] labels;
    private final JButton[] keyboard;

    private final JButton enter;
    private final JButton backspace;

    private String currGuess;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
    }

    public void addLetter(String letter) {
        //when either a letter on the screen or a letter on the keyboard is clicked

        //first validate if the letter can be entered (that the current guess has less than 5 letters)
        // if the guess is valid,
        // add this letter to the current guess
        // display this letter on the board
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
