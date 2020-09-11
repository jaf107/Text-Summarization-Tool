package TextRank.FinalProject;

public class MainMethod {
    public static void main(String[] args) {
        SummaryTool tool = new SummaryTool("I know one thing for certain. Don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.");

        tool.docConversion();
                                  //Calculation of TD-IDF in paragraph
        tool.formAllExclusiveWords();
        tool.tfidf();
        tool.cosineSimilarity();

        tool.printcsMat();
//        System.out.println(tool.toString());
    }

}
