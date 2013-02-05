/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import fr.jsimforest.controller.Controller_ForestArea;
import fr.jsimforest.view.View_ActionMenu;
import fr.jsimforest.view.View_ForestArea;
import fr.jsimforest.view.View_StatMenu;
import fr.jsimforest.view.View_TreeMenu;
import fr.jsimforest.view.View_Tree_YoungPlant;
import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;
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
        
        this.getContentPane().setLayout(new BorderLayout());
       
        JPanel forestArea_zone = new JPanel(new BorderLayout());
        this.forestArea = new View_ForestArea(this);
        
        JScrollPane scroll = new JScrollPane(this.forestArea);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);
        forestArea_zone.add(scroll);
        this.add(forestArea_zone, BorderLayout.CENTER);
        
        this.Menu_action = new View_ActionMenu(this);
        this.getContentPane().add(this.Menu_action, BorderLayout.NORTH);
        
        this.Menu_tree = new View_TreeMenu();
        this.getContentPane().add(this.Menu_tree, BorderLayout.WEST);
        
        this.Menu_stat = new View_StatMenu();
        this.getContentPane().add(this.Menu_stat, BorderLayout.SOUTH);
        
        //Reminder rmd = new Reminder(2);
        
        this.updateForest();
        
        this.setVisible(true);
        //this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);                

    }
    
    public void updateForest() {
        this.forestArea.updateGrid();
        this.Menu_stat.updateLabelStat();
    }

    /**
     * @param Window_title the Window_title to set
     */
    public void setWindow_title(String Window_title) {
        //this.Window_title = Window_title;
        this.setTitle(Window_title);
    }

    public void forestAreaZoomIn() {
        this.forestArea.zoomin();
    }

    public void forestAreaZoomOut() {
        this.forestArea.zoomout();
    }


    
}
