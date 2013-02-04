/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
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
        
        private JLabel Label_width;
        //private JLabel Label_width_var;
        
        private JLabel Label_height;
        //private JLabel Label_height_var;
        
        private JLabel Label_total;
        
        private JLabel Label_empty;
        //private JLabel Label_empty_var;
        
        private JLabel Label_yp;
        //private JLabel Label_yp_var;
        
        private JLabel Label_st;
        //private JLabel Label_st_var;
        
        private JLabel Label_at;
        //private JLabel Label_at_var;
                
        
        public View_StatMenu() {
            
            //this.setBorder(BorderFactory.createLineBorder(Color.black, 1));  
            this.setPreferredSize(new Dimension(0,45));
            this.setLayout(new BorderLayout());
            //this.setBackground(Color.RED);
                        
            JPanel lb = new JPanel();
            JPanel rb = new JPanel();
            
            lb.setLayout(new GridBagLayout());
            
            ImageIcon Ico_fire = new ImageIcon(new ImageIcon("img/ico_fire.png").getImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT)); 
            this.Button_fire = new JButton(Ico_fire);
            rb.add(this.Button_fire);
            
            ImageIcon Ico_infect = new ImageIcon(new ImageIcon("img/ico_infect.png").getImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT)); 
            this.Button_infect = new JButton(Ico_infect);
            rb.add(this.Button_infect);
            
            this.Label_width = new JLabel();
            this.Label_height = new JLabel();
            this.Label_total = new JLabel();
            this.Label_empty = new JLabel();
            this.Label_yp = new JLabel();
            this.Label_st = new JLabel();
            this.Label_at = new JLabel();
            
            lb.add(new JLabel(" WIDTH : "));
            lb.add(this.Label_width);
            
            lb.add(new JLabel(" HEIGHT : "));
            lb.add(this.Label_height);
            
            lb.add(new JLabel(" TOTAL : "));
            lb.add(this.Label_total);
            
            lb.add(new JLabel(" Empty : "));
            lb.add(this.Label_empty);
            
            lb.add(new JLabel(" Young plant : "));
            lb.add(this.Label_yp);
            
            lb.add(new JLabel(" Small tree : "));
            lb.add(this.Label_st);
            
            lb.add(new JLabel(" Adult tree : "));
            lb.add(this.Label_at);
            
            this.add(lb, BorderLayout.WEST);
            this.add(rb, BorderLayout.EAST);
            
        }
    
    public void updateLabelStat() {
        
        this.Label_width.setText(" " +Controller_ForestArea.getWidth() + " | ");
        this.Label_height.setText(" " +Controller_ForestArea.getHeight() + " | ");
        this.Label_total.setText(" " +Controller_ForestArea.getHeight()*Controller_ForestArea.getWidth() + " | ");
        this.Label_empty.setText(" " +Controller_ForestArea.getNbr_empty() + " | ");
        this.Label_yp.setText(" " +Controller_ForestArea.getNbr_yp() + " | ");
        this.Label_st.setText(" " +Controller_ForestArea.getNbr_st() + " | ");
        this.Label_at.setText(" " +Controller_ForestArea.getNbr_at() + " ");
    }
    
}
