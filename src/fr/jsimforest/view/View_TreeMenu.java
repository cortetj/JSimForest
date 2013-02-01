/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author EggMan
 */
public class View_TreeMenu extends JPanel {
    public View_TreeMenu() {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
        this.setPreferredSize(new Dimension(200,200));  
        this.setBackground(Color.ORANGE);        
    }
    
}
