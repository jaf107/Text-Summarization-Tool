package org.wordFrequencyAlgorithm;

public class Main {

    public static void main(String[] args) {
        SummaryTool summary = new SummaryTool();

        //Input

        //PreProcess
        summary.preProcessing();

        //Process - ALGORITHM
        /*5 steps
        1. Create Word Frequency Table
        2. Tokenize Sentences
        3. Score the sentences
        4. Find Threshold
        5. Generate Summary
        */

        summary.mainProcess();


//        Output

        summary.showComparison();

//        summary.showSentences();              //show Sentence and it's scores
//        summary.showSummary();                  //show Summary

//        summary.showTextTable();              // Show Text Table
//        summary.showFrequencyTable();         // Show the Word Frequency Table
    }
}
