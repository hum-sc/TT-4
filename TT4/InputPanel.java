package TT4;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
public class InputPanel extends JPanel implements ActionListener {
  
    private Input[] inputFields;
    private JButton submitButton;
    private JLabel titleLabel;
    private CompletableFuture<int[]> intInputs;
    private CompletableFuture<double[]> doubleInputs;
    private CompletableFuture<String[]> stringInputs;
    private Class tType;
    public InputPanel(int n,String title, String[] labels, String submitMessage, int textFieldWidth, Class tType) {
        super();
        this.tType = tType;
        this.inputFields = new Input[n];
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        this.titleLabel = new JLabel(title);
        this.titleLabel.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.ipady = 20;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints. PAGE_START;
        this.add(this.titleLabel, c);

       
        int i;
        for (i = 0; i < n; i++) {
            this.inputFields[i] = new Input(labels[i], textFieldWidth);
            c.gridx = 0;
            c.gridy = i+1;
            c.gridwidth = 1;
            c.weightx = 0.5;
            c.ipady = 0;
            this.add(this.inputFields[i], c);
        }

        this.submitButton = new JButton(submitMessage);
        this.submitButton.setActionCommand("ok");
        this.submitButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,10,10);  //top padding
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = i+1;  

        this.add(submitButton, c);
    }

    public int[] getIntInputs() throws InterruptedException, ExecutionException{
        intInputs = new CompletableFuture<int[]>();
        return (int[]) intInputs.get();
    }

    public String[] getStringInputs() throws InterruptedException, ExecutionException{
        stringInputs = new CompletableFuture<String[]>();
        return (String[]) stringInputs.get();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ok")){
            int[] inputs = new int[inputFields.length];
            if (tType == int.class) {
                try{
                    for (int i = 0; i < inputFields.length; i++) {
                        inputs[i] = Integer.parseInt(inputFields[i].getText());
                    }
                    intInputs.complete(inputs);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        

    }
}
