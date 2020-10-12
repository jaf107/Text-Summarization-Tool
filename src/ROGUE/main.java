package ROGUE;

public class main {
    public static void main(String[] args) {
//        RogueTextRank rogueTextRank = new RogueTextRank();
//        rogueTextRank.getCrossValidated();
//        System.out.println(rogueTextRank.toString());
//


        RogueWordFrequency rogueWordFrequency = new RogueWordFrequency();
        rogueWordFrequency.getCrossValidated();
        System.out.println(rogueWordFrequency.toString());


        System.out.println("\n\n\n\n\n\n\n\n\n\n");


        RogueDirect rogueDirect = new RogueDirect();
        rogueDirect.getCrossValidated();
        System.out.println(rogueDirect.toString());
    }
}
