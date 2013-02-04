/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
/**
 *
 * @author EggMan
 */
public class View_Tree_AdultTree extends View_Tree { 
    public View_Tree_AdultTree() {

        this.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        this.setPreferredSize(new Dimension(12,12));
        this.setBackground(Color.decode("#0b210b"));

    }
}
