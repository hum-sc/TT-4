package TT4;

import java.awt.Dimension;
import java.util.concurrent.CompletableFuture;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window () {
        super();
    }

    public Window(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Window (String title, int width, int height) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(width, height));
    }

    public int[] getInt(int n, String[] labels, String message, String submitMessage){
        InputPanel inputPanel = new InputPanel(n, message, labels, submitMessage, 5, int.class);
        this.getContentPane().add(inputPanel);
        this.pack();
        int[] inputs = null;
        try {
            inputs = inputPanel.getIntInputs();
        } catch (Exception e) {
        }
        this.getContentPane().remove(inputPanel);
        this.repaint();
        return inputs;
    }

    public void showTables(int n, String[][] pLabels, int[][][] values){
        for (int i = 0; i < n; i++) {
            String headers[] = pLabels[i];
            String[][] tableValues = new String[values[i].length][values[i][0].length];
            for (int j = 0; j < values[i].length; j++) {
                for (int k = 0; k < values[i][j].length; k++) {
                    tableValues[j][k] = Integer.toString(values[i][j][k]);
                }
            }
            TablePanel tablePanel = new TablePanel(headers, tableValues);
            this.getContentPane().add(tablePanel);
            this.pack();
            this.repaint();
        }
    }


}