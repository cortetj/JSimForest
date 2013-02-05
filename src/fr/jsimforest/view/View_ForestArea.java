/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import jsimforest.Window;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 *
 * @author EggMan
 */
public class View_ForestArea extends JPanel{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private Window parent;
    
    public View_ForestArea(Window win) {

         this.parent = win;
        Controller_ForestArea ctr = new Controller_ForestArea();
        
        View_Cell.setCell_height(12);
        View_Cell.setCell_width(12);
        
        this.setBackground(Color.decode("#DDDDDD"));
        this.gbl = new GridBagLayout();
        this.setLayout(this.gbl);
        
        this.gbc = new GridBagConstraints();
        this.gbc.gridheight = 1;
        this.gbc.gridwidth = 1;

        this.updateGrid();
        
    }
    
    public void updateGrid() {
        
        this.removeAll();   
        
        
        for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
            
            this.gbc.gridy = i;
            
            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
                
                this.gbc.gridx = j;

                switch(Controller_ForestArea.getForestAreaTab()[i][j]) {
                    case 0 : this.add(new View_Cell_Empty(i, j), this.gbc);
                        break;
                    case 1 : this.add(new View_Tree_YoungPlant(i, j), this.gbc);
                        break;
                    case 2 : this.add(new View_Tree_SmallTree(i, j), this.gbc);
                        break;
                    case 3 : this.add(new View_Tree_AdultTree(i, j), this.gbc);
                        break;
                    case 4 : this.add(new View_Tree_Fire(i, j), this.gbc);
                        break;
                    case 5 : this.add(new View_Tree_Infect(i, j), this.gbc);
                        break;
                    case 6 : this.add(new View_Cell_Ash(i, j), this.gbc);
                        break;
                }

            }
        }
        this.revalidate();
        this.repaint();
         
        this.parent.setWindow_title("JSimForest - " + Controller_ForestArea.getName());
        
        
    }
    
    public void setCellAt(int x, int y, int cell) {
            System.err.println(" X : " + x);
            
            this.gbc.gridx = x;
            this.gbc.gridy = y;

                switch(cell) {
                    case 0 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 0);
                        this.add(new View_Cell_Empty(x, y), this.gbc);
                        break;
                    case 1 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 1);
                        this.add(new View_Tree_YoungPlant(x, y), this.gbc);
                        break;
                    case 2 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 2);
                        this.add(new View_Tree_SmallTree(x, y), this.gbc);
                        break;
                    case 3 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 3);
                        this.add(new View_Tree_AdultTree(x, y), this.gbc);
                        break;
                    case 4 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 4);
                        this.add(new View_Tree_Fire(x, y), this.gbc);
                        break;
                    case 5 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 5);
                        this.add(new View_Tree_Infect(x, y), this.gbc);
                        break;
                    case 6 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 6);
                        this.add(new View_Cell_Ash(x, y), this.gbc);
                        break;
                }
            
            this.revalidate();
            //this.repaint(); 
            View_StatMenu.updateLabelStat();
    }

    public void zoomin() {
        View_Cell.setCell_height(View_Cell.getCell_height() + 2);
        View_Cell.setCell_width(View_Cell.getCell_width() + 2);
        
        System.out.println("Cell : " + View_Cell.getCell_height());
        this.updateGrid();
    }

    public void zoomout() {
        if (View_Cell.getCell_height() > 2 && View_Cell.getCell_width() > 2) {
            
            View_Cell.setCell_height(View_Cell.getCell_height() - 2);
            View_Cell.setCell_width(View_Cell.getCell_width() - 2);
        }
        
        System.out.println("Cell : " + View_Cell.getCell_height());
        this.updateGrid();
    }
}
