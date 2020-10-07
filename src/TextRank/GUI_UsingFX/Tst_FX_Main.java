package TextRank.GUI_UsingFX;

import TextRank.FinalProject.SummaryTool;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Tst_FX_Main extends Application {

    Stage window;
    Scene start,menu,tool;


    TextArea context_tool,summary_tool;

    Button summarize;
    @Override
    public void start(Stage stage) throws Exception {

        String buttonCSS = "-fx-background-color:\n" +
                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                "    -fx-background-radius: 8,7,6;\n" +
                "    -fx-background-insets: 0,1,2;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";


        // Start page Scene
        Pane startPane = new Pane();
        Label introTitle = new Label("Text Summarization Tool");
        introTitle.setFont(Font.font("Arial",FontWeight.BOLD,48));
        Button startButton = new Button("Start");
//        Tooltip startToolTip = new Tooltip("Start Button");
        Tooltip.install(startButton,new Tooltip("Start Button"));
        startButton.setStyle(buttonCSS);
        startButton.setScaleX(4);
        startButton.setScaleY(4);

        introTitle.setTranslateX(200);
        introTitle.setTranslateY(150);
        startButton.setTranslateX(480);
        startButton.setTranslateY(300);

        startPane.getChildren().addAll(introTitle,startButton);

        // Menu Scene

        Button toolButton = new Button("Tool");
        Tooltip.install(toolButton,new Tooltip("Text Summarizer Tool "));
        toolButton.setStyle(buttonCSS);
        toolButton.setScaleX(2);
        toolButton.setScaleY(2);

        Button aboutButton = new Button("About");
        aboutButton.setStyle(buttonCSS);
        Tooltip.install(aboutButton,new Tooltip("About section"));
        aboutButton.setScaleX(2);
        aboutButton.setScaleY(2);

        Button evaluationButton = new Button("Evaluation");
        Tooltip.install(evaluationButton,new Tooltip("Evaluation section"));
        evaluationButton.setStyle(buttonCSS);
        evaluationButton.setScaleX(2);
        evaluationButton.setScaleY(2);

        Button backButton_Menu = new Button("Back");
        Tooltip.install(backButton_Menu,new Tooltip("Get back to Start"));
        backButton_Menu.setStyle(buttonCSS);
        backButton_Menu.setScaleX(1);
        backButton_Menu.setScaleY(1);

        Pane menuPane = new Pane();

        Label menuLabel = new Label("Menu");
        menuLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        menuLabel.setTextFill(Color.BLACK);

        // Menu buttons coordinates
        toolButton.setTranslateX(500);
        toolButton.setTranslateY(140);
        aboutButton.setTranslateX(500);
        aboutButton.setTranslateY(240);
        evaluationButton.setTranslateX(500);
        evaluationButton.setTranslateY(340);
        backButton_Menu.setTranslateX(50);
        backButton_Menu.setTranslateY(400);
        menuLabel.setTranslateX(50);
        menuLabel.setTranslateY(30);

        toolButton.setPrefSize(90,30);
        aboutButton.setPrefSize(90,30);
        evaluationButton.setPrefSize(90,30);


        menuPane.getChildren().addAll(toolButton,aboutButton,evaluationButton,backButton_Menu,menuLabel);
        menu = new Scene(menuPane,1000,500);
        start = new Scene(startPane,1000,500);


        // Tool page
        Pane toolPane = new Pane();
        Label toolLabel = new Label("Text Summarization Tool");
        toolLabel.setFont(Font.font("Arial",FontWeight.BOLD,20));
        toolLabel.setTextFill(Color.BLACK);

        summarize = new Button("Summarize");
        Tooltip.install(summarize,new Tooltip("Summarize text\nDefault method: TextRank"));
        Button textRankButton = new Button("TextRank");
        Tooltip.install(textRankButton,new Tooltip("Text Rank Algorithm"));
        Button directButton = new Button("Manual");
        Tooltip.install(directButton,new Tooltip("Manual Method"));
        Button wordFrequencyButton = new Button("WordFrequency");
        Tooltip.install(wordFrequencyButton,new Tooltip("Word Frequency Algorithm"));
        Button backButton_Tool = new Button("Back");
        Tooltip.install(backButton_Tool,new Tooltip("Get back to Menu"));
        Button statsButton = new Button("Stats");
        Tooltip.install(statsButton,new Tooltip("Statistical Analysis of the above data"));

        context_tool = new TextArea();
        summary_tool = new TextArea();

//        context_tool.setPrefColumnCount(50);
        context_tool.setPrefSize(450,400);
        context_tool.setPromptText("Enter the article for summarization");

        summary_tool.setPrefSize(450,400);
        summary_tool.setPromptText("Press summarize button to get the summary");

        context_tool.setWrapText(true);
        summary_tool.setWrapText(true);

        tool = new Scene(toolPane,1000,500);



        toolPane.getChildren().addAll(statsButton,toolLabel,summarize,context_tool,summary_tool,textRankButton,directButton,wordFrequencyButton,backButton_Tool);
//        toolPane.getChildren().addAll(context,summary);
        // Coordinates
        toolLabel.setTranslateX(30);
        toolLabel.setTranslateY(10);
        summarize.setTranslateX(370);
        summarize.setTranslateY(10);
        summarize.setStyle(buttonCSS);
        textRankButton.setTranslateX(625);
        textRankButton.setTranslateY(10);
        textRankButton.setStyle(buttonCSS);
        directButton.setTranslateX(750);
        directButton.setTranslateY(10);
        directButton.setStyle(buttonCSS);
        wordFrequencyButton.setTranslateX(875);
        wordFrequencyButton.setTranslateY(10);
        wordFrequencyButton.setStyle(buttonCSS);
        backButton_Tool.setTranslateX(30);
        backButton_Tool.setTranslateY(460);
        backButton_Tool.setStyle(buttonCSS);
        context_tool.setTranslateX(30);
        context_tool.setTranslateY(45);
        summary_tool.setTranslateX(530);
        summary_tool.setTranslateY(45);
        statsButton.setTranslateX(930);
        statsButton.setTranslateY(460);
        statsButton.setStyle(buttonCSS);




        summarize.setPrefSize(105,25);
        textRankButton.setPrefSize(105,25);
        directButton.setPrefSize(105,25);
        wordFrequencyButton.setPrefSize(105,25);
        statsButton.setPrefSize(50,25);
        backButton_Tool.setPrefSize(50,25);

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
        evaluationButton.setOnAction(new EventHandler<ActionEvent>() {
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




        window = stage;

        window.setTitle("Text Summarizer Tool");

        window.setScene(start);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
