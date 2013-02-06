/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;


/**
 *
 * @author raff
 */
public class Controller_Moore { 
    
    private int[] NeighboorMoor(int forestArea[][], int y, int x){
        // Test pour 8 voisins
        //int table[]=new int[5];
        
        if(y>0 && y<forestArea.length && x>0 && x<forestArea.length){
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
    }
    
    public int CountTypeNeighboor(int forestArea[][], int y, int x, int type){
        int count[]={0, 0, 0, 0, 0, 0, 0};
        int list_neigh[];
        list_neigh = NeighboorMoor(forestArea, y, x);
        
        for(int i=0;i<list_neigh.length;i++){
            
            switch(list_neigh[i]){
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
            }
        //list_neigh = NeighboorMoor(forestArea, y, x);
        //NeighBoorMoor(forestArea, y, x);
        }
        switch(type){
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
        return 0;
    }
    
    public int[][] changeCell(int forestArea[][], int tempforestArea[][], int y, int x){
        /*   rappel code état : vide=0
         *                      jeune pousse=1
         *                      arbustre=2 
         *                      arbre=3 
         *                      feu=4 
         *                      cendre=5 
         *                      infecte=6
         */
       if(tempforestArea[y][x]==5){
           forestArea[y][x]=0;
       }
       else if(tempforestArea[y][x]==4){
           forestArea[y][x]=5;
       }
       else if(tempforestArea[y][x]==6){
           forestArea[y][x]=0;
       }
       else if(tempforestArea[y][x]==0){
           if(CountTypeNeighboor(tempforestArea, y, x, 3)>=2){
               forestArea[y][x]=1;
           }
           else if(CountTypeNeighboor(tempforestArea, y, x, 2)>=3){
               forestArea[y][x]=1;
           }
           else if(CountTypeNeighboor(tempforestArea, y, x, 3)==1 && CountTypeNeighboor(tempforestArea, y, x, 2)==2){
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
       }
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

            for(int i=0; i<temp.length-1;i++){
                for(int j=0; j<temp[0].length-1;j++){
                    temp=changeCell(temp, temp, i, j);
                }
            }
            Controller_ForestArea.setForestAreaTab(temp);
            
            
        }
         
        public int getRandom(){
            return (int)(Math.random()*(100000+1-0))+0;
        }
}
