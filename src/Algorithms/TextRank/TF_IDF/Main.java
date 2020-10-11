package Algorithms.TextRank.TF_IDF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);


        TFIDFCalculator calculator = new TFIDFCalculator();

        for (List<String> doc:documents             ) {
            for (String w:doc  ) {

                double tfidf = calculator.tfIdf(doc, documents, w);
                System.out.println("TF-IDF " +w +" = " +tfidf);
            }
        }

//        double tfidf = calculator.tfIdf(doc1, documents, "ipsum");
//        System.out.println("TF-IDF (ipsum) = " + tfidf);

    }
}
