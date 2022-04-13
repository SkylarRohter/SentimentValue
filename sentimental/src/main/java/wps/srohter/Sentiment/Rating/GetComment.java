package wps.srohter.Sentiment.Rating;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Skylar Rohter
 */
public class GetComment {
    public static ArrayList<String> getTweets(String topic) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("your key")
                .setOAuthConsumerSecret(
                        "your key")
                .setOAuthAccessToken(
                        "your key")
                .setOAuthAccessTokenSecret(
                        "your key");

        Twitter twitter = new TwitterFactory().getInstance();
        ArrayList<String> tweetList = new ArrayList<String>();
        try {
            Query query = new Query(topic);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    tweetList.add(tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        return tweetList;
    }
}
