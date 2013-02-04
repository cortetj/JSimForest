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
               
        
        //Color Color_back = Color.decode("#EEEEEE");
        
        //this.setPreferredSize(new Dimension(200,200));
        this.setBackground(Color.decode("#DDDDDD"));
        //this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.gbl = new GridBagLayout();
        this.setLayout(this.gbl);
        
        this.gbc = new GridBagConstraints();
        this.gbc.gridheight = 1;
        this.gbc.gridwidth = 1;
                    System.out.println(" / " + Controller_ForestArea.getWidth());

        for(int i=0; i<Controller_ForestArea.getWidth(); i++) {
            System.out.println((i+1) + " / " + Controller_ForestArea.getWidth());
            for(int j=0; j<Controller_ForestArea.getHeight(); j++) {
                
                this.gbc.gridx = j;
                this.gbc.gridy = i;

                switch(Controller_ForestArea.getForestAreaTab()[i][j]) {
                    case 0 : this.add(new View_Tree(), this.gbc);
                    case 1 : this.add(new View_Tree_YoungPlant(), this.gbc);
                    case 2 : this.add(new View_Tree_SmallTree(), this.gbc);
                    case 3 : this.add(new View_Tree_AdultTree(), this.gbc);
                }
                
            }
        }
        

    }
    
    public void setCellAt(int x, int y, View_Tree tree) {
        
            this.gbc.gridx = x;
            this.gbc.gridy = y;
            
            this.add(new View_Tree(), this.gbc);

    }
}
