package chambre.morsecode;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import static chambre.morsecode.CharResult.Correct;
import static chambre.morsecode.CharResult.NotFound;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

class WordleGameTest {
    @Test
    public void guess() throws FileNotFoundException {
        // given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<String>(Collections.singleton("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game = new WordleGame();

        //when
        CharResult[] result = game.guess("APPLE");

        //then
        CharResult[] answer = {Correct, Correct, Correct, Correct, Correct};
        assertArrayEquals(answer, result);
    }

    @Test
    public void incorrect() throws FileNotFoundException {
        // given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<String>(Collections.singleton("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game = new WordleGame(dictionary);

        //when
        CharResult[] result = game.guess("FRINDLE");

        //then
        CharResult[] answer = {NotFound, NotFound, NotFound, NotFound, NotFound};
        assertArrayEquals(answer, result);
    }
}