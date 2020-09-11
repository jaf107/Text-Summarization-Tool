package TextRank.FinalProject;

import TextRank.VectorArray.VectorUsingArray;

public class CosineSimilarity {

    Double dotProduct(Sentence s1, Sentence s2)
    {
//        System.out.println(s1.text +"\n" +s2.text);
        double num = calculateDotProduct(s1,s2);
        double deno = (mod(s1)*mod(s2));

//        System.out.println(num);
//        System.out.println(deno);
        return num/deno;
    }

    double calculateDotProduct(Sentence s1, Sentence s2)
    {
        double val = 0.0;


        for (String w:s1.allExclusiveWords)
        {
            val += (s1.tfidf.get(w) * s2.tfidf.get(w));
        }

        return val;
    }
    double mod(Sentence A)
    {
        double val = 0.0;

        for (String s:A.allExclusiveWords ) {

            val += Math.pow(A.tfidf.get(s),2);

        }
        return Math.sqrt(val);
    }
}
