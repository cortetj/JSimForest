/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

/**
 *
 * @author raff
 */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import fr.jsmiforest.tools.Utils;
import org.w3c.dom.Document;

public class Singleton{

	/*
         *   Attribus pour méthode sans XML
         * 
        public static String dbName ="";
	public static String user ="root"; 
	public static String pass ="root";*/
    
	private static Connection connectDB =null;
	
	public static Connection connectToDB(){
		//singleton -> connect to 
		if(Singleton.connectDB !=null){
			return Singleton.connectDB;
		}
                
                try{
                    File fXmlFile = new File("src/fr/jsimforest/tools/DataBaseInfo.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(fXmlFile);
                    doc.getDocumentElement().normalize();
                    
                    Class.forName("org.mysql.JDBC"); // Utile? YES or NO?
                    Singleton.connectDB =DriverManager.getConnection(
                           doc.getElementsByTagName("url").item(0).getTextContent(),
                           doc.getElementsByTagName("login").item(0).getTextContent(),
                           doc.getElementsByTagName("password").item(0).getTextContent());
                    
                    System.out.println("Connection established...");
                    
		}catch (Exception e){
			Singleton.connectDB =null;
			Utils.errorGui(e, "ERROR CAN'T CONNECT TO MySQL DB...");
                }
                return Singleton.connectDB;
        }
}