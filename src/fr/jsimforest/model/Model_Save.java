/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author raff
 */
public class Model_Save {
    private int id_save;
    private String name_save;
    private Date date;
    private String forest_save;
    private int id_stat;
    private Model_Stats stats = new Model_Stats();
    
    public Model_Save(){}
    
    public Model_Save(int id, String name, Date date, String forest, int  foreign_id) throws SQLException{
        this.id_save=id;
        this.name_save=name;
        this.date=date;
        this.forest_save=forest;
        this.id_stat=foreign_id;
        this.stats=this.loadStats();
        

    }
    private Model_Stats loadStats() throws SQLException{
		return new Model_StatsDAO(Model_Singleton.connectToDB()).find(this.getId_stat());
	}

    /**
     * @return the id_save
     */
    public int getId_save() {
        return id_save;
    }

    /**
     * @param id_save the id_save to set
     */
    public void setId_save(int id_save) {
        this.id_save = id_save;
    }

    /**
     * @return the name_save
     */
    public String getName_save() {
        return name_save;
    }

    /**
     * @param name_save the name_save to set
     */
    public void setName_save(String name_save) {
        this.name_save = name_save;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the forest_save
     */
    public String getForest_save() {
        return forest_save;
    }

    /**
     * @param forest_save the forest_save to set
     */
    public void setForest_save(String forest_save) {
        this.forest_save = forest_save;
    }

    /**
     * @return the id_stat
     */
    public int getId_stat() {
        return id_stat;
    }

    /**
     * @param id_stat the id_stat to set
     */
    public void setId_stat(int id_stat) {
        this.id_stat = id_stat;
    }

    /**
     * @return the stats
     */
    public Model_Stats getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(Model_Stats stats) {
        this.stats = stats;
    }
}
