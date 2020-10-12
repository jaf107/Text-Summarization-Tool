package Algorithms.TextRank.GUI_UsingFX;

import ROGUE.CrossValidation;
import ROGUE.RogueDirect;
import ROGUE.RogueTextRank;
import Algorithms.TextRank.FinalProject.SummaryStatistics;
import Algorithms.TextRank.FinalProject.SummaryTool;
import ROGUE.RogueWordFrequency;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Tst_FX_Main extends Application {

    Stage window;
    Scene start, menu, tool;


    TextArea context_tool, summary_tool;

    Button summarize;

    private static DecimalFormat df = new DecimalFormat("0.00");

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

        // BackButtons Image
        FileInputStream backImageInputStream = new FileInputStream("Images/back2.png");
        Image backImage = new Image(backImageInputStream);
        ImageView backImageView = new ImageView(backImage);
        backImageView.setFitHeight(10);
        backImageView.setPreserveRatio(true);


        // Background
        Image startImage = new Image(new FileInputStream("Images/Background/ts.jpg"));
        ImageView startBackgroundImageView = new ImageView(startImage);
        BackgroundImage startBackgroundImage = new BackgroundImage(startImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background startBackground = new Background(startBackgroundImage);

        int backButtonWidth = 70;
        int backButtonHeight = 25;


        // Start page Scene
        Pane startPane = new Pane();
        startPane.setBackground(startBackground);
//        Label introTitle = new Label("Text Summarization Tool");
//        introTitle.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        Button startButton = new Button("Start");
//        Tooltip startToolTip = new Tooltip("Start Button");
        Tooltip.install(startButton, new Tooltip("Start Button"));
        startButton.setStyle(buttonCSS);
        startButton.setScaleX(4);
        startButton.setScaleY(4);

//        introTitle.setTranslateX(200);
//        introTitle.setTranslateY(150);
        startButton.setTranslateX(480);
        startButton.setTranslateY(300);

        startPane.getChildren().addAll( startButton);

        // Image
        Image image = new Image(new FileInputStream("Images/icons8-start-48.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(10);
        imageView.setPreserveRatio(true);

        startButton.setGraphic(imageView);

        // Menu Scene

        Button toolButton = new Button("Tool");
        Tooltip.install(toolButton, new Tooltip("Text Summarizer Tool "));
        toolButton.setStyle(buttonCSS);
        toolButton.setScaleX(2);
        toolButton.setScaleY(2);

        Button aboutButton = new Button("About");
        aboutButton.setStyle(buttonCSS);
        Tooltip.install(aboutButton, new Tooltip("About section"));
        aboutButton.setScaleX(2);
        aboutButton.setScaleY(2);

        Button evaluationButton = new Button("Evaluation");
        Tooltip.install(evaluationButton, new Tooltip("Evaluation section"));
        evaluationButton.setStyle(buttonCSS);
        evaluationButton.setScaleX(2);
        evaluationButton.setScaleY(2);

        Button backButton_Menu = new Button("Back");
        Tooltip.install(backButton_Menu, new Tooltip("Get back to Start"));
        backButton_Menu.setStyle(buttonCSS);
        backButton_Menu.setGraphic(backImageView);
        backButton_Menu.setScaleX(1);
        backButton_Menu.setScaleY(1);

        // Images - tool

        Image toolImage = new Image(new FileInputStream("Images/tool1.png"));
        ImageView toolImageView = new ImageView(toolImage);
        toolImageView.setFitHeight(15);
        toolImageView.setPreserveRatio(true);
        toolButton.setGraphic(toolImageView);

        Image aboutImage = new Image(new FileInputStream("Images/about.png"));
        ImageView aboutImageView = new ImageView(aboutImage);
        aboutImageView.setFitHeight(15);
        aboutImageView.setPreserveRatio(true);
        aboutButton.setGraphic(aboutImageView);

        Image evaluationImage = new Image(new FileInputStream("Images/evaluation.png"));
        ImageView evaluationImageView = new ImageView(evaluationImage);
        evaluationImageView.setFitHeight(15);
        evaluationImageView.setPreserveRatio(true);
        evaluationButton.setGraphic(evaluationImageView);

        Pane menuPane = new Pane();

        Image allImage = new Image(new FileInputStream("Images/Background/ts_light_2.png"));
        BackgroundImage allBackgroundImage = new BackgroundImage(allImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background allBackground = new Background(allBackgroundImage);


        Image allaboutImage = new Image(new FileInputStream("Images/Background/ts_light_2.png"));
        BackgroundImage allBgroundImage = new BackgroundImage(allaboutImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background allAboutBg = new Background(allBgroundImage);

        menuPane.setBackground(allBackground);

        Label menuLabel = new Label("Menu");
        menuLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        menuLabel.setTextFill(Color.BLACK);

        // Menu buttons coordinates
        toolButton.setTranslateX(480);
        toolButton.setTranslateY(140);
        aboutButton.setTranslateX(480);
        aboutButton.setTranslateY(240);
        evaluationButton.setTranslateX(480);
        evaluationButton.setTranslateY(340);
        backButton_Menu.setTranslateX(30);
        backButton_Menu.setTranslateY(460);
        backButton_Menu.setPrefSize(backButtonWidth,backButtonHeight);
        menuLabel.setTranslateX(50);
        menuLabel.setTranslateY(30);

        toolButton.setPrefSize(90, 30);
        aboutButton.setPrefSize(90, 30);
        evaluationButton.setPrefSize(90, 30);


        menuPane.getChildren().addAll(toolButton, aboutButton, evaluationButton, backButton_Menu, menuLabel);
        menu = new Scene(menuPane, 1000, 500);
        start = new Scene(startPane, 1000, 500);

        // About page

        Pane aboutPane = new Pane();
        aboutPane.setBackground(allAboutBg);

        Label aboutTitle = new Label("Text Summarization Tool");
        aboutTitle.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
        aboutTitle.setTextFill(Color.BLACK);
        aboutTitle.setUnderline(true);


        Text aboutText = new Text("Text Summarizer is a tool used to generate a precise summary from a voluminous text. It also delivers accurate summary which can fluently pass the intended messages.\n" +
                "\n\nThere are two main types of summarizing text in Natural language Process.\n" +
                "\n\n\bAbstraction : entails paraphrasing and shortening\n" +
                "\n\bExtraction   : involves scoring sentences and extracting the important ones'\n");
        aboutText.setFont(Font.font("Arial",FontWeight.EXTRA_LIGHT,20));
        aboutText.setWrappingWidth(900);



        Button algorithmsButton = new Button("Algorithms");
        Tooltip.install(algorithmsButton, new Tooltip("Algorithms used in Summarization\n1. Text Rank\n2. Direct\n3. Word Frequency"));
        algorithmsButton.setStyle(buttonCSS);
        algorithmsButton.setScaleX(1.5);
        algorithmsButton.setScaleY(1.5);

        Button textRankButton_about = new Button("Text Rank");
        Tooltip.install(textRankButton_about, new Tooltip("Text Rank Algorithm"));
        textRankButton_about.setStyle(buttonCSS);

        Button backButton_about = new Button("Back");
        Tooltip.install(backButton_about, new Tooltip("Back"));
        backButton_about.setGraphic(backImageView);
        backButton_about.setTranslateX(30);
        backButton_about.setTranslateY(460);
        backButton_about.setStyle(buttonCSS);
        backButton_about.setPrefSize(backButtonWidth,backButtonHeight);


        Image algorithmsImage = new Image(new FileInputStream("Images/algorithms.png"));
        ImageView algorithmsImageView = new ImageView(algorithmsImage);
        algorithmsImageView.setFitHeight(10);
        algorithmsImageView.setPreserveRatio(true);
        algorithmsButton.setGraphic(algorithmsImageView);

        // Coordinates

        aboutTitle.setTranslateX(30);
        aboutTitle.setTranslateY(25);

        algorithmsButton.setTranslateX(800);
        algorithmsButton.setTranslateY(450);

        aboutText.setTranslateX(30);
        aboutText.setTranslateY(100);










        aboutPane.getChildren().addAll(algorithmsButton,aboutTitle,backButton_about,aboutText);
        Scene aboutScene = new Scene(aboutPane,1000,500);



        // Tool page
        Pane toolPane = new Pane();
        toolPane.setBackground(allBackground);
        Label toolLabel = new Label("Text Summarization Tool");
        toolLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        toolLabel.setTextFill(Color.BLACK);

        summarize = new Button("Summarize");
        Tooltip.install(summarize, new Tooltip("Summarize text\nDefault method: TextRank"));
        Button textRankButton = new Button("TextRank");
        Tooltip.install(textRankButton, new Tooltip("Text Rank Algorithm"));
        Button directButton = new Button("Direct");
        Tooltip.install(directButton, new Tooltip("Manual Method"));
        Button wordFrequencyButton = new Button("WordFrequency");
        Tooltip.install(wordFrequencyButton, new Tooltip("Word Frequency Algorithm"));
        Button backButton_Tool = new Button("Back");
        Tooltip.install(backButton_Tool, new Tooltip("Get back to Menu"));
        backButton_Tool.setGraphic(backImageView);
        Button statsButton = new Button("Stats");
        Tooltip.install(statsButton, new Tooltip("Statistical Analysis of the above data"));

        // Delete Button
        Button deleteButton = new Button("Delete");
        Tooltip.install(deleteButton, new Tooltip("Delete all the texts in context"));


        // Sample run Button
        Button runSampleButton = new Button("Sample");
        Tooltip.install(runSampleButton, new Tooltip("Run Sample Data"));

        context_tool = new TextArea();
        summary_tool = new TextArea();
        Label summaryLabel = new Label("Summary:");
        summaryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        summaryLabel.setTextFill(Color.BLACK);
        Label contextLabel = new Label("Context:");
        contextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        contextLabel.setTextFill(Color.BLACK);

//        context_tool.setPrefColumnCount(50);
        context_tool.setPrefSize(450, 370);
        context_tool.setPromptText("Enter the article for summarization");

        summary_tool.setPrefSize(450, 370);
        summary_tool.setPromptText("Press summarize button to get the summary");

        context_tool.setWrapText(true);
        summary_tool.setWrapText(true);

        //Images - tool

        Image summarizeImage = new Image(new FileInputStream("Images/summarizeButton.png"));
        ImageView summarizeImageView = new ImageView(summarizeImage);
        summarizeImageView.setFitHeight(10);
        summarizeImageView.setPreserveRatio(true);
        summarize.setGraphic(summarizeImageView);

        Image textRankImage = new Image(new FileInputStream("Images/textRank.png"));
        ImageView textRankImageView = new ImageView(textRankImage);
        textRankImageView.setFitHeight(10);
        textRankImageView.setPreserveRatio(true);
        textRankButton.setGraphic(textRankImageView);

        Image directImage = new Image(new FileInputStream("Images/direct.png"));
        ImageView directImageView = new ImageView(directImage);
        directImageView.setFitHeight(10);
        directImageView.setPreserveRatio(true);
        directButton.setGraphic(directImageView);

        Image wordFrequencyImage = new Image(new FileInputStream("Images/wordFrequency.png"));
        ImageView wordFrequencyImageView= new ImageView(wordFrequencyImage);
        wordFrequencyImageView.setFitHeight(10);
        wordFrequencyImageView.setPreserveRatio(true);
        wordFrequencyButton.setGraphic(wordFrequencyImageView);



        Image statsImage = new Image(new FileInputStream("Images/stats.png"));
        ImageView statsImageView = new ImageView(statsImage);
        statsImageView.setFitHeight(10);
        statsImageView.setPreserveRatio(true);
        statsButton.setGraphic(statsImageView);

        Image sampleImage = new Image(new FileInputStream("Images/sample.png"));
        ImageView sampleImageView = new ImageView(sampleImage);
        sampleImageView.setFitHeight(10);
        sampleImageView.setPreserveRatio(true);
        runSampleButton.setGraphic(sampleImageView);

        Image deleteImage = new Image(new FileInputStream("Images/delete.png"));
        ImageView deleteImageView = new ImageView(deleteImage);
        deleteImageView.setFitHeight(10);
        deleteImageView.setPreserveRatio(true);
        deleteButton.setGraphic(deleteImageView);

        tool = new Scene(toolPane, 1000, 500);


        toolPane.getChildren().addAll(summaryLabel, contextLabel, statsButton, toolLabel, deleteButton, summarize, runSampleButton, context_tool
                , summary_tool, textRankButton, directButton, wordFrequencyButton, backButton_Tool);
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
        wordFrequencyButton.setTranslateX(855);
        wordFrequencyButton.setTranslateY(10);
        wordFrequencyButton.setStyle(buttonCSS);
        backButton_Tool.setTranslateX(30);
        backButton_Tool.setTranslateY(460);
        backButton_Tool.setStyle(buttonCSS);
        contextLabel.setTranslateX(30);
        contextLabel.setTranslateY(45);
        summaryLabel.setTranslateX(530);
        summaryLabel.setTranslateY(45);
        context_tool.setTranslateX(30);
        context_tool.setTranslateY(70);
        summary_tool.setTranslateX(530);
        summary_tool.setTranslateY(70);
        statsButton.setTranslateX(910);
        statsButton.setTranslateY(460);
        statsButton.setStyle(buttonCSS);

        deleteButton.setTranslateX(320);
        deleteButton.setTranslateY(460);
        deleteButton.setStyle(buttonCSS);


        runSampleButton.setTranslateX(400);
        runSampleButton.setTranslateY(460);
        runSampleButton.setStyle(buttonCSS);


        runSampleButton.setPrefSize(80, 25);
        deleteButton.setPrefSize(70, 25);
        summarize.setPrefSize(105, 25);
        textRankButton.setPrefSize(105, 25);
        directButton.setPrefSize(90, 25);
        wordFrequencyButton.setPrefSize(120, 25);
        statsButton.setPrefSize(70, 25);
        backButton_Tool.setPrefSize(backButtonWidth,backButtonHeight);


        //Evaluation Scene

        Label evaluationTitle = new Label("Recall-Oriented Understudy for Gisting Evaluation (ROGUE)");
        evaluationTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        evaluationTitle.setTextFill(Color.BLACK);


        Label meanPrecisionLabel = new Label();
        meanPrecisionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        meanPrecisionLabel.setTextFill(Color.BLACK);
        Label meanRecallLabel = new Label();

        Button detailsButton_textRank_evaluation = new Button("TextRank");
        detailsButton_textRank_evaluation.setStyle(buttonCSS);
        detailsButton_textRank_evaluation.setTranslateX(550);
        detailsButton_textRank_evaluation.setTranslateY(200);
        detailsButton_textRank_evaluation.setPrefSize(100, 25);

        Button detailsButton_direct_evaluation = new Button("Direct");
        detailsButton_direct_evaluation.setStyle(buttonCSS);
        detailsButton_direct_evaluation.setTranslateX(550);
        detailsButton_direct_evaluation.setTranslateY(240);
        detailsButton_direct_evaluation.setPrefSize(100, 25);

        Button detailsButton_wordFrequency_evaluation = new Button("WordFrequncy");
        detailsButton_wordFrequency_evaluation.setStyle(buttonCSS);
        detailsButton_wordFrequency_evaluation.setTranslateX(550);
        detailsButton_wordFrequency_evaluation.setTranslateY(280);
        detailsButton_wordFrequency_evaluation.setPrefSize(100, 25);

        meanRecallLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        meanRecallLabel.setTextFill(Color.BLACK);


        // Image - evaluation

        Image detailsImage = new Image(new FileInputStream("Images/details.png"));
        ImageView detailsImageView = new ImageView(detailsImage);
        detailsImageView.setFitHeight(15);
        detailsImageView.setPreserveRatio(true);
//        detailsButton_textRank_evaluation.setGraphic(detailsImageView);




        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Precison");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Scores");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Precision Scores");

        RogueTextRank rogueTextRankTool = new RogueTextRank();
        RogueDirect rogueDirect = new RogueDirect();
        RogueWordFrequency rogueWordFrequency = new RogueWordFrequency();

        df.setRoundingMode(RoundingMode.UP);
        meanPrecisionLabel.setText("Precision : " + df.format(rogueTextRankTool.getAveragePrecision()));
        meanRecallLabel.setText("Recall : " + df.format(rogueTextRankTool.getAverageRecall()));


        dataSeries1.getData().add(new XYChart.Data("TextRank", rogueTextRankTool.getAveragePrecision()));
        dataSeries1.getData().add(new XYChart.Data("Direct", rogueDirect.getAveragePrecision()));
        dataSeries1.getData().add(new XYChart.Data("WordFrequency", rogueWordFrequency.getAveragePrecision()));

        barChart.getData().add(dataSeries1);


        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Recall Scores");

        dataSeries2.getData().add(new XYChart.Data("TextRank", rogueTextRankTool.getAverageRecall()));
        dataSeries2.getData().add(new XYChart.Data("Direct", rogueDirect.getAverageRecall()));
        dataSeries2.getData().add(new XYChart.Data("WordFrequency", rogueWordFrequency.getAverageRecall()));


        barChart.getData().add(dataSeries2);

        barChart.setTranslateX(50);
        barChart.setTranslateY(70);

        Pane evaluationPane = new Pane(barChart);
        evaluationPane.setBackground(allAboutBg);

        meanPrecisionLabel.setTranslateX(550);
        meanPrecisionLabel.setTranslateY(200);
        meanRecallLabel.setTranslateX(550);
        meanRecallLabel.setTranslateY(240);

        evaluationTitle.setTranslateX(50);
        evaluationTitle.setTranslateY(15);

        Scene evaluationScene = new Scene(evaluationPane, 1000, 500);

        Button aboutROGUE = new Button("About");


        Image aboutROGUEImage = new Image(new FileInputStream("Images/about.png"));
        ImageView aboutROGUEImageView = new ImageView(aboutROGUEImage);
        aboutROGUEImageView.setFitHeight(15);
        aboutROGUEImageView.setPreserveRatio(true);

        aboutROGUE.setGraphic(aboutROGUEImageView);
        aboutROGUE.setTranslateX(800);
        aboutROGUE.setTranslateY(450);
        aboutROGUE.setStyle(buttonCSS);
        aboutROGUE.setPrefSize(backButtonWidth,backButtonHeight);
        aboutROGUE.setScaleX(1.5);
        aboutROGUE.setScaleY(1.5);


        Button backButton_evaluation = new Button("Back");
        backButton_evaluation.setGraphic(backImageView);
        backButton_evaluation.setTranslateX(30);
        backButton_evaluation.setTranslateY(460);
        backButton_evaluation.setStyle(buttonCSS);
        backButton_evaluation.setPrefSize(backButtonWidth,backButtonHeight);
        evaluationPane.getChildren().addAll(aboutROGUE,backButton_evaluation,detailsButton_direct_evaluation
                , detailsButton_wordFrequency_evaluation,evaluationTitle,
                 detailsButton_textRank_evaluation);



        Button backButton_details = new Button("Back");
        backButton_details.setStyle(buttonCSS);
        backButton_details.setGraphic(backImageView);

        backButton_details.setTranslateX(30);
        backButton_details.setTranslateY(460);
        backButton_details.setPrefSize(backButtonWidth,backButtonHeight);

        backButton_details.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu);
            }
        });

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

                window.setScene(aboutScene);
            }
        });

        backButton_about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu);
            }
        });

        algorithmsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button backButton = new Button("Back");
                Tooltip.install(backButton, new Tooltip("Back"));
                backButton.setGraphic(backImageView);
                backButton.setTranslateX(30);
                backButton.setTranslateY(460);
                backButton.setStyle(buttonCSS);
                backButton.setPrefSize(backButtonWidth,backButtonHeight);
                backButton.setOnAction(e->{
                    window.setScene(aboutScene);
                });

                Pane algorithmsPane = new Pane();
                algorithmsPane.setBackground(allBackground);

                Label algorithmTitle = new Label("Algorithms");
                algorithmTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                algorithmTitle.setTextFill(Color.BLACK);
//                algorithmTitle.setUnderline(true);
                algorithmTitle.setTranslateX(30);
                algorithmTitle.setTranslateY(30);

                Button textRank = new Button("Text Rank");
                Tooltip.install(textRank, new Tooltip("Text Rank Algorithm"));
                textRank.setGraphic(textRankImageView);
                textRank.setTranslateX(400);
                textRank.setTranslateY(150);
                textRank.setStyle(buttonCSS);
                textRank.setPrefSize(120,25);

                Button direct = new Button("Direct");
                Tooltip.install(direct, new Tooltip("Direct Algorithm"));
                direct.setGraphic(directImageView);
                direct.setTranslateX(400);
                direct.setTranslateY(250);
                direct.setStyle(buttonCSS);
                direct.setPrefSize(120,25);

                Button wordFrequency = new Button("Word Frequency");
                Tooltip.install(wordFrequency, new Tooltip("Word Frequency Algorithm"));
                wordFrequency.setGraphic(wordFrequencyImageView);
                wordFrequency.setTranslateX(400);
                wordFrequency.setTranslateY(350);
                wordFrequency.setStyle(buttonCSS);
                wordFrequency.setPrefSize(120,25);




                double scale  = 2;
                textRank.setScaleX(scale);
                textRank.setScaleY(scale);

                direct.setScaleX(scale);
                direct.setScaleY(scale);

                wordFrequency.setScaleX(scale);
                wordFrequency.setScaleY(scale);


                algorithmsPane.getChildren().addAll(algorithmTitle,backButton,textRank,direct,wordFrequency);
                Scene algorithmScene = new Scene(algorithmsPane,1000,500);
                window.setScene(algorithmScene);


                wordFrequency.setOnAction(e->{

                    Label wordFrequencyTitle = new Label("Word Frequency Algorithm");
                    wordFrequencyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    wordFrequencyTitle.setTextFill(Color.BLACK);
                    wordFrequencyTitle.setUnderline(true);
                    wordFrequencyTitle.setTranslateX(30);
                    wordFrequencyTitle.setTranslateY(30);

                    Text wordFrequencyText = new Text();
                    wordFrequencyText.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 22));



                    wordFrequencyText.setText("\t5 steps :\n\n\n" +
                            "        1. Create Word Frequency Table\n\n" +
                            "        2. Tokenize Sentences\n\n" +
                            "        3. Score the sentences\n\n" +
                            "        4. Find Threshold\n\n" +
                            "        5. Generate Summary");


                    wordFrequencyText.setTranslateX(30);
                    wordFrequencyText.setTranslateY(100);


                    Button backButton_wordFrequency = new Button("Back");
                    Tooltip.install(backButton_wordFrequency, new Tooltip("Back"));
                    backButton_wordFrequency.setGraphic(backImageView);
                    backButton_wordFrequency.setTranslateX(30);
                    backButton_wordFrequency.setTranslateY(460);
                    backButton_wordFrequency.setStyle(buttonCSS);
                    backButton_wordFrequency.setPrefSize(backButtonWidth,backButtonHeight);
                    backButton_wordFrequency.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            window.setScene(algorithmScene);
                        }
                    });

                    Pane wordFrequencyPane = new Pane();
                    wordFrequencyPane.setBackground(allBackground);


                    wordFrequencyPane.getChildren().addAll(backButton_wordFrequency,wordFrequencyTitle,wordFrequencyText);
                    Scene wordFrequencyScene = new Scene(wordFrequencyPane,1000,500);
                    window.setScene(wordFrequencyScene);
                });

                textRank.setOnAction(e->{
                    Label textRankTitle = new Label("Text Rank Algorithm");
                    textRankTitle.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
                    textRankTitle.setTextFill(Color.BLACK);
                    textRankTitle.setUnderline(true);
                    textRankTitle.setTranslateX(30);
                    textRankTitle.setTranslateY(30);

                    Text textRankText = new Text();
                    textRankText.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 23));



                    textRankText.setText("" +
                            "        8 Steps :\n\n\n" +
                            "        1. Context -> Sentences\n" +
                            "        2. Preprocessing of Sentences\n" +
                            "        3. Tokenize Words vectors from processed Sentences\n" +
                            "        4. TF-IDF calculation\n" +
                            "        5. Scoring tf idf value by implementing BOG(Bag of Words model)\n" +
                            "        6. Cosine Similarity Matrix\n" +
                            "        7. Scoring Sentences\n" +
                            "        8. Extraction");


                    textRankText.setTranslateX(30);
                    textRankText.setTranslateY(100);


                    Button backButton_textRank = new Button("Back");
                    Tooltip.install(backButton_textRank, new Tooltip("Back"));
                    backButton_textRank.setGraphic(backImageView);
                    backButton_textRank.setTranslateX(30);
                    backButton_textRank.setTranslateY(460);
                    backButton_textRank.setStyle(buttonCSS);
                    backButton_textRank.setPrefSize(backButtonWidth,backButtonHeight);
                    backButton_textRank.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            window.setScene(algorithmScene);
                        }
                    });

                    Pane textRankPane = new Pane();
                    textRankPane.setBackground(allAboutBg);


                    textRankPane.getChildren().addAll(backButton_textRank,textRankText,textRankTitle);
                    Scene textRankScene = new Scene(textRankPane,1000,500);
                    window.setScene(textRankScene);
                });


                direct.setOnAction(e ->{
                    Label directTitle = new Label("Direct Algorithm");
                    directTitle.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
                    directTitle.setTextFill(Color.BLACK);
                    directTitle.setUnderline(true);
                    directTitle.setTranslateX(30);
                    directTitle.setTranslateY(30);

                    Text directText = new Text();
                    directText.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 22));



                    directText.setText("    6 Steps:\n\n\n" +
                            "    1. Context -> Sentence\n\n" +
                            "    2. Intersection Matrix is created. Size of Matrix = [sentence.length()][sentence.length()]\n\n" +
                            "    3. Mat[i][j] = ((noOfWords of sentence 'i') + (noOfWords of sentence 'j'))/2\n\n" +
                            "    4. Score of a row for each sentence is added\n\n" +
                            "    5. Order of sentences are maintained and half of the sentences are marked\n\n" +
                            "    6. Extraction of most scored sentences");


                    directText.setTranslateX(30);
                    directText.setTranslateY(100);


                    Button backButton_direct = new Button("Back");
                    Tooltip.install(backButton_direct, new Tooltip("Back"));
                    backButton_direct.setGraphic(backImageView);
                    backButton_direct.setTranslateX(30);
                    backButton_direct.setTranslateY(460);
                    backButton_direct.setStyle(buttonCSS);
                    backButton_direct.setPrefSize(backButtonWidth,backButtonHeight);
                    backButton_direct.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            window.setScene(algorithmScene);
                        }
                    });

                    Pane directPane = new Pane();
                    directPane.setBackground(allBackground);


                    directPane.getChildren().addAll(backButton_direct,directText,directTitle);
                    Scene directScene = new Scene(directPane,1000,500);
                    window.setScene(directScene);

                });



            }
        });



        detailsButton_direct_evaluation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Label detailsTitle = new Label("Details : Direct");
                detailsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                detailsTitle.setTextFill(Color.BLACK);
//                algorithmTitle.setUnderline(true);
                detailsTitle.setTranslateX(30);
                detailsTitle.setTranslateY(30);

                Button backButton_details_textrank = new Button("Back");
                backButton_details_textrank.setGraphic(backImageView);
                backButton_details_textrank.setTranslateX(30);
                backButton_details_textrank.setTranslateY(460);
                backButton_details_textrank.setStyle(buttonCSS);
                backButton_details_textrank.setPrefSize(backButtonWidth,backButtonHeight);

                backButton_details_textrank.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        window.setScene(evaluationScene);
                    }
                });





                CategoryAxis xAxis = new CategoryAxis();
                xAxis.setLabel("Precison");

                NumberAxis yAxis = new NumberAxis();
                yAxis.setLabel("Scores");

                BarChart barChart = new BarChart(xAxis, yAxis);

                XYChart.Series dataSeries1 = new XYChart.Series();
                dataSeries1.setName("Precision Scores Evaluation");


                RogueDirect rogueDirect1 = new RogueDirect();
                ArrayList<CrossValidation> checkedArticles = rogueDirect1.getArticleEvaluation();


                int counter=1;
                String articleString = "Article";
                for (CrossValidation article:checkedArticles  ) {

                    String nameOfArticle = articleString+counter;
                    counter++;
                    dataSeries1.getData().add(new XYChart.Data(nameOfArticle, article.getPrecision()));
                }


                barChart.getData().add(dataSeries1);


                XYChart.Series dataSeries2 = new XYChart.Series();
                dataSeries2.setName("Recall");

                counter=1;
                articleString = "Article";
                for (CrossValidation article:checkedArticles  ) {

                    String nameOfArticle = articleString+counter;
                    counter++;
                    dataSeries2.getData().add(new XYChart.Data(nameOfArticle, article.getRecall()));
                }

                barChart.getData().add(dataSeries2);


                Pane pane = new Pane();
                pane.setBackground(allBackground);
                pane.getChildren().addAll(backButton_details_textrank,barChart,detailsTitle);
                double scale = 1.0;
                barChart.setBarGap(0.5);
                barChart.setScaleX(scale);
                barChart.setScaleY(scale);
                barChart.setScaleZ(scale);
                barChart.setTranslateX(50);
                barChart.setTranslateY(70);

                barChart.setPrefSize(900,400);

                Scene detailsScene = new Scene(pane, 1000, 500);

                window.setScene(detailsScene);

            }
        });


        detailsButton_wordFrequency_evaluation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Label detailsTitle = new Label("Details : WordFrequency");
                detailsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                detailsTitle.setTextFill(Color.BLACK);
//                algorithmTitle.setUnderline(true);
                detailsTitle.setTranslateX(30);
                detailsTitle.setTranslateY(30);

                Button backButton_details_textrank = new Button("Back");
                backButton_details_textrank.setGraphic(backImageView);
                backButton_details_textrank.setTranslateX(30);
                backButton_details_textrank.setTranslateY(460);
                backButton_details_textrank.setStyle(buttonCSS);
                backButton_details_textrank.setPrefSize(backButtonWidth,backButtonHeight);

                backButton_details_textrank.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        window.setScene(evaluationScene);
                    }
                });





                CategoryAxis xAxis = new CategoryAxis();
                xAxis.setLabel("Precison");

                NumberAxis yAxis = new NumberAxis();
                yAxis.setLabel("Scores");

                BarChart barChart = new BarChart(xAxis, yAxis);

                XYChart.Series dataSeries1 = new XYChart.Series();
                dataSeries1.setName("Precision Scores Evaluation");


                RogueWordFrequency rogueWordFrequency1 = new RogueWordFrequency();
                ArrayList<CrossValidation> checkedArticles = rogueWordFrequency1.getArticleEvaluation();


                int counter=1;
                String articleString = "Article";
                for (CrossValidation article:checkedArticles  ) {

                    String nameOfArticle = articleString+counter;
                    counter++;
                    dataSeries1.getData().add(new XYChart.Data(nameOfArticle, article.getPrecision()));
                }


                barChart.getData().add(dataSeries1);


                XYChart.Series dataSeries2 = new XYChart.Series();
                dataSeries2.setName("Recall");

                counter=1;
                articleString = "Article";
                for (CrossValidation article:checkedArticles  ) {

                    String nameOfArticle = articleString+counter;
                    counter++;
                    dataSeries2.getData().add(new XYChart.Data(nameOfArticle, article.getRecall()));
                }

                barChart.getData().add(dataSeries2);


                Pane pane = new Pane();
                pane.setBackground(allBackground);
                pane.getChildren().addAll(backButton_details_textrank,barChart,detailsTitle);
                double scale = 1.0;
                barChart.setBarGap(0.5);
                barChart.setScaleX(scale);
                barChart.setScaleY(scale);
                barChart.setScaleZ(scale);
                barChart.setTranslateX(50);
                barChart.setTranslateY(70);

                barChart.setPrefSize(900,400);

                Scene detailsScene = new Scene(pane, 1000, 500);

                window.setScene(detailsScene);


            }
        });









        evaluationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(evaluationScene);

            }
        });
        aboutROGUE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Pane aboutROGUE_pane = new Pane();

                Label ROGUE = new Label("Recall-Oriented Understudy for Gisting Evaluation");
                ROGUE.setUnderline(true);
                Text introText = new Text("Compares an automatically produced summary against a reference summary (typically human-produced)\n\n"+
                        "Computation of PRECISION and RECALL is done.");


                Label line1 = new Label("__________________________");
                line1.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,20));

                Label line2 = new Label("__________________________");
                line2.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,20));


                Label precision = new Label("Precision   =");
                Label precisionEquals = new Label("  Total overlapped words\n"+
//                                                      "__________________________\n" +
                                                      "  Total words in Ref summary");
                precision.setFont(Font.font("Arial",FontWeight.BOLD,20));
                precisionEquals.setFont(Font.font("Arial",FontWeight.LIGHT,20));


                Label recall = new Label("Recall        =");
                recall.setFont(Font.font("Arial",FontWeight.BOLD,20));
                Label recallEquals = new Label("  Total overlapped words\n"+
//                        "_____________________________\n" +
                        "Total words in Machine summary");


                recallEquals.setFont(Font.font("Arial",FontWeight.LIGHT,20));

                ROGUE.setFont(Font.font("Arial",FontWeight.BOLD,24));
                introText.setFont(Font.font("Arial",FontWeight.LIGHT,20));

                ROGUE.setTranslateX(30);
                ROGUE.setTranslateY(30);
                introText.setTranslateX(30);
                introText.setTranslateY(100);


                precision.setTranslateX(200);
                precision.setTranslateY(237);
                line1.setTranslateX(330);
                line1.setTranslateY(227);
                precisionEquals.setTranslateX(330);
                precisionEquals.setTranslateY(224);

                recall.setTranslateX(200);
                recall.setTranslateY(330);
                line2.setTranslateX(330);
                line2.setTranslateY(322);
                recallEquals.setTranslateX(330);
                recallEquals.setTranslateY(320);


                Button backButton_ROGUE = new Button("Back");
                backButton_ROGUE.setGraphic(backImageView);
                backButton_ROGUE.setTranslateX(30);
                backButton_ROGUE.setTranslateY(460);
                backButton_ROGUE.setStyle(buttonCSS);
                backButton_ROGUE.setPrefSize(backButtonWidth,backButtonHeight);

                backButton_ROGUE.setOnAction(e->
                        window.setScene(evaluationScene));


                aboutROGUE_pane.getChildren().addAll(ROGUE,introText,backButton_ROGUE,recall,line1,line2,recallEquals,precision,precisionEquals);
                aboutROGUE_pane.setBackground(allBackground);
                Scene aboutROGUE_scene = new Scene(aboutROGUE_pane,1000,500);

                window.setScene(aboutROGUE_scene);
            }
        });
        detailsButton_textRank_evaluation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Label detailsTitle = new Label("Details : TextRank");
                detailsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                detailsTitle.setTextFill(Color.BLACK);
//                algorithmTitle.setUnderline(true);
                detailsTitle.setTranslateX(30);
                detailsTitle.setTranslateY(30);

                Button backButton_details_textrank = new Button("Back");
                backButton_details_textrank.setGraphic(backImageView);
                backButton_details_textrank.setTranslateX(30);
                backButton_details_textrank.setTranslateY(460);
                backButton_details_textrank.setStyle(buttonCSS);
                backButton_details_textrank.setPrefSize(backButtonWidth,backButtonHeight);

                backButton_details_textrank.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        window.setScene(evaluationScene);
                    }
                });





                CategoryAxis xAxis = new CategoryAxis();
                xAxis.setLabel("Precison");

                NumberAxis yAxis = new NumberAxis();
                yAxis.setLabel("Scores");

                BarChart barChart = new BarChart(xAxis, yAxis);

                XYChart.Series dataSeries1 = new XYChart.Series();
                dataSeries1.setName("Precision Scores Evaluation");


                RogueTextRank rogueTextRankTool = new RogueTextRank();
                ArrayList<CrossValidation> checkedArticles = rogueTextRankTool.getArticleEvaluation();


                int counter=1;
                String articleString = "Article";
                for (CrossValidation article:checkedArticles  ) {

                    String nameOfArticle = articleString+counter;
                    counter++;
                    dataSeries1.getData().add(new XYChart.Data(nameOfArticle, article.getPrecision()));
                }


                barChart.getData().add(dataSeries1);


                XYChart.Series dataSeries2 = new XYChart.Series();
                dataSeries2.setName("Recall");

                counter=1;
                articleString = "Article";
                for (CrossValidation article:checkedArticles  ) {

                    String nameOfArticle = articleString+counter;
                    counter++;
                    dataSeries2.getData().add(new XYChart.Data(nameOfArticle, article.getRecall()));
                }

                barChart.getData().add(dataSeries2);


                Pane pane = new Pane();
                pane.setBackground(allBackground);
                pane.getChildren().addAll(backButton_details_textrank,barChart,detailsTitle);
                double scale = 1.0;
                barChart.setBarGap(0.5);
                barChart.setScaleX(scale);
                barChart.setScaleY(scale);
                barChart.setScaleZ(scale);
                barChart.setTranslateX(50);
                barChart.setTranslateY(70);

                barChart.setPrefSize(900,400);

                Scene detailsScene = new Scene(pane, 1000, 500);

                window.setScene(detailsScene);

            }
        });

        backButton_evaluation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(menu);
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
                if(context.isEmpty())
                {
                    context_tool.setText("");
                    summary_tool.setText("");

                }
                else {
                    SummaryTool textRankTool = new SummaryTool(context);
                    String summary = textRankTool.getSummary();

                    summary_tool.setText(summary);
                }
            }
        });

        directButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                if(context.isEmpty())
                {
                    context_tool.setText("");
                    summary_tool.setText("");

                }
                else {
                    Algorithms.Direct.SummaryTool directTool = new Algorithms.Direct.SummaryTool(context);
                    String summary = directTool.getSummary();

                    summary_tool.setText(summary);
                }

            }
        });

        textRankButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                if(context.isEmpty())
                {
                    context_tool.setText("");
                    summary_tool.setText("");

                }
                else {
                    SummaryTool textRankTool = new SummaryTool(context);
                    String summary = textRankTool.getSummary();

                    summary_tool.setText(summary);
                }
            }
        });

        wordFrequencyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                if(context.isEmpty())
                {
                    context_tool.setText("");
                    summary_tool.setText("");
                }
                else {


                    Algorithms.WordFrequency.SummaryTool wordFreqTool = new Algorithms.WordFrequency.SummaryTool(context);

                String summary = wordFreqTool.getSummary();

                summary_tool.setText(summary);
            }
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                context_tool.setText("");
                summary_tool.setText("");
            }
        });

        statsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                String summary = summary_tool.getText();

                Pane statsPane = new Pane();
                statsPane.setBackground(allBackground);
                Scene statsScene = new Scene(statsPane,1000,500);
                if(context.isEmpty() && summary.isEmpty())
                {
                    context_tool.setText("");
                    summary_tool.setText("");

                }
                else{
                    SummaryStatistics summaryStatisticsTool = new SummaryStatistics(context,summary);

                    Label statsTitle = new Label("Summary Statistics:");

                    Label wordsInContext = new Label(String.format("Total words in Context : %s", summaryStatisticsTool.getNoOfWordsInContext()));
                    Label wordsInSummary = new Label("Total words in Summary : "+ summaryStatisticsTool.getNoOfWordsInSummary());
                    Label reductionLabel = new Label("Words reduced by : "+ (100- summaryStatisticsTool.getPercentageOfReduction()*100)+"%");
                    Label percentageLabel = new Label("Summary Words percentage wrt to Context : "+ ( summaryStatisticsTool.getPercentageOfReduction()*100)+"%");

                    Button backButton = new Button("Back");
                    backButton.setStyle(buttonCSS);
                    backButton.setGraphic(backImageView);
                    statsTitle.setTranslateX(25);
                    statsTitle.setTranslateY(20);
                    wordsInContext.setTranslateX(25);
                    wordsInContext.setTranslateY(80);
                    wordsInSummary.setTranslateX(25);
                    wordsInSummary.setTranslateY(120);
                    reductionLabel.setTranslateX(25);
                    reductionLabel.setTranslateY(160);
                    percentageLabel.setTranslateX(25);
                    percentageLabel.setTranslateY(200);


                    statsTitle.setFont(Font.font("Arial",FontWeight.BOLD,30));
                    statsTitle.setTextFill(Color.BLACK);

                    wordsInContext.setFont(Font.font("Arial", FontWeight.LIGHT, 20));
                    wordsInContext.setTextFill(Color.BLACK);

                    wordsInSummary.setFont(Font.font("Arial", FontWeight.LIGHT, 20));
                    wordsInSummary.setTextFill(Color.BLACK);

                    reductionLabel.setFont(Font.font("Arial", FontWeight.LIGHT, 20));
                    reductionLabel.setTextFill(Color.BLACK);

                    percentageLabel.setFont(Font.font("Arial", FontWeight.LIGHT, 20));
                    percentageLabel.setTextFill(Color.BLACK);


                    backButton.setTranslateX(30);
                    backButton.setTranslateY(460);
                    backButton.setPrefSize(backButtonWidth,backButtonHeight);
                    backButton.setGraphic(backImageView);

                    backButton.setOnAction(e->
                    {
                        window.setScene(tool);
                    });


                    statsPane.getChildren().addAll(statsTitle,percentageLabel,wordsInContext,wordsInSummary,reductionLabel,backButton);
                    window.setScene(statsScene);


                }


            }
        });

        runSampleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String context = "‘The Good Morrow’ is a typical Donnian love poem, divided into three stanzas. It’s one of those love poems in which he praises the spiritual relationship between men and women and hails it so ardently.\n" +
                        "\n" +
                        "In the opening stanza, the poet expresses his wonder as to what he and his beloved did before they fell in love with each other. He becomes surprised remembering their past love experiences. He compares the love experiences of himself and his beloved with `weaning’, falsely sucking country pleasures’ and `snorting.’ The reference to these three physical activities indicates that they spent a life of worldly enjoyment. But now the poet using the conjunction ‘But’ makes a contrast and say’s that all these past physical activities seem to be utterly meaningless. The closing two lines of the first stanza imply that though the poet indulged himself in ‘country pleasures’, he has never been unmindful to perfect beauty of ideal spiritual love, which he always desired and has finally ‘got’ in his present beloved.\n" +
                        "\n" +
                        "Obviously there is a shift from physical to spiritual love, sleeping to waking period, sensuous appearances to ideal reality and as if from platonic cave to the world of light in the poet and his beloved. Here the poet seems to have touched the metaphysics of Plato. In his metaphysics, Plato at first takes something concrete such as man, but soon he leaps into abstract namely the Form of man. Similarly Donne also begins with physical love and soon he turns to Platonic or metaphysical love.\n" +
                        "\n" +
                        "The first stanza contains several Donnian elements. It opens abruptly with an explosive question. This abrupt colloquial beginning, which is so characteristic of Donne startles us and captures our attention. Another noticeable thing is that Donne swears his true relation – ‘I wonder by my troth’. Here he is unconventional. Any of his contemporary of Elizabethan poets might swear to God, but Donne has not done it. Then there are the references of physical union and the use of imageries in the following three lines. The fourth line contains a legendary conceit,a legend that tells of seven young men of Ephesus who took refuge in a cave during the persecution of Diocletian and were entombed there. They were found alive two centuries later. Here Donne compares himself and his beloved with the seven sleepers. Here he is cynical when he utters the word ‘did’. Surely the word ‘did’ includes the connotations of sexual doing – what did we ever do with the time?\n" +
                        "\n" +
                        "The second stanza begins with hail and celebration. The unconscious past of flesh is over and a new conscious spiritual relationship begins. So the speaker cerebrates the present. “Now good morrow to our waking souls”. He also makes declaration that their souls have also learnt not to spy one another. That the married women or men involve in extra-marital affair was a dominant theme in the Elizabethan and Jacobean literature. So, fear only works in sensual lovers as motivation for watching over each other, least the other should become unfaithful to his or her mate. But the speaker and his beloved have overcome this fear and a peaceful satisfaction prevails their love. And for their faithful love they will control the temptations of other things. They love so faithfully and ardently that their love has the force to be merged into the universal love and to move out to become “an every where”.\n" +
                        "\n" +
                        "As spiritual lovers, the poet and his beloved are indifferent to earthly pleasures and possessions – let the sea-lovers and map-lovers do what they like to do. The lovers want to be happy with their joint world though they have their individual worlds but their individual worlds are fused into a single world. Now they are the joint owners of a single world.\n" +
                        "\n" +
                        "Here in this stanza, we find the presence of imagery from the contemporary geographical world. That is to say the contemporary geographical interest of the explorers.\n" +
                        "\n" +
                        "The third stanza opens with endearing words from the speaker. The two lovers stand so closely that their respective faces are reflected in each others eyes. The simplicity of their heart is also reflected in their faces, which are conceived as two hemispheres of their world. But their world of love is so unearthly that its hemispheres are free from coldness and decay. They are not afraid of separation or break up of their “relation, because” ‘what ever dyes, was not mixt equality’. The ingredients of their love have been proportionately mixed and there is no ware and woof between them. They have love equally and proportionately.\n" +
                        "\n" +
                        "Thus the poem ends with the establishment of true friendship. After an abrupt beginning, there is calmness at last. The couple has rejected the country pleasures and entered into a true inter-dependent friendship. They have renounced the mundane world in order possess an unearthly world. Experience has thought them that the true happiness can be achieved through a mutual spiritual friendship.\n" +
                        "\n" +
                        "In the first stanza, there is the regret for past doings, in the second stanza the pleasure of discovering something in the last stanza, the prospect/hope of doing better/using the discovery. The abrupt beginning of the poem, the use of conceits form everyday life and myth in the first stanza, the geographical reference of stanza two, the use of scholastic philosophy in stanza three, and ultimately the emphasis of spiritual love continue to make it one of those poems of Donne which combine intellect and emotion. These above motioned qualities have made the poem get a certain place in honored, treasured lyrics written by John Donne.";
                context_tool.setText(context);
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
