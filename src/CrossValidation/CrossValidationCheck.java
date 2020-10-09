package CrossValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CrossValidationCheck {
    private ArrayList<CrossValidation> articleEvaluation;

    CrossValidationCheck()
    {
        articleEvaluation = new ArrayList<CrossValidation>();
    }


    @Override
    public String toString() {
        return "CrossValidationCheck{" +
                "articleEvaluation=" + articleEvaluation +
                '}';
    }

    public void getCrossValidated() {
        int counter = 0;


        for (int i= 0;i<8;i++) {
            counter++;
            String article = "Article" + counter + ".txt";

            String referanceSummary = "";
            String machineSummary = "";
            File file = new File("Evaluation/TextRankSummary/" + article);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    machineSummary += line;
                    machineSummary += "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            file = new File("Evaluation/ReferanceSummary/" + article);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    referanceSummary += line;
                    referanceSummary += "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            articleEvaluation.add(new CrossValidation(machineSummary,referanceSummary));
//            System.out.println(referanceSummary + "\n\n\n" + machineSummary);
        }



    }
}
