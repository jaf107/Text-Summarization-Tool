package CrossValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CrossValidationCheck {
    ArrayList<String> machineSummaries;
    ArrayList<String> referanceSummaries;
    CrossValidationCheck()
    {
        String machineSummary = "";
        String referanceSummary ="";


        File machineSummaryFile = new File("Inputs/Article1.txt");
        try(FileReader fileReader = new FileReader(machineSummaryFile))
        {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
                machineSummary+=line;
            }


        }catch (Exception e){

        }
//        machineSummaries.add(machineSummary);
        machineSummary = "";

        System.out.println("\n\n\n\n\n\n\n");
        File referanceSummaryFile = new File("ReferanceSummary/Article1.txt");
        try(FileReader fileReader = new FileReader(referanceSummaryFile))
        {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
                referanceSummary += line;
            }


        }catch (Exception e){

        }
//        referanceSummaries.add(referanceSummary);
        referanceSummary = "";
    }

    public static void main(String[] args) {
        CrossValidationCheck crossValidationCheck = new CrossValidationCheck();
    }
}
