/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import fr.jsimforest.model.Enum_Cell;
import fr.jsimforest.view.View_Cell;
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
    private View_Cell Cells[][];
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

        this.createGrid();
        
    }
    
    public void createGrid() {
        
        this.removeAll();   

        this.Cells = new View_Cell[Controller_ForestArea.getHeight()][Controller_ForestArea.getWidth()];
        Controller_ForestArea.updatePropWithTab();
        
        for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
            this.gbc.gridy = i;
            
            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
                this.gbc.gridx = j;
                
                switch(Controller_ForestArea.getForestAreaTab()[i][j]) {
                    case 0 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.EMPTY.getColor());
                        break;
                    case 1 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.YOUNG_PLANT.getColor());
                        break;
                    case 2 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.SMALL_TREE.getColor());
                        break;
                    case 3 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.ADULT_TREE.getColor());
                        break;
                    case 4 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.FIRE.getColor());
                        break;
                    case 5 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.INFECT.getColor());
                        break;
                    case 6 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.ASH.getColor());
                        break;
                }
                
                this.add(this.Cells[i][j], this.gbc);
            }
        }
        this.revalidate();
        this.repaint();
    }
    
    public void updateGrid() {
        
        Controller_ForestArea.updatePropWithTab();
        
        for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
            
            this.gbc.gridy = i;
            
            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
                
                this.gbc.gridx = j;

                switch(Controller_ForestArea.getForestAreaTab()[i][j]) {
                    
                    case 0 : this.Cells[i][j].setBackground(Enum_Cell.EMPTY.getColor());
                        break;
                    case 1 : this.Cells[i][j].setBackground(Enum_Cell.YOUNG_PLANT.getColor());
                        break;
                    case 2 : this.Cells[i][j].setBackground(Enum_Cell.SMALL_TREE.getColor());
                        break;
                    case 3 : this.Cells[i][j].setBackground(Enum_Cell.ADULT_TREE.getColor());
                        break;
                    case 4 : this.Cells[i][j].setBackground(Enum_Cell.FIRE.getColor());
                        break;
                    case 5 : this.Cells[i][j].setBackground(Enum_Cell.INFECT.getColor());
                        break;
                    case 6 : this.Cells[i][j].setBackground(Enum_Cell.ASH.getColor());
                        break;
                }

            }
        }
        System.out.println("eslez");
        //this.revalidate();
        
        
        
    }
    
    public void setCellAt(int x, int y, int cell) {
            System.err.println(" X : " + x);

                switch(cell) {
                    case 0 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 0);
                        this.Cells[x][y].setBackground(Color.WHITE);
                        break;
                    case 1 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 1);
                        this.Cells[x][y].setBackground(Color.BLUE);
                        break;
                    case 2 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 2);
                        this.Cells[x][y].setBackground(Color.GREEN);
                        break;
                    case 3 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 3);
                        this.Cells[x][y].setBackground(Color.CYAN);
                        break;
                    case 4 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 4);
                        this.Cells[x][y].setBackground(Color.WHITE);
                        break;
                    case 5 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 5);
                        this.Cells[x][y].setBackground(Color.WHITE);
                        break;
                    case 6 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 6);
                        this.Cells[x][y].setBackground(Color.WHITE);
                        break;
                }
            
            //this.revalidate();
            this.repaint(); 
            View_StatMenu.updateLabelStat();
    }

    public void zoomin() {
        View_Cell.setCell_height(View_Cell.getCell_height() + 2);
        View_Cell.setCell_width(View_Cell.getCell_width() + 2);
        
        this.updateGrid();
    }

    public void zoomout() {
        if (View_Cell.getCell_height() > 2 && View_Cell.getCell_width() > 2) {
            
            View_Cell.setCell_height(View_Cell.getCell_height() - 2);
            View_Cell.setCell_width(View_Cell.getCell_width() - 2);
        }
        
        this.updateGrid();
    }
}
