/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import fr.jsimforest.tools.Utils_ExportCSV;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EggMan
 */
public class View_Stats extends JPanel {
        
    private JTable Table_Stat;
    private JTable Table_Stat_prc;
    private JTable Table_Stat_actPrc;
    
    private boolean Save_Data;
    private JSplitPane split, split2, split3;
    private static DefaultTableModel Model_stat;
    private static DefaultTableModel Model_stat_prc;
    private static DefaultTableModel Model_stat_actPrc;
   
    private JButton exportCSV;
    private JButton deleteRows;
    
    public View_Stats() {
  
        JPanel buttons = new JPanel();
        JPanel Stat_panel = new JPanel();
        JPanel Stat_panel_prc = new JPanel();
        JPanel Stat_panel_actPrc = new JPanel();
        final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");
        
        Stat_panel.setLayout(new GridLayout(1,1));
        Stat_panel_prc.setLayout(new GridLayout(1,1));
        Stat_panel_actPrc.setLayout(new GridLayout(1,1));
        this.setLayout(new BorderLayout());
        
        String[] col = {"t", "Empty", "Young Plant", "Small tree", "Adult tree", "fire", "infect", "ash"};
        String[] col_prc = {"t", "% Empty", "% Young Plant", "% Small tree", "% Adult tree", "% fire", "% infect", "% ash"};
        
        Object[][] data = {{
            Controller_ForestArea.getStep(),
            Controller_ForestArea.getNbr_empty(),
            Controller_ForestArea.getNbr_yp(),
            Controller_ForestArea.getNbr_st(),
            Controller_ForestArea.getNbr_at(),
            Controller_ForestArea.getNbr_fire(),
            Controller_ForestArea.getNbr_infect(),
            Controller_ForestArea.getNbr_ash()
        }};
        
        Object[][] data_prc = {{
            Controller_ForestArea.getStep(), 
            Controller_ForestArea.getNbr_empty()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()), 
            Controller_ForestArea.getNbr_yp()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_st()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_at()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_fire()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_infect()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_ash()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight())
        }};
        
        
        View_Stats.Model_stat = new DefaultTableModel(data, col);
        View_Stats.Model_stat_prc = new DefaultTableModel(data_prc, col_prc);
        View_Stats.Model_stat_actPrc = new DefaultTableModel(data_prc, col);
        
        this.Table_Stat = new JTable(View_Stats.Model_stat);
        this.Table_Stat_prc = new JTable(View_Stats.Model_stat_prc);
        this.Table_Stat_actPrc = new JTable(View_Stats.Model_stat_actPrc);
        
        this.exportCSV = new JButton("Export to CSV");
        this.exportCSV.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Utils_ExportCSV.Utils_ExportCSV(Table_Stat, Controller_ForestArea.getName() + dateFormat.format(new Date()) +".csv");
          }
        });
        
       
        this.deleteRows = new JButton("Clear table");
        this.deleteRows.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              Model_stat.setRowCount(0);
              Model_stat_prc.setRowCount(0);
              Model_stat_actPrc.setRowCount(0);
          }
        });
        
        
        
        buttons.add(this.deleteRows);
        buttons.add(this.exportCSV);
        
        Stat_panel.add(new JScrollPane(this.Table_Stat));
        Stat_panel_prc.add(new JScrollPane(this.Table_Stat_prc));
        Stat_panel_actPrc.add(new JScrollPane(this.Table_Stat_actPrc));

        split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Stat_panel_prc, Stat_panel_actPrc);
        split2.setDividerLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2);
        
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Stat_panel, split2);
        split.setDividerLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2);
        

        
        JPanel Stats_container = new JPanel(new GridLayout(1,1));
        Stats_container.add(split);
        Stats_container.add(split2);
        this.add(buttons, BorderLayout.SOUTH);
        this.add(Stats_container, BorderLayout.CENTER);
    }
    
    public static void addStatRow() {
        Object[] data = {
            Controller_ForestArea.getStep(),
            Controller_ForestArea.getNbr_empty(),
            Controller_ForestArea.getNbr_yp(),
            Controller_ForestArea.getNbr_st(),
            Controller_ForestArea.getNbr_at(),
            Controller_ForestArea.getNbr_fire(),
            Controller_ForestArea.getNbr_infect(),
            Controller_ForestArea.getNbr_ash()
        };
        
        Object[] data_prc = {
            Controller_ForestArea.getStep(), 
            Controller_ForestArea.getNbr_empty()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()), 
            Controller_ForestArea.getNbr_yp()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_st()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_at()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_fire()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_infect()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight()),
            Controller_ForestArea.getNbr_ash()*100/(Controller_ForestArea.getWidth()*Controller_ForestArea.getHeight())
        };
        
        View_Stats.Model_stat.addRow(data);
        View_Stats.Model_stat_prc.addRow(data_prc);
    }
}
