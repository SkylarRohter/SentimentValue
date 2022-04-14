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
 */
public class GetAdjective {
    public ArrayList<String> positives = new ArrayList<>();
    public ArrayList<Double> pValues = new ArrayList<>();
    public ArrayList<String> negatives = new ArrayList<>();
    public ArrayList<Double> nValues = new ArrayList<>();
    public String getPositve() throws FileNotFoundException {
        Scanner pos = new Scanner(new File(
                "C:\\Users\\SkylarRohter\\Documents\\SentimentValue\\sentimental\\src\\main\\java\\wps\\srohter\\Sentiment\\positive.txt"));
        Random rnd = new Random();
        String returnable, KpreSubString;
        while (pos.hasNext()) {
            KpreSubString = pos.nextLine();

            String key = KpreSubString.substring(0, KpreSubString.indexOf(" ") + 1);
            positives.add(key);

            String value = KpreSubString.substring(KpreSubString.indexOf(" "), KpreSubString.length());
            double addValue = Double.parseDouble(value);
            pValues.add(addValue);
        }
        returnable = positives.get(rnd.nextInt(positives.size()));
        return returnable;
    }

    public String getNegative() throws FileNotFoundException {
        Scanner neg = new Scanner(new File(
                "C:\\Users\\SkylarRohter\\Documents\\SentimentValue\\sentimental\\src\\main\\java\\wps\\srohter\\Sentiment\\negative.txt"));
        Random rnd = new Random();
        String returnable, KpreSubString;
        while (neg.hasNext()) {
            KpreSubString = neg.nextLine();

            String key = KpreSubString.substring(0, KpreSubString.indexOf(" ") + 1);
            negatives.add(key);

            String value = KpreSubString.substring(KpreSubString.indexOf(" "), KpreSubString.length());
            double addValue = Double.parseDouble(value);
            nValues.add(addValue);
        }
        returnable = negatives.get(rnd.nextInt(negatives.size()));
        return returnable;
    }
}
