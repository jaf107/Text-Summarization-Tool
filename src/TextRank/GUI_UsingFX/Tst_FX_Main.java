package TextRank.GUI_UsingFX;

import CrossValidation.CrossValidation;
import CrossValidation.CrossValidationCheck;
import TextRank.FinalProject.SummaryStatistics;
import TextRank.FinalProject.SummaryTool;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Tst_FX_Main extends Application {

    Stage window;
    Scene start, menu, tool;


    TextArea context_tool, summary_tool;

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

        // BackButtons Image
        FileInputStream backImageInputStream = new FileInputStream("Images/back2.png");
        Image backImage = new Image(backImageInputStream);
        ImageView backImageView = new ImageView(backImage);
        backImageView.setFitHeight(10);
        backImageView.setPreserveRatio(true);

        int backButtonWidth = 70;
        int backButtonHeight = 25;


        // Start page Scene
        Pane startPane = new Pane();
        Label introTitle = new Label("Text Summarization Tool");
        introTitle.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        Button startButton = new Button("Start");
//        Tooltip startToolTip = new Tooltip("Start Button");
        Tooltip.install(startButton, new Tooltip("Start Button"));
        startButton.setStyle(buttonCSS);
        startButton.setScaleX(4);
        startButton.setScaleY(4);

        introTitle.setTranslateX(200);
        introTitle.setTranslateY(150);
        startButton.setTranslateX(480);
        startButton.setTranslateY(300);

        startPane.getChildren().addAll(introTitle, startButton);

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
        Tooltip.install(algorithmsButton, new Tooltip("Text Rank Algorithm"));
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

        Button detailsButton_evaluation = new Button("Details");
        detailsButton_evaluation.setStyle(buttonCSS);
        detailsButton_evaluation.setTranslateX(550);
        detailsButton_evaluation.setTranslateY(300);
        detailsButton_evaluation.setPrefSize(80, 25);

        meanRecallLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        meanRecallLabel.setTextFill(Color.BLACK);


        // Image - evaluation

        Image detailsImage = new Image(new FileInputStream("Images/details.png"));
        ImageView detailsImageView = new ImageView(detailsImage);
        detailsImageView.setFitHeight(15);
        detailsImageView.setPreserveRatio(true);
        detailsButton_evaluation.setGraphic(detailsImageView);




        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Precison");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Scores");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Precision Scores");

        CrossValidationCheck crossValidationCheckTool = new CrossValidationCheck();

        meanPrecisionLabel.setText("Precision : " + crossValidationCheckTool.getAveragePrecision());
        meanRecallLabel.setText("Recall : " + crossValidationCheckTool.getAverageRecall());


        dataSeries1.getData().add(new XYChart.Data("Mean", crossValidationCheckTool.getAveragePrecision()));

        barChart.getData().add(dataSeries1);


        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Recall Scores");

        dataSeries2.getData().add(new XYChart.Data("Mean", crossValidationCheckTool.getAverageRecall()));


        barChart.getData().add(dataSeries2);

        barChart.setTranslateX(50);
        barChart.setTranslateY(70);

        Pane evaluationPane = new Pane(barChart);

        meanPrecisionLabel.setTranslateX(550);
        meanPrecisionLabel.setTranslateY(200);
        meanRecallLabel.setTranslateX(550);
        meanRecallLabel.setTranslateY(240);

        evaluationTitle.setTranslateX(50);
        evaluationTitle.setTranslateY(15);

        Scene evaluationScene = new Scene(evaluationPane, 1000, 500);
        Button backButton_evaluation = new Button("Back");
        backButton_evaluation.setGraphic(backImageView);
        backButton_evaluation.setTranslateX(30);
        backButton_evaluation.setTranslateY(460);
        backButton_evaluation.setStyle(buttonCSS);
        backButton_evaluation.setPrefSize(backButtonWidth,backButtonHeight);
        evaluationPane.getChildren().addAll(backButton_evaluation, meanRecallLabel,evaluationTitle, meanPrecisionLabel, detailsButton_evaluation);


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
                    wordFrequencyTitle.setTranslateX(30);
                    wordFrequencyTitle.setTranslateY(30);

                    Text wordFrequencyText = new Text();



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


                    wordFrequencyPane.getChildren().addAll(backButton_wordFrequency,wordFrequencyTitle,wordFrequencyText);
                    Scene wordFrequencyScene = new Scene(wordFrequencyPane,1000,500);
                    window.setScene(wordFrequencyScene);
                });



            }
        });









        evaluationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(evaluationScene);

            }
        });
        detailsButton_evaluation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Button backButton = new Button("Back");
                backButton.setStyle(buttonCSS);
                backButton.setGraphic(backImageView);

                backButton.setTranslateX(30);
                backButton.setTranslateY(460);
                backButton.setPrefSize(backButtonWidth,backButtonHeight);



                CategoryAxis xAxis = new CategoryAxis();
                xAxis.setLabel("Precison");

                NumberAxis yAxis = new NumberAxis();
                yAxis.setLabel("Scores");

                BarChart barChart = new BarChart(xAxis, yAxis);

                XYChart.Series dataSeries1 = new XYChart.Series();
                dataSeries1.setName("Precision Scores Evaluation");


                CrossValidationCheck crossValidationCheckTool = new CrossValidationCheck();
                ArrayList<CrossValidation> checkedArticles = crossValidationCheckTool.getArticleEvaluation();


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


                Pane pane = new Pane(barChart);
                pane.getChildren().addAll(backButton);


                Scene detailsScene = new Scene(pane, 1000, 500);

                window.setScene(detailsScene);

                backButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        window.setScene(evaluationScene);
                    }
                });
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
                org.wordFrequencyAlgorithm.SummaryTool wordFreqTool = new org.wordFrequencyAlgorithm.SummaryTool(context);

                String summary = wordFreqTool.getSummary();

                summary_tool.setText(summary);
            }
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                context_tool.setText("");
            }
        });

        statsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String context = context_tool.getText();
                String summary = summary_tool.getText();

                Pane statsPane = new Pane();
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

                String context = "Battling pandemic fatigue: Some feel burned out as the Covid-19 outbreak drags on with no end in sight\n" +
                        "\n" +
                        "Freelance writer Sng Ler Jun has been taking on more writing assignments since March to earn extra money for his family and himself.\n" +
                        "\n" +
                        "His 55-year-old mother was retrenched from a part-time job as a food promoter in February and his father, a 59-year-old taxi driver, has seen earnings fall since the start of the coronavirus pandemic.\n" +
                        "\n" +
                        "As a result, the 24-year-old, who is doing a communications degree from the University at Buffalo at the Singapore Institute of Management, said he feels \"pressured to work harder\".\n" +
                        "\n" +
                        "The worry of finding a stable job after he graduates in December keeps him up at night. \"I'm doing unpaid writing work to beef up my resume so it'll help in my job hunt,\" said Sng, who is an only child.\n" +
                        "\n" +
                        "Still, he feels \"plagued by the uncertainty\" as he does not know when the economy will improve. \"It's demoralising thinking about it and I feel burned out.\"\n" +
                        "\n" +
                        "Because of this, his mood and energy has been low and he no longer enjoys the walks he used to take in the neighbourhood.\n" +
                        "\n" +
                        "Dr Annabelle Chow, principal clinical psychologist at Annabelle Psychology, said the burnout a person experiences due to effects brought about by Covid-19 is a sign of pandemic fatigue.\n" +
                        "\n" +
                        "\"Pandemic fatigue describes a mental state where a prolonged, heightened state of fear and caution leads to a form of burnout. Although it is not classified as a mental disorder, the effects of pandemic fatigue are nevertheless real and have an impact on those experiencing it,\" she said.\n" +
                        "\n" +
                        "Signs include reduced socialising with others; feeling restless, sad, helpless, unmotivated and frustrated; being irritable and sensitive; and having low mood and energy, and insomnia.\n" +
                        "\n" +
                        "Long-term worries about a pandemic can take a toll on mental and emotional health and may result in the worsening of mental health conditions and chronic health problems.\n" +
                        "\n" +
                        "It may also lead to headaches, an inability to focus, digestive issues, insomnia and a weakened immune system, ultimately affecting a person's overall daily functioning.\n" +
                        "\n" +
                        "Terri Chen, senior clinical psychologist at the National University Hospital's (NUH) Department of Psychological Medicine, said it is likely that people started feeling these effects in April when the circuit breaker here was extended.\n" +
                        "\n" +
                        "The restrictions were a \"drastic change\" to people's daily routine and way of life.\n" +
                        "\n" +
                        "\"Everyone was required to adapt in a short amount of time and many people were accepting of these restrictions as they thought it was a short-term measure to deal with the virus,\" said Chen, who is head of psychology at NUH.\n" +
                        "\n" +
                        "\"But when the circuit breaker was extended and subsequent announcements about phase one and phase two were made, it was hard for people to keep up, and even more so with no clear end in sight.\"\n" +
                        "\n" +
                        "Dr Chow said seniors, children, caregivers, front-line workers, those who are living alone or socially isolated, and those who already struggle with depression and anxiety have an increased risk of getting pandemic fatigue.\n" +
                        "\n" +
                        "Working adults have also been hit hard. Dr Geraldine Tan, director and principal psychologist at The Therapy Room, started noticing signs of pandemic fatigue in her clients last month.\n" +
                        "\n" +
                        "\"The uncertainty of the job market and the impending crisis get them down. The breaks they used to take overseas are now non-existent and the work they do has taken a radical shift for some, especially if they are working from home,\" she said.\n" +
                        "\n" +
                        "\"Each day becomes more routine and mundane. People in Singapore are very used to travelling and now we appear to be imprisoned on our island.\"\n" +
                        "\n" +
                        "For those working or studying from home, the frequent need to be connected via video conferencing also contributes to the fatigue.\n" +
                        "\n" +
                        "People report feeling exhausted after virtual interactions, a phenomenon known as \"Zoom fatigue\", although it also applies to other video-conferencing platforms like Google Hangouts, Skype or FaceTime.\n" +
                        "\n" +
                        "Sng, who has been attending online classes since late April, said he sometimes does not switch on his webcam during lessons.\n" +
                        "\n" +
                        "\"I feel like the lack of a physical presence makes me less accountable. I've put on 5kg since the circuit breaker and I don't want people to see me looking like a mess at home. I was also sick of looking at my own face on the screen.\"\n" +
                        "\n" +
                        "NUH's Chen said a lot of energy is required to pay attention to non-verbal communication, which is harder to pick up over video conferencing.\n" +
                        "\n" +
                        "\"The multi-person screens tax the brain further from the need to process and decode all the information at once. Staring at your own face during the meetings can be stressful too,\" she added.\n" +
                        "\n" +
                        "One danger of pandemic fatigue is that people may drop their guard against the virus.\n" +
                        "\n" +
                        "According to a Sunday Times survey of 1,000 people aged 16 and above, people in Singapore are becoming weary of the rules to limit the spread of the coronavirus.\n" +
                        "\n" +
                        "It showed that 44 per cent of people are tired of following the necessary health measures. These include having to wear a mask, checking in with SafeEntry, limiting the size of physical gatherings with friends and family, and not being able to travel overseas.\n" +
                        "\n" +
                        "Dr Chow said the constant barrage of Covid-19 news and advisories could actually be desensitising and complacency may set in.\n" +
                        "\n" +
                        "\"Repeated exposure to pandemic-related news will eventually diminish the initial feelings of anxiety and caution. Consequently, we may begin to engage in behaviours that were initially inhibited by the anxiety responses, such as not adhering to safe distancing rules or washing our hands as regularly as we did before,\" she said.\n" +
                        "\n" +
                        "Habituation - the progressive decrease in response, such as feelings of anxiety, after repeated exposure to a stimulus - has caused people to become less careful or conscious about the precautions they need to take than they were at the start of the pandemic, said Chen.\n" +
                        "\n" +
                        "\"This means that over time - especially if we or anyone we knew did not get Covid-19 - we are likely to be less careful or conscious about the precautions as it would appear that there is less of a need to maintain such levels of vigilance,\" she said.\n" +
                        "\n" +
                        "While it is normal to drop our guard when we see no end in sight, a reminder of the benefits of maintaining precautions and the consequences of not doing so would help people stay vigilant to fight Covid-19, Chen added.\n" +
                        "\n" +
                        "But musician Joe Chahal, 35, said he feels \"extremely tired\" of the situation even though he complies with the measures.\n" +
                        "\n" +
                        "\"I find it difficult to breathe comfortably with a mask and I don't feel like leaving my house because I have to wear it. There's also the hassle of constantly having to check in to places with SafeEntry. There are long queues just to enter a mall or a shop on weekends.\"\n" +
                        "\n" +
                        "Because of this, he hardly goes out and does not meet his friends much now.\n" +
                        "\n" +
                        "Dr Chow cautioned that social avoidance and distancing can make people feel isolated and lonely, and may increase stress and anxiety.\n" +
                        "\n" +
                        "Chen advised people to seek help from a psychologist if they experience persistent anxiety, hopelessness or sadness for more than two weeks, which in turn affects their performance and relationships.\n" +
                        "\n" +
                        "While it is normal to feel weary in response to the pandemic, it is important to remember that \"we are not alone in our struggles\", she said.\n" +
                        "\n" +
                        "\"This is a marathon and not a short sprint, so people need to manage their expectations and pace themselves so that they are able to go the distance,\" she added.\n" +
                        "\n" +
                        "\"It is important to remind ourselves that we are doing the best we can in an unprecedented situation that we are all experiencing for the first time in our lives.\"\n" +
                        "\n" +
                        "HOW TO COPE WITH PANDEMIC FATIGUE\n" +
                        "Terri Chen, head of psychology and senior clinical psychologist at the National University Hospital's department of psychological medicine, gives some tips.\n" +
                        "\n" +
                        "BE AWARE: We cannot make changes if we are not aware of what is going on within us. When we are busy, it is easy to overlook emotions and behaviours that are warning signs for us. Practise awareness to take care of your mental health. Take some time to check in with yourself daily. This can be as short as one minute a day to observe and describe to yourself what you are thinking and feeling within.\n" +
                        "\n" +
                        "BE CREATIVE: Many of the ways we use to recharge have been thwarted or impacted by pandemic restrictions. Short getaways, for instance, are no longer an option. Neither are large gatherings, which feed our innate social needs.\n" +
                        "\n" +
                        "Being creative and open to new ideas and experiences can help you cope in the interim. For instance, you can travel vicariously with friends by having a \"watch party\" of a travel show and make a fantasy list of future travel plans together.\n" +
                        "\n" +
                        "BE KIND AND COMPASSIONATE: There are many things that are not within our control at this moment, which could leave us feeling angry and frustrated. This can lead to criticisms being directed towards ourselves or others, which may worsen our mood.\n" +
                        "\n" +
                        "Show kindness to yourself or others through one act a day. Research has shown that this can help us feel happier and it also boosts our immune system and energy levels.\n" +
                        "\n" +
                        "BE PATIENT: We do not know when the coronavirus pandemic will end and it is hard to be patient with the safety restrictions indefinitely. Make space for emotions, as it is impossible to think logically 100 per cent of the time.\n" +
                        "\n" +
                        "Try the \"five, four, three, two, one\" technique to relax: Look around you and name them aloud as you notice them: five things you can see, four things you can feel, three things you can hear, two things you can smell and one thing you can taste.\n" +
                        "\n" +
                        "BE EFFECTIVE: There are many tips and suggestions on how to cope with the pandemic, such as practising mindfulness or working out, and it can be overwhelming - and tiring - to try many things at once.\n" +
                        "\n" +
                        "It is more effective to identify what need - physical, emotional, intellectual or spiritual - is most pressing and try one technique at a time to gauge if it helps you.";

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
