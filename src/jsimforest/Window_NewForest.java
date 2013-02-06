/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import fr.jsimforest.controller.Controller_ForestArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author EggMan
 */
public class Window_NewForest extends JFrame {
    
        private JPanel Buttons;
        private JPanel Form;
        
        private JButton Button_ok;
        private JButton Button_cancel;
        
        private JTextField Text_name;
                
        private JSpinner Spinner_width;
        private JSpinner Spinner_height;
                
        private SpinnerNumberModel Model_width;
        private SpinnerNumberModel Model_height;
        
    public Window_NewForest(final Window parent) {
        
        this.setTitle("Create new forest");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new GridLayout(15,1));
        
        this.Buttons = new JPanel();
        this.Form = new JPanel();
        this.Text_name = new JTextField();
        
        this.Form.setLayout(new BoxLayout(this.Form, BoxLayout.LINE_AXIS));
        this.Form.setPreferredSize(new Dimension(400,100));
        //this.Form.setBackground(Color.BLUE);
        this.Button_ok = new JButton("OK");
        
        this.Button_cancel = new JButton("Cancel");
        
        this.Model_width = new SpinnerNumberModel(50, 1, 400, 1); 
        this.Model_height = new SpinnerNumberModel(50, 1, 400, 1); 
        
        this.Buttons.add(this.Button_ok);
        this.Buttons.add(this.Button_cancel);

        this.Spinner_height = new JSpinner(this.Model_height);
        this.Spinner_width = new JSpinner(this.Model_width);

        this.Button_ok.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_ForestArea.defautTab(Model_width.getNumber().intValue(), Model_height.getNumber().intValue(), Text_name.getText());
                parent.updateForest();
                dispose();
          }
        });
        
        this.Button_cancel.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                dispose();
          }
        });
        this.Form.add(new JLabel("Name"));
        this.Form.add(this.Text_name);
        this.Form.add(new JLabel("Height"));
        this.Form.add(this.Spinner_height);
        this.Form.add(new JLabel("Width"));
        this.Form.add(this.Spinner_width);

        this.add(Form, BorderLayout.CENTER);
        this.add(Buttons, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
       
        
    }
    
}
