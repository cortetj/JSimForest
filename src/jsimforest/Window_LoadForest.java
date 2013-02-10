/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EggMan
 */
public class Window_LoadForest extends JFrame {
    
        private JPanel Buttons;
        private JPanel Form;
        
        private JButton Button_ok;
        private JButton Button_cancel;
        
        private JTable Table_loads;
        private JTable Table_names;
        
        private JSplitPane split;
        private DefaultTableModel Model_loads;
        private DefaultTableModel Model_names;
        
    public Window_LoadForest() {
        
        this.setTitle("Create new forest");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());
        
        this.Buttons = new JPanel();
        
        this.Button_ok = new JButton("OK");
        this.Button_cancel = new JButton("Cancel");
        
        this.Buttons.add(this.Button_ok);
        this.Buttons.add(this.Button_cancel);
        
        this.add(this.Buttons, BorderLayout.SOUTH);
        
        
        String[] col_names = {"Name", "Last save"};
        String[] col_loads = {"id", "Date"};
        
        Object[][] data = {{

        }};
        
        this.Form = new JPanel();
        this.Form.setLayout(new GridLayout(1,1));
        
        this.Model_loads = new DefaultTableModel(data, col_loads);
        this.Model_names = new DefaultTableModel(data, col_names);
        this.Table_loads = new JTable(Model_loads);
        this.Table_names = new JTable(Model_names);
        
        this.split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(Table_names) ,new JScrollPane(Table_loads));
        split.setDividerLocation(300);
                
        this.Form.add(this.split);
        this.add(this.Form);
        this.setVisible(true);
        
        
        
    }
    
}
