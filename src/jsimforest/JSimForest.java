/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsimforest;

import fr.jsimforest.controller.Controller_Save;
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

       // Window w = new Window();
       fr.jsimforest.model.Model_Singleton.connectToDB();
       
       Controller_Save saves = new Controller_Save();
       for(int i=0; i<saves.getSaves().size();i++){
           System.out.print("Nom sauvegarde n°"+(i+1)+" <--> ID n°"+saves.getSaves().get(i).getId_save() +" ||| "+saves.getSaves().get(i).getName_save()+" ");
           System.out.print("Forest n°"+(i+1)+" : "+saves.getSaves().get(i).getForest_save()+" ||| ");
           System.out.print("ID Stat n°"+(i+1)+" : "+saves.getSaves().get(i).getId_stat()+" ||| ");
           System.out.print("t = "+saves.getSaves().get(i).getStats().getT()+" ||| ");
           System.out.print("STAT cells empty : "+saves.getSaves().get(i).getStats().getT()+" ||| ");
           System.out.print("STAT cells young plant : "+saves.getSaves().get(i).getStats().getStat_youngplant()+" ||| ");
           System.out.print("STAT cells young tree: "+saves.getSaves().get(i).getStats().getStat_youngtree()+" ||| ");
           System.out.print("STAT cells tree: "+saves.getSaves().get(i).getStats().getStat_tree()+" ||| ");
           System.out.print("STAT cells fire : "+saves.getSaves().get(i).getStats().getStat_fire()+" ||| ");
           
           
       }
    }
}
