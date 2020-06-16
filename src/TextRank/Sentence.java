package TextRank;

import javafx.geometry.HPos;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sentence {
    String text = "The name of my University is Dhaka University";
    private int score ;

    // PARAMETERS
    private int sentenencePosition;
    private int frequency;                  // TF - IDF
    private int numberOfWords;
    private int sentenceLength;
    private int numberOfProperNoun;         // Implementation later

    private String[] words;                 // Words of the Sentence
        HashMap<String, Integer > wordScore  = new HashMap<>();
//    CONSTRUCTOR

    Sentence()
    {

        this.sentenencePosition = 0;
        this.sentenceLength = text.length();
        this.numberOfWords = getNumberOfWords(text);
        this.words = text.split(" ");
        wordScore = generateWordScore(words);
    }



    Sentence(String sample, int sentenencePosition)
    {
        this.text = sample;
        this.sentenencePosition = sentenencePosition;
        this.sentenceLength = text.length();
        this.numberOfWords = getNumberOfWords(sample);
        this.score = scoreSentence();
        this.words = text.split(" ");
        wordScore = generateWordScore(words);
    }

//    METHODS
    HashMap<String, Integer> generateWordScore(String[] allWords)
    {
        HashMap<String , Integer > sample  = new HashMap<>();
        for (String s: allWords) {
            sample.compute(s,(k,v) -> v == null? 1:v+1);
        }
        return sample;
    }
    int scoreSentence()
    {
        int score = 0;
        return score;
    }


//    OUTPUT METHODS



//    GETTERS and SETTERS
    public String getSample() {
        return text;
    }

    public void setSample(String sample) {
        this.text = sample;
    }

    public int getSentenencePosition() {
        return sentenencePosition;
    }

    public void setSentenencePosition(int sentenencePosition) {
        this.sentenencePosition = sentenencePosition;
    }

    public int getFrequency() {
        return frequency;
    }


    public int getNumberOfWords(String s) {
        int spaceCounter = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' ')
                spaceCounter++;

        }

        return spaceCounter+1;
    }

    public void setNumberOfWords(int numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public int getSentenceLength() {
        return sentenceLength;
    }

    public void setSentenceLength(int sentenceLength) {
        this.sentenceLength = sentenceLength;
    }

    public int getNumberOfProperNoun() {
        return numberOfProperNoun;
    }

    public void setNumberOfProperNoun(int numberOfProperNoun) {
        this.numberOfProperNoun = numberOfProperNoun;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "text='" + text + '\'' +
                ", score=" + score +
                ", sentenencePosition=" + sentenencePosition +
                ", frequency=" + frequency +
                ", numberOfWords=" + numberOfWords +
                ", sentenceLength=" + sentenceLength +
                ", numberOfProperNoun=" + numberOfProperNoun +
                ", words=" + Arrays.toString(words) +
                ", wordScore=" + wordScore +
                '}';
    }
}
