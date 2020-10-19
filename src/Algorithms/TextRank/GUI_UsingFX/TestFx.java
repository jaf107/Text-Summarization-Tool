package Algorithms.TextRank.GUI_UsingFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;


public class TestFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FileChooser fileChooser = new FileChooser();
                Pane pane = new FlowPane();



        Label label = new Label();

        Button button = new Button("Select File");
        button.setOnAction(e->{
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

//            System.out.println(selectedFile.toString());
            String context = "";
            try(FileReader fileReader = new FileReader(selectedFile))
            {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;
                while ((line = bufferedReader.readLine()) != null)
                {
                    System.out.println(line);
                    context+=line;
                }

            }catch (Exception exception){
                exception.printStackTrace();
            }

            label.setText(context);


        });


        Button save = new Button("Save");


        save.setOnAction(e->{
            FileChooser fileChooser1 = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser1.getExtensionFilters().add(extFilter);

            File selectedFileToWrite = fileChooser1.showSaveDialog(primaryStage);
            
            if(selectedFileToWrite != null)
            {
                saveTextToFile(label.getText(),selectedFileToWrite);
                
            }
        });

        pane.getChildren().addAll(button,label,save);


        Scene scene = new Scene(pane,1000,500);
        primaryStage.setTitle("File Opener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveTextToFile(String text, File selectedFileToWrite) {

        try {
            PrintWriter writer;
            writer = new PrintWriter(selectedFileToWrite);
            writer.println(text);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TestFx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
