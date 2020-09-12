package TextRank.FinalProject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SummaryTool {

    static int numberOrdering = 0;
    String context;
    String summary;

    int noOfSentences;

    ArrayList<Sentence> paragraph;
    ArrayList<String> allExclusiveWords;    // Takes all the words only once

    ArrayList<ArrayList<String>> docs;

    double[][] csMatrix;                    // Cosine Similarity Matrix
    ArrayList<Double> scoreOfSentences;


    SummaryTool(String t) {
        this.context = t;
        paragraph = new ArrayList<Sentence>();
        docs = new ArrayList<>();
        allExclusiveWords = new ArrayList<>();


        noOfSentences = fullStopCounter(t);
        csMatrix = new double[noOfSentences][noOfSentences];
        scoreOfSentences = new ArrayList();

        String[] sentencesArray = new String[noOfSentences];
        sentencesArray = context.split("\\.");

        for (String s : sentencesArray) {
            numberOrdering++;
            paragraph.add(new Sentence(s,numberOrdering));
        }
    }

    void tfidf() {
        for (Sentence s : paragraph) {
            s.tfidfCalculation();
        }
    }

    void cosineSimilarity()
    {
        for(int i=0; i< noOfSentences;i++ )
        {
            for(int j=0; j<noOfSentences; j++)
            {
                Sentence s1 = paragraph.get(i);
                Sentence s2 = paragraph.get(j);

                CosineSimilarity tool = new CosineSimilarity();

                csMatrix[i][j] = tool.dotProduct(s1,s2);
//                csMatrix[j][i] = csMatrix[i][j];
            }
        }


        for(int i=0;i<noOfSentences;i++)
        {
            double value = 0.0;
            for(int j=0; j<noOfSentences;j++)
            {
                value += csMatrix[i][j];
            }
            paragraph.get(i).setScore(value);
            scoreOfSentences.add(value);
        }
        

    }

    void formAllExclusiveWords()
    {
        for (Sentence s:paragraph  ) {
            for (String w:s.getWords() ) {

                if(!allExclusiveWords.contains(w))
                {
                    allExclusiveWords.add(w);
                }

            }
        }


        for (int i=0; i<paragraph.size();i++) {
            paragraph.get(i).setAllExclusiveWords(allExclusiveWords);

        }
    }

    void docConversion()
    {
        for (Sentence s:paragraph ) {

            String sen = s.getProcessedText();
            String[] words = sen.split(" ");

            ArrayList<String> wordsAL = new ArrayList<>();
            for (String w:words ) {
                wordsAL.add(w);
            }

            docs.add(wordsAL);
        }

        for (int i=0; i<paragraph.size();i++)
        {
            paragraph.get(i).setParagraph(docs);
        }
    }

    int fullStopCounter(String sample) {
        int fullstop = 0;
        for (int i = 0; i < sample.length(); i++) {
            if (sample.charAt(i) == '.')
                fullstop++;
        }
        return fullstop;
    }

    void extraction(int n)
    {
        Collections.sort(scoreOfSentences,Collections.reverseOrder());

        double threshold = scoreOfSentences.get(n-1);

        System.out.println(threshold);
        for (Sentence s: paragraph ) {
            if(s.getScore() >= threshold)
            {
                System.out.println(s.getText() + s.getScore());
                summary += s.getText();
            }
        }

        System.out.println(summary);

    }

    void printcsMat()
    {
        for(int i=0; i<noOfSentences;i++)
        {
            for(int j=0; j<noOfSentences;j++)
            {
                System.out.print(csMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    @Override
    public String toString() {
        return "SummaryTool{" +
                "context='" + context + '\'' +
                ", summary='" + summary + '\'' +
                ", noOfSentences=" + noOfSentences +
                ", paragraph=" + paragraph +
                ", allExclusiveWords=" + allExclusiveWords +
                ", docs=" + docs +
                ", csMatrix=" + Arrays.toString(csMatrix) +
                '}';
    }
}
