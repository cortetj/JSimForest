/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
/**
 *
 * @author EggMan
 */
public class View_Tree_YoungPlant extends View_Cell implements MouseListener { 
    
    public View_Tree_YoungPlant(int x, int y) {    
        super(x, y, Color.decode("#54ff54"));
    }

}
