package Algorithms.Direct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SummaryTool {
    /*

    1. Obtain Context
    2. Context -> Sentence
    3. Sentence.NoOfWords are measured
    4. Intersection Matrix is created. Size of Matrix = [sentence.length()][sentence.length()]
    5. mat[i][j] = ((noOfWords of sentence 'i') + (noOfWords of sentence 'j'))/2
    6. Score of a row for each sentence is added
    7. Order of sentences are maintained and half of the sentences are marked
    8. Extraction of most scored sentences

     */


    private static int order = 1;
    private String context;
    private String summary;
    private ArrayList<Sentence> sentences;
    private int noOfSentences;
    private int noOfSentencesInSummary;
    private String[] sentencesArray;
    private double[][] intersectionMatrix;
    private HashMap<Sentence, Double> sentenceScores;
    private ArrayList<Double> scoreOfSentences;

    public SummaryTool(String context){

        this.context = context;
        this.sentencesArray = context.split("\\.");
        this.sentences = new ArrayList<Sentence>();
        this.scoreOfSentences = new ArrayList<>();
        for(String sen:sentencesArray){
            sentences.add(new Sentence(sen,order));
            order++;
        }
        this.noOfSentences = sentences.size();
        intersectionMatrix = new double[noOfSentences][noOfSentences];
        this.sentenceScores = new HashMap<Sentence,Double>();
        this.noOfSentencesInSummary = noOfSentences /2;
        this.summary = "";
        calculateIntersectionMatrix();
        calculateScores();

        extraction(noOfSentencesInSummary);

        System.out.println(spaceCalculator(this.context) + 1);
        System.out.println(spaceCalculator(summary) + 1);


    }

    private void extraction(int noOfSentencesInSummary) {
        Collections.sort(scoreOfSentences,Collections.reverseOrder());

        double threshold = scoreOfSentences.get(noOfSentencesInSummary-1);

//        System.out.println('\n'+summary+'\n');
//        System.out.println("Threshold :" + threshold);
        for (Sentence s: sentences ) {
            if(s.getScore() >= threshold && s.getSentenceString()!= null)
            {
//                System.out.println(s.getText() + ". ");
                summary += s.getSentenceString();
                summary += ".\n";
            }
        }

    }

    private void calculateIntersectionMatrix() {
        for (int i = 0; i < noOfSentences ; i++) {
            for (int j = 0; j < noOfSentences; j++) {
                intersectionMatrix[i][j] = (0);
            }
        }

        for (int i = 0; i < noOfSentences ; i++) {
            for (int j = 0; j < noOfSentences; j++) {
                intersectionMatrix[i][j] = ((sentences.get(i).getNumberOfWords() + sentences.get(j).getNumberOfWords()) /2);
            }
        }

    }

    void calculateScores() {
        for (int i = 0; i < noOfSentences; i++) {
            double scoreTemp = 0;
            for (int j = 0; j < noOfSentences; j++) {
                scoreTemp+= intersectionMatrix[i][j];
            }
            sentences.get(i).setScore(scoreTemp);
            scoreOfSentences.add(scoreTemp);
        }
    }

    public String getSummary() {
        return summary;
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




    @Override
    public String toString() {
        return "SummaryTool{" +
//                "context='" + context + '\'' +
                ", summary='" + summary + '\'' +
//                ", sentences=" + sentences +
//                ", \nnoOfSentences=" + noOfSentences +
//                ", sentencesArray=" + Arrays.toString(sentencesArray) +
//                ", intersectionMatrix=" + Arrays.toString(intersectionMatrix) +
//                ", sentenceScores=" + sentenceScores +
                '}';
    }
}
