package chambre.morsecode;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WordleControllerTest {
    @Test
    public void addLetter() {
        //given
        WordleGame game = mock();
        WordleDictionary dictionary = mock();
        JLabel[][] labels = new JLabel[][]{{
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
        JButton enter = mock();
        JButton back = mock();
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
        WordleGame game = mock();
        WordleDictionary dictionary = mock();
        JLabel[][] labels = new JLabel[][]{{
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
        JButton enter = mock();
        JButton back = mock();
        WordleController controller = new WordleController(game, dictionary, labels, enter, back);

        //when
        for (int i = 0; i < game.getWordleWord().length() - 1; i++) {
            controller.addLetter(game.getWordleWord().substring(i, i + 1));
        }
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
        WordleGame game = mock();
        WordleDictionary dictionary = mock();
        JLabel[][] labels = new JLabel[][]{{
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
        JButton enter = mock();
        JButton back = mock();
        WordleController controller = new WordleController(game, dictionary, labels, enter, back);

        //when
        controller.addLetter("A");
        controller.backspace();

        //then
        verify(labels[0][0]).setText("");
        assertEquals("", controller.theGuess.toString());
    }

}