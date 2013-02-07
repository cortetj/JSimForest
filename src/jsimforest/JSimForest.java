/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

/**
 *
 * @author EggMan
 */
public class JSimForest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    try 
    {
      UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }

        Window w = new Window();
    }
}
