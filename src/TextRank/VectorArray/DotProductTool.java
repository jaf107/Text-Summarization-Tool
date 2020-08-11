package TextRank.VectorArray;

import TextRank.Sample.Vector;

public class DotProductTool {

    double calculateDotProduct(VectorUsingArray A, VectorUsingArray B)
    {
        double val = 0.0;

        for (int i=0; i< A.n ;i++)
        {
            val += (A.value[i] * B.value[i]);
        }

        return val;
    }
    double mod(VectorUsingArray A)
    {
        double val = 0.0;

        for (int i=0;i< A.n ; i++)
        {
            val += Math.pow(A.value[i],2);
        }
        return Math.sqrt(val);
    }
    double DotProduct(VectorUsingArray A, VectorUsingArray B)
    {
        double num = calculateDotProduct(A,B);
        double deno = (mod(A)*mod(B));

        System.out.println(num);
        System.out.println(deno);
        return num/deno;
    }
}
