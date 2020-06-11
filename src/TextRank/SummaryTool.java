package TextRank;

import java.util.ArrayList;

public class SummaryTool {

    String text = "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.";

    //    ArrayList sentences  = new ArrayList();
    String[] sentences;
    String[] processedSentences;

    void mainProcess() {
        int n = 7;// Random initialization
        concatanateText();
        textToSentence();
        wordEmbedding();
        cosineSimilarity();
        matrixToGraph();
        generateSummary(n);
    }

    void concatanateText() {

    }

    void textToSentence() {
        sentences = new String[fullStopCounter(text)];


        System.out.println("Total number of sentences :" + fullStopCounter(text));
        sentences = text.split("\\.");


        processedSentences = sentences;

        showProcessedSentences();

        for (int i = 0; i < sentences.length; i++) {
            processedSentences[i] = stopWordRemoval(sentences[i]);
        }

        System.out.println("Processed Sentences :" );
        showProcessedSentences();

    }

    void wordEmbedding() {

    }

    void cosineSimilarity() {

    }

    void matrixToGraph() {

    }

    void generateSummary(int n) {
        // n is the number of selected sentences
    }


    //    Other Functions
    String stopWordRemoval(String input) {
        String[] stop_words = {"a", "able", "about", "after", "all", "also", "am", " ", "The", "\r", "\n",
                "an", "and", "any", "are", "as", "at", "be", "because", "been", "but", "by", "can", "cannot", "could", "did",
                "do", "does", "either", "else", "ever", "every", "for", "from", "get", "got", "had", "has", "have", "he", "her", "hers", "him", "his", "how", "I",
                "if", "in", "into", "is", "it", "its", "just", "let", "like", "likely", "may", "me",
                "might", "most", "must", "my", "neither", "no", "nor", "not", "of", "off",
                "often", "on", "only", "or", "other", "our", "own", "said", "say", "says", "she",
                "should", "so", "some", "than", "that", "the", "their", "them", "then", "there",
                "these", "they", "this", "they're", "to", "too", "that's", "us", "was", "we", "were",
                "what", "when", "where", "which", "while", "who", "whom", "why", "will", "with",
                "would", "yet", "you", "your", "you're"};
        String noPunctuation = punctuationRemover(input);
        String[] word = noPunctuation.toLowerCase().split(" ");
        String output = "";
        boolean temp = true;

        int j = 0;
        for (int i = 0; i < word.length; i++) {

            temp = true;
            for (String s : stop_words) {
                if (word[i].equalsIgnoreCase(s))
                    temp = false;

            }
            if (temp == true)
            {
                output += word[i];
                output += " ";
            }


        }
//        System.out.println(output);
        return output;
    }

    String punctuationRemover(String content) {
        String noPunctuationSentence = "";
        //String noPunctuationContent = "";
        for (int i = 0; i < content.length(); i++) {
            if ((content.charAt(i) != '.') && (content.charAt(i) != ',') &&
                    (content.charAt(i) != '!') && (content.charAt(i) != ':') &&
                    (content.charAt(i) != ';') && (content.charAt(i) != '"') &&
                    (content.charAt(i) != '?') && (content.charAt(i) != '-') &&
                    (content.charAt(i) != '.') && (content.charAt(i) != '(') &&
                    (content.charAt(i) != ')') && (content.charAt(i) != '*') &&
                    (content.charAt(i) != '\r') && (content.charAt(i) != '\n')) {
                noPunctuationSentence += content.charAt(i);
            } else
                noPunctuationSentence += "";

        }
        return noPunctuationSentence;
    }

    int fullStopCounter(String sample) {
        int fullstop = 0;
        for (int i = 0; i < sample.length(); i++) {
            if (sample.charAt(i) == '.')
                fullstop++;
        }
        return fullstop;
    }

    //    Output Functions
    void showStringArray(String[] sample)
    {
        for (String s:sample ) {
            System.out.println(s);
        }
    }
    void showSentences()
    {
        for (String s:sentences  ) {
            System.out.println(s);
        }
    }
    void showProcessedSentences()
    {
        for (String s:processedSentences ) {
            System.out.println(s);
        }
    }

}
