package org.jafar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SummaryTool {



    String text = "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.";

    String textTable[];
    String sentences[] = new String[100];


    String textTable1[] = {"i", "know" ,"one" ,"thing", "for", "certain", "don’t", "settle" ,"for", "less", "than","what" ,"you’re"
            ,"capable", "of", "but", "strive", "for" ,"something", "bigger", "Some" ,"of","you", "reading", "this", "might",
            "identify", "with" ,"this" ,"message" ,"because" ,"it" ,"resonates" ,"with", "you", "on" ,"a" ,"deeper", "level"
            , "for", "others", "at" ,"the" ,"end" ,"of" ,"their", "tether", "the", "message" ,"might" ,"be" ,"nothing"
            ,"more" ,"than" ,"a", "trivial", "pep" ,"talk" ,"what" ,"i", "wish", "to", "convey", "irrespective", "of" ,"where"
            ,"you" ,"are" ,"in", "your", "journey" ,"is", "never" ,"settle", "for", "less", "if", "you", "settle" ,"for"
            , "less", "you" ,"will" ,"receive", "less" ,"than", "you", "deserve" ,"and", "convince", "yourself", "you"
            ,"are", "justified", "to", "receive", "it"};



    HashMap<String,Integer> frequencyCounter = new HashMap<>();
    HashMap<String,Double> sentencesScore = new HashMap<>();
    ArrayList<String> summary = new ArrayList<>();

    //Main Algorithm
    void mainProcess()
    {
        createWordFrequencyTable();
        tokenizeSentences();
        scoreSentences();
        findThreshold();
        generateSummary();
    }



    void createWordFrequencyTable()
    {

        for (String sample: textTable) {
            frequencyCounter.compute(sample,(k,v) -> v == null? 1:v+1);
        }

    }
    void tokenizeSentences()
    {
        /*String s = text.toLowerCase();
        //s = punctuationRemover(s);
        System.out.println(s);
        String[] sen = s.split("\\.");
        for (String t:sen) {
            System.out.println(t);

        }*/
        sentences = text.split("\\.");
        for(int i = 0 ;i<sentences.length;i++){
            sentences[i] += ".";

        }


    }
    void scoreSentences()
    {
        double sentenceScore = 0;
        int noOfTotalWords = 0;
        for(int i=0;i<sentences.length;i++) {
            noOfTotalWords = spaceCounter(sentences[i]) + 1;


            sentenceScore = noOfNonStopWords(sentences[i]);
//            sentenceScore = ( noOfNonStopWords(sentences[i])  / (double)noOfTotalWords); // Percentage of Non Stop Words

//            System.out.println(sentenceScore + " = " + sentences[i]);
            sentencesScore.put(sentences[i],sentenceScore);
        }

    }
    double findThreshold()
    {
        double threshold = 0;
        for (Map.Entry<String, Double> entry : sentencesScore.entrySet()) {
            String key = (String) entry.getKey();
            Double value = entry.getValue();

            threshold += value;
            //System.out.println(key + "=" + value);
        }
        threshold /= (double)sentences.length;
//        System.out.println(threshold + " = Threshold" );

        return threshold;
    }
    void generateSummary()
    {
        double threshold = findThreshold();
        for (Map.Entry<String, Double> entry : sentencesScore.entrySet()) {
            String key = (String) entry.getKey();
            Double value = entry.getValue();

            if(value > threshold)
                summary.add(key);

        }


    }

    //Functions
    int noOfNonStopWords(String sample) {
//        System.out.println(sample);
        String[] stop_words = {"a", "able", "about", "after", "all", "also", "am", " ", "The", "\r", "\n",
                "an", "and", "any", "are", "as", "at", "be", "because", "been", "but", "by", "can", "cannot", "could", "did",
                "do", "does", "either", "else", "ever", "every", "for", "from", "get", "got", "had", "has", "have", "he", "her", "hers", "him", "his", "how", "I",
                "if", "in", "into", "is", "it", "its", "just", "let", "like", "likely", "may", "me",
                "might", "most", "must", "my", "neither", "no", "nor", "not", "of", "off",
                "often", "on", "only", "or", "other", "our", "own", "said", "say", "says", "she",
                "should", "so", "some", "than", "that", "the", "their", "them", "then", "there",
                "these", "they", "this", "they're", "to", "too", "that's", "us", "was", "we", "were",
                "what", "when", "where", "which", "while", "who", "whom", "why", "will", "with",
                "would", "yet", "you", "your", "you're"};
        String noPunctuation = punctuationRemover(sample);
        String[] word = noPunctuation.toLowerCase().split(" ");

        int noOfNonStopWords = 0;
        boolean temp = true;


        for (int i = 0; i < word.length; i++) {


            temp = true;
            for (String s : stop_words) {
                if (word[i].equalsIgnoreCase(s))
                    temp = false;

            }
            if (temp == true)
                noOfNonStopWords++;

//            System.out.println(word[i] + " = " + temp);
        }

//        System.out.println("\nNo of NonStop words :" + noOfNonStopWords);
        return noOfNonStopWords;
    }
    int spaceCounter(String sample)
    {
        int space = 0;
        for (int i=0;i<sample.length();i++)
        {
            if(sample.charAt(i) == ' ')
                space++;
        }

        return space;
    }

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

        textTable = new String[word.length];
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
    void showSummary()
    {
        System.out.println("\n\n Summary:" );
        for (String s: summary) {
            System.out.println(s);

        }
    }
    void showSentences()
    {
        for (Map.Entry<String, Double> entry : sentencesScore.entrySet()) {
            String key = (String) entry.getKey();
            Double value = entry.getValue();

            System.out.println(key + "=" + value);
        }
    }
    void showFrequencyTable()
    {
        for (Map.Entry<String, Integer> entry : frequencyCounter.entrySet()) {
            String key = (String) entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + "=" + value);
        }
    }

    void showTextTable()
    {
        for (String s:textTable ) {
            System.out.println(s);
        }
    }
}
