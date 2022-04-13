package wps.srohter.Sentiment.Sorting;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Skylar Rohter
 * @see getSize
 * @param args Use from main class.
 */

public class GetFileSize extends SortValues{
    public int WordArraySize;
    public void getSize()throws FileNotFoundException{
        Scanner words=new Scanner(WordsFile);
        while(words.hasNext()){
            WordArraySize++;
        }
        words.close();
    }
}
