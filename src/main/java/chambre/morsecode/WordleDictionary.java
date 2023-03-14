package chambre.morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordleDictionary {
    private final ArrayList<String> wordList = new ArrayList<>();

    private final HashMap<String, String> map = new HashMap<>();

    public WordleDictionary() throws FileNotFoundException {
        String fileName = "src/main/java/chambre/morsecode/dictionary.txt";
        File reader = new File(fileName);
        Scanner input = new Scanner(reader);
        while (input.hasNext()) {
            String data = input.nextLine();
            String[] holder = data.split(" ", 2);
            wordList.add(holder[0]);
            if (holder.length == 2) {
                map.put(holder[0], holder[1]);
            } else {
                map.put(holder[0], "");
            }
        }
        input.close();
    }


    public String getDefinition(String word) {
        return map.get(word.toUpperCase());
    }

    public ArrayList<String> getList() {
        return wordList;
    }

}
