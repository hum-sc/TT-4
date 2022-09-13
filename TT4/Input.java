package TT4;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input extends JPanel {
    private JLabel label;
    private JTextField textField;
    public Input(String labelText, int textFieldWidth) {
        super();
        this.textField = new JTextField(textFieldWidth);
        
        this.label = new JLabel(labelText);
        this.label.setLabelFor(textField);

        this.add(this.label);
        this.add(this.textField);
    }

    public String getText() {
        return this.textField.getText();
    }

    public void handleInput() {
        this.textField.setEditable(!this.textField.isEditable());
    }
}
