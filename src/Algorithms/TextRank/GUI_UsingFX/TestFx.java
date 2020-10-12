package Algorithms.TextRank.GUI_UsingFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class TestFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Image backgroundImageSource = new Image(new FileInputStream("Images/backGround.jpg"));
        ImageView imageView = new ImageView(backgroundImageSource);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundImageSource, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);


        Text text = new Text("This is a JavaFX text.");
        text.setUnderline(true);
        Label label = new Label("This is a label");
        label.setUnderline(true);

        VBox vBox = new VBox(text,label);
        vBox.setBackground(background);

        Scene scene = new Scene(vBox, 300, 250);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
