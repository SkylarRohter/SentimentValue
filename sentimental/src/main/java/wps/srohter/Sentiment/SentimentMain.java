package wps.srohter.Sentiment;

import java.io.FileNotFoundException;

import wps.srohter.Sentiment.Rating.RateComment;

/**
 * @author Skylar Rohter
 */
public class SentimentMain {
    public static void main(String[] args) {
        RateComment commentRater = new RateComment();
        try {
            commentRater.rate();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
