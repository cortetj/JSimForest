/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
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
    
    
    public View_ActionMenu(final Window parent) {
        
        JPanel lb = new JPanel();
        JPanel rb = new JPanel();
         
        //this.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        this.setPreferredSize(new Dimension(0,45));
        //this.setBackground(Color.GREEN);
        
        this.setLayout(new BorderLayout());
        
        ImageIcon Ico_new = new ImageIcon("img/ico_new.png");        
        this.Button_new = new JButton("New", Ico_new);
        this.Button_new.setOpaque(true);
        this.Button_new.setBorderPainted(false);
        this.Button_new.setBackground(Color.decode("#A9A9A9"));
        this.Button_new.setForeground(Color.white);
        this.Button_new.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                 Window_NewForest Window_new = new Window_NewForest(parent);
          }
        });

        ImageIcon Ico_open = new ImageIcon("img/ico_open.png");        
        this.Button_open = new JButton("Open", Ico_open);
        this.Button_open.setOpaque(true);
        this.Button_open.setBorderPainted(false);
        this.Button_open.setBackground(Color.decode("#A9A9A9"));
        this.Button_open.setForeground(Color.white);
        this.Button_open.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(fc);
          }
        });

        ImageIcon Ico_save = new ImageIcon("img/ico_save.png");        
        this.Button_save = new JButton("Save", Ico_save);
        this.Button_save.setOpaque(true);
        this.Button_save.setBorderPainted(false);
        this.Button_save.setBackground(Color.decode("#A9A9A9"));
        this.Button_save.setForeground(Color.white);

        ImageIcon Ico_load = new ImageIcon("img/ico_load.png");        
        this.Button_load = new JButton("Load", Ico_load);
        this.Button_load.setOpaque(true);
        this.Button_load.setBorderPainted(false);
        this.Button_load.setBackground(Color.decode("#A9A9A9"));
        this.Button_load.setForeground(Color.white);
        this.Button_load.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Window_LoadForest Window_new = new Window_LoadForest();
          }
        });
        
        ImageIcon Ico_play = new ImageIcon("img/ico_play.png"); 
        this.Button_play = new JButton(Ico_play);
        
        ImageIcon Ico_pause = new ImageIcon("img/ico_pause.png"); 
        this.Button_pause = new JButton(Ico_pause);
        
        ImageIcon Ico_nf = new ImageIcon("img/ico_nextframe.png"); 
        this.Button_nf = new JButton(Ico_nf);
        
        ImageIcon Ico_fast = new ImageIcon("img/ico_fast.png"); 
        this.Button_fast = new JButton(Ico_fast);
        
        lb.add(this.Button_new);
        lb.add(this.Button_open);
        lb.add(this.Button_save);
        lb.add(this.Button_load);
         
        rb.add(this.Button_play);
        rb.add(this.Button_pause);
        rb.add(this.Button_nf);
        rb.add(this.Button_fast);
        
        this.add(lb, BorderLayout.WEST);
        this.add(rb, BorderLayout.EAST);
        
    }
}
