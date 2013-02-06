/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_Cell;
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
    private static int Cell_width;
    private static int Cell_height;
    
    private Color color;
    
    public View_Cell(int x, int y, Color color) {
        
        this.x = x;
        this.y = y;
        this.color = color;
        
        this.addMouseListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        this.setPreferredSize(new Dimension(View_Cell.getCell_width(), View_Cell.getCell_height()));
        this.setBackground(this.color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 1)); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        
        View_ForestArea fa = (View_ForestArea) getParent();
        fa.setCellAt(this.x, this.y, Controller_Cell.getSelected_tree());
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
    /**
     * @return the Cell_width
     */
    public static int getCell_width() {
        return Cell_width;
    }

    /**
     * @param aCell_width the Cell_width to set
     */
    public static void setCell_width(int aCell_width) {
        Cell_width = aCell_width;
    }

    /**
     * @return the Cell_height
     */
    public static int getCell_height() {
        return Cell_height;
    }

    /**
     * @param aCell_height the Cell_height to set
     */
    public static void setCell_height(int aCell_height) {
        Cell_height = aCell_height;
    }
    
}
