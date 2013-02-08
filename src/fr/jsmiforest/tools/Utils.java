/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsmiforest.tools;

/**
 *
 * @author raff
 */
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Utils{
	
	public static void errorGui(Exception e, String msg){
		//debug
		e.printStackTrace();
		Toolkit.getDefaultToolkit().beep();
		System.err.println(msg);
		JOptionPane.showMessageDialog(null, msg, "Erreur", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}	
}

