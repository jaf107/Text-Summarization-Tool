package Algorithms.TextRank.FinalProject;

import java.util.ArrayList;


public class TFIDFCalc {
    public double tf(ArrayList<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    public double idf(ArrayList<ArrayList<String>> docs, String term) {
        double n = 0;
        for (ArrayList<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }
    public double tfIdf(ArrayList<String> doc, ArrayList<ArrayList<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }
}
