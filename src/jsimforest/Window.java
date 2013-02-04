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
import java.awt.BorderLayout;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Timer;
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
     
        Controller_ForestArea ctr = new Controller_ForestArea();
  
        JPanel forestArea_zone = new JPanel(new BorderLayout());
        this.forestArea = new View_ForestArea();
        
        JScrollPane scroll = new JScrollPane(this.forestArea);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);
        forestArea_zone.add(scroll);
        this.add(forestArea_zone, BorderLayout.CENTER);
        
        this.Menu_action = new View_ActionMenu();
        this.getContentPane().add(this.Menu_action, BorderLayout.NORTH);
        
        this.Menu_tree = new View_TreeMenu();
        this.getContentPane().add(this.Menu_tree, BorderLayout.WEST);
        
        this.Menu_stat = new View_StatMenu();
        this.getContentPane().add(this.Menu_stat, BorderLayout.SOUTH);
        
        Reminder rmd = new Reminder(2);
        
        this.update();
        
        this.setVisible(true);
        //this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    
    private void update() {
        this.Menu_stat.updateLabelStat();
    }
    
}

class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(),
                       0,        //initial delay
                       1*1000);
	}

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            System.out.format("Time's up!%n");
            //timer.cancel(); //Terminate the timer thread
        }
    }

}