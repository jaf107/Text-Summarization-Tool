package TextRank.FinalProject;

public class SummaryStatistics {
    private String context;
    private String summary;
    private int noOfWordsInSummary;
    private int noOfWordsInContext;
    private double percentageOfReduction;

    public SummaryStatistics(String c, String s) {
        this.context = c;
        this.summary = s;
        this.noOfWordsInContext = calculateNoOfWords(context);
        this.noOfWordsInSummary = calculateNoOfWords(summary);
        this.percentageOfReduction = (double) noOfWordsInSummary/noOfWordsInContext;
    }

    private int calculateNoOfWords(String context) {
        int noOfWords = 0;
        String[] words = context.split(" ");
        noOfWords = words.length;
        return noOfWords;
    }

    public int getNoOfWordsInSummary() {
        return noOfWordsInSummary;
    }

    public int getNoOfWordsInContext() {
        return noOfWordsInContext;
    }

    public double getPercentageOfReduction() {
        return percentageOfReduction;
    }
}
