package chambre.morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleDictionary {
    public ArrayList<String> fillListFromFile(String fileName) throws FileNotFoundException {
        ArrayList<String> fileContents = new ArrayList<>();

        File reader = new File(fileName);
        Scanner input = new Scanner(reader);
        while (input.hasNext()) {
            String data = input.nextLine();
            fileContents.add(data);

        }
        input.close();
        return fileContents;
    }

    public String getDefinition(String word) throws FileNotFoundException {
        ArrayList<String> fileContents = fillListFromFile("C:\\Users\\cbcha\\Downloads\\dictionary.txt\\");
        String retVal ="";
        for (String curr : fileContents) {
            String[] holder = curr.split(" ");
            if (holder[0].equalsIgnoreCase(word)) {
                for (int j = 1; j < holder.length; j++) {
                    retVal += holder[j] + " ";
                }
            }
        }
        retVal.trim();

        return retVal;
    }

    public ArrayList<String> getList() throws FileNotFoundException{
        ArrayList<String> fileContents = fillListFromFile("C:\\Users\\cbcha\\Downloads\\dictionary.txt\\");
        ArrayList<String> allWords = new ArrayList<>();
        for (String curr: fileContents) {
            String [] holder = curr.split(" ");
            allWords.add(holder[0]);
        }
        return allWords;
    }

}
