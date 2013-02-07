/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import fr.jsimforest.controller.Controller_ForestArea;
import fr.jsimforest.controller.Utils_ExportCSV;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author EggMan
 */
public class View_Stats extends JPanel {
    private String[] columnNames;
    private JTable Table_Stat;
    private static DefaultTableModel Model_stat;
    private JButton exportCSV;
    
    public View_Stats() {
  
        JPanel buttons = new JPanel();
        JPanel Stat_panel = new JPanel(new GridLayout(1,1));
        
        this.setLayout(new BorderLayout());
        
        String[] col = {"t", "Empty", "Young Plant", "Small tree", "Adult tree", "fire", "infect", "ash"};
        this.columnNames = col;
        
        Object[][] data = {   
            {Controller_ForestArea.getStep(), Controller_ForestArea.getNbr_empty(), Controller_ForestArea.getNbr_yp(), Controller_ForestArea.getNbr_st(), Controller_ForestArea.getNbr_at(), Controller_ForestArea.getNbr_fire(), Controller_ForestArea.getNbr_infect(), Controller_ForestArea.getNbr_ash()}
        };
        
        final DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");
        
        this.exportCSV = new JButton("Export to CSV");
        this.exportCSV.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
                Utils_ExportCSV.Utils_ExportCSV(Table_Stat, Controller_ForestArea.getName() + dateFormat.format(new Date()) +".csv");
          }
        });
        View_Stats.Model_stat = new DefaultTableModel(data, this.columnNames);
        this.Table_Stat = new JTable(View_Stats.Model_stat);
        
        buttons.add(this.exportCSV);
        Stat_panel.add(new JScrollPane(this.Table_Stat));
        
        this.add(buttons, BorderLayout.SOUTH);
        this.add(Stat_panel, BorderLayout.CENTER);
    }
    
    public static void addStatRow() {
        Object[] data = {Controller_ForestArea.getStep(), Controller_ForestArea.getNbr_empty(), Controller_ForestArea.getNbr_yp(), Controller_ForestArea.getNbr_st(), Controller_ForestArea.getNbr_at(), Controller_ForestArea.getNbr_fire(), Controller_ForestArea.getNbr_infect(), Controller_ForestArea.getNbr_ash()};
        View_Stats.Model_stat.addRow(data);
    }
}
