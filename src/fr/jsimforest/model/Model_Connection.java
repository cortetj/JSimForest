/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author EggMan
 */
public class Model_Connection {

    private Connection connect;
    
    public Model_Connection() 
    {
        this.connectToDB();
//        Connection con = DriverManager.getConnection(
//                         "jdbc:myDriver:myDatabase",
//                         username,
//                         password);
//
//        Statement stmt = con.createStatement();
    }
    
    public void connectToDB() {
        try {

            File fXmlFile = new File("src/fr/jsimforest/tools/DataBaseInfo.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            
         try{

         String url ="jdbc:mysql://localhost:3306/wsjdbcdb";
         String user="root";
         String pass="root";
         
         this.connect = DriverManager.getConnection(
                 doc.getElementsByTagName("url").item(0).getTextContent(),
                 doc.getElementsByTagName("login").item(0).getTextContent(),
                 doc.getElementsByTagName("password").item(0).getTextContent());
         
         System.out.println("Database Established…");

        }catch(SQLException e){
            throw new RuntimeException("Erreur dans l'obtention de la connexion");
        }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
