package Algorithms.WordFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SummaryTool {



    String text = "Battling pandemic fatigue: Some feel burned out as the Covid-19 outbreak drags on with no end in sight. Freelance writer Sng Ler Jun has been taking on more writing assignments since March to earn extra money for his family and himself." +
            "" +
            "His 55-year-old mother was retrenched from a part-time job as a food promoter in February and his father, a 59-year-old taxi driver, has seen earnings fall since the start of the coronavirus pandemic." +
            "" +
            "As a result, the 24-year-old, who is doing a communications degree from the University at Buffalo at the Singapore Institute of Management, said he feels \"pressured to work harder\"." +
            "" +
            "The worry of finding a stable job after he graduates in December keeps him up at night. \"I'm doing unpaid writing work to beef up my resume so it'll help in my job hunt,\" said Sng, who is an only child." +
            "" +
            "Still, he feels \"plagued by the uncertainty\" as he does not know when the economy will improve. \"It's demoralising thinking about it and I feel burned out.\"" +
            "" +
            "Because of this, his mood and energy has been low and he no longer enjoys the walks he used to take in the neighbourhood." +
            "" +
            "Dr Annabelle Chow, principal clinical psychologist at Annabelle Psychology, said the burnout a person experiences due to effects brought about by Covid-19 is a sign of pandemic fatigue." +
            "" +
            "\"Pandemic fatigue describes a mental state where a prolonged, heightened state of fear and caution leads to a form of burnout. Although it is not classified as a mental disorder, the effects of pandemic fatigue are nevertheless real and have an impact on those experiencing it,\" she said." +
            "" +
            "Signs include reduced socialising with others; feeling restless, sad, helpless, unmotivated and frustrated; being irritable and sensitive; and having low mood and energy, and insomnia." +
            "" +
            "Long-term worries about a pandemic can take a toll on mental and emotional health and may result in the worsening of mental health conditions and chronic health problems." +
            "" +
            "It may also lead to headaches, an inability to focus, digestive issues, insomnia and a weakened immune system, ultimately affecting a person's overall daily functioning." +
            "" +
            "Terri Chen, senior clinical psychologist at the National University Hospital's (NUH) Department of Psychological Medicine, said it is likely that people started feeling these effects in April when the circuit breaker here was extended." +
            "" +
            "The restrictions were a \"drastic change\" to people's daily routine and way of life." +
            "" +
            "\"Everyone was required to adapt in a short amount of time and many people were accepting of these restrictions as they thought it was a short-term measure to deal with the virus,\" said Chen, who is head of psychology at NUH." +
            "" +
            "\"But when the circuit breaker was extended and subsequent announcements about phase one and phase two were made, it was hard for people to keep up, and even more so with no clear end in sight.\"" +
            "" +
            "Dr Chow said seniors, children, caregivers, front-line workers, those who are living alone or socially isolated, and those who already struggle with depression and anxiety have an increased risk of getting pandemic fatigue." +
            "" +
            "Working adults have also been hit hard. Dr Geraldine Tan, director and principal psychologist at The Therapy Room, started noticing signs of pandemic fatigue in her clients last month." +
            "" +
            "\"The uncertainty of the job market and the impending crisis get them down. The breaks they used to take overseas are now non-existent and the work they do has taken a radical shift for some, especially if they are working from home,\" she said." +
            "" +
            "\"Each day becomes more routine and mundane. People in Singapore are very used to travelling and now we appear to be imprisoned on our island.\"" +
            "" +
            "For those working or studying from home, the frequent need to be connected via video conferencing also contributes to the fatigue." +
            "" +
            "People report feeling exhausted after virtual interactions, a phenomenon known as \"Zoom fatigue\", although it also applies to other video-conferencing platforms like Google Hangouts, Skype or FaceTime." +
            "" +
            "Sng, who has been attending online classes since late April, said he sometimes does not switch on his webcam during lessons." +
            "" +
            "\"I feel like the lack of a physical presence makes me less accountable. I've put on 5kg since the circuit breaker and I don't want people to see me looking like a mess at home. I was also sick of looking at my own face on the screen.\"" +
            "" +
            "NUH's Chen said a lot of energy is required to pay attention to non-verbal communication, which is harder to pick up over video conferencing." +
            "" +
            "\"The multi-person screens tax the brain further from the need to process and decode all the information at once. Staring at your own face during the meetings can be stressful too,\" she added." +
            "" +
            "One danger of pandemic fatigue is that people may drop their guard against the virus." +
            "" +
            "According to a Sunday Times survey of 1,000 people aged 16 and above, people in Singapore are becoming weary of the rules to limit the spread of the coronavirus." +
            "" +
            "It showed that 44 per cent of people are tired of following the necessary health measures. These include having to wear a mask, checking in with SafeEntry, limiting the size of physical gatherings with friends and family, and not being able to travel overseas." +
            "" +
            "Dr Chow said the constant barrage of Covid-19 news and advisories could actually be desensitising and complacency may set in." +
            "" +
            "\"Repeated exposure to pandemic-related news will eventually diminish the initial feelings of anxiety and caution. Consequently, we may begin to engage in behaviours that were initially inhibited by the anxiety responses, such as not adhering to safe distancing rules or washing our hands as regularly as we did before,\" she said." +
            "" +
            "Habituation - the progressive decrease in response, such as feelings of anxiety, after repeated exposure to a stimulus - has caused people to become less careful or conscious about the precautions they need to take than they were at the start of the pandemic, said Chen." +
            "" +
            "\"This means that over time - especially if we or anyone we knew did not get Covid-19 - we are likely to be less careful or conscious about the precautions as it would appear that there is less of a need to maintain such levels of vigilance,\" she said." +
            "" +
            "While it is normal to drop our guard when we see no end in sight, a reminder of the benefits of maintaining precautions and the consequences of not doing so would help people stay vigilant to fight Covid-19, Chen added." +
            "" +
            "But musician Joe Chahal, 35, said he feels \"extremely tired\" of the situation even though he complies with the measures." +
            "" +
            "\"I find it difficult to breathe comfortably with a mask and I don't feel like leaving my house because I have to wear it. There's also the hassle of constantly having to check in to places with SafeEntry. There are long queues just to enter a mall or a shop on weekends.\"" +
            "" +
            "Because of this, he hardly goes out and does not meet his friends much now." +
            "" +
            "Dr Chow cautioned that social avoidance and distancing can make people feel isolated and lonely, and may increase stress and anxiety." +
            "" +
            "Chen advised people to seek help from a psychologist if they experience persistent anxiety, hopelessness or sadness for more than two weeks, which in turn affects their performance and relationships." +
            "" +
            "While it is normal to feel weary in response to the pandemic, it is important to remember that \"we are not alone in our struggles\", she said." +
            "" +
            "\"This is a marathon and not a short sprint, so people need to manage their expectations and pace themselves so that they are able to go the distance,\" she added." +
            "" +
            "\"It is important to remind ourselves that we are doing the best we can in an unprecedented situation that we are all experiencing for the first time in our lives.\"" +
            "" +
            "HOW TO COPE WITH PANDEMIC FATIGUE" +
            "Terri Chen, head of psychology and senior clinical psychologist at the National University Hospital's department of psychological medicine, gives some tips." +
            "" +
            "BE AWARE: We cannot make changes if we are not aware of what is going on within us. When we are busy, it is easy to overlook emotions and behaviours that are warning signs for us. Practise awareness to take care of your mental health. Take some time to check in with yourself daily. This can be as short as one minute a day to observe and describe to yourself what you are thinking and feeling within." +
            "" +
            "BE CREATIVE: Many of the ways we use to recharge have been thwarted or impacted by pandemic restrictions. Short getaways, for instance, are no longer an option. Neither are large gatherings, which feed our innate social needs." +
            "" +
            "Being creative and open to new ideas and experiences can help you cope in the interim. For instance, you can travel vicariously with friends by having a \"watch party\" of a travel show and make a fantasy list of future travel plans together." +
            "" +
            "BE KIND AND COMPASSIONATE: There are many things that are not within our control at this moment, which could leave us feeling angry and frustrated. This can lead to criticisms being directed towards ourselves or others, which may worsen our mood." +
            "" +
            "Show kindness to yourself or others through one act a day. Research has shown that this can help us feel happier and it also boosts our immune system and energy levels." +
            "" +
            "BE PATIENT: We do not know when the coronavirus pandemic will end and it is hard to be patient with the safety restrictions indefinitely. Make space for emotions, as it is impossible to think logically 100 per cent of the time." +
            "" +
            "Try the \"five, four, three, two, one\" technique to relax: Look around you and name them aloud as you notice them: five things you can see, four things you can feel, three things you can hear, two things you can smell and one thing you can taste." +
            "" +
            "BE EFFECTIVE: There are many tips and suggestions on how to cope with the pandemic, such as practising mindfulness or working out, and it can be overwhelming - and tiring - to try many things at once." +
            "" +
            "It is more effective to identify what need - physical, emotional, intellectual or spiritual - is most pressing and try one technique at a time to gauge if it helps you." +
            "" +
            "TALK TO SOMEONE: Seek help if you notice that you have signs of pandemic fatigue." +
            "" +
            "Talking to a professional or someone you trust, having them listen to what you are going through and getting support can help regulate emotions and reduce stress.";
//    String text = "Those Who Are Resilient Stay In The Game Longer\n" +
//        "“On the mountains of truth you can never climb in vain: either you will reach a point higher up today, or you will be training your powers so that you will be able to climb higher tomorrow.” — Friedrich Nietzsche\n" +
//        "Challenges and setbacks are not meant to defeat you, but promote you. However, I realise after many years of defeats, it can crush your spirit and it is easier to give up than risk further setbacks and disappointments. Have you experienced this before? To be honest, I don’t have the answers. I can’t tell you what the right course of action is; only you will know. However, it’s important not to be discouraged by failure when pursuing a goal or a dream, since failure itself means different things to different people. To a person with a Fixed Mindset failure is a blow to their self-esteem, yet to a person with a Growth Mindset, it’s an opportunity to improve and find new ways to overcome their obstacles. Same failure, yet different responses. Who is right and who is wrong? Neither. Each person has a different mindset that decides their outcome. Those who are resilient stay in the game longer and draw on their inner means to succeed.\n" +
//        "I’ve coached many clients who gave up after many years toiling away at their respective goal or dream. It was at that point their biggest breakthrough came. Perhaps all those years of perseverance finally paid off. It was the 19th Century’s minister Henry Ward Beecher who once said: “One’s best success comes after their greatest disappointments.” No one knows what the future holds, so your only guide is whether you can endure repeated defeats and disappointments and still pursue your dream. Consider the advice from the American academic and psychologist Angela Duckworth who writes in Grit: The Power of Passion and Perseverance: “Many of us, it seems, quit what we start far too early and far too often. Even more than the effort a gritty person puts in on a single day, what matters is that they wake up the next day, and the next, ready to get on that treadmill and keep going.”\n" +
//        "I know one thing for certain: don’t settle for less than what you’re capable of, but strive for something bigger. Some of you reading this might identify with this message because it resonates with you on a deeper level. For others, at the end of their tether the message might be nothing more than a trivial pep talk. What I wish to convey irrespective of where you are in your journey is: NEVER settle for less. If you settle for less, you will receive less than you deserve and convince yourself you are justified to receive it.\n" +
//        "“Two people on a precipice over Yosemite Valley” by Nathan Shipps on Unsplash\n" +
//        "Develop A Powerful Vision Of What You Want\n" +
//        "“Your problem is to bridge the gap which exists between where you are now and the goal you intend to reach.” — Earl Nightingale\n" +
//        "I recall a passage my father often used growing up in 1990s: “Don’t tell me your problems unless you’ve spent weeks trying to solve them yourself.” That advice has echoed in my mind for decades and became my motivator. Don’t leave it to other people or outside circumstances to motivate you because you will be let down every time. It must come from within you. Gnaw away at your problems until you solve them or find a solution. Problems are not stop signs, they are advising you that more work is required to overcome them. Most times, problems help you gain a skill or develop the resources to succeed later. So embrace your challenges and develop the grit to push past them instead of retreat in resignation. Where are you settling in your life right now? Could you be you playing for bigger stakes than you are? Are you willing to play bigger even if it means repeated failures and setbacks? You should ask yourself these questions to decide whether you’re willing to put yourself on the line or settle for less. And that’s fine if you’re content to receive less, as long as you’re not regretful later.\n" +
//        "If you have not achieved the success you deserve and are considering giving up, will you regret it in a few years or decades from now? Only you can answer that, but you should carve out time to discover your motivation for pursuing your goals. It’s a fact, if you don’t know what you want you’ll get what life hands you and it may not be in your best interest, affirms author Larry Weidel: “Winners know that if you don’t figure out what you want, you’ll get whatever life hands you.” The key is to develop a powerful vision of what you want and hold that image in your mind. Nurture it daily and give it life by taking purposeful action towards it.\n" +
//        "Vision + desire + dedication + patience + daily action leads to astonishing success. Are you willing to commit to this way of life or jump ship at the first sign of failure? I’m amused when I read questions written by millennials on Quora who ask how they can become rich and famous or the next Elon Musk. Success is a fickle and long game with highs and lows. Similarly, there are no assurances even if you’re an overnight sensation, to sustain it for long, particularly if you don’t have the mental and emotional means to endure it. This means you must rely on the one true constant in your favour: your personal development. The more you grow, the more you gain in terms of financial resources, status, success — simple. If you leave it to outside conditions to dictate your circumstances, you are rolling the dice on your future.\n" +
//        "So become intentional on what you want out of life. Commit to it. Nurture your dreams. Focus on your development and if you want to give up, know what’s involved before you take the plunge. Because I assure you, someone out there right now is working harder than you, reading more books, sleeping less and sacrificing all they have to realise their dreams and it may contest with yours. Don’t leave your dreams to chance.";

    String textTable[];
    String sentences[];


    HashMap<String,Integer> frequencyCounter = new HashMap<>();
    HashMap<String,Double> sentencesScore = new HashMap<>();
    ArrayList<String> summary = new ArrayList<>();

    //Main Algorithm
    public SummaryTool(String context)
    {
        this.text = context;
        sentences = new String[fullstopCounter(text)];
        sentences = text.split("\\.");
//        textTable = context.split(" ");
        mainProcess();

    }
    void mainProcess()
    {

        tokenizeSentences();
        extractWordsFromSentence();
        createWordFrequencyTable();
        scoreSentences();
        findThreshold();
        generateSummary();
    }

    public void setText(String text) {
        this.text = text;
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

        for(int i = 0 ;i<sentences.length;i++){
            sentences[i] += ". ";

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
    int fullstopCounter(String sample)
    {
        int fullstop = 0;
        for(int i=0;i<sample.length();i++)
        {
            if(sample.charAt(i) == '.')
                fullstop++;
        }
        return fullstop;
    }
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

    public String getSummary()
    {
        String summaryString = "";


//        System.out.println("\n\n Summary:" );
        for (String s: summary) {
            summaryString += s;
//            summaryString+= ". ";

        }
        return summaryString;

    }

    void showSummary()
    {

//        allShowFunctions();
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
