/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

import fr.jsimforest.view.View_Stats;
import java.util.Timer;
import java.util.TimerTask;
import jsimforest.Window;

/**
 *
 * @author EggMan
 */
public class Controller_Player {
    
        private static int gap;
        private static int nbr_step;


        private Timer timer;
        private Controller_Moore moore;
        private Window parent;
        private static RemindTask rt;
        
        private Boolean paused;

        public Controller_Player(Window parent) {
            this.paused = false;    
            Controller_Player.rt = new Controller_Player.RemindTask();
            this.parent = parent;
            Controller_Player.nbr_step = 0;
            Controller_Player.gap = 10;
            timer = new Timer();
            this.moore = new Controller_Moore();
        }
        
        public void nextStep() {
            moore.evolutionArea();
            Controller_ForestArea.setStep(Controller_ForestArea.getStep()+1);
            if (View_Stats.isSave_stat()) {
                View_Stats.addStatRow();
            }
        }
        
        public void autoPlay() {
            Controller_Player.rt = new Controller_Player.RemindTask();
            timer.scheduleAtFixedRate(Controller_Player.rt, 0, Controller_Player.gap * 10);
        }
        
        public static void stopPlayer() {
            rt.cancel();
        }
        
        class RemindTask extends TimerTask {
            @Override
            public void run() {
                if ((Controller_ForestArea.getStep() < Controller_Player.getNbr_step() || Controller_Player.getNbr_step() == 0) && !paused) {
                    
                    if(Controller_ForestArea.getStatut() == 1){
                        paused = false;
                    }
                    
                    else if(Controller_ForestArea.getStatut() != 1) {
                        paused = true;
                    }
                    
                    parent.updateForest(); 
                    nextStep();
                        

                    if(Controller_ForestArea.getStatut() == 1 && paused) {
                        paused = true;
                    }
                    else if(Controller_ForestArea.getStatut() == 1 && !paused) {
                        paused = false;
                    }
                    else {
                        paused = false;
                    }
                    
                }
                else {
                    paused = false;
                    stopPlayer();
                }
            }
        }


    /**
     * @return the gap
     */
    public static int getGap() {
        return gap;
    }

    /**
     * @param aGap the gap to set
     */
    public static void setGap(int aGap) {
        gap = aGap;
    }
    
    /**
     * @return the nbr_step
     */
    public static int getNbr_step() {
        return nbr_step;
    }

    /**
     * @param aNbr_step the nbr_step to set
     */
    public static void setNbr_step(int aNbr_step) {
        nbr_step = aNbr_step;
    }
}
