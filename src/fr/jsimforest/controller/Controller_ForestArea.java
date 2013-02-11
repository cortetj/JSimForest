/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

import fr.jsimforest.view.View_Stats;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EggMan
 */
public class Controller_ForestArea {
   
        private static int[][] ForestAreaTab;
                
        private static String name;
        
        private static int step;
        
        private static int width;
        private static int height;
        private static int Nbr_empty;
        private static int Nbr_yp;
        private static int Nbr_st;
        private static int Nbr_at;
        private static int Nbr_fire;
        private static int Nbr_ash;
        private static int Nbr_infect;
        
        
        private static int statut;
        private static boolean c_develop;

        
    public Controller_ForestArea() {
        
        Controller_ForestArea.c_develop = true;
        Controller_ForestArea.statut = 1;
        Controller_ForestArea.name = "Default Forest";
        Controller_ForestArea.step = 0;
        
        int fo[][] = new int[40][40];
        for(int i=0; i<fo[0].length;i++) {
            for(int j=0; j<fo.length; j++) {
                fo[i][j] = (int)(Math.random() * (4));
            }
        }
        
        Controller_ForestArea.ForestAreaTab = fo;
        Controller_ForestArea.updatePropWithTab();  
        System.out.println(this.TabToString());
    }
    
    public static void defautTab(int width, int height, String name) {
        
        Controller_ForestArea.setName(name);
        
        int fo[][] = new int[height][width];
        
        for(int i=0; i<height;i++) {
            for(int j=0; j<width; j++) {
                fo[i][j] = 0;
            }
        }
        
        Controller_ForestArea.ForestAreaTab = fo;
        Controller_ForestArea.updatePropWithTab();
    }
    
    public static void CreatTabwithFile(File file) throws FileNotFoundException {
                
        Scanner scanner=new Scanner(file);
        
        ArrayList<String> stats = new ArrayList();
        String line;
        // On boucle sur chaque champ detecté`
        if (scanner.hasNextLine()) {
            line = scanner.nextLine();
            Controller_ForestArea.CreatTabwithString(line);
        }
        
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            stats.add(line);
        }
        View_Stats.importStat(stats);
        scanner.close();

        Controller_ForestArea.setName(file.getName());
        
        int fo[][] = new int[height][width];
        
        for(int i=0; i<height;i++) {
            for(int j=0; j<width; j++) {
                fo[i][j] = 0;
            }
        }
        
    }
    
    public static void CreatTabwithString(String forest) {
       
        int HEIGHT = 1;
        int WIDTH = 0;
        
        for(int i=0; i<forest.length();i++) {            
            if(forest.charAt(i) == 'n') {
                HEIGHT++;
                WIDTH = 0;
            }
            WIDTH++;
        }
        WIDTH--;
         

        int fo[][] = new int[HEIGHT][WIDTH];
        int x = 0;
        int y = 0;
        
        for(int i=0; i<forest.length();i++) {
            System.out.println(forest.charAt(i));
            if(forest.charAt(i) == 'n') {
                y++;
                x=0;
            }
            else {
                String c = ""+forest.charAt(i);
                fo[y][x] = Integer.parseInt(c);
                x++;
            }
        
            
        }
        
      for (int i = 0; i<HEIGHT; i++) {
            for (int j = 0; j<WIDTH; j++) {
                System.out.print(fo[i][j]);
            }
            System.out.println("");
        }
        
        Controller_ForestArea.ForestAreaTab = fo;
        
        Controller_ForestArea.updatePropWithTab();
    }
    
    public static void updatePropWithTab() {
        
        Controller_ForestArea.width = 0;
        Controller_ForestArea.height = 0;
        Controller_ForestArea.Nbr_empty = 0;
        Controller_ForestArea.Nbr_yp = 0;
        Controller_ForestArea.Nbr_st = 0;
        Controller_ForestArea.Nbr_at = 0;
        Controller_ForestArea.setNbr_fire(0);
        Controller_ForestArea.setNbr_ash(0);
        Controller_ForestArea.setNbr_infect(0);
        
        Controller_ForestArea.setHeight(Controller_ForestArea.getForestAreaTab().length);
        Controller_ForestArea.setWidth(Controller_ForestArea.getForestAreaTab()[0].length);

        for (int i = 0; i<Controller_ForestArea.getHeight(); i++) {
            for (int j = 0; j<Controller_ForestArea.getWidth(); j++) {
                

                switch(Controller_ForestArea.getForestAreaTab()[i][j]) {
                    case 0 : 
                        Controller_ForestArea.setNbr_empty(Controller_ForestArea.getNbr_empty() + 1);
                        break;
                    case 1 : 
                        Controller_ForestArea.setNbr_yp(Controller_ForestArea.getNbr_yp() + 1);
                        break;
                        
                    case 2 : 
                        Controller_ForestArea.setNbr_st(Controller_ForestArea.getNbr_st() + 1);
                        break;
                        
                     case 3 : 
                        Controller_ForestArea.setNbr_at(Controller_ForestArea.getNbr_at() + 1);
                        break;
            
                    case 4 : 
                        Controller_ForestArea.setNbr_fire(Controller_ForestArea.getNbr_fire() + 1);
                        break;
                        
                    case 5 : 
                        Controller_ForestArea.setNbr_infect(Controller_ForestArea.getNbr_infect() + 1);
                        break;
                        
                     case 6 : 
                        Controller_ForestArea.setNbr_ash(Controller_ForestArea.getNbr_ash() + 1);
                        break;
                     case 7 :
                         Controller_ForestArea.setNbr_st(Controller_ForestArea.getNbr_st() + 1);
                        break;
                }
                
            }            
        }

    }

    public static String TabToString()
    {
        String str = new String();
        for (int i = 0; i<Controller_ForestArea.getHeight(); i++) {
            for (int j = 0; j<Controller_ForestArea.getWidth(); j++) {
                str += Controller_ForestArea.getForestAreaTab()[i][j];
            }
            str += "n";
        }
        str = str.substring(0, str.length()-1);
        return str;
    }
        
    /**
     * @return the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * @param aWidth the width to set
     */
    public static void setWidth(int aWidth) {
        width = aWidth;
    }

    /**
     * @return the height
     */
    public static int getHeight() {
        return height;
    }

    /**
     * @param aHeight the height to set
     */
    public static void setHeight(int aHeight) {
        height = aHeight;
    }

    /**
     * @return the Nbr_empty
     */
    public static int getNbr_empty() {
        return Nbr_empty;
    }

    /**
     * @param aNbr_empty the Nbr_empty to set
     */
    public static void setNbr_empty(int aNbr_empty) {
        Nbr_empty = aNbr_empty;
    }

    /**
     * @return the Nbr_yp
     */
    public static int getNbr_yp() {
        return Nbr_yp;
    }

    /**
     * @param aNbr_yp the Nbr_yp to set
     */
    public static void setNbr_yp(int aNbr_yp) {
        Nbr_yp = aNbr_yp;
    }

    /**
     * @return the Nbr_st
     */
    public static int getNbr_st() {
        return Nbr_st;
    }

    /**
     * @param aNbr_st the Nbr_st to set
     */
    public static void setNbr_st(int aNbr_st) {
        Nbr_st = aNbr_st;
    }

    /**
     * @return the Nbr_at 
     */
    public static int getNbr_at() {
        return Nbr_at;
    }

    /**
     * @param aNbr_at the Nbr_at to set
     */
    public static void setNbr_at(int aNbr_at) {
        Nbr_at = aNbr_at;
    }

    /**
     * @return the ForestArea
     */
    public static int[][] getForestAreaTab() {
        return ForestAreaTab;
    }

    /**
     * @param ForestArea the ForestArea to set
     */
    public static void setForestAreaTab(int[][] ForestArea) {
        Controller_ForestArea.ForestAreaTab = ForestArea;
    }
    
    /**
     * @return the Nbr_fire
     */
    public static int getNbr_fire() {
        return Nbr_fire;
    }

    /**
     * @param aNbr_fire the Nbr_fire to set
     */
    public static void setNbr_fire(int aNbr_fire) {
        Nbr_fire = aNbr_fire;
    }

    /**
     * @return the Nbr_ash
     */
    public static int getNbr_ash() {
        return Nbr_ash;
    }

    /**
     * @param aNbr_ash the Nbr_ash to set
     */
    public static void setNbr_ash(int aNbr_ash) {
        Nbr_ash = aNbr_ash;
    }

    /**
     * @return the Nbr_infect
     */
    public static int getNbr_infect() {
        return Nbr_infect;
    }

    /**
     * @param aNbr_infect the Nbr_infect to set
     */
    public static void setNbr_infect(int aNbr_infect) {
        Nbr_infect = aNbr_infect;
    }


    /**
     * @return the name
     */
    public static String getName() {
        return name;
    }

    /**
     * @param aName the name to set
     */
    public static void setName(String aName) {
        name = aName;
    }


    /**
     * @return the step
     */
    public static int getStep() {
        return step;
    }

    /**
     * @param aStep the step to set
     */
    public static void setStep(int aStep) {
        step = aStep;
    }
    
    public static int getStatut(){
        return statut;
    }
    public static void setStatut(int state){
       statut=state;
    }
    
    public static void setForestAreaTabAt(int x, int y, int value) {
        
        switch(Controller_ForestArea.ForestAreaTab[x][y]) {
                    case 0 : 
                        Controller_ForestArea.setNbr_empty(Controller_ForestArea.getNbr_empty() - 1);
                        break;
                    case 1 : 
                        Controller_ForestArea.setNbr_yp(Controller_ForestArea.getNbr_yp() - 1);
                        break;
                        
                    case 2 : 
                        Controller_ForestArea.setNbr_st(Controller_ForestArea.getNbr_st() - 1);
                        break;
                        
                     case 3 : 
                        Controller_ForestArea.setNbr_at(Controller_ForestArea.getNbr_at() - 1);
                        break;
                         
                    case 4 : 
                        Controller_ForestArea.setNbr_fire(Controller_ForestArea.getNbr_fire() - 1);
                        break;
                        
                    case 5 : 
                        Controller_ForestArea.setNbr_infect(Controller_ForestArea.getNbr_infect() - 1);
                        break;
                        
                    case 6 : 
                        Controller_ForestArea.setNbr_ash(Controller_ForestArea.getNbr_ash() - 1);
                        break;
         }
        
        Controller_ForestArea.ForestAreaTab[x][y] = value;
        
        switch(Controller_ForestArea.ForestAreaTab[x][y]) {
                    case 0 : 
                        Controller_ForestArea.setNbr_empty(Controller_ForestArea.getNbr_empty() + 1);
                        break;
                    case 1 : 
                        Controller_ForestArea.setNbr_yp(Controller_ForestArea.getNbr_yp() + 1);
                        break;
                        
                    case 2 : 
                        Controller_ForestArea.setNbr_st(Controller_ForestArea.getNbr_st() + 1);
                        break;
                        
                     case 3 : 
                        Controller_ForestArea.setNbr_at(Controller_ForestArea.getNbr_at() + 1);
                        break;
                         
                   case 4 : 
                        Controller_ForestArea.setNbr_fire(Controller_ForestArea.getNbr_fire() + 1);
                        break;
                        
                    case 5 : 
                        Controller_ForestArea.setNbr_infect(Controller_ForestArea.getNbr_infect() + 1);
                        break;
                        
                    case 6 : 
                        Controller_ForestArea.setNbr_ash(Controller_ForestArea.getNbr_ash() + 1);
                        break;
         }      
    }

    /**
     * @return the c_develop
     */
    public static boolean isC_develop() {
        return c_develop;
    }

    /**
     * @param aC_develop the c_develop to set
     */
    public static void setC_develop(boolean aC_develop) {
        c_develop = aC_develop;
    }
}
