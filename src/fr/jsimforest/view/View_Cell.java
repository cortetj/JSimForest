/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 *
 * @author EggMan
 */
public class View_Cell extends JPanel implements MouseListener { 
    
    private int x;
    private int y;
    
    private Color color;
    
    public View_Cell(int x, int y, Color color) {
        
        this.x = x;
        this.y = y;
        this.color = color;
        
        this.addMouseListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        this.setPreferredSize(new Dimension(12,12));
        this.setBackground(this.color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 1)); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(" class : " + this.getClass());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        
        View_ForestArea fa = (View_ForestArea) getParent();
        
        fa.setCellAt(this.x, this.y, 2);
        fa.updateGrid();

//       for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
//            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
//                System.out.print(Controller_ForestArea.getForestAreaTab()[i][j]);
//            }
//                System.out.println("");
//        }
//        System.out.println("");
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    }
