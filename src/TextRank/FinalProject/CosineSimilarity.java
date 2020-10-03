package TextRank.FinalProject;

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


        for (String w:s1.getAllExclusiveWords())
        {
            val += (s1.getTfidf().get(w) * s2.getTfidf().get(w));
        }

        return val;
    }
    double mod(Sentence A)
    {
        double val = 0.0;

        for (String s:A.getAllExclusiveWords()) {

            val += Math.pow(A.getTfidf().get(s),2);

        }
        return Math.sqrt(val);
    }
}
