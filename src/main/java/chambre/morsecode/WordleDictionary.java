package chambre.morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleDictionary {
    private final ArrayList<String> wordList = new ArrayList<>();
    private final ArrayList<String> definitionList = new ArrayList<>();

    public WordleDictionary() throws FileNotFoundException {
        String fileName = "src/main/java/chambre/morsecode/dictionary.txt";
        File reader = new File(fileName);
        Scanner input = new Scanner(reader);
        while (input.hasNext()) {
            String data = input.nextLine();
            String[] holder = data.split(" ", 2);
            wordList.add(holder[0]);
            if (holder.length == 2) {
                definitionList.add(holder[1]);
            } else {
                definitionList.add("");
            }
        }
        input.close();
    }


    public String getDefinition(String word) {
        int index = wordList.indexOf(word.toUpperCase());
        if (index == -1) {
            return null;
        }
        return definitionList.get(index);
    }

    public ArrayList<String> getList() {
        return wordList;
    }

}
