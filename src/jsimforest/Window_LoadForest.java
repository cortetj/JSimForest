/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import fr.jsimforest.model.Model_Connection;
import javax.swing.JFrame;

/**
 *
 * @author EggMan
 */
public class Window_LoadForest extends JFrame {
    
    public Window_LoadForest() {
        
        this.setTitle("Create new forest");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        Model_Connection connect = new Model_Connection();
    }
    
}
