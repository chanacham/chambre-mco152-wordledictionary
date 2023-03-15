package chambre.morsecode;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    public void enterGuess() {
        //given
        WordleController controller = new WordleController(game, dictionary, labels, enter, back);
        controller.addLetter("A");
        controller.addLetter("P");
        controller.addLetter("P");
        controller.addLetter("L");
        controller.addLetter("E");


        //when
        controller.enterGuess();

        //then
        //asserts that all colors have changed to the correct color
        Mockito.verify(labels[0][0]).setBackground(new Color(0, 204, 0));
        Mockito.verify(labels[0][1]).setBackground(new Color(0, 204, 0));
        Mockito.verify(labels[0][2]).setBackground(new Color(0, 204, 0));
        Mockito.verify(labels[0][3]).setBackground(new Color(0, 204, 0));
        Mockito.verify(labels[0][4]).setBackground(new Color(0, 204, 0));
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