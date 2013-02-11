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
import fr.jsimforest.model.Model_Save;
import fr.jsimforest.model.Model_SaveDAO;
import fr.jsimforest.model.Model_Singleton;
import fr.jsimforest.model.Model_Stats;
import fr.jsimforest.model.Model_StatsDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author EggMan
 */
public class JSimForest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
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
       
       /////////////// MEMENTO TYPE DATE ///////////////////
       
       /*
       Date today;
       String dateOut;
       DateFormat dateFormatter;
       dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
       today = new Date();
       dateOut = dateFormatter.format(today);
       System.out.println(dateOut + " " );*/
       
       /////////////// ADD SAVE WITH STATS ///////////////////
       
    /* Model_Save savegame = new Model_Save(1, "simu16", "fqefvdsf");
     ArrayList<Model_Stats> stats = new ArrayList<Model_Stats>();
     stats.add(new Model_Stats(0, 174, 12, 13, 14, 114, 232, 132,1521,0));
     stats.add(new Model_Stats(0, 174, 12, 13, 14, 114, 232, 132,1521,0));
     stats.add(new Model_Stats(0, 174, 12, 13, 14, 114, 232, 132,1521,0));
     stats.add(new Model_Stats(0, 174, 12, 13, 14, 114, 232, 132,1521,0));
     stats.add(new Model_Stats(0, 174, 12, 13, 14, 114, 232, 132,1521,0));
     stats.add(new Model_Stats(0, 174, 12, 13, 14, 114, 232, 132,1521,0));

      Controller_Save saves = new Controller_Save();
      saves.newSave(savegame, stats);*/
      
   /////////////// SAVES LIST & THEIR STATS ///////////////////
       
         // saves.newSave(savegame, stats);
    /* for(int i=0; i<saves.getSaves().size();i++){
          System.out.println("Sauvegarde ID="+saves.getSaves().get(i).getId_save()+" | Nom="+saves.getSaves().get(i).getName_save()+"");
          System.out.println("Sa Liste de Stats : ");
          for(int j=0; j<saves.getSaves().get(i).getStats().size(); j++){
              System.out.println("ID="+saves.getSaves().get(i).getStats().get(j).getId_stat()+
                                 " | t="+saves.getSaves().get(i).getStats().get(j).getT()+
                                 " | Empty="+saves.getSaves().get(i).getStats().get(j).getStat_empty()+
                                 " | Young Plant="+saves.getSaves().get(i).getStats().get(j).getStat_youngplant()+"\n");
          }  
    }*/
  }
}
