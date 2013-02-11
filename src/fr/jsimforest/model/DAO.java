/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

/**
 *
 * @author raff
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<T> {
    
    protected Connection connect = null;
    
    /**
     * Constructeur
     * @param conn
     */
    public DAO(Connection conn){
            this.connect = conn;
    }
    
    /**
     * Méthode de création
     * @param obj
     * @return
     */
    /**
     * Méthode pour effacer
     * @param obj
     * @return
     */
    public abstract void delete(T obj) throws SQLException;
    /**
     * Méthode de mise à jour
     * @param obj
     * @return
*/
    

    public abstract T find(int id) throws SQLException;
    
    public abstract int nbEntries() throws SQLException;
  //  public abstract T find(String strSearch) throws SQLException;
}
