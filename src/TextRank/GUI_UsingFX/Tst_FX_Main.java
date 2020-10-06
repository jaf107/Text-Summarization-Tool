package TextRank.GUI_UsingFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Tst_FX_Main extends Application {

    Stage window;
    Scene start,menu,tool;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        // Start page Scene
        Pane startPane = new Pane();
        Label introTitle = new Label("Text Summarization Tool");
        Button startButton = new Button("Start");

        introTitle.setTranslateX(100);
        introTitle.setTranslateY(250);
        startButton.setTranslateX(300);
        startButton.setTranslateY(250);

        startPane.getChildren().addAll(introTitle,startButton);

        // Menu Scene

        Button toolButton = new Button("Tool");
        Button aboutButton = new Button("About");
        Button testButton = new Button("Testing");
        Button backButton_Menu = new Button("Back");

        Pane menuPane = new Pane();

        // Menu buttons coordinates
        toolButton.setTranslateX(250);
        toolButton.setTranslateY(140);
        aboutButton.setTranslateX(250);
        aboutButton.setTranslateY(240);
        testButton.setTranslateX(250);
        testButton.setTranslateY(340);
        backButton_Menu.setTranslateX(50);
        backButton_Menu.setTranslateY(400);



        menuPane.getChildren().addAll(toolButton,aboutButton,testButton,backButton_Menu);
        menu = new Scene(menuPane,500,500);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Im here");
                window.setScene(menu);
            }
        });

        start = new Scene(startPane,500,500);

        window.setTitle("Text Summarizer Tool");
        window.setScene(start);
        window.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
