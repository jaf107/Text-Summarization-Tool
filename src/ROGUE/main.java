package ROGUE;

public class main {
    public static void main(String[] args) {
        RogueTextRank rogueTextRank = new RogueTextRank();
        rogueTextRank.getCrossValidated();
        System.out.println(rogueTextRank.toString());
    }
}
