package chambre.morsecode;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordleGameTest {
    @Test
    public void guess() throws FileNotFoundException {
        WordleGame game = new WordleGame();

        CharResult[] result = game.guess(game.getWordleWord());
        CharResult[] answer = {CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct};
        assertEquals(Arrays.toString(answer), Arrays.toString(result));
    }
}