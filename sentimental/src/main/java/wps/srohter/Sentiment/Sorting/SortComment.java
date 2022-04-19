package wps.srohter.Sentiment.Sorting;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Skylar Rohter
 * Morgan is standing behind me rn.
 */
public class SortComment {
    public static ArrayList<String> CommentArray = new ArrayList<>();

    public void sortComment() throws FileNotFoundException {
        Scanner comment = new Scanner(SortValues.CommentFile);
        while (comment.hasNext()) {
            String NewComment = comment.next();
            NewComment = NewComment.replaceAll("[^a-zA-Z0-9\\s+]", " ");
            NewComment = NewComment.replaceAll("\\s", "");
            NewComment = NewComment.toLowerCase();
            CommentArray.add(NewComment);
        }
        comment.close();
    }
}
// This food is alright. Not the best. It was somewhat good.
// This was great food! Would come back for sure! Love the way all their delecious food is cooked. All of this was amazing!
// I hate this place. Awful good. Tastes like you're eating soap with and awful stench. DO NOT COME HERE.
