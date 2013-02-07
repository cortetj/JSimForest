/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jsimforest.Window;
import jsimforest.Window_LoadForest;
import jsimforest.Window_NewForest;

/**
 *
 * @author EggMan
 */
public class View_ActionMenu extends JPanel{
    
    private JButton Button_save;
    private JButton Button_new;
    private JButton Button_open;
    private JButton Button_load;
    private JButton Button_play;
    private JButton Button_pause;
    private JButton Button_nf;
    private JButton Button_fast;
    private JButton Button_zoomin;
    private JButton Button_zoomout;
    
    private Controller_Player player;
    
    
    public View_ActionMenu(final Window parent) {

        JPanel separator = new JPanel();
        separator.setOpaque(false);
        JPanel lb = new JPanel();
        lb.setOpaque(false);
        //lb.setLayout(new GridLayout(1,5, 0, 0));
        JPanel rb = new JPanel();
        rb.setLayout(new GridLayout(1,6, 0, 0));
        rb.setOpaque(false);
         
        this.player = new Controller_Player(parent);
        //this.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        this.setPreferredSize(new Dimension(0,42));
        this.setBackground(Color.decode("#2c2c2c"));
        
        this.setLayout(new BorderLayout());
        
        ImageIcon Ico_new = new ImageIcon("img/ico_new.png");        
        this.Button_new = new JButton(Ico_new);
        this.Button_new.setOpaque(false);
        this.Button_new.setBorderPainted(false);
        this.Button_new.setContentAreaFilled(false);
        this.Button_new.setPreferredSize(new Dimension(71, 33));
        //this.Button_new.setBackground(Color.decode("#A9A9A9"));
        this.Button_new.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                 Window_NewForest Window_new = new Window_NewForest(parent);
          }
        });

        ImageIcon Ico_open = new ImageIcon("img/ico_open.png");        
        this.Button_open = new JButton(Ico_open);
        this.Button_open.setOpaque(false);
        this.Button_open.setBorderPainted(false);
        this.Button_open.setPreferredSize(new Dimension(78, 33));
        this.Button_open.setContentAreaFilled(false);
        this.Button_open.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(fc);
          }
        });

        ImageIcon Ico_save = new ImageIcon("img/ico_save.png");        
        this.Button_save = new JButton(Ico_save);
        this.Button_save.setOpaque(false);
        this.Button_save.setContentAreaFilled(false);
        this.Button_save.setPreferredSize(new Dimension(78, 33));
        this.Button_save.setBorderPainted(false);

        ImageIcon Ico_load = new ImageIcon("img/ico_load.png");        
        this.Button_load = new JButton(Ico_load);
        this.Button_load.setOpaque(false);
        this.Button_load.setContentAreaFilled(false);
        this.Button_load.setPreferredSize(new Dimension(78, 33));
        this.Button_load.setBorderPainted(false);
        this.Button_load.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Window_LoadForest Window_new = new Window_LoadForest();
          }
        });
        
        ImageIcon Ico_play = new ImageIcon("img/ico_play.png"); 
        this.Button_play = new JButton(Ico_play);
        this.Button_play.setOpaque(false);
        this.Button_play.setContentAreaFilled(false);
        this.Button_play.setPreferredSize(new Dimension(40, 33));
        this.Button_play.setBorderPainted(false);
        this.Button_play.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              player.autoPlay();
          }
        });
        
        ImageIcon Ico_pause = new ImageIcon("img/ico_pause.png"); 
        this.Button_pause = new JButton(Ico_pause);
        this.Button_pause.setOpaque(false);
        this.Button_pause.setContentAreaFilled(false);
        this.Button_pause.setPreferredSize(new Dimension(40, 33));
        this.Button_pause.setBorderPainted(false);
        this.Button_pause.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              player.stopPlayer();
              parent.updateForest();
          }
        });
        
        ImageIcon Ico_nf = new ImageIcon("img/ico_nextframe.png"); 
        this.Button_nf = new JButton(Ico_nf);
        this.Button_nf.setOpaque(false);
        this.Button_nf.setContentAreaFilled(false);
        this.Button_nf.setPreferredSize(new Dimension(40, 33));
        this.Button_nf.setBorderPainted(false);
        this.Button_nf.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              player.nextStep();
              parent.updateForest();
          }
        });
        
        ImageIcon Ico_fast = new ImageIcon("img/ico_fast.png"); 
        this.Button_fast = new JButton(Ico_fast);
        this.Button_fast.setOpaque(false);
        this.Button_fast.setContentAreaFilled(false);
        this.Button_fast.setPreferredSize(new Dimension(40, 33));
        this.Button_fast.setBorderPainted(false);
        
        ImageIcon Ico_zommin = new ImageIcon("img/ico_zoomin.png"); 
        this.Button_zoomin = new JButton(Ico_zommin);
        this.Button_zoomin.setOpaque(false);
        this.Button_zoomin.setContentAreaFilled(false);
        this.Button_zoomin.setPreferredSize(new Dimension(33, 33));
        this.Button_zoomin.setBorderPainted(false);
        this.Button_zoomin.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                parent.forestAreaZoomIn();
          }
        });
        
        ImageIcon Ico_zoomout = new ImageIcon("img/ico_zoomout.png"); 
        this.Button_zoomout = new JButton(Ico_zoomout);
        this.Button_zoomout.setOpaque(false);
        this.Button_zoomout.setContentAreaFilled(false);
        this.Button_zoomout.setPreferredSize(new Dimension(35, 33));
        this.Button_zoomout.setBorderPainted(false);
        this.Button_zoomout.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                parent.forestAreaZoomOut();
          }
        });
        
        ImageIcon logo = new ImageIcon("img/logo.png");
        lb.add(new JLabel(logo));
        
        lb.add(this.Button_new);
        lb.add(this.Button_open);
        lb.add(this.Button_save);
        lb.add(this.Button_load);
         
        rb.add(this.Button_pause);
        rb.add(this.Button_play);
        rb.add(this.Button_nf);
        rb.add(this.Button_fast);
        rb.add(separator);
        rb.add(this.Button_zoomin);
        rb.add(this.Button_zoomout);
        
                
        this.add(lb, BorderLayout.WEST);
        this.add(rb, BorderLayout.EAST);
        
    }
}
