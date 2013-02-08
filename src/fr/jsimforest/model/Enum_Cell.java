/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

import java.awt.Color;

/**
 *
 * @author EggMan
 */
public enum Enum_Cell {
  
    EMPTY(Color.decode("#E8D3BE"), 0), 
    YOUNG_PLANT(Color.decode("#54ff54"), 1), 
    SMALL_TREE(Color.decode("#2a7e2a"), 2), 
    ADULT_TREE(Color.decode("#0b210b"), 3), 
    FIRE(Color.decode("#E0AF1B"), 4), 
    INFECT(Color.decode("#E01BD9"), 5), 
    ASH(Color.decode("#CCCCCC"), 6),
    SMALL_OLDTREE(Color.decode("#2a7e2a"), 7);
      
     private Color Cell_color; 
     private int Cell_ref; 

     private Enum_Cell(Color color, int ref) {  
         this.Cell_color = color; 
         this.Cell_ref = ref;
    }
    
    public Color getColor() {  
         return  this.Cell_color;  
    }
    public int getRef() {  
         return  this.Cell_ref;  
    }
}
