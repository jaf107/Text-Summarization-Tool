package TextRank.Sample;

import java.util.ArrayList;

public class Tool {
    private String text = "The government is considering strategies to ensure proper education for children amid the pandemic, with improving online access and redesigning the physical class model." +
            "Students across the world are suffering immensely with their studies interrupted by the Covid-19 pandemic." +
            " There are now suggestions for launching a combined, hybrid education system, using both online and offline platforms." +
            " These suggestions came at a webinar on Thursday night and Bangladesh also agreed on the matter. " +
            "NextGenEdu, in collaboration with The Edtech Hub, hosted the virtual session on reopening schools with reimagined learning. " +
            "NextGenEdu helps educational institutions adapt to the rapidly changing landscape driven by technology," +
            " while The EdTech Hub aims to increase the use of evidence to inform decision-making about education technology." ;

    private ArrayList<String> sentences = new ArrayList<>();
//    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<ArrayList<String> > doc = new ArrayList<ArrayList<String>>();

    Tool()
    {
        preprocess();
    }
    Tool(String s)
    {
        this.text = s;
        preprocess();

    }


    void preprocess()
    {
        textToSentences();
        sentenceToWord();
    }
    void textToSentences()
    {
        String[] sentencesArray = text.split("\\.");
        for (String sen:sentencesArray ) {
            sentences.add(sen.trim());

        }

    }

    void sentenceToWord()
    {
        for (String sentence:sentences) {
            ArrayList<String> wordsAL = new ArrayList<>();
            String[] words = sentence.split(" ");

            for (String w:words ) {
                wordsAL.add(w);
            }

            doc.add(wordsAL);
        }
    }

    void showSentences()
    {
        for (String sen:sentences  ) {
            System.out.println(sen.trim());
        }
    }

    void showDoc()
    {
        for (ArrayList<String> sen:doc ) {
            for (String w: sen ) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> getDoc() {
        return doc;
    }
}
