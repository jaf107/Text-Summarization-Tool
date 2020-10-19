package Algorithms.TextRank.GUI_UsingFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class TestFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FileChooser fileChooser = new FileChooser();
                Pane pane = new Pane();



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

        pane.getChildren().addAll(button,label);


        Scene scene = new Scene(pane,1000,500);
        primaryStage.setTitle("File Opener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
