/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 *
 * @author EggMan
 */
public class View_Tree extends JPanel implements MouseListener { 
    public View_Tree() {

        this.addMouseListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        this.setPreferredSize(new Dimension(12,12));
        this.setBackground(Color.white);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(Color.WHITE);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    }
