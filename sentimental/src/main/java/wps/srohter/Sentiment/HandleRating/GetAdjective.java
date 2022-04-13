package wps.srohter.Sentiment.HandleRating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Skylar Rohter
 * @return Either positive or negative adjective
 * @see getNegative
 * Test again
 */
public class GetAdjective {

    public String getPositve() throws FileNotFoundException {
        Scanner pos = new Scanner(new File(
                "/Users/skylarrohter/Documents/sentimental/src/main/java/wps/srohter/Sentiment/Rating/positive.txt"));
        ArrayList<String> positives = new ArrayList<>();
        ArrayList<String> pValues = new ArrayList<>();
        Random rnd = new Random();
        String returnable, KpreSubString;
        while (pos.hasNext()) {
            KpreSubString = pos.nextLine();

            String key = KpreSubString.substring(0, KpreSubString.indexOf(" ") + 1);
            positives.add(key);

            String value = KpreSubString.substring(KpreSubString.indexOf(" "), KpreSubString.length());
            pValues.add(value);
        }
        returnable = positives.get(rnd.nextInt(positives.size()));
        return returnable;
    }

    public String getNegative() throws FileNotFoundException {
        Scanner neg = new Scanner(new File(
                "/Users/skylarrohter/Documents/sentimental/src/main/java/wps/srohter/Sentiment/Rating/negative.txt"));
        ArrayList<String> negatives = new ArrayList<>();
        ArrayList<String> nValues = new ArrayList<>();
        Random rnd = new Random();
        String returnable, KpreSubString;
        while (neg.hasNext()) {
            KpreSubString = neg.nextLine();

            String key = KpreSubString.substring(0, KpreSubString.indexOf(" ") + 1);
            negatives.add(key);

            String value = KpreSubString.substring(KpreSubString.indexOf(" "), KpreSubString.length());
            nValues.add(value);
        }
        returnable = negatives.get(rnd.nextInt(negatives.size()));
        return returnable;
    }
}
