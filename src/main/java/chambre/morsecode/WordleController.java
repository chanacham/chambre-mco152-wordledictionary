package chambre.morsecode;

import javax.swing.*;

public class WordleController {
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;

    private final JLabel[][] labels;
    private final JButton[] keyboard;

    private final JButton enter;
    private final JButton backspace;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
    }

    public void addLetter(String letter) {
        //when you either type or click on a letter on the screen keyboard.
    }

    public void enterGuess() {

    }

    public void backspace() {

    }
}
