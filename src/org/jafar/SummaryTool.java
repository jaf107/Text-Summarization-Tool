package org.jafar;

import java.util.HashMap;
import java.util.Map;

public class SummaryTool {

    String text = "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.";

    String textTable[] = {"i", "know" ,"one" ,"thing", "for", "certain", "don’t", "settle" ,"for", "less", "than","what" ,"you’re"
            ,"capable", "of", "but", "strive", "for" ,"something", "bigger", "Some" ,"of","you", "reading", "this", "might",
            "identify", "with" ,"this" ,"message" ,"because" ,"it" ,"resonates" ,"with", "you", "on" ,"a" ,"deeper", "level"
            , "for", "others", "at" ,"the" ,"end" ,"of" ,"their", "tether", "the", "message" ,"might" ,"be" ,"nothing"
            ,"more" ,"than" ,"a", "trivial", "pep" ,"talk" ,"what" ,"i", "wish", "to", "convey", "irrespective", "of" ,"where"
            ,"you" ,"are" ,"in", "your", "journey" ,"is", "never" ,"settle", "for", "less", "if", "you", "settle" ,"for"
            , "less", "you" ,"will" ,"receive", "less" ,"than", "you", "deserve" ,"and", "convince", "yourself", "you"
            ,"are", "justified", "to", "receive", "it"};

    //String TextTable[] = {"Bangladesh","India","Bangladesh","Pakistan","Bangladesh"};

    HashMap<String,Integer> frequencyCounter = new HashMap<>();
    //Main Algorithm
    void createWordFrequencyTable()
    {

        for (String sample: textTable) {
            frequencyCounter.compute(sample,(k,v) -> v == null? 1:v+1);
        }

    }
    void tokenizeSentences()
    {


    }
    void scoreSentences()
    {

    }
    void findThreshold()
    {

    }
    void generateSummary()
    {

    }

    //Functions

    void preProcessing()
    {
        //Text To Text Table

        //Stop Word Removal
        //Case Conversion

    }


    //Output Methods
    void showFrequencyTable()
    {
        for (Map.Entry<String, Integer> entry : frequencyCounter.entrySet()) {
            String key = (String) entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + "=" + value);
        }
    }
}
