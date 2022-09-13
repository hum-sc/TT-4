package TT4;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;

public class TablePanel extends JPanel {
    private JLabel titleLabel;
    private JTable table;

    /**
     * @param headers
     * @param values
     */
    public TablePanel(String[] headers, String[][] values) {
        super();
        this.titleLabel = new JLabel("Table");
        this.titleLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(this.titleLabel);

        this.table = new JTable(values, headers);
        JScrollPane scrollPane = new JScrollPane(this.table);
        this.add(scrollPane);
        
        this.setPreferredSize(new Dimension(300,300));
    }
    
    
}
