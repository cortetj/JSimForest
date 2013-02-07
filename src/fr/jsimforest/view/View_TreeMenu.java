/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_Cell;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jsimforest.Window;

/**
 *
 * @author EggMan
 */
public class View_TreeMenu extends JPanel {

    private static int selected_tree;
    
    private JButton Button_empty;
    private JButton Button_yp;
    private JButton Button_st;
    private JButton Button_at;
    
    private JCheckBox Check_Border;


    public View_TreeMenu(final Window parent) {

        JLabel separator = new JLabel();
        separator.setText("");

        this.setLayout(new GridLayout(22, 1));
        this.Button_empty = new JButton("Empty");
        ImageIcon Ico_cell_empty = new ImageIcon("img/ico_cell_empty.png");        
        this.Button_empty = new JButton(Ico_cell_empty);
        this.Button_empty.setOpaque(false);
        this.Button_empty.setBorderPainted(false);
        this.Button_empty.setContentAreaFilled(false);
        this.Button_empty.setPreferredSize(new Dimension(130, 34));
        this.Button_empty.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(0);
          }
        });
        
        this.Button_yp = new JButton("Young plant");
        this.Button_yp.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(1);
          }
        });
        
        this.Button_st = new JButton("Small tree");
        this.Button_st.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(2);
          }
        });
        
        this.Button_at = new JButton("Adult tree");
        this.Button_at.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(3);
          }
        });
        
        this.Check_Border = new JCheckBox("Border", null, true);
        this.Check_Border.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                View_ForestArea.setMap_border(Check_Border.isSelected());
                parent.updateBorder();
          }
        });
        

        //this.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
        this.setPreferredSize(new Dimension(150,0));
        this.setBackground(Color.decode("#DDDDDD"));

        this.add(new JLabel(" MENU "));
        
        this.add(new JLabel(" Trees : "));
        this.add(this.Button_empty);
        this.add(this.Button_yp);
        this.add(this.Button_st);
        this.add(this.Button_at);

        this.add(new JLabel(""));
        
        this.add(new JLabel(" Preference : "));
        this.add(this.Check_Border);
    }
    
}
