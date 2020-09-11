package TextRank.BOGandTFIDF;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BagOfWords {
    private String text;
    private ArrayList<String> words;

    private String[] wordsArray;
    public BagOfWords(String s)
    {
        this.text = s;

        words = new ArrayList<String>();
        String[] allwords = s.split(" ");
        for (int i=0; i<allwords.length;i++)
        {
            if(!words.contains(allwords[i]))
                words.add(allwords[i]);
        }
        wordsArray = new String[words.size()];
        for(int i=0; i<words.size();i++)
        {
            wordsArray[i] = words.get(i);
        }
    }


    public String[] getWordsArray() {
        return wordsArray;
    }

    @Override
    public String toString() {
        return "BagOfWords{" +
                "text='" + text + '\'' +
                ", words=" + words +
                ", wordsArray=" + Arrays.toString(wordsArray) +
                '}';
    }
}
