package oldSummarization;

public class Sentence {
    private int paragraphNumber ;
    private int number;
    private double score;
    private int noOfWords;
    private String value;
    private String[] words;


    Sentence(int number, String value, int paragraphNumber) {
        this.number = number;
        this.value = new String(value);
        words = value.split("\\s+");
        noOfWords = words.length;
        score = 0.0;
        this.paragraphNumber = paragraphNumber;

    }


    public double getScore() {
        return score;
    }

    public int getNumber() {
        return number;
    }

    public int getParagraphNumber() {
        return paragraphNumber;
    }

    public String getValue() {
        return value;
    }

    public int getNoOfWords() {
        return noOfWords;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
