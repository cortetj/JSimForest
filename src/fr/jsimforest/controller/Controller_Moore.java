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
    
  private Enum_Mode mode;
  
  Controller_Moore(){
  }

    
   /* private int[] NeighboorMoor(int forestArea[][], int y, int x){
        // Test pour 8 voisins
        //int table[]=new int[5];
        
        /*if(y-1>0 && y+1<forestArea.length && x-1>0 && x+1<forestArea[0].length){
            int table[]={forestArea[y][x+1], forestArea[y][x-1], forestArea[y-1][x-1], forestArea[y+1][x-1], forestArea[y+1][x], forestArea[y-1][x], forestArea[y-1][x+1], forestArea[y+1][x+1]};
            return table;
        }*/
       // if(y-1<0 && y+1)
        
     /*   if(y>0 && y<forestArea.length && x>0 && x<forestArea.length){
           int neighboor[]={forestArea[y][x+1], forestArea[y][x-1], forestArea[y-1][x-1], forestArea[y+1][x-1], forestArea[y+1][x], forestArea[y-1][x], forestArea[y-1][x+1], forestArea[y+1][x+1]};
           return neighboor;
        }
        // Tests pour 5 voisins
        else if(x==0 && y>0 && y<forestArea.length){
           int neighboor[]={forestArea[y][x+1], forestArea[y+1][x], forestArea[y-1][x], forestArea[y-1][x+1], forestArea[y+1][x+1]};
           return neighboor;
        }
        else if(y==0 && x>0 && x<forestArea[0].length -1){
           int neighboor[]={forestArea[y][x+1], forestArea[y][x-1], forestArea[y+1][x], forestArea[y+1][x+1], forestArea[y+1][x-1]};
           return neighboor;
        }
        else if(x==forestArea[0].length && y>0 && y<forestArea.length){
           int neighboor[]={forestArea[y][x-1], forestArea[y-1][x-1], forestArea[y+1][x-1], forestArea[y+1][x], forestArea[y-1][x]};
           return neighboor;
        }
        else if(y==forestArea.length && x>0 && x<forestArea[0].length){
           int neighboor[]={forestArea[y][x+1], forestArea[y][x-1], forestArea[y-1][x-1], forestArea[y-1][x], forestArea[y-1][x+1]};
           return neighboor;
        }
        // Tests pour 3 voisins
        else if(x==0 && y==0){
           int neighboor[]={forestArea[y][x+1], forestArea[y+1][x], forestArea[y+1][x+1]};
           return neighboor;
        }
        else if(x==0 && y==forestArea.length){
           int neighboor[]={forestArea[y][x+1], forestArea[y-1][x], forestArea[y-1][x+1]};
           return neighboor;
        }
        else if(x==forestArea[0].length && y==0){
            int neighboor[]={forestArea[y][x-1], forestArea[y+1][x-1], forestArea[y+1][x]};
            return neighboor;
            
        }
        else if(x==forestArea[0].length && y==forestArea.length){
           int neighboor[]={forestArea[y][x-1], forestArea[y-1][x-1], forestArea[y-1][x]};
           return neighboor;
        }
        int defaut[]=null;
        return defaut;
    }*/
    
     public ArrayList<Integer> getVoisinMoore(int _y, int _x, int[][] forestArea) {
        // int[] neighboor=null;
         ArrayList<Integer> neighboor=new ArrayList<Integer>();
        //ArrayList<Case> voisins = new ArrayList<Case>();
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
    
   /* private int[] NeighboorVanNeumann(int forestArea[][], int y, int x){
        
        return 
        
    }*/
    
    public int CountTypeNeighboor(int forestArea[][], int y, int x, int type){
        int count[]={0, 0, 0, 0, 0, 0, 0};
        ArrayList<Integer> countList= getVoisinMoore(y, x, forestArea);
        
        for(int i=0;i<countList.size();i++){   
            switch(countList.get(i)){
                case 0:
                    count[0]++;
                //  NeighBoorMoor();
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                case 3:
                    count[3]++;
                    break;
                case 4:
                    count[4]++;
                    break;
                case 5:
                    count[5]++;
                    break;
                case 6:
                    count[6]++;
                    break;
                case 7:
                    count[2]++;
                    break;
            }
            
        //list_neigh = NeighboorMoor(forestArea, y, x);
        //NeighBoorMoor(forestArea, y, x);
        }
        if(type==7){
            type=2;
        }
        return count[type];
        /*switch(type){
            case 0:
               return count[0];
            case 1:
               return count[1];
            case 2:
               return count[2];
            case 3:
               return count[3];
            case 4:
               return count[4];
            case 5:
               return count[5];
            case 6:
               return count[6]; 
        }
        * s
        return 0;*/
    }
    private Enum_Mode returnMode(int forestArea[][], int y, int x){
          if(CountTypeNeighboor(forestArea, y, x, 4)>0){
              return mode.MODE_FIRE;
          }
          else if(CountTypeNeighboor(forestArea, y, x, 5)>0){
              return mode.MODE_INFECTED;
          }
          else{
            return mode.MODE_GROWTH;}
    }
        private int setStateGrowth(int forestArea[][], int y, int x){
            int nbTree=CountTypeNeighboor(forestArea, y, x, 3);
            int nbYoungTree=CountTypeNeighboor(forestArea, y, x, 2)+CountTypeNeighboor(forestArea, y, x, 7);
            
            switch(forestArea[y][x]){
                case 0:
                    if ( nbTree >= 2 || nbYoungTree >= 3 || (nbTree == 1 && nbYoungTree == 2)) {
                        return 1;
                    }
                    break;
                case 1:
                    if ( nbTree+nbYoungTree<=3) {
                        return 2;
                    }
                    break;
                case 2:
                    return 7;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return 3;
        }
            return 0;
        }
        private void setStateFire(int forestArea[][], int y, int x){
            
        }
        private void setStateInfected(int forestArea[][], int y, int x){
            
        }
    public int[][] changeCell(int forestArea[][], int y, int x){
        

        this.mode=returnMode(forestArea, y, x);
        
        switch(mode){
            case MODE_FIRE:
               setStateFire(forestArea, y, x);
                break;
            case MODE_INFECTED:
                setStateInfected(forestArea, y, x);
                break;
            case MODE_GROWTH:
                forestArea[y][x]=setStateGrowth(forestArea, y, x);
                return forestArea;
        }
        
    
        
        

        /*            code State :  empty=0
         *                          young plant=1
         *                          young tree=2
         *                          tree =3 
         *                          feu =4 
         *                          cendre =5 
         *                          infected =6
         *                          young oldtree =7
         */
        // int tempforestArea[][]=forestArea;
     /*
        switch(getVoisinMoore(y, x, tempforestArea).get(i)){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;   
        }*/
     /*  if(tempforestArea[y][x]==5){
           forestArea[y][x]=0;
       }
       else if(tempforestArea[y][x]==4){
           forestArea[y][x]=5;
       }
       else if(tempforestArea[y][x]==6){
           forestArea[y][x]=0;
       }
       else if(tempforestArea[y][x]==0){
           if(CountTypeNeighboor(tempforestArea, y, x, 3)>=2 || CountTypeNeighboor(tempforestArea, y, x, 2)>=3 || CountTypeNeighboor(tempforestArea, y, x, 3)==1 && CountTypeNeighboor(tempforestArea, y, x, 2)==2){
               forestArea[y][x]=1;
           }
       }
       else if(tempforestArea[y][x]==1){
           if(CountTypeNeighboor(tempforestArea, y, x, 3)<=3 || CountTypeNeighboor(tempforestArea, y, x, 2)<=3){
                forestArea[y][x]=2;
           }
       }
       else if(tempforestArea[y][x]==2){
           forestArea[y][x]=3;
       }
       //Risques du feu
       if(CountTypeNeighboor(tempforestArea, y, x, 4)>=1){
           if(tempforestArea[y][x]==1){
               if(this.getRandom()<=25000){
                   forestArea[y][x]=4;
               }
           }
           else if(tempforestArea[y][x]==2){
               if(this.getRandom()<=50000){
                   forestArea[y][x]=4;
               }
           }
           else if(tempforestArea[y][x]==3){
               if(this.getRandom()<=75000){
                   forestArea[y][x]=4;
               }
           }
       }*/
       return forestArea;
       //Risque d'infection -> METHODE DE VOISINAGE A CHANGER
       /*if(CountTypeNeighboor(tempforestArea, y, x, 6)>=1){
           if(tempforestArea[y][x]==1){
               if(getRandom()<=75000){
                   forestArea[y][x]=6;
               }
           }
           else if(tempforestArea[y][x]==2){
               if(getRandom()<=50000){
                   forestArea[y][x]=6;
               }
           }
           else if(tempforestArea[y][x]==3){
               if(getRandom()<=25000){
                   forestArea[y][x]=6;
               }
           } 
       }*/

    }
         public void evolutionArea(){
             
            int temp[][]=Controller_ForestArea.getForestAreaTab();

            for(int i=0; i<temp.length;i++){
                for(int j=0; j<temp[0].length;j++){
                    temp=changeCell(temp, i, j);
                }
            }
            Controller_ForestArea.setForestAreaTab(temp); 
        }
         
        public int getRandom(){
            return (int)(Math.random()*(100000+1-0))+0;
        }
}
