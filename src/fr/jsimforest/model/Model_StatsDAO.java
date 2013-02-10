/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author raff
 */
public class Model_StatsDAO extends DAO<Model_Stats> {

    
    public Model_StatsDAO(Connection conn){
        super(conn);
    }

    @Override
    public void create(Model_Stats obj) throws SQLException {
        this.connect.createStatement().executeUpdate("INSERT INTO STATS (t, stat_empty, stat_youngplant, youngtree,"+ 
                                                        "stat_tree, stat_fire, stat_ash, stat_infecte) VALUES('"+
                                                        obj.getT()+"','"+obj.getStat_empty()+"','"+obj.getStat_youngplant()+
                                                        "','" +obj.getStat_youngtree()+"','"+obj.getStat_tree()+"','"+
                                                        obj.getStat_fire()+"','"+obj.getStat_ash()+"','"+obj.getStat_infecte()+")");
    }

    @Override
    public void delete(Model_Stats obj) throws SQLException {
        this.connect.createStatement().executeUpdate("DELETE FROM STATS WHERE id_stat =" +obj.getId_stat()+"");
    }

    @Override
    public void select(Model_Stats obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int nbEntries() throws SQLException {
        return this.connect.createStatement().executeQuery("SELECT COUNT (*) FROM STATS").getInt(1);
    }

      @Override
    public Model_Stats find(int id) throws SQLException{
        ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM STATS WHERE id_stat =" +id);
		return new Model_Stats(result.getInt(1),result.getInt(2),result.getInt(3),
                        result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),
                        result.getInt(8),result.getInt(9));
    }
}
