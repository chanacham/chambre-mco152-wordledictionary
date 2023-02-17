package chambre.morsecode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordleGame {
    private String wordleWord;

    public WordleGame() throws FileNotFoundException{
        WordleDictionary dictionary = new WordleDictionary();

        ArrayList<String> fives = new ArrayList<>();
        for (String word : dictionary.getList()) {
            if (word.length() == 5) {
                fives.add(word);
            }
        }
        Random random = new Random();
        wordleWord = fives.get(random.nextInt(fives.size()));
    }

    public CharResult[] guess(String guessString){
        CharResult[] status = new CharResult[5];
        for (int i = 0; i < wordleWord.length(); i++) {
            if (wordleWord.contains(guessString.substring(i, i + 1))) {
                String guess = guessString.substring(i,i+1);
                String wordle = wordleWord.substring(i,i+1);
                if (guess.equalsIgnoreCase(wordle)){
                    status[i] = CharResult.Correct;
                }
                status[i] = CharResult.WrongPlace;
            } else {
                status[i] = CharResult.NotFound;
            }
        }
        return status;
    }
}
