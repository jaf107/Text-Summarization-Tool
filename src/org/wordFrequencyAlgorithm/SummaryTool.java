package org.wordFrequencyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SummaryTool {



//    String text = "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.";
    String text = "Those Who Are Resilient Stay In The Game Longer\n" +
        "“On the mountains of truth you can never climb in vain: either you will reach a point higher up today, or you will be training your powers so that you will be able to climb higher tomorrow.” — Friedrich Nietzsche\n" +
        "Challenges and setbacks are not meant to defeat you, but promote you. However, I realise after many years of defeats, it can crush your spirit and it is easier to give up than risk further setbacks and disappointments. Have you experienced this before? To be honest, I don’t have the answers. I can’t tell you what the right course of action is; only you will know. However, it’s important not to be discouraged by failure when pursuing a goal or a dream, since failure itself means different things to different people. To a person with a Fixed Mindset failure is a blow to their self-esteem, yet to a person with a Growth Mindset, it’s an opportunity to improve and find new ways to overcome their obstacles. Same failure, yet different responses. Who is right and who is wrong? Neither. Each person has a different mindset that decides their outcome. Those who are resilient stay in the game longer and draw on their inner means to succeed.\n" +
        "I’ve coached many clients who gave up after many years toiling away at their respective goal or dream. It was at that point their biggest breakthrough came. Perhaps all those years of perseverance finally paid off. It was the 19th Century’s minister Henry Ward Beecher who once said: “One’s best success comes after their greatest disappointments.” No one knows what the future holds, so your only guide is whether you can endure repeated defeats and disappointments and still pursue your dream. Consider the advice from the American academic and psychologist Angela Duckworth who writes in Grit: The Power of Passion and Perseverance: “Many of us, it seems, quit what we start far too early and far too often. Even more than the effort a gritty person puts in on a single day, what matters is that they wake up the next day, and the next, ready to get on that treadmill and keep going.”\n" +
        "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.\n" +
        "“Two people on a precipice over Yosemite Valley” by Nathan Shipps on Unsplash\n" +
        "Develop A Powerful Vision Of What You Want\n" +
        "“Your problem is to bridge the gap which exists between where you are now and the goal you intend to reach.” — Earl Nightingale\n" +
        "I recall a passage my father often used growing up in 1990s: “Don’t tell me your problems unless you’ve spent weeks trying to solve them yourself.” That advice has echoed in my mind for decades and became my motivator. Don’t leave it to other people or outside circumstances to motivate you because you will be let down every time. It must come from within you. Gnaw away at your problems until you solve them or find a solution. Problems are not stop signs, they are advising you that more work is required to overcome them. Most times, problems help you gain a skill or develop the resources to succeed later. So embrace your challenges and develop the grit to push past them instead of retreat in resignation. Where are you settling in your life right now? Could you be you playing for bigger stakes than you are? Are you willing to play bigger even if it means repeated failures and setbacks? You should ask yourself these questions to decide whether you’re willing to put yourself on the line or settle for less. And that’s fine if you’re content to receive less, as long as you’re not regretful later.\n" +
        "If you have not achieved the success you deserve and are considering giving up, will you regret it in a few years or decades from now? Only you can answer that, but you should carve out time to discover your motivation for pursuing your goals. It’s a fact, if you don’t know what you want you’ll get what life hands you and it may not be in your best interest, affirms author Larry Weidel: “Winners know that if you don’t figure out what you want, you’ll get whatever life hands you.” The key is to develop a powerful vision of what you want and hold that image in your mind. Nurture it daily and give it life by taking purposeful action towards it.\n" +
        "Vision + desire + dedication + patience + daily action leads to astonishing success. Are you willing to commit to this way of life or jump ship at the first sign of failure? I’m amused when I read questions written by millennials on Quora who ask how they can become rich and famous or the next Elon Musk. Success is a fickle and long game with highs and lows. Similarly, there are no assurances even if you’re an overnight sensation, to sustain it for long, particularly if you don’t have the mental and emotional means to endure it. This means you must rely on the one true constant in your favour: your personal development. The more you grow, the more you gain in terms of financial resources, status, success — simple. If you leave it to outside conditions to dictate your circumstances, you are rolling the dice on your future.\n" +
        "So become intentional on what you want out of life. Commit to it. Nurture your dreams. Focus on your development and if you want to give up, know what’s involved before you take the plunge. Because I assure you, someone out there right now is working harder than you, reading more books, sleeping less and sacrificing all they have to realise their dreams and it may contest with yours. Don’t leave your dreams to chance.";

    String textTable[];
    String sentences[] = new String[100];


    String textTable1[] = {"i", "know" ,"one" ,"thing", "for", "certain", "don’t", "settle" ,"for", "less", "than","what" ,"you’re"
            ,"capable", "of", "but", "strive", "for" ,"something", "bigger", "Some" ,"of","you", "reading", "this", "might",
            "identify", "with" ,"this" ,"message" ,"because" ,"it" ,"resonates" ,"with", "you", "on" ,"a" ,"deeper", "level"
            , "for", "others", "at" ,"the" ,"end" ,"of" ,"their", "tether", "the", "message" ,"might" ,"be" ,"nothing"
            ,"more" ,"than" ,"a", "trivial", "pep" ,"talk" ,"what" ,"i", "wish", "to", "convey", "irrespective", "of" ,"where"
            ,"you" ,"are" ,"in", "your", "journey" ,"is", "never" ,"settle", "for", "less", "if", "you", "settle" ,"for"
            , "less", "you" ,"will" ,"receive", "less" ,"than", "you", "deserve" ,"and", "convince", "yourself", "you"
            ,"are", "justified", "to", "receive", "it"};



    HashMap<String,Integer> frequencyCounter = new HashMap<>();
    HashMap<String,Double> sentencesScore = new HashMap<>();
    ArrayList<String> summary = new ArrayList<>();

    //Main Algorithm
    void mainProcess()
    {
        createWordFrequencyTable();
        tokenizeSentences();
        scoreSentences();
        findThreshold();
        generateSummary();
    }



    void createWordFrequencyTable()
    {

        for (String sample: textTable) {
            frequencyCounter.compute(sample,(k,v) -> v == null? 1:v+1);
        }

    }
    void tokenizeSentences()
    {
        /*String s = text.toLowerCase();
        //s = punctuationRemover(s);
        System.out.println(s);
        String[] sen = s.split("\\.");
        for (String t:sen) {
            System.out.println(t);

        }*/
        sentences = text.split("\\.");
        for(int i = 0 ;i<sentences.length;i++){
            sentences[i] += ".";

        }


    }
    void scoreSentences()
    {
        double sentenceScore = 0;
        int noOfTotalWords = 0;
        for(int i=0;i<sentences.length;i++) {
            noOfTotalWords = spaceCounter(sentences[i]) + 1;


            sentenceScore = noOfNonStopWords(sentences[i]);
//            sentenceScore = ( noOfNonStopWords(sentences[i])  / (double)noOfTotalWords); // Percentage of Non Stop Words

//            System.out.println(sentenceScore + " = " + sentences[i]);
            sentencesScore.put(sentences[i],sentenceScore);
        }

    }
    double findThreshold()
    {
        double threshold = 0;
        for (Map.Entry<String, Double> entry : sentencesScore.entrySet()) {
            String key = (String) entry.getKey();
            Double value = entry.getValue();

            threshold += value;
            //System.out.println(key + "=" + value);
        }
        threshold /= (double)sentences.length;
//        System.out.println(threshold + " = Threshold" );

        return threshold;
    }
    void generateSummary()
    {
        double threshold = findThreshold();
        for (Map.Entry<String, Double> entry : sentencesScore.entrySet()) {
            String key = (String) entry.getKey();
            Double value = entry.getValue();

            if(value > threshold)
                summary.add(key);

        }


    }

    //Functions
    int noOfNonStopWords(String sample) {
//        System.out.println(sample);
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
        String noPunctuation = punctuationRemover(sample);
        String[] word = noPunctuation.toLowerCase().split(" ");

        int noOfNonStopWords = 0;
        boolean temp = true;


        for (int i = 0; i < word.length; i++) {


            temp = true;
            for (String s : stop_words) {
                if (word[i].equalsIgnoreCase(s))
                    temp = false;

            }
            if (temp == true)
                noOfNonStopWords++;

//            System.out.println(word[i] + " = " + temp);
        }

//        System.out.println("\nNo of NonStop words :" + noOfNonStopWords);
        return noOfNonStopWords;
    }
    int spaceCounter(String sample)
    {
        int space = 0;
        for (int i=0;i<sample.length();i++)
        {
            if(sample.charAt(i) == ' ')
                space++;
        }

        return space;
    }

    void preProcessing()
    {


        //Stop Word Removal
            extractWordsFromSentence();
        //Punctuation remover   -> called inside the above method
        //Case Conversion       -> called inside the above method


        //Text To Text Table
    }

    void extractWordsFromSentence() {
        String[] stop_words = { "a","able","about","after","all","also","am"," ","The","\r","\n",
                "an","and","any","are","as","at","be","because","been","but","by","can","cannot","could","did",
                "do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","his","how","I",
                "if","in","into","is","it","its","just","let","like","likely","may","me",
                "might","most","must","my","neither","no","nor","not","of","off",
                "often","on","only","or","other","our","own","said","say","says","she",
                "should","so","some","than","that","the","their","them","then","there",
                "these","they","this","they're","to","too","that's","us","was","we","were",
                "what","when","where","which","while","who","whom","why","will","with",
                "would","yet","you","your", "you're" };
        String noPunctuation = punctuationRemover(text);
        String[] word = noPunctuation.toLowerCase().split(" ");

        textTable = new String[word.length];
        boolean temp = true;

        int j=0;
        for (int i = 0; i < word.length; i++) {

            temp = true;
            for (String s: stop_words) {
                if(word[i].equalsIgnoreCase(s))
                    temp = false;

            }
            if(temp == true)
                textTable[j++] = word[i];

//            if(j!=0)
//            System.out.println(word[i] +" " +textTable[j-1]);
//                words.add(new Word(word[i]));
        }
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


    //Output Methods
    void showComparison()
    {
        System.out.println("Content:\n" + text);
        System.out.println("No of WORDS are : " + (spaceCounter(text) + 1));

        showSummary();
        //System.out.println("No of WORDS are : " + (spaceCounter(text) + 1));
    }
    void showSummary()
    {
        int noOfWords = 0;
        System.out.println("\n\n Summary:" );
        for (String s: summary) {
            System.out.println(s);
            noOfWords += spaceCounter(s);

        }

        System.out.println("Total Number of words are :" + noOfWords);
    }
    void showSentences()
    {
        for (Map.Entry<String, Double> entry : sentencesScore.entrySet()) {
            String key = (String) entry.getKey();
            Double value = entry.getValue();

            System.out.println(key + "=" + value);
        }
    }
    void showFrequencyTable()
    {
        for (Map.Entry<String, Integer> entry : frequencyCounter.entrySet()) {
            String key = (String) entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + "=" + value);
        }
    }

    void showTextTable()
    {
        for (String s:textTable ) {
            System.out.println(s);
        }
    }
}
