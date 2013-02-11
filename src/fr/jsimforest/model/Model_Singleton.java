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

import fr.jsimforest.tools.Utils;
import org.w3c.dom.Document;

public class Model_Singleton{

	/*
         *   Attribus pour méthode sans XML
         * */
        /*public static String dbName ="jdbc:sqlite:dbJSim.db3";
	public static String user ="root"; 
	public static String pass ="root";*/
    
	private static Connection connectDB =null;
	
	public static Connection connectToDB(){
		//singleton -> connect to 
		if(Model_Singleton.connectDB !=null){
			return Model_Singleton.connectDB;
		}
                
                try{
                    File fXmlFile = new File("src/fr/jsimforest/tools/DataBaseInfo.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(fXmlFile);
                    doc.getDocumentElement().normalize();
                    
                    Class.forName("com.mysql.jdbc.Driver");	
                    Model_Singleton.connectDB =DriverManager.getConnection(
                           doc.getElementsByTagName("url").item(0).getTextContent(),
                           doc.getElementsByTagName("login").item(0).getTextContent(),
                           doc.getElementsByTagName("password").item(0).getTextContent());
                    
                    System.out.println("Connection established...");
                    
		}catch (Exception e){
			Model_Singleton.connectDB =null;
			Utils.errorGui(e, "ERROR CAN'T CONNECT TO MySQL DB...");
                }
                return Model_Singleton.connectDB;
        }
}