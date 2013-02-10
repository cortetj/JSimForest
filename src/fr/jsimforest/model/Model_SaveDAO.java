/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import fr.jsimforest.model.Model_Save;
import fr.jsimforest.model.DAO;
/**
 *
 * @author raff
 */
public class Model_SaveDAO extends DAO<Model_Save> {
    
    public Model_SaveDAO(Connection conn){
        super(conn);
    }
    
    @Override
    public void create(Model_Save obj) throws SQLException{
        this.connect.createStatement().executeUpdate("INSERT INTO SAVE (name_save, date_save, forest_save, id_stat) VALUES('"+
                                                        obj.getName_save()+"','"+obj.getDate().toString()+"','"+
                                                        obj.getForest_save()+"','" +obj.getId_stat()+ "')");
    }
    
    @Override
    public void delete(Model_Save obj) throws SQLException{
        this.connect.createStatement().executeUpdate("DELETE FROM SAVE WHERE id_save =" +obj.getId_save() +"");
    }

    @Override
    public void select(Model_Save obj) throws SQLException{
        
    }
    
       
   

    
    @Override
    public int nbEntries() throws SQLException{
       return this.connect.createStatement().executeQuery("SELECT COUNT (*) FROM SAVE").getInt(1);
    }

   
    @Override
    public Model_Save find(int i) throws SQLException {
        ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM SAVE WHERE id_save =" +i);
			if(!result.next()){
				return null;
			}
			return new Model_Save(i, result.getString(2), result.getDate(3), result.getString(4), result.getInt(5));
    }
    

    /*public ArrayList<Model_Save> findList() throws SQLException{
        ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM SAVE");
        ArrayList<Model_Save> ListSaves = new ArrayList<Model_Save>();
        
        while(result.next()){
            ListSaves.add(new Model_Save(result.getInt(1), result.getString(2), result.getDate(3), result.getString(4), result.getInt(5)));
        }																 
        return ListSaves;  
    }*/



}
