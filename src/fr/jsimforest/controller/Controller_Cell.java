/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

/**
 *
 * @author EggMan
 */
public class Controller_Cell { 
    
    private static int Selected_tree;


    
    public Controller_Cell() {
        
    }
    
    /**
     * @return the Selected_tree
     */
    public static int getSelected_tree() {
        return Selected_tree;
    }

    /**
     * @param aSelected_tree the Selected_tree to set
     */
    public static void setSelected_tree(int aSelected_tree) {
        Selected_tree = aSelected_tree;
    }
}
