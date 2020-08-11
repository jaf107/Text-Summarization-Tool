package TextRank.VectorArray;

public class Main {
    public static void main(String[] args) {

        double[] a = {3,4,1,3,5};
        double[] b = {3,4,1,7,2,3,5};

        VectorUsingArray v1 = new VectorUsingArray(a);
        VectorUsingArray v2 = new VectorUsingArray(b);

        DotProductTool tool = new DotProductTool();

        System.out.println(tool.DotProduct(v1,v2));
    }
}
