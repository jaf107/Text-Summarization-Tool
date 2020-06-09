package org.jafar;

import java.util.HashMap;
import java.util.Map;

public class SummaryTool {

    String text = "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.";

    String textTable[] = new String[10000];
    String textTable1[] = {"i", "know" ,"one" ,"thing", "for", "certain", "don’t", "settle" ,"for", "less", "than","what" ,"you’re"
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


        //Stop Word Removal
            extractWordsFromSentence();
        //Punctuation remover   -> called inside the above method
        //Case Conversion       -> called inside the above method


        //Text To Text Table
    }

    void extractWordsFromSentence() {
        String[] stop_words = { "a","able","about","after","all","also","am"," ","The","\r","\n",
                "an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","did",
                "do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","I",
                "if","in","into","is","it","its","just","let","like","likely","may","me",
                "might","most","must","my","neither","no","nor","not","of","off",
                "often","on","only","or","other","our","own","said","say","says","she",
                "should","so","some","than","that","the","their","them","then","there",
                "these","they","this","they're","to","too","that's","us","was","we","were",
                "what","when","where","which","while","who","whom","why","will","with",
                "would","yet","you","your", "you're" };
        String noPunctuation = punctuationRemover(text);
        String[] word = noPunctuation.toLowerCase().split(" ");


        boolean temp = true;

        int j=0;
        for (int i = 0; i < word.length; i++) {

            temp = true;
            for (String s: stop_words) {
                if(word[i].equalsIgnoreCase(s))
                    temp = false;

            }
            if(temp == true)
                textTable[j++] = word[i];

//            if(j!=0)
//            System.out.println(word[i] +" " +textTable[j-1]);
//                words.add(new Word(word[i]));
        }
    }
    String punctuationRemover(String content) {
        String noPunctuationSentence = "";
        //String noPunctuationContent = "";
        for (int i = 0; i < content.length(); i++) {
            if ((content.charAt(i) != '.') && (content.charAt(i) != ',') &&
                    (content.charAt(i) != '!') && (content.charAt(i) != ':') &&
                    (content.charAt(i) != ';') && (content.charAt(i) != '"') &&
                    (content.charAt(i) != '?') && (content.charAt(i) != '-') &&
                    (content.charAt(i) != '.') && (content.charAt(i) != '(') &&
                    (content.charAt(i) != ')') && (content.charAt(i) != '*') &&
                    (content.charAt(i) != '\r') && (content.charAt(i) != '\n')) {
                noPunctuationSentence += content.charAt(i);
            } else
                noPunctuationSentence += "";

        }
        return noPunctuationSentence;
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
