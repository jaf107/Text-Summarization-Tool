package CrossValidation;

public class CrossValidationCheck {
    public static void main(String[] args) {

        String machinemadeSummary = "Castle, return on France 2\n" +
                "\n" +
                "It is the 5 September at 20h35 that France 2 will broadcast the new season.\n" +
                " As well, each Monday, viewers will be able to watch two episodes of the 3rd season and a replay.\n" +
                "5 million viewers had been met when the first two seasons had been disseminated.\n" +
                " Released in 2009, the first season does account that ten episodes.\n" +
                " Before its success, three seasons have succeeded to the first, with a current total of 63 episodes.\n" +
                "\n" +
                "\n" +
                "Interpreted by Nathan Fillion, Richard Castle is a famous author of novels policemen who regularly makes one of the sheets to scandal.\n" +
                " 1 in a criminal investigation where a serial killer is inspired by his novels.\n" +
                " Convened by Kate Beckett, the Inspector of the criminal charge of the investigation, Castle is stimulated by this meeting and discovers a new field of action.\n" +
                " It is as well a team with the lieutenant Beckett who did not appreciate his flippancy.\n" +
                " Interpreted by Stana Katic, Kate Beckett will learn to appreciate Castle.\n" +
                " A gifted to confess the suspects, Kate is an inspector intransigent.\n";
        String referanceSummary ="Castle, return on France 2\n" +
                "\n" +
                "As well, each Monday, viewers will be able to watch two episodes of the 3rd season and a replay. Released in 2009, the first season does account that ten episodes. Before its success, three seasons have succeeded to the first, with a current total of 63 episodes. Interpreted by Nathan Fillion, Richard Castle is a famous author of novels policemen who regularly makes one of the sheets to scandal.\n" +
                "\n" +
                "Harassed by his publisher, who is none other than his ex-wife, Castle is in failure of inspiration when it becomes the suspect No. Convened by Kate Beckett, the Inspector of the criminal charge of the investigation, Castle is stimulated by this meeting and discovers a new field of action. Interpreted by Stana Katic, Kate Beckett will learn to appreciate Castle. A gifted to confess the suspects, Kate is an inspector intransigent.\n";
        CrossValidation tool = new CrossValidation(machinemadeSummary,referanceSummary);
        System.out.println(tool.toString());
        }
    }
