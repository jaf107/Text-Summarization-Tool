package TextRank;

public class Main {
    public static void main(String[] args) {

        /*

        Steps:
        1. Concatenate all the text .
        2. Split the text into individual sentences .
        3. Word Embedding for each and every sentence .
        4. Similarity between sentence vectors -> Cosine similarity .
        5. Similarity Matrix is converted to a graph where
                - sentence          -> vertices .
                - similarity scores -> edges .
        6. Selection of N sentences .

        */

        SummaryTool mytool = new SummaryTool();

        mytool.mainProcess();



//        Sentence TESTING
//        Sentence mySentence = new Sentence("This is Mahin",2);
//        System.out.println(mySentence.toString());


//        mytool.showSentences();
//        mytool.showProcessedSentences();
    }
}
