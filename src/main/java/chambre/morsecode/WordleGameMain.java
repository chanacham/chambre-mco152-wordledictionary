package chambre.morsecode;

import java.io.FileNotFoundException;

public class WordleGameMain {
    public static void main(String[] args) throws FileNotFoundException {
        WordleDictionary dictionary = new WordleDictionary();
        WordleGame currGame = new WordleGame(dictionary);
        WordleGameFrame frame = new WordleGameFrame(currGame, dictionary);
        frame.setVisible(true);
    }
}
