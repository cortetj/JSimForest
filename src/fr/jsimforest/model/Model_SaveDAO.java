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
        this.connect.createStatement().execute("INSERT INTO SAVE (name_save, forest_save) VALUES('"+
                                                        save.getName_save()+"','"+
                                                        save.getForest_save()+"')");
        
        ResultSet result =this.connect.createStatement().executeQuery("SELECT * FROM "+
                                                    "SAVE ORDER BY id_save DESC LIMIT 1");
        
        
        for(int i=0; i<stats.size(); i++){
        this.connect.createStatement().execute("INSERT INTO STATS (t, stat_empty, stat_youngplant, stat_youngtree,stat_tree, stat_fire"+
                                               ", stat_ash, stat_infecte, id_save) VALUES('"+stats.get(i).getT()+
                                               "','"+stats.get(i).getStat_empty()+"','"+stats.get(i).getStat_youngplant()+
                                               "','"+stats.get(i).getStat_youngtree()+"','"+stats.get(i).getStat_tree()+
                                               "','"+stats.get(i).getStat_fire()+"','"+stats.get(i).getStat_ash()+
                                               "','"+stats.get(i).getStat_infecte()+"','"+result.getInt(1)+"')");
        }    
        this.connect.close();
    }
    
    @Override
    public void delete(Model_Save obj) throws SQLException{
        this.connect.createStatement().executeUpdate("DELETE FROM SAVE WHERE id_save =" +obj.getId_save() +"");
    }

    
    @Override
    public int nbEntries() throws SQLException{
       return this.connect.createStatement().executeQuery("SELECT COUNT (*) FROM SAVE").getInt(1);
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
			return new Model_Save(id, result.getString("name_save"), result.getString("forest_save"));
    }
}
