package CrossValidation;

public class CrossValidationCheck {
    public static void main(String[] args) {

        String machinemadeSummary = "Prices of daily essentials going\n" +
                "up\n" +
                "As the prices of essentials continue to go up in the city&#39;s kitchen markets, lower- and middle-\n" +
                "income people, already grappling with the fallout of the pandemic, are finding it hard to make\n" +
                "both ends meet.\n" +
                " Our correspondents visited four kitchen markets and one wholesale market of\n" +
                "the city and found that the prices of kitchen essentials like rice, onion, oil, chicken, potato and\n" +
                "fish rose by Tk 5 to Tk 90 per kg while the prices of vegetables rose by Tk 10 to Tk 15 per kg.\n" +
                "\n" +
                "While each kg of aubergine was being sold at Tk 80, a Tk 20 jump in a week, green chillies were\n" +
                "being sold at Tk 200 per kg and local onions sold for Tk 60 to Tk 70 per kg, a hike of Tk 10 from\n" +
                "a week ago and Tk 30 from a month ago.\n" +
                "\n" +
                "Under the circumstances, the government should act immediately to check the prices of\n" +
                "essentials in the city&#39;s kitchen and wholesale markets.\n" +
                " We hope they will continue these\n" +
                "programmes until the prices of essentials are brought in to the reach of common people.\n";
        String referanceSummary = "Prices of daily essentials going up\n" +
                "\n" +
                "As the prices of essentials continue to go up in the city's kitchen markets, lower- and middle-income people, already grappling with the fallout of the pandemic, are finding it hard to make both ends meet. Our correspondents visited four kitchen markets and one wholesale market of the city and found that the prices of kitchen essentials like rice, onion, oil, chicken, potato and fish rose by Tk 5 to Tk 90 per kg while the prices of vegetables rose by Tk 10 to Tk 15 per kg.\n" +
                "Those who earn their living by doing small businesses like running fruit stores or grocery shops or selling vegetables on footpaths are finding it hard to live in the city with their families since their earnings fell drastically over the past few months. Also, the government will have to consider reducing taxes and port charges to stop the price hikes of essential imports.";
        CrossValidation tool = new CrossValidation(machinemadeSummary,referanceSummary);
        System.out.println(tool.toString());
        }
    }
