package wps.srohter.Sentiment.HandleRating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Skylar Rohter
 * @return Either positive or negative adjective
 * @see getNegative
 */
public class GetAdjective {
    public ArrayList<String> positives = new ArrayList<>();
    public ArrayList<Double> pValues = new ArrayList<>();
    public ArrayList<String> negatives = new ArrayList<>();
    public ArrayList<Double> nValues = new ArrayList<>();
    public void sortPositve() throws FileNotFoundException {
        Scanner pos = new Scanner(new File(
                "C:\\Users\\SkylarRohter\\Documents\\SentimentValue\\sentimental\\src\\main\\java\\wps\\srohter\\Sentiment\\positive.txt"));
        String KpreSubString;
        while (pos.hasNext()) {
            KpreSubString = pos.nextLine();

            String key = KpreSubString.substring(0, KpreSubString.indexOf(" "));
            positives.add(key);

            String value = KpreSubString.substring(KpreSubString.indexOf(" "), KpreSubString.length());
            double addValue = Double.parseDouble(value);
            pValues.add(addValue);
        }
    }

    public void sortNegative() throws FileNotFoundException {
        Scanner neg = new Scanner(new File(
                "C:\\Users\\SkylarRohter\\Documents\\SentimentValue\\sentimental\\src\\main\\java\\wps\\srohter\\Sentiment\\negative.txt"));
        String KpreSubString;
        while (neg.hasNext()) {
            KpreSubString = neg.nextLine();

            String key = KpreSubString.substring(0, KpreSubString.indexOf(" "));
            negatives.add(key);

            String value = KpreSubString.substring(KpreSubString.indexOf(" "), KpreSubString.length());
            double addValue = Double.parseDouble(value);
            addValue = addValue*-1;
            nValues.add(addValue);
        }
    }
}
