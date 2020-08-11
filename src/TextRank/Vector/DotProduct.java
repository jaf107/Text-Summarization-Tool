package TextRank.Vector;

import TextRank.Sample.Vector;

public class DotProduct {

    double calculateDotProduct(SentenceVector A, SentenceVector B)
    {
        return dotProduct( A,  B)/( mod( A) * mod( B));
    }

    double dotProduct(SentenceVector A, SentenceVector B)
    {
        double value = 0.0;

        int dim = A.dimensions;
        if(B.dimensions > dim)
            dim = B.dimensions;

        for (int i=0; i< dim;i++)
        {
            value += A.magnitudes.get(i)* B.magnitudes.get(i);
        }

        return value;
    }

    double mod(SentenceVector A)
    {
        int dim = A.dimensions;
        double value = 0.0;
        for (double v:A.magnitudes ) {
            value += Math.pow(v,2);
        }

        return Math.sqrt(value);
    }
}
