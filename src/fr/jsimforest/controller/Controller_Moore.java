/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.jsimforest.controller;
import java.util.ArrayList;
import fr.jsimforest.model.Enum_Cell;

/**
 *
 * @author raff
 */
public class Controller_Moore {
    
  private static Enum_Mode mode;
  

     public ArrayList<Integer> getVoisinMoore(int _y, int _x, int[][] forestArea) {
        ArrayList<Integer> neighboor=new ArrayList<Integer>();
        if (_y < 0 || _y >= forestArea.length || _x < 0 || _x >= forestArea[0].length) {
            return neighboor;
        } else {
            if (_x - 1 >= 0) {
                    neighboor.add(forestArea[_y][_x-1]);
                if (_y - 1 >= 0) {
                    neighboor.add(forestArea[_y-1][_x-1]);
                }
                if (_y + 1 < forestArea.length) {
                    neighboor.add(forestArea[_y+1][_x-1]);
                }
            }
            if (_x + 1 < forestArea[0].length) {
                neighboor.add(forestArea[_y][_x+1]);//voisins.add(getCase(_x + 1, _y));
                if (_y - 1 >= 0) {
                    neighboor.add(forestArea[_y-1][_x+1]);;  //  voisins.add(getCase(_x + 1, _y - 1));
                }
                if (_y + 1 < forestArea.length) {
                    neighboor.add(forestArea[_y+1][_x+1]);//    voisins.add(getCase(_x + 1, _y + 1));
                }
            }
            if (_y - 1 >= 0) {
                neighboor.add(forestArea[_y-1][_x]);
                //voisins.add(getCase(_x, _y - 1));
            }
            if (_y + 1 < forestArea.length) {
                neighboor.add(forestArea[_y+1][_x]);
                //voisins.add(getCase(_x, _y + 1));
            }
            return neighboor;
        }
    }
     
    public ArrayList<Integer> getVoisinVanNeumann(int _y, int _x, int[][] forestArea) {
        ArrayList<Integer> neighboor=new ArrayList<Integer>();
         if (_y < 0 || _y >= forestArea.length || _x < 0 || _x >= forestArea[0].length) {
            return neighboor;
        } else {
            if (_x - 1 >= 0) {
                neighboor.add(forestArea[_y][_x-1]);
            }
            if (_x + 1 < forestArea[0].length) {
                neighboor.add(forestArea[_y][_x+1]);
            }
            if (_y - 1 >= 0) {
                neighboor.add(forestArea[_y-1][_x]);
            }
            if (_y + 1 < forestArea.length) {
                neighboor.add(forestArea[_y+1][_x]);
            }
            return neighboor;
        }
    }
    
    private int returnMode(int forestArea[][]){
        for(int i=0; i<forestArea.length; i++){
            for(int j=0; j<forestArea[0].length; j++){
                if(forestArea[i][j]==4){
                    return 3;  
                }
                else if(forestArea[i][j]==6){
                    return 2;
                }
            }
        }
        return 1;
    }
    
    private int setStateCellGrowth(int forestArea[][], int y, int x){
        int nbTree=0;
        int nbYoungTree=0;
            
        for(int i=0; i<getVoisinMoore(y, x, forestArea).size(); i++){
            if(getVoisinMoore(y, x, forestArea).get(i)==3){
                nbTree++;
            }
            else if(getVoisinMoore(y, x, forestArea).get(i)==2 || getVoisinMoore(y, x, forestArea).get(i)==7){
                nbYoungTree++;
            }
        }
        
        switch(forestArea[y][x]){
            case 0:
                if ( nbTree >= 2 || nbYoungTree >= 3 || (nbTree == 1 && nbYoungTree == 2)) {
                    return 1;
                }
                break;
            case 1:
                if ((nbYoungTree+nbTree)<=3){
                    return 2;
                }
                break;
            case 2:
                 return 7;
            case 3:
                 return forestArea[y][x];
            case 7:
                 return 3;
            }
            return forestArea[y][x];
    }
        
    private int setStateFire(int forestArea[][], int y, int x){
        boolean fire=false;
        System.out.println("Voisin de la cellule ["+y+"]["+x+"]--->");
        for(int i=0; i<getVoisinMoore(y, x, forestArea).size(); i++){
            System.out.println("voisin n°"+(i+1)+" = "+getVoisinMoore(y, x, forestArea).get(i));
            if(getVoisinMoore(y, x, forestArea).get(i)==4){
                
                fire=true;
            }
           // System.out.println("cellule à l'indice ["+y+"]["+x+"] value = ["+forestArea[y][x]+"] case voisines de type feu ="+fire+"");
        }
        System.out.println("CELULLE a l'INDICE ["+y+"]["+x+"] STATUT voisin en feu-> "+fire);
        
            switch(forestArea[y][x]){
                case 1:
                  if(fire){
                    if(getRandom()<25000){
                        return 4;
                    }
                  }
                break;
                case 2:
                   if(fire){
                    if(getRandom()<50000){
                          return 4;
                      }
                   }
                case 3:
                    if(fire){
                       if(getRandom()<75000){
                           return 4;
                       }
                    }
                case 4:
                    return 6;
                case 6:
                    return 0;
                case 7:
                    if(fire){
                        if(getRandom()<50000){
                         return 4;
                        }
                    }
            }
            return forestArea[y][x];
    }
    
    private void setStateInfected(int forestArea[][], int y, int x){        
    }
        
    public int changeCell(int forestArea[][], int y, int x, Enum_Mode MODE){
        if(MODE==MODE.MODE_FIRE){
            System.out.println("CHANGECELL MODE FIRE ACTIVATE");
            return setStateFire(forestArea, y, x);
        }
        else{
            if(MODE==MODE.MODE_INFECTED){  
            }
        }
        return setStateCellGrowth(forestArea, y, x);
    }
        
         public void evolutionArea(){
            int forestArea[][]=Controller_ForestArea.getForestAreaTab();
            int [][] temp= new int[forestArea.length][forestArea[0].length];
            
            int state=returnMode(forestArea);
            System.out.println("MOD = "+state);
            int mod=0;
            

            for(int i=0; i<temp.length;i++){
                for(int j=0; j<temp[0].length;j++){
                    if(state==1 && mod==0){
                        temp[i][j]=changeCell(forestArea, i, j, mode.MODE_GROWTH);
                    }
                    else if(state==3){
                        if(mod==0){
                        mod++;}
                        temp[i][j]=changeCell(forestArea, i, j, mode.MODE_FIRE);
                    }
                    else
                        System.out.println("Mode infection");
                }
                    //System.out.println("cellule à l'indice ["+i+"]["+j+"] value = ["+forestArea[i][j]+"] AFTER CHANGE");
            }
            Controller_ForestArea.setForestAreaTab(temp);
            
            
        
         } 
           
         
        public int getRandom(){
            return (int)(Math.random()*(100000+1-0))+0;
        }
}
