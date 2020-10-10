package CrossValidation;

import static java.lang.Integer.min;

public class CrossValidation {
    String machinemadeSummary;
    String referenceSummary;

    private double precision;
    private double recall;

    CrossValidation(String machinemadeSummary,String goldenSummary)
    {
        precision = 0.0;
        recall = 0.0;

        Preprocessing tool = new Preprocessing();

        this.machinemadeSummary = tool.stopWordRemoval(tool.punctuationRemover(machinemadeSummary));
        this.referenceSummary =tool.stopWordRemoval(tool.punctuationRemover(goldenSummary));


        calculatePrecision();
        calculateRecall();
    }

    void calculatePrecision()
    {
        int numberOfOverlappingWords = getNumberOfOverlappedWords(getMachinemadeSummary(),getReferenceSummary());
        int totalWordsInSystemSummary = wordCounter(getMachinemadeSummary());

//        System.out.println("Overlapped Words:" + numberOfOverlappingWords);
//        System.out.println("Total system Summary words:" + totalWordsInSystemSummary);

        this.precision = (double)numberOfOverlappingWords/totalWordsInSystemSummary;
    }

    void calculateRecall()
    {
        int numberOfOverlappingWords = getNumberOfOverlappedWords(getMachinemadeSummary(),getReferenceSummary());
        int totalWordsInReferenceSummary = wordCounter(getReferenceSummary());


//        System.out.println("Overlapped Words:" + numberOfOverlappingWords);
//        System.out.println("Total Reference Summary words:" + totalWordsInReferenceSummary);

        this.recall = (double)numberOfOverlappingWords/totalWordsInReferenceSummary;

    }

    int getNumberOfOverlappedWords(String s1,String s2)
    {
        int number = 0;
        String[] table1 = s1.split(" ");
        String[] table2 = s2.split(" ");

        Boolean[] bTable1 = new Boolean[table1.length];
        for (int i = 0; i <bTable1.length ; i++) {
            bTable1[i] = false;
        }
        Boolean[] bTable2 = new Boolean[table2.length];
        for (int i = 0; i <bTable2.length ; i++) {
            bTable2[i] = false;
        }
//        System.out.println(s1 + s2);
        int j = 0;
        for(int i=0; i< table1.length;i++) {
            for (j=0; j < table2.length; j++) {
                if(table1[i].trim().equals(table2[j].trim()) && bTable2[j]==false) {
                    number++;
                    bTable2[j] = true;
//                System.out.println(table1[i] +" "+table2[j]);
                }
            }
        }
        return number;
    }

    public String getMachinemadeSummary() {
        return machinemadeSummary;
    }

    public String getReferenceSummary() {
        return referenceSummary;
    }

    int wordCounter(String s)
    {
        int spaceCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                spaceCounter++;
        }
        spaceCounter++;         // Considering the first word
        return spaceCounter;
    }

    public double getPrecision() {
        return precision;
    }

    public double getRecall() {
        return recall;
    }

    @Override
    public String toString() {
        return "\nCrossValidation{" +
//                "machinemadeSummary='" + machinemadeSummary + '\'' +
//                ", referenceSummary='" + referenceSummary + '\'' +
                ", precision=" + precision +
                ", recall=" + recall +
                '}' + "\n\n";
    }
}
