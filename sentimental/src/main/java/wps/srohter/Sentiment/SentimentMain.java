package wps.srohter.Sentiment;

import java.io.FileNotFoundException;

import wps.srohter.Sentiment.HandleRating.GetAdjective;
import wps.srohter.Sentiment.Rating.RateComment;

/**
 * @author Skylar Rohter
 */
public class SentimentMain {
    public static void main(String[] args) {
        RateComment commentRater=new RateComment();
        GetAdjective getAdjective = new GetAdjective();
        try {
            commentRater.rate();
            System.out.println(getAdjective.getPositve());
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
