package chambre.morsecode;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static chambre.morsecode.CharResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WordleControllerTest {
    private WordleGame game = mock();
    private WordleDictionary dictionary = mock();
    private JLabel[][] labels = new JLabel[][]{{
            mock(), mock(), mock(), mock(), mock(),
    }, {
            mock(), mock(), mock(), mock(), mock(),
    }, {
            mock(), mock(), mock(), mock(), mock(),
    }, {
            mock(), mock(), mock(), mock(), mock(),
    }, {
            mock(), mock(), mock(), mock(), mock(),
    }, {
            mock(), mock(), mock(), mock(), mock(),
    },
    };
    private JButton enter = mock();
    private JButton back = mock();

    @Test
    public void addLetter() {
        //given
        WordleController controller = new WordleController(game, dictionary, labels, enter, back);

        //when
        controller.addLetter("A");

        //then
        verify(labels[0][0]).setText("A");
        assertEquals("A", controller.theGuess.toString());
    }

    @Test
    public void enterGuess2() {
        //given
        WordleController controller = new WordleController(game, dictionary, labels, enter, back);
        CharResult[] results = {WrongPlace, Correct, Correct, NotFound, NotFound};
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("IRATE");
        dictionary.add("BRAIN");
        String guess = "IRATE";
        doReturn(dictionary).when(game).getFives();
        doReturn(results).when(game).guess(guess);

        //when
        controller.addLetter("i");
        controller.addLetter("r");
        controller.addLetter("a");
        controller.addLetter("t");
        controller.addLetter("e");

        controller.enterGuess();

        //then
        verify(labels[0][0]).setBackground(new Color(213, 228, 13));
        verify(labels[0][0]).setOpaque(true);
        verify(labels[0][1]).setBackground(new Color(0, 204, 0));
        verify(labels[0][1]).setOpaque(true);
        verify(labels[0][2]).setBackground(new Color(0, 204, 0));
        verify(labels[0][2]).setOpaque(true);
        verify(labels[0][3]).setBackground(new Color(155, 155, 155));
        verify(labels[0][3]).setOpaque(true);
        verify(labels[0][4]).setBackground(new Color(155, 155, 155));
        verify(labels[0][4]).setOpaque(true);

        assertEquals(0, controller.theGuess.length());
    }


    @Test
    public void backspace() {
        //given
        WordleController controller = new WordleController(game, dictionary, labels, enter, back);

        //when
        controller.addLetter("A");
        controller.backspace();

        //then
        verify(labels[0][0]).setText("");
        assertEquals("", controller.theGuess.toString());
    }

}