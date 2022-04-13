package wps.srohter.Sentiment.Sorting;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Skylar Rohter
 */
public class SortWords {
    public ArrayList<String> Words = new ArrayList<>();
    public void sortWords() throws FileNotFoundException {
        Scanner words = new Scanner(SortValues.WordsFile);
        while (words.hasNext()) {
            // Add to String Array
            String preValue = words.nextLine();
            preValue = preValue.substring(0, preValue.indexOf(','));
            Words.add(preValue);
        }
        words.close();
    }
}
