package TextRank.Vector;

import java.util.ArrayList;

public class SentenceVector {
    // This is a vector with multiple dimensions.
    int dimensions ;
    ArrayList<Integer> magnitudes;


    SentenceVector(int dim,ArrayList<Integer> m)
    {
        this.dimensions = dim;
        this.magnitudes = m;
    }


}
