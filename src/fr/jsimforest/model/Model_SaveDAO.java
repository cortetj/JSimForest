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
import fr.jsimforest.tools.Utils;
import java.sql.PreparedStatement;
import java.util.Date;
/**
 *
 * @author raff
 */
public class Model_SaveDAO extends DAO<Model_Save> {
    
    public Model_SaveDAO(Connection conn){
        super(conn);
    }
    
    public void creatE(Model_Save save, ArrayList<Model_Stats> stats) throws SQLException{
        
        int key = 0;
        
        PreparedStatement prepareInsertSave = this.connect.prepareStatement("INSERT INTO SAVE (name_save, forest_save) VALUES(?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            prepareInsertSave.setString(1, save.getName_save());
            prepareInsertSave.setString(2, save.getForest_save());
            prepareInsertSave.executeUpdate();
           
        ResultSet rs = prepareInsertSave.getGeneratedKeys();
        
        if (rs != null && rs.next()) {
           key = rs.getInt(1);
        }
        
        for(int i=0; i<stats.size(); i++){
        this.connect.createStatement().execute("INSERT INTO STATS (t, stat_empty, stat_youngplant, stat_youngtree, stat_tree, stat_fire"+
                                               ", stat_ash, stat_infecte, id_save) VALUES('"+stats.get(i).getT()+
                                               "','"+stats.get(i).getStat_empty()+"','"+stats.get(i).getStat_youngplant()+
                                               "','"+stats.get(i).getStat_youngtree()+"','"+stats.get(i).getStat_tree()+
                                               "','"+stats.get(i).getStat_fire()+"','"+stats.get(i).getStat_ash()+
                                               "','"+stats.get(i).getStat_infecte()+"','"+ key +"')");
        }    
        
        prepareInsertSave.close();
        //this.connect.close();
    }
    
    @Override
    public void delete(Model_Save obj) throws SQLException{
        this.connect.createStatement().executeUpdate("DELETE FROM SAVE WHERE id_save =" +obj.getId_save() +"");
    }

    
    @Override
    public int nbEntries() throws SQLException{
        
        int key = 0;
        
        PreparedStatement prepareNbSave = this.connect.prepareStatement("SELECT COUNT(id_save) FROM SAVE");
        //prepareInsertSave.executeUpdate();
           
        ResultSet rs = prepareNbSave.executeQuery();
        
        if (rs != null && rs.next()) {
           key = rs.getInt(1);
        }
        
       return key;
    }

   
    public ArrayList<Model_Stats> findListStats(Model_Save e) throws SQLException {
        ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM STATS WHERE"+
                                                                       " id_save =" +e.getId_save());
        ArrayList<Model_Stats> ListStats = new ArrayList<Model_Stats>();
            while(result.next()){
                ListStats.add(new Model_Stats(result.getInt(1), result.getInt(2),result.getInt(3),
                                              result.getInt(4),result.getInt(5),result.getInt(6),
                                              result.getInt(7),result.getInt(8),result.getInt(9),result.getInt(10)));
            }
            return ListStats;
    }
    
    @Override
    public Model_Save find(int id) throws SQLException {
        ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM SAVE WHERE id_save =" +id+"");
			if(!result.next()){
				return null;
			}
			return new Model_Save(id, result.getString("name_save"), result.getString("forest_save"), result.getTimestamp("date_save"));
    }
}
