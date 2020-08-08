package TextRank.Sample;

import java.util.ArrayList;
import java.util.List;

public class TfIdfCalculator {
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
        for (List<String> doc : docs) {
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
