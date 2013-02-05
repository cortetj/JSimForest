/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author EggMan
 */
class Controller_Player {
    
        private int time;
        private int gap;
        private Timer timer;

        public Controller_Player() {
        timer = new Timer();
        timer.schedule(new Controller_Player.RemindTask(),
                       0,        //initial delay
                       1*1000);
        }
        
        class RemindTask extends TimerTask {
            @Override
            public void run() {
                System.out.format("Time's up!%n");
                //timer.cancel(); //Terminate the timer thread
            }
        }
}
