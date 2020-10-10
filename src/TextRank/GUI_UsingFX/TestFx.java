package TextRank.GUI_UsingFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class TestFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(new FileInputStream("Images/startButton.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);


        Button startButton = new Button("Sample");
        startButton.setGraphic(imageView);
//        startButton.setPrefSize(100,25);

        VBox vBox = new VBox();
        Scene scene = new Scene(vBox,300,300);

        vBox.getChildren().addAll(startButton);
        stage.setScene(scene);
        stage.show();
//        sample.setGraphic();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
