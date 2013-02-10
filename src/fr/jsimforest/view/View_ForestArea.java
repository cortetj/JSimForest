/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import fr.jsimforest.tools.Enum_Cell;
import fr.jsimforest.view.View_Cell;
import jsimforest.Window;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
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
    private static boolean map_border;

            
    public View_ForestArea(Window win) {
                
        this.parent = win;
        View_ForestArea.map_border = true;
        
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
                    case 7 : this.Cells[i][j] = new View_Cell(i, j, Enum_Cell.SMALL_OLDTREE.getColor());
                        break;
                }
                
                this.add(this.Cells[i][j], this.gbc);
            }
        }
        this.revalidate();
        this.repaint();
    }
    
    public void updateGridColors() {
        
        Controller_ForestArea.updatePropWithTab();
        
        for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
                        
            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
                
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
                    case 7 : this.Cells[i][j].setBackground(Enum_Cell.SMALL_OLDTREE.getColor());
                        break;
                }
            }
        }
        //this.revalidate();
        
        
        
    }

    public void updateGridBorder() {
        
        Controller_ForestArea.updatePropWithTab();
        
        for(int i=0; i<Controller_ForestArea.getHeight(); i++) {
                       
            for(int j=0; j<Controller_ForestArea.getWidth(); j++) {
                if(View_ForestArea.isMap_border()) {
                    this.Cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
                else {this.Cells[i][j].setBorder(null);} 
            }
        }        
        
    }
    
    public void setCellAt(int x, int y, int cell) {

                switch(cell) {
                    case 0 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 0);
                        this.Cells[x][y].setBackground(Enum_Cell.EMPTY.getColor());
                        break;
                    case 1 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 1);
                        this.Cells[x][y].setBackground(Enum_Cell.YOUNG_PLANT.getColor());
                        break;
                    case 2 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 2);
                        this.Cells[x][y].setBackground(Enum_Cell.SMALL_TREE.getColor());
                        break;
                    case 3 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 3);
                        this.Cells[x][y].setBackground(Enum_Cell.ADULT_TREE.getColor());
                        break;
                    case 4 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 4);
                        this.Cells[x][y].setBackground(Enum_Cell.FIRE.getColor());
                        break;
                    case 5 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 5);
                        this.Cells[x][y].setBackground(Enum_Cell.INFECT.getColor());
                        break;
                    case 6 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 6);
                        this.Cells[x][y].setBackground(Enum_Cell.ASH.getColor());
                        break;
                    case 7 :
                        Controller_ForestArea.setForestAreaTabAt(x, y, 7);
                        this.Cells[x][y].setBackground(Enum_Cell.SMALL_OLDTREE.getColor());
                        break;
                }
            
            //this.revalidate();
            this.repaint(); 
            View_StatMenu.updateLabelStat();
    }

    public void zoomin() {
        
        if (View_Cell.getCell_height() <= 8) {
            
            View_Cell.setCell_height(View_Cell.getCell_height() + 1);
            View_Cell.setCell_width(View_Cell.getCell_width() + 1);
        }
        
        else if (View_Cell.getCell_height() > 8) {
            
            View_Cell.setCell_height(View_Cell.getCell_height() + 2);
            View_Cell.setCell_width(View_Cell.getCell_width() + 2);
        }
        
        this.createGrid();
    }

    public void zoomout() {
        System.out.println(View_Cell.getCell_height());
        if (View_Cell.getCell_height() > 1 && View_Cell.getCell_height() <= 8) {
            
            View_Cell.setCell_height(View_Cell.getCell_height() - 1);
            View_Cell.setCell_width(View_Cell.getCell_width() - 1);
        }
        else if (View_Cell.getCell_height() > 8) {
            
            View_Cell.setCell_height(View_Cell.getCell_height() - 2);
            View_Cell.setCell_width(View_Cell.getCell_width() - 2);
        }
        
        this.createGrid();

    }
    
    /**
     * @return the map_border
     */
    public static boolean isMap_border() {
        return map_border;
    }

    /**
     * @param aMap_border the map_border to set
     */
    public static void setMap_border(boolean aMap_border) {
        map_border = aMap_border;
    }
    
}
