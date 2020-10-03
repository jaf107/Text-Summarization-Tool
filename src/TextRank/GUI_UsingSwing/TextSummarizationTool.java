package TextRank.GUI_UsingSwing;

import TextRank.FinalProject.SummaryTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextSummarizationTool {

    private JFrame frame ;
    private JTextArea context;
    private JTextArea summary;
    private JButton summarize;
    private JLabel contextLabel;
    private JLabel summaryLabel;

    TextSummarizationTool()
    {
        frame = new JFrame("Text Summarization Tool");
        JPanel mainPanel = new JPanel();
        Font mFont = new Font("Helvetica",Font.BOLD,12);
        contextLabel = new JLabel("Context");
        summaryLabel = new JLabel("Summary");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Context setting
        context = new JTextArea(30,50);
        context.setLineWrap(true);
        context.setWrapStyleWord(true);
        context.setFont(mFont);

        // Summary setting
        summary = new JTextArea(30,50);
        summary.setFont(mFont);
//        summary.setLineWrap(true);
//        summary.setWrapStyleWord(true);


        // Context scroll pane
        JScrollPane cJScrollPane = new JScrollPane(context);
        cJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Summary scroll pane
        JScrollPane sJScrollPane = new JScrollPane(summary);
        sJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


        summarize = new JButton("\nSummarize\n");

//        mainPanel.add(contextLabel);
        mainPanel.add(cJScrollPane);

//        mainPanel.add(summaryLabel);
        mainPanel.add(sJScrollPane);

        mainPanel.add(summarize);
        summarize.addActionListener(new SummarizeListener());

        // Add things to frame
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(1920,1080);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextSummarizationTool();
            }
        });
    }

    private class SummarizeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            String para = context.getText();

            SummaryTool tool = new SummaryTool(para);
            String summ = tool.getSummary();

            summary.setText(summ);
        }
    }
}
