package chambre.morsecode;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class WordleDictionaryTest {
    @Test
    public void getDefinition() throws FileNotFoundException {
        WordleDictionary dictionary = new WordleDictionary();
        assertEquals("an expression of gratitude [n -S]", dictionary.getDefinition("TA"));
        assertEquals("to cry with a convulsive catching of the breath [v SOBBED, SOBBING, SOBS]", dictionary.getDefinition("SOB"));
        assertEquals("",dictionary.getDefinition("WELTANSCHAUUNGS"));
        assertNull(dictionary.getDefinition("jfihgiorhffdvb"));
        assertEquals("<format=v> [v]", dictionary.getDefinition("formatting"));
    }

    @Test
    public void getList() throws FileNotFoundException{
        WordleDictionary dictionary = new WordleDictionary();
        assertEquals(167964, dictionary.getList().size());
    }

}