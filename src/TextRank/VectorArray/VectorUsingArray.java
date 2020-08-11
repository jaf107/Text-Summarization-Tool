package TextRank.VectorArray;

import java.util.Arrays;

public class VectorUsingArray {

    int n = 10;
    double[] value;

    VectorUsingArray(double[] v)
    {
        n = 10;
        value = new double[n];
        for(int i=0;i<n;i++)
        {
            value[i] = 0;
        }

        for(int i =0 ;i<v.length; i++)
        {
            value[i] = v[i];
        }
    }

    @Override
    public String toString() {
        return "VectorUsingArray{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
