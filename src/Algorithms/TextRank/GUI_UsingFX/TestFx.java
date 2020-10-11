package Algorithms.TextRank.GUI_UsingFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class TestFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text("This is a JavaFX text.");
        text.setUnderline(true);
        Label label = new Label("This is a label");
        label.setUnderline(true);

        Scene scene = new Scene(new VBox(text,label), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
