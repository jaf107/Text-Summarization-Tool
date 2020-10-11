package Algorithms.Direct;

public class Sentence {

    private int order;
    private String sentenceString;
    private int numberOfWords;
    private double score;

    public Sentence(String sen,int order){
        this.sentenceString = sen.trim();
        this.numberOfWords = spaceCalculator(sen) + 1;
        this.order =order;
    }

    int spaceCalculator(String sen){
        int counter = 0;
        for (int i = 0; i < sen.length() ; i++) {
            if(sen.charAt(i) == ' '){
                counter++;
            }
        }
        return counter;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public String getSentenceString() {
        return sentenceString;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "\n\nSentence{" +
                "order=" + order +
                ", sentenceString='" + sentenceString + '\'' +
                ", \nnumberOfWords=" + numberOfWords +
                ", \nscore=" + score +
                "}\n\n";
    }
}
