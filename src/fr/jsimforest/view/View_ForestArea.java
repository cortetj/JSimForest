/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EggMan
 */
public class View_ForestArea extends JPanel{
    
    private int height;
    private int width;
    
    public View_ForestArea() {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
        this.setPreferredSize(new Dimension(200,200));  
        this.setBackground(Color.BLUE);  
    }
}
