/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import fr.jsimforest.view.View_Stats;
import fr.jsimforest.view.View_ActionMenu;
import fr.jsimforest.view.View_ForestArea;
import fr.jsimforest.view.View_StatMenu;
import fr.jsimforest.view.View_TreeMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
    private View_Stats Tab_stat;
    private JTabbedPane tab;
                     
    public Window() {
        
        this.setTitle("JSimForest");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().setLayout(new BorderLayout());
       
        this.forestArea = new View_ForestArea(this);
        this.tab = new JTabbedPane(JTabbedPane.TOP);
        this.tab.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JPanel forestArea_zone = new JPanel(new BorderLayout());
        this.Tab_stat = new View_Stats();
        
        
        JScrollPane scroll = new JScrollPane(this.forestArea);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);
        tab.add("Forest" ,scroll);
        tab.add("Statistic", this.Tab_stat);
        
        forestArea_zone.add(tab);
        this.add(forestArea_zone, BorderLayout.CENTER);
        
        this.Menu_action = new View_ActionMenu(this);
        this.getContentPane().add(this.Menu_action, BorderLayout.NORTH);
        
        this.Menu_tree = new View_TreeMenu(this);
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
        this.forestArea.updateGridColors();
        View_StatMenu.updateLabelStat();
    }
    
    public void updateBorder() {
        this.forestArea.updateGridBorder();
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

    void newForest() {
        this.forestArea.createGrid();
        View_StatMenu.updateLabelStat();
    }


    
}
