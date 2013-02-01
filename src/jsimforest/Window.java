/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import fr.jsimforest.view.View_ActionMenu;
import fr.jsimforest.view.View_ForestArea;
import fr.jsimforest.view.View_StatMenu;
import fr.jsimforest.view.View_TreeMenu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author EggMan
 */
public class Window extends JFrame{

    private View_ForestArea forestArea;
    private View_ActionMenu Menu_action;
    private View_TreeMenu Menu_tree;
    private View_StatMenu Menu_stat;
                 
    public Window() {
        this.setTitle("JSimForest");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.getContentPane().setLayout(new BorderLayout());
       
     
        this.forestArea = new View_ForestArea();
        this.getContentPane().add(this.forestArea, BorderLayout.CENTER);
        
        this.Menu_action = new View_ActionMenu();
        this.getContentPane().add(this.Menu_action, BorderLayout.NORTH);
        
        this.Menu_tree = new View_TreeMenu();
        this.getContentPane().add(this.Menu_tree, BorderLayout.WEST);
        
        this.Menu_stat = new View_StatMenu();
        this.getContentPane().add(this.Menu_stat, BorderLayout.SOUTH);
        
        this.setVisible(true);
        

    }
    
}
