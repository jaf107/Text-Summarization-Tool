package TextRank.GUI_UsingFX;

import TextRank.FinalProject.SummaryTool;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class Tst_FX_Main extends Application {

    Stage window;
    Scene start,menu,tool;

    TextField context_tool,summary_tool;

    Button summarize;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        // Start page Scene
        Pane startPane = new Pane();
        Label introTitle = new Label("Text Summarization Tool");
        Button startButton = new Button("Start");

        introTitle.setTranslateX(200);
        introTitle.setTranslateY(250);
        startButton.setTranslateX(600);
        startButton.setTranslateY(250);

        startPane.getChildren().addAll(introTitle,startButton);

        // Menu Scene

        Button toolButton = new Button("Tool");
        Button aboutButton = new Button("About");
        Button testButton = new Button("Testing");
        Button backButton_Menu = new Button("Back");

        Pane menuPane = new Pane();

        // Menu buttons coordinates
        toolButton.setTranslateX(500);
        toolButton.setTranslateY(140);
        aboutButton.setTranslateX(500);
        aboutButton.setTranslateY(240);
        testButton.setTranslateX(500);
        testButton.setTranslateY(340);
        backButton_Menu.setTranslateX(50);
        backButton_Menu.setTranslateY(400);



        menuPane.getChildren().addAll(toolButton,aboutButton,testButton,backButton_Menu);
        menu = new Scene(menuPane,1000,500);



        start = new Scene(startPane,1000,500);

        Font mFont = new Font("Helvetica",Font.BOLD,12);
        window.setTitle("Text Summarizer Tool");
        window.setScene(start);
        window.show();

        // Tool page
        Pane toolPane = new Pane();

        summarize = new Button("Summarize");
        Button textRankButton = new Button("TextRank");
        Button directButton = new Button("Manual");
        Button wordFrequencyButton = new Button("WordFrequency");
        Button backButton_Tool = new Button("Back");

        context_tool = new TextField();
        summary_tool = new TextField();

//        context_tool.setPrefColumnCount(50);
        context_tool.setPrefSize(450,400);
        context_tool.setPromptText("Enter the article for summarization");

        summary_tool.setPrefSize(450,400);
        summary_tool.setPromptText("Press summarize button to get the summary");
        tool = new Scene(toolPane,1000,500);



        toolPane.getChildren().addAll(summarize,context_tool,summary_tool,textRankButton,directButton,wordFrequencyButton,backButton_Tool);
//        toolPane.getChildren().addAll(context,summary);
        // Coordinates
        summarize.setTranslateX(400);
        summarize.setTranslateY(10);
        textRankButton.setTranslateX(725);
        textRankButton.setTranslateY(10);
        directButton.setTranslateX(800);
        directButton.setTranslateY(10);
        wordFrequencyButton.setTranslateX(875);
        wordFrequencyButton.setTranslateY(10);
        backButton_Tool.setTranslateX(30);
        backButton_Tool.setTranslateY(460);
        context_tool.setTranslateX(30);
        context_tool.setTranslateY(45);
        summary_tool.setTranslateX(530);
        summary_tool.setTranslateY(45);





















        // Buttons set on  Action
        // Start
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu);
            }
        });

        //Menu
        toolButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
        window.setScene(tool);
            }
        });
        aboutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        backButton_Menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(start);
            }
        });
        backButton_Tool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu);
            }
        });

        //Tool Pane
        summarize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                SummaryTool textRankTool = new SummaryTool(context);
                String summary = textRankTool.getSummary();

                summary_tool.setText(summary);

            }
        });

        textRankButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                SummaryTool textRankTool = new SummaryTool(context);
                String summary = textRankTool.getSummary();

                summary_tool.setText(summary);
            }
        });

        wordFrequencyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                org.wordFrequencyAlgorithm.SummaryTool wordFreqTool = new org.wordFrequencyAlgorithm.SummaryTool(context);

                String summary = wordFreqTool.getSummary();

                summary_tool.setText(summary);
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
