package Algorithms.TextRank.FinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sentence {
    private int number;
    private String text;
    private String processedText;
    private Double score;
    private ArrayList<String> words;
    private ArrayList<String> allExclusiveWords;

    private ArrayList<ArrayList<String>> paragraph;

    private HashMap<String, Double> tfidf;


    Sentence(String text,int number)
    {
        this.number = number;
        this.text = text;
        this.processedText = stopWordRemoval(text);
        this.paragraph = new ArrayList<>();
        this.words = new ArrayList<>();
        this.tfidf = new HashMap<String, Double>();
        this.allExclusiveWords = new ArrayList<>();
        this.score = 0.0;

        String[] wordArray = processedText.split(" ");
        for (String w:wordArray) {
            words.add(w);
        }
    }

    void tfidfCalculation()
    {
        TFIDFCalc calculator = new TFIDFCalc();

        for (String s:allExclusiveWords ) {
            tfidf.put(s,0.0);
        }

        for (List<String> doc:paragraph  ) {
            for (String w:words  ) {

                double tfidfV = calculator.tfIdf(words, paragraph, w);

                tfidf.put(w,tfidfV);
//                System.out.println("TF-IDF " +w +" = " +tfidf);
            }
        }
    }

    public void setParagraph(ArrayList<ArrayList<String>> paragraph) {
        this.paragraph = paragraph;
    }

    public void setAllExclusiveWords(ArrayList<String> allExclusiveWords) {
        this.allExclusiveWords = allExclusiveWords;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getScore() {
        return score;
    }


    public String getText() {
        return text;
    }

    public ArrayList<String> getAllExclusiveWords() {
        return allExclusiveWords;
    }

    public HashMap<String, Double> getTfidf() {
        return tfidf;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getProcessedText() {
        return processedText;
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

    String stopWordRemoval(String input) {
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
        String noPunctuation = punctuationRemover(input);
        String[] word = noPunctuation.toLowerCase().split(" ");
        String output = "";
        boolean temp = true;

        int j = 0;
        for (int i = 0; i < word.length; i++) {

            temp = true;
            for (String s : stop_words) {
                if (word[i].equalsIgnoreCase(s))
                    temp = false;

            }
            if (temp == true)
            {
                output += word[i];
                output += " ";
            }


        }
//        System.out.println(output);
        return output;
    }

    @Override
    public String toString() {
        return "\nSentence{" +
                "number=" + number +
                ", text='" + text + '\'' +
//                ", processedText='" + processedText + '\'' +
                ",\nscore=" + score +
//                ", words=" + words +
//                ", allExclusiveWords=" + allExclusiveWords +
//                ", paragraph=" + paragraph +
//                ", tfidf=" + tfidf +
                '}';
    }
}
