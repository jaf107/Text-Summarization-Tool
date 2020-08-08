package TextRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sentence {
    String sentence;
    String[] words;
    Sentence(String s)
    {
        this.sentence = s;
        words = s.split(" ");

    }

    void process()
    {

    }

    int spaceCounter(String s)
    {
        int counter = 0;
        for(int i = 0; i<s.length();i++)
        {
            if(s.charAt(i) == ' ')
                counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                ", words=" + Arrays.toString(words) +
                '}';
    }
}
