package TextRank.BOGandTFIDF;

import java.util.Arrays;

public class Tool {
    String text;
    String[] bagOfWords;
    Tool(String s)
    {
        text = s;
        BagOfWords tool = new BagOfWords(text);
        bagOfWords = tool.getWordsArray();
    }


    @Override
    public String toString() {
        return "Tool{" +
                "text='" + text + '\'' +
                ", bagOfWords=" + Arrays.toString(bagOfWords) +
                '}';
    }
}
