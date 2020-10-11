package oldSummarization.direct;

import java.util.ArrayList;
import java.util.Arrays;
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
    private String[] sentencesArray;
    private double[][] intersectionMatrix;
    private HashMap<Sentence, Double> sentenceScores;

    public SummaryTool(String context){

        this.context = context;
        this.sentencesArray = context.split("\\.");
        this.sentences = new ArrayList<Sentence>();
        for(String sen:sentencesArray){
            sentences.add(new Sentence(sen,order));
            order++;
        }
        this.noOfSentences = sentences.size();
        intersectionMatrix = new double[noOfSentences][noOfSentences];
        this.sentenceScores = new HashMap<Sentence,Double>();

        calculateIntersectionMatrix();
        calculateScores();
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
        }
    }

    public String getSummary() {
        return summary;
    }


    @Override
    public String toString() {
        return "SummaryTool{" +
//                "context='" + context + '\'' +
//                ", summary='" + summary + '\'' +
                ", sentences=" + sentences +
                ", \nnoOfSentences=" + noOfSentences +
//                ", sentencesArray=" + Arrays.toString(sentencesArray) +
                ", \n\n\nintersectionMatrix=" + Arrays.toString(intersectionMatrix) +
                ", \n\n\nsentenceScores=" + sentenceScores +
                '}';
    }
}
