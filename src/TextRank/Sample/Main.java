package TextRank.Sample;

import TextRank.TF_IDF.TFIDFCalculator;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tool myTool = new Tool("Hello this is Mahin. I'm from Dhaka University. This University is located in Shahbagh.");

        myTool.showDoc();

        TfIdfCalculator calculator = new TfIdfCalculator();

       ArrayList<ArrayList<String>> documents ;
        documents = myTool.getDoc();
        for (ArrayList<String> doc:documents             ) {
            for (String w:doc  ) {

                double tfidf = calculator.tfIdf(doc, documents, w.toLowerCase());
                System.out.println("TF-IDF of " +w +" = " +tfidf);
            }
        }

    }
}
