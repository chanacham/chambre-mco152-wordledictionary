package chambre.morsecode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame {
    private final String wordleWord;

    public WordleGame(WordleDictionary dictionary) throws FileNotFoundException {

        ArrayList<String> fives = new ArrayList<>();
        for (String word : dictionary.getList()) {
            if (word.length() == 5) {
                fives.add(word);
            }
        }
        Random random = new Random();
        wordleWord = fives.get(random.nextInt(fives.size()));
    }

    public String getWordleWord() {
        return wordleWord;
    }

    public CharResult[] guess(String guessString) {
        CharResult[] status = new CharResult[5];
        for (int i = 0; i < wordleWord.length(); i++) {
            String guess = String.valueOf(guessString.charAt(i));
            if (wordleWord.contains(guess)) {
                String wordleLetter = wordleWord.substring(i, i + 1);
                if (guess.equalsIgnoreCase(wordleLetter)) {
                    status[i] = CharResult.Correct;
                } else {
                    status[i] = CharResult.WrongPlace;
                }
            } else {
                status[i] = CharResult.NotFound;
            }
        }
        return status;
    }
}
