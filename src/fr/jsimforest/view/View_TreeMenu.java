/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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


    public View_TreeMenu() {

        JLabel separator = new JLabel();
        separator.setText("");

        this.setLayout(new GridLayout(22, 1));
        this.Button_empty = new JButton("Empty");
        this.Button_yp = new JButton("Young plant");
        this.Button_st = new JButton("Small tree");
        this.Button_at = new JButton("Adult tree");

        //this.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
        this.setPreferredSize(new Dimension(150,0));
        this.setBackground(Color.decode("#BBBBBB"));

        this.add(new JLabel(" MENU "));
        this.add(new JLabel(" Trees : "));
        this.add(this.Button_empty);
        this.add(this.Button_yp);
        this.add(this.Button_st);
        this.add(this.Button_at);
    }
    
}
