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
    
        private int time;
        private int gap;
        private Timer timer;
        private Controller_Moore moore;
        private Window parent;

        public Controller_Player(Window parent) {
            this.parent = parent;
            timer = new Timer();
            this.moore = new Controller_Moore();
        }
        
        public void nextStep() {
            moore.evolutionArea();
        }
        
        public void autoPlay() {
            timer.schedule(new Controller_Player.RemindTask(),
                           0,        //initial delay
                           1*500);
        }
        
        public void stopPlayer() {
            timer.cancel();
        }
        
        class RemindTask extends TimerTask {
            @Override
            public void run() {
                moore.evolutionArea();
                parent.updateForest();
                
            }
        }
}
