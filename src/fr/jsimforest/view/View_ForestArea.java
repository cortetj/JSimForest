/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
/**
 *
 * @author EggMan
 */
public class View_ForestArea extends JPanel{
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    public View_ForestArea() {
               
        Controller_ForestArea ctr = new Controller_ForestArea();

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
        this.repaint();
        
        for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
            
            this.gbc.gridy = i;
            
            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
                
                this.gbc.gridx = j;

                switch(Controller_ForestArea.getForestAreaTab()[j][i]) {
                    case 0 : this.add(new View_Cell_Empty(j, i), this.gbc);
                        break;
                    case 1 : this.add(new View_Tree_YoungPlant(j, i), this.gbc);
                        break;
                    case 2 : this.add(new View_Tree_SmallTree(j, i), this.gbc);
                        break;
                    case 3 : this.add(new View_Tree_AdultTree(j, i), this.gbc);
                        break;
                }

            }
        }
        
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
                }
            
            this.revalidate();
            //this.repaint(); 
            
    }
}
