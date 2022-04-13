package wps.srohter.Sentiment.Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Skylar Rohter
 */
public class SortValues {
    public static File WordsFile = new File(
            "/Users/skylarrohter/Documents/sentimental/src/main/java/wps/srohter/Sentiment/words.txt");
    public static File CommentFile = new File(
            "/Users/skylarrohter/Documents/sentimental/src/main/java/wps/srohter/Sentiment/comment.txt");
    public double[] Values = new double[6279];

    public void sortSentiment() throws FileNotFoundException {
        Scanner words = new Scanner(WordsFile);
        int i = 0;

        while (words.hasNext()) {
            // Add to Double Array
            String preSubString = words.nextLine();
            preSubString = preSubString.substring(preSubString.indexOf(',') + 1, preSubString.length());
            double value = Double.parseDouble(preSubString);
            Values[i] = value;
            i++;
        }
        words.close();
    }
}
