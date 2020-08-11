package TextRank.Sample;

public class DotProduct {



    double calculateDotProduct(Vector A, Vector B)
    {
        return  dotProduct(A,B)/(mod(A)*mod(B));
    }

    double dotProduct(Vector A, Vector B)
    {
        return A.x*B.x + A.y*B.y + A.z*B.z;
    }

    double mod(Vector A)
    {
        return  Math.sqrt(Math.pow(A.x,2) + Math.pow(A.y,2) + Math.pow(A.z,2) );
    }
}
