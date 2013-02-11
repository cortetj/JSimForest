/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_Cell;
import fr.jsimforest.controller.Controller_ForestArea;
import fr.jsimforest.controller.Controller_Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import jsimforest.Window;

/**
 *
 * @author EggMan
 */
public class View_TreeMenu extends JPanel {

    private static int selected_tree;
    
    private JButton Button_empty;
    private JButton Button_yp;
    private JButton Button_st;
    private JButton Button_at;
    
    private JCheckBox Check_Border;
    private JCheckBox Check_ContinueDev;
    private JCheckBox Check_saveStat;
    private JSlider Slide_speed;
    private JSpinner Text_maxStep;
    private JCheckBox Check_StepInfinite;


    public View_TreeMenu(final Window parent) {

        JLabel separator = new JLabel();
        separator.setText("");

        this.Button_empty = new JButton("Empty");
        ImageIcon Ico_cell_empty = new ImageIcon("img/ico_cell_empty.png");        
        this.Button_empty = new JButton(Ico_cell_empty);
        this.Button_empty.setOpaque(false);
        this.Button_empty.setBorderPainted(false);
        this.Button_empty.setContentAreaFilled(false);
        this.Button_empty.setPreferredSize(new Dimension(130, 34));
        this.Button_empty.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(0);
          }
        });
        
        this.Button_yp = new JButton("Young plant");
        ImageIcon Ico_cell_yp = new ImageIcon("img/ico_cell_yp.png");        
        this.Button_yp = new JButton(Ico_cell_yp);
        this.Button_yp.setOpaque(false);
        this.Button_yp.setBorderPainted(false);
        this.Button_yp.setContentAreaFilled(false);
        this.Button_yp.setPreferredSize(new Dimension(130, 34));
        this.Button_yp.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(1);
          }
        });
        
        this.Button_st = new JButton("Small tree");
        ImageIcon Ico_cell_st = new ImageIcon("img/ico_cell_st.png");        
        this.Button_st = new JButton(Ico_cell_st);
        this.Button_st.setOpaque(false);
        this.Button_st.setBorderPainted(false);
        this.Button_st.setContentAreaFilled(false);
        this.Button_st.setPreferredSize(new Dimension(130, 34));
        this.Button_st.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(2);
          }
        });
        
        this.Button_at = new JButton("Adult tree");
        ImageIcon Ico_cell_at = new ImageIcon("img/ico_cell_at.png");        
        this.Button_at = new JButton(Ico_cell_at);
        this.Button_at.setOpaque(false);
        this.Button_at.setBorderPainted(false);
        this.Button_at.setContentAreaFilled(false);
        this.Button_at.setPreferredSize(new Dimension(130, 34));
        this.Button_at.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Controller_Cell.setSelected_tree(3);
          }
        });
        
        this.Check_Border = new JCheckBox("Border", null, true);
        this.Check_Border.setPreferredSize(new Dimension(130,30));
        this.Check_Border.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                View_ForestArea.setMap_border(Check_Border.isSelected());
                parent.updateBorder();
          }
        });
        
        final SpinnerNumberModel Model_maxStep = new SpinnerNumberModel(10, 1, 1000, 1); 
        this.Text_maxStep = new JSpinner(Model_maxStep);
        this.Text_maxStep.setPreferredSize(new Dimension(80, 25));
        this.Text_maxStep.setEnabled(false);
        this.Text_maxStep.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
              Controller_Player.setNbr_step(Model_maxStep.getNumber().intValue());
              System.out.println(Text_maxStep.getValue());

            }
        });
                
        this.Check_ContinueDev = new JCheckBox("Continue dev", null, false);
        this.Check_ContinueDev.setPreferredSize(new Dimension(130,30));
        this.Check_ContinueDev.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              if(Check_StepInfinite.isSelected()) {
                  Controller_ForestArea.setC_develop(true);
              }
              else {
                Text_maxStep.setEnabled(true);
               Controller_ForestArea.setC_develop(false);
              }
          }
        });
        
        
        this.Check_StepInfinite = new JCheckBox("Infinite", null, true);
        this.Check_StepInfinite.setPreferredSize(new Dimension(130,30));
        this.Check_StepInfinite.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              if(Check_StepInfinite.isSelected()) {
                  Text_maxStep.setEnabled(false);
                  Controller_Player.setNbr_step(0);
              }
              else {
                Text_maxStep.setEnabled(true);
                Controller_Player.setNbr_step(Model_maxStep.getNumber().intValue());
              }
          }
        });
        
        this.Check_saveStat = new JCheckBox("Save statistic", null, false);
        this.Check_saveStat.setPreferredSize(new Dimension(130,30));
        this.Check_saveStat.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              if(View_Stats.isSave_stat()) {
                  View_Stats.setSave_stat(false);
              }
              else {View_Stats.setSave_stat(true);}
          }
        });
        
        this.Slide_speed = new JSlider();
        this.Slide_speed.setPreferredSize(new Dimension(71,45));
        this.Slide_speed.setMinimum(1);
        this.Slide_speed.setMaximum(5);
        this.Slide_speed.setInverted(true);
        this.Slide_speed.setValue(1);
        this.Slide_speed.setPaintTicks(true);
        this.Slide_speed.setPaintLabels(true);
        this.Slide_speed.setMajorTickSpacing(1);
        this.Slide_speed.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent me) {
                    Controller_Player.stopPlayer();
                    

            }

            @Override
            public void mouseReleased(MouseEvent me) {
                    Controller_Player.setGap(Slide_speed.getValue() * 10);
                    View_ActionMenu.getPlayer().autoPlay();
            }


            @Override
            public void mouseExited(MouseEvent me) {}

            @Override
            public void mouseClicked(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}
        });
        
        this.setPreferredSize(new Dimension(150,0));
        this.setBackground(Color.decode("#EEEEEE"));

        this.add(new JLabel(" MENU "));
        
        JPanel Fieldset_tree = new JPanel();
        Fieldset_tree.setBorder(BorderFactory.createTitledBorder("TREES"));
        Fieldset_tree.setPreferredSize(new Dimension(145,190));
        Fieldset_tree.add(this.Button_empty);
        Fieldset_tree.add(this.Button_yp);
        Fieldset_tree.add(this.Button_st);
        Fieldset_tree.add(this.Button_at);
        this.add(Fieldset_tree);
        
        
        JPanel Fieldset_pref = new JPanel();
        Fieldset_pref.setBorder(BorderFactory.createTitledBorder("PREFERENCES"));
        Fieldset_pref.setPreferredSize(new Dimension(145,240));
        Fieldset_pref.add(this.Check_Border);
        
        
        
        Fieldset_pref.add(new JLabel("Speed :"));
        
        JPanel jp_speed = new JPanel();
        jp_speed.add(this.Slide_speed);
        Fieldset_pref.add(jp_speed);
        JPanel jp_step = new JPanel();

        jp_step.add(new JLabel("t Max :"));
        jp_step.add(this.Text_maxStep);
        Fieldset_pref.add(jp_step);
        Fieldset_pref.add(this.Check_StepInfinite);
        Fieldset_pref.add(this.Check_ContinueDev);
        
        this.add(Fieldset_pref);
        
        JPanel Fieldset_stat = new JPanel();
        Fieldset_stat.setBorder(BorderFactory.createTitledBorder("STATISTICS"));
        Fieldset_stat.setPreferredSize(new Dimension(145,60));
        
        Fieldset_stat.add(this.Check_saveStat);
        this.add(Fieldset_stat);
    }
    
}
