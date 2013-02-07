/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_Cell;
import fr.jsimforest.controller.Controller_ForestArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EggMan
 */
public class View_StatMenu extends JPanel {
    
        private JButton Button_fire;
        private JButton Button_infect;
        
        private static JLabel Label_width;
        private static JLabel Label_height;
        private static JLabel Label_total;
        
        private static JLabel Label_empty;
        private static JLabel Label_yp;
        private static JLabel Label_st;
        private static JLabel Label_at;
        private static JLabel Label_infect;
        private static JLabel Label_fire;
        private static JLabel Label_ash;
        
        public View_StatMenu() {
            
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#AAAAAA"), 1));  
            this.setPreferredSize(new Dimension(0,45));
            this.setLayout(new BorderLayout());
            //this.setBackground(Color.decode("#2c2c2c"));
            
                        
            JPanel lb = new JPanel();
            lb.setOpaque(false);
          
            JPanel rb = new JPanel();
            rb.setOpaque(false);
            
            lb.setLayout(new GridBagLayout());
            
            ImageIcon Ico_fire = new ImageIcon(new ImageIcon("img/ico_fire.png").getImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT)); 
            this.Button_fire = new JButton(Ico_fire);
            this.Button_fire.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                   Controller_Cell.setSelected_tree(4);
             }
           });
            
            rb.add(this.Button_fire);
            
            ImageIcon Ico_infect = new ImageIcon(new ImageIcon("img/ico_infect.png").getImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT)); 
            this.Button_infect = new JButton(Ico_infect);
            this.Button_infect.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent evt) {
                    Controller_Cell.setSelected_tree(5);
              }
            });
            
            rb.add(this.Button_infect);
            
            View_StatMenu.Label_width = new JLabel();
            View_StatMenu.Label_height = new JLabel();
            View_StatMenu.Label_total = new JLabel();
            View_StatMenu.Label_empty = new JLabel();
            View_StatMenu.Label_yp = new JLabel();
            View_StatMenu.Label_st = new JLabel();
            View_StatMenu.Label_at = new JLabel();
            View_StatMenu.Label_fire = new JLabel();
            View_StatMenu.Label_infect = new JLabel();
            View_StatMenu.Label_ash = new JLabel();
            
            JLabel separator = new JLabel();
            separator.setPreferredSize(new Dimension(10,10));
            lb.add(separator);
            lb.add(new JLabel(" WIDTH : "));
            lb.add(View_StatMenu.Label_width);
            
            lb.add(new JLabel(" HEIGHT : "));
            lb.add(View_StatMenu.Label_height);
            
            lb.add(new JLabel(" TOTAL : "));
            lb.add(View_StatMenu.Label_total);
            
            lb.add(new JLabel(" Empty : "));
            lb.add(View_StatMenu.Label_empty);
            
            lb.add(new JLabel(" Young plant : "));
            lb.add(View_StatMenu.Label_yp);
            
            lb.add(new JLabel(" Small tree : "));
            lb.add(View_StatMenu.Label_st);
            
            lb.add(new JLabel(" Adult tree : "));
            lb.add(View_StatMenu.Label_at);
            
            lb.add(new JLabel(" Fire : "));
            lb.add(View_StatMenu.Label_fire);
            
            lb.add(new JLabel(" Infect : "));
            lb.add(View_StatMenu.Label_infect);
            
            lb.add(new JLabel(" Ash : "));
            lb.add(View_StatMenu.Label_ash);
            
            this.add(lb, BorderLayout.WEST);
            this.add(rb, BorderLayout.EAST);
            
        }
    
    public static void updateLabelStat() {
        
        View_StatMenu.Label_width.setText(" " +Controller_ForestArea.getWidth() + " | ");
        View_StatMenu.Label_height.setText(" " +Controller_ForestArea.getHeight() + " | ");
        View_StatMenu.Label_total.setText(" " +Controller_ForestArea.getHeight()*Controller_ForestArea.getWidth() + " | ");
        View_StatMenu.Label_empty.setText(" " +Controller_ForestArea.getNbr_empty() + " | ");
        View_StatMenu.Label_yp.setText(" " +Controller_ForestArea.getNbr_yp() + " | ");
        View_StatMenu.Label_st.setText(" " +Controller_ForestArea.getNbr_st() + " | ");
        View_StatMenu.Label_at.setText(" " +Controller_ForestArea.getNbr_at() + " | ");
        View_StatMenu.Label_fire.setText(" " +Controller_ForestArea.getNbr_fire() + " | ");
        View_StatMenu.Label_infect.setText(" " +Controller_ForestArea.getNbr_infect() + " | ");
        View_StatMenu.Label_ash.setText(" " +Controller_ForestArea.getNbr_ash() + " ");
    }
    
}
