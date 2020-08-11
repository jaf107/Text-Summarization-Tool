package TextRank.Vector;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        A.add(2);
        A.add(4);

        B.add(4);
        B.add(1);
        B.add(3);

        SentenceVector S1 = new SentenceVector(2,A);
        SentenceVector S2 = new SentenceVector(3,B);

        DotProduct tool = new DotProduct();

        System.out.println(tool.calculateDotProduct(S1,S2));
    }
}
