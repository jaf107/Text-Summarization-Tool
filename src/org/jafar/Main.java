package org.jafar;

public class Main {

    public static void main(String[] args) {
        SummaryTool summary = new SummaryTool();

        //Input


        //Process - ALGORITHM
        /*5 steps
        1. Create Word Frequency Table
        2. Tokenize Sentences
        3. Score the sentences
        4. Find Threshold
        5. Generate Summary
        */
        summary.createWordFrequencyTable();
        summary.tokenizeSentences();
        summary.scoreSentences();
        summary.findThreshold();
        summary.generateSummary();

        //Output
        summary.showFrequencyTable();
    }
}
