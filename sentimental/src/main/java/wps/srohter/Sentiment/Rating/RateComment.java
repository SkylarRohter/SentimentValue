package wps.srohter.Sentiment.Rating;

import java.io.FileNotFoundException;

import wps.srohter.Sentiment.HandleRating.GetAdjective;
import wps.srohter.Sentiment.Sorting.SortComment;
import wps.srohter.Sentiment.Sorting.SortValues;
import wps.srohter.Sentiment.Sorting.SortWords;

/**
 * @author Skylar Rohter
 * @return Rated Comment
 */
public class RateComment extends SortComment {
    /**
     * @return Double of rated value.
     */
    public void rate() {
        SortValues valueSorter = new SortValues();
        SortWords wordSorter = new SortWords();
        SortComment commentSorter = new SortComment();
        double sum = 0, returnable = 0;
        try {
            valueSorter.sortSentiment();
            wordSorter.sortWords();
            commentSorter.sortComment();
            for (int i = 0; i < CommentArray.size(); i++) {
                for (int k = 0; k < wordSorter.Words.size(); k++) {
                    if (CommentArray.get(i).equals(wordSorter.Words.get(k))) {
                        // System.out.print(wordSorter.Words[k] + " " + valueSorter.Values[k]);
                        // System.out.println();
                        sum += valueSorter.Values[k];
                    }
                }
            }
            double average = sum / CommentArray.size();
            // Positives
            if (average > 0) {
                returnable = ratePositives(average);
                System.out.println(getPosWord(returnable));
            } else if (average < 0) {// Negatives
                returnable = rateNegatives(average);
                System.out.println(getNegativeWord(returnable));
            }
            // Neutrals
            else if (average == 0) {
                System.out.println("Neutral");
            } else {
                returnable = 0;
            }
            System.out.println(returnable);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    private String getPosWord(double input) {
        GetAdjective adj = new GetAdjective();
        String finalWord = "Hello";
        for (int i = 0; i < adj.pValues.size(); i++) {
            if (adj.pValues.get(i).equals(input)) {
                finalWord = adj.positives.get(i);
            }
        }
        return finalWord;
    }

    private String getNegativeWord(double input) {
        GetAdjective adj = new GetAdjective();
        String finalWord = "Okay";
        for (int i = 0; i < adj.nValues.size(); i++) {
            if (adj.nValues.get(i).equals(input)) {
                finalWord = adj.negatives.get(i);
            }
        }
        return finalWord;
    }

    private double ratePositives(double average) {
        double returnable;
        if (average > 0 && average < 0.05) {// 1
            returnable = 0.5;
        } else if (average > 0.051 && average < 0.1) {// 2
            returnable = 1.0;
        } else if (average > 0.11 && average < 0.2) {// 3
            returnable = 1.5;
        } else if (average < 0.21 && average > 0.5) {// 4
            returnable = 2.0;
        } else if (average < 0.51 && average > 1) {// 5
            returnable = 2.5;
        } else if (average < 1.1 && average > 3) {// 6
            returnable = 3.0;
        } else {// Definer
            returnable = 0;
        }
        return returnable;
    }

    private double rateNegatives(double average) {
        double returnable;
        if (average < 0 && average > -0.05) {
            returnable = -0.5;
        } else if (average < -0.051 && average > -0.1) {
            returnable = -1.0;
        } else if (average < -0.11 && average > -0.2) {
            returnable = -1.5;
        } else if (average < -0.21 && average > -0.5) {
            returnable = -2.0;
        } else if (average < -0.51 && average > -1) {
            returnable = -2.5;
        } else if (average < -1.1 && average > -3) {
            returnable = -3.0;
        } else {
            returnable = 0;
        }
        return returnable;
    }
}
