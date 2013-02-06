/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

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
        private RemindTask rt;

        public Controller_Player(Window parent) {
            this.rt = new Controller_Player.RemindTask();
            this.parent = parent;
            Controller_Player.nbr_step = 511;
            Controller_Player.gap =5;
            timer = new Timer();
            this.moore = new Controller_Moore();
        }
        
        public void nextStep() {
                moore.evolutionArea();
                Controller_ForestArea.setStep(Controller_ForestArea.getStep()+1);
                System.out.println(Controller_ForestArea.getStep());
            
        }
        
        public void autoPlay() {
            this.rt = new Controller_Player.RemindTask();
            timer.scheduleAtFixedRate(this.rt, 0, Controller_Player.gap * 100);
        }
        
        public void stopPlayer() {
            rt.cancel();
        }
        
        class RemindTask extends TimerTask {
            @Override
            public void run() {
                if (Controller_ForestArea.getStep() < Controller_Player.nbr_step) {
                    nextStep();
                    parent.updateForest();
                }
                else {
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
}
