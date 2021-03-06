/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.jsimforest.controller;
import java.util.ArrayList;

/**
 *
 * @author raff
 */
public class Controller_Moore {
      

     private ArrayList<Integer> getNeighboorMoore(int _y, int _x, int[][] forestArea) {
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
     
    private ArrayList<Integer> getNeighboorVanNeumann(int _y, int _x, int[][] forestArea) {
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
    
    private int setStateCellGrowth(int forestArea[][], int y, int x){
        int nbTree=0;
        int nbYoungTree=0;
            
        for(int i=0; i<getNeighboorMoore(y, x, forestArea).size(); i++){
            if(getNeighboorMoore(y, x, forestArea).get(i)==3){
                nbTree++;
            }
            else if(getNeighboorMoore(y, x, forestArea).get(i)==2 || getNeighboorMoore(y, x, forestArea).get(i)==7){
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
            case 6:
                 return 0;
            case 7:
                 return 3;
            }
            return forestArea[y][x];
    }
        
    private int setStateFire(int forestArea[][], int y, int x){
        int nbTree=0;
        int nbYoungTree=0;
            
        for(int i=0; i<getNeighboorMoore(y, x, forestArea).size(); i++){
            if(getNeighboorMoore(y, x, forestArea).get(i)==3){
                nbTree++;
            }
            else if(getNeighboorMoore(y, x, forestArea).get(i)==2 || getNeighboorMoore(y, x, forestArea).get(i)==7){
                nbYoungTree++;
            }
        }
        boolean fire=false;
        
        for(int i=0; i<getNeighboorMoore(y, x, forestArea).size(); i++){
            if(getNeighboorMoore(y, x, forestArea).get(i)==4){
                fire=true;
            }
        }
        switch(forestArea[y][x]){
            case 0:
                break;
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
                break;
            case 3:
                if(fire){
                    if(getRandom()<75000){
                        return 4;
                    }
                }
                break;
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
                break;
        }
        return forestArea[y][x];
    }
    
    private int setStateAll(int forestArea[][], int y, int x){
        int nbTree=0;
        int nbYoungTree=0;
        boolean fire=false;
            
        for(int i=0; i<getNeighboorMoore(y, x, forestArea).size(); i++){
            if(getNeighboorMoore(y, x, forestArea).get(i)==3){
                nbTree++;
            }
            else if(getNeighboorMoore(y, x, forestArea).get(i)==2 || getNeighboorMoore(y, x, forestArea).get(i)==7){
                nbYoungTree++;
            }
        }
        
        
        for(int i=0; i<getNeighboorMoore(y, x, forestArea).size(); i++){
            if(getNeighboorMoore(y, x, forestArea).get(i)==4){
                fire=true;
            }
        }
        switch(forestArea[y][x]){
            case 0:
                if ( nbTree >= 2 || nbYoungTree >= 3 || (nbTree == 1 && nbYoungTree == 2)) {
                    return 1;
                }
                return forestArea[y][x];
            case 1:
                if(fire){
                    if(getRandom()<25000){
                        return 4;
                    }
                }else
                    if ((nbYoungTree+nbTree)<=3){
                    return 2;
                }
                return forestArea[y][x];
            case 2:
                if(fire){
                    if(getRandom()<50000){
                        return 4;
                    }
                }else
                    return 7;
            case 3:
                if(fire){
                    if(getRandom()<75000){
                        return 4;
                    }
                }else
                    return forestArea[y][x];
            case 4:
                return 6;
            case 6:
                return 0;
            case 7:
                if(fire){
                    if(getRandom()<50000){
                        return 4;
                    }
                }else
                    return 3;
        }
        return forestArea[y][x];
    }
    
    private int setStateInfected(int forestArea[][], int y, int x){
         boolean infected=false;
        
        for(int i=0; i<getNeighboorVanNeumann(y, x, forestArea).size(); i++){
            if(getNeighboorVanNeumann(y, x, forestArea).get(i)==5){
                infected=true;
            }
        }
        switch(forestArea[y][x]){
            case 1:
                if(infected){
                    if(getRandom()<75000){
                        return 5;
                    }
                }
                break;
            case 2:
                if(infected){
                    if(getRandom()<50000){
                        return 5;
                    }
                }
                break;
            case 3:
                if(infected){
                    if(getRandom()<25000){
                        return 5;
                    }
                }
                break;
            case 4:
                return 6;
            case 5:
                return 0;
            case 6:
                return 0;
            case 7:
                if(infected){
                    if(getRandom()<50000){
                        return 5;
                    }
                }
                break;
        }
        return forestArea[y][x];
    }
        
    public void evolutionArea(){
        int forestArea[][]=Controller_ForestArea.getForestAreaTab();
        int [][] temp= new int[forestArea.length][forestArea[0].length];
            
        if(Controller_ForestArea.getNbr_fire()==0 && Controller_ForestArea.getNbr_infect()==0 && Controller_ForestArea.getNbr_ash()==0){
            Controller_ForestArea.setStatut(1);
        }
        else
            if(Controller_ForestArea.getNbr_infect()>0){
                Controller_ForestArea.setStatut(2);
            }
        else
            if((Controller_ForestArea.getNbr_fire()>0 || Controller_ForestArea.getNbr_ash()>0)&& Controller_ForestArea.isC_develop()==false){
                    Controller_ForestArea.setStatut(3);
            }
        else
            if((Controller_ForestArea.getNbr_fire()>0 || Controller_ForestArea.getNbr_ash()>0)&&Controller_ForestArea.isC_develop()==true){
                Controller_ForestArea.setStatut(4);
            }
        

        for(int i=0; i<temp.length;i++){
            for(int j=0; j<temp[0].length;j++){
                switch(Controller_ForestArea.getStatut()){
                    case 1: temp[i][j]=setStateCellGrowth(forestArea, i, j);
                        break;
                    case 2:temp[i][j]=setStateInfected(forestArea, i, j);
                        break;
                    case 3: temp[i][j]=setStateFire(forestArea, i, j);
                        break;
                    case 4: temp[i][j]=setStateAll(forestArea, i, j);
                        break;
                }
            }
        }
        

        Controller_ForestArea.setForestAreaTab(temp);
        
  
    } 

        private int getRandom(){
            return (int)(Math.random()*(100000+1-0))+0;
        }
}
