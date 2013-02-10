/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author raff
 */
public class Model_StatsDAO extends DAO<Model_Stats> {

    
    public Model_StatsDAO(Connection conn){
        super(conn);
    }

    public void create(Model_Stats obj) throws SQLException {
        System.out.println("INSERT INTO STATS (nb_steps, stat_empty, stat_youngplant, stat_youngtree,"+ 
                                                        "stat_tree, stat_fire, stat_ash, stat_infecte) VALUES('"+
                                                        obj.getT()+"','"+obj.getStat_empty()+"','"+obj.getStat_youngplant()+
                                                        "','" +obj.getStat_youngtree()+"','"+obj.getStat_tree()+"','"+
                                                        obj.getStat_fire()+"','"+obj.getStat_ash()+"','"+obj.getStat_infecte()+"')");
        this.connect.createStatement().execute("INSERT INTO STATS (nb_steps, stat_empty, stat_youngplant, stat_youngtree,"+ 
                                                        "stat_tree, stat_fire, stat_ash, stat_infecte) VALUES('"+
                                                        obj.getT()+"','"+obj.getStat_empty()+"','"+obj.getStat_youngplant()+
                                                        "','" +obj.getStat_youngtree()+"','"+obj.getStat_tree()+"','"+
                                                        obj.getStat_fire()+"','"+obj.getStat_ash()+"','"+obj.getStat_infecte()+"')");
        this.connect.close();
    }

    @Override
    public int nbEntries() throws SQLException {
        return this.connect.createStatement().executeQuery("SELECT COUNT (*) FROM STATS").getInt(1);
    }

    @Override
    public void delete(Model_Stats obj) throws SQLException {
        this.connect.createStatement().executeUpdate("DELETE FROM STATS WHERE id_stat =" +obj.getId_stat()+"");
    }

    @Override
    public Model_Stats find(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 



}
