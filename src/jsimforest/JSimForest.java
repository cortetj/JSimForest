/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;


/**
 *
 * @author EggMan
 */
public class JSimForest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
               // Set cross-platform Java L&F (also called "Metal")
           UIManager.setLookAndFeel(
               UIManager.getCrossPlatformLookAndFeelClassName());
       } 
       catch (UnsupportedLookAndFeelException e) {
          // handle exception
       }
       catch (ClassNotFoundException e) {
          // handle exception
       }
       catch (InstantiationException e) {
          // handle exception
       }
       catch (IllegalAccessException e) {
          // handle exception
       }
       UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));

        Window w = new Window();
    }
}
