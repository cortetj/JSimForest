/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.tools;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author EggMan
 */
public class Utils_ExportJSM {
     public static void Utils_ExportJSM(JTable tableToExport, String pathToExportTo, String forest){

            try {
               
               String path = pathToExportTo.replaceAll("\\s+$", "");
               FileWriter writer = new FileWriter(path);
               
               String str = forest;
               
               writer.append(str+"\n");  
               
                str="";
               
                for(int k=0; k<tableToExport.getColumnCount(); k++) {
                    str += tableToExport.getColumnName(k);
                    if(k < tableToExport.getColumnCount()) {
                        str += ",";
                    }
                }
                
                writer.append(str+"\n");
               str="";
               
               for(int i=0; i<tableToExport.getRowCount(); i++) {
                for(int j=0; j<tableToExport.getColumnCount(); j++) {
                    str += tableToExport.getValueAt(i, j);
                    if(j < tableToExport.getColumnCount()) {
                        str += ",";
                    }
                }
                writer.append(str+"\n");              
                str="";
                
               }
               
               writer.flush();
               writer.close();
               
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
    }
}
