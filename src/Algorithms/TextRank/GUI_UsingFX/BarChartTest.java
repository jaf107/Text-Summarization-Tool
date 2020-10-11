package Algorithms.TextRank.GUI_UsingFX;

import CrossValidation.CrossValidation;
import CrossValidation.CrossValidationCheck;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BarChartTest extends Application {

        @Override
        public void start (Stage primaryStage) throws Exception {
            primaryStage.setTitle("BarChart Experiments");

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

            Scene scene = new Scene(pane, 1000, 500);

            primaryStage.setScene(scene);
//            primaryStage.setHeight(300);
//            primaryStage.setWidth(1200);

            primaryStage.show();
        }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
