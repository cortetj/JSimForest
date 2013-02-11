/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.jsimforest.model.Model_SaveDAO;
import fr.jsimforest.model.Model_Save;
import fr.jsimforest.model.Model_Stats;
import fr.jsimforest.model.DAO;
import fr.jsimforest.model.Model_Singleton;
import fr.jsimforest.tools.Utils;
/**
 *
 * @author raff
 */
public class Controller_Save {
    private DAO<Model_Save> connectSaveDAO;
    private DAO<Model_Stats> connectStatsDAO;
    private ArrayList<Model_Save> saves;
    private Model_SaveDAO save;
    
    public Controller_Save(){
        this.connectSaveDAO = new Model_SaveDAO(Model_Singleton.connectToDB());
        this.save = new Model_SaveDAO(Model_Singleton.connectToDB());
        try{
            this.saves = new ArrayList<Model_Save>();
            this.loadSaves();
        }catch(Exception e){
            Utils.errorGui(e, "Error data access..");
        }
    }


    /**
     * @return the saves
     */
    public ArrayList<Model_Save> getSaves() {
        return saves;
    }

    /**
     * @param saves the saves to set
     */
    public void setSaves(ArrayList<Model_Save> saves) {
        this.saves = saves;
    }
    
    //INNER FUNCTIONS
    private void loadSaves() throws SQLException{
        int len=this.connectSaveDAO.nbEntries();
        System.out.println("NB ENTRIES <=> "+len);
        int i=0;
        Model_Save Saves;
        while(++i <len +1){
           if((Saves=this.connectSaveDAO.find(i))!=null){
               this.saves.add(Saves);
               System.out.println("VALUES <=> "+Saves.getName_save());
           }
        }  
    }
    
    public void loadLastSave(){
        
    }
    public void loadSaveWithName(){
                
    }
    
    public void newSave(Model_Save save, ArrayList<Model_Stats> stats) throws SQLException{
      this.save.creatE(save, stats);
    }
    
    public void DeleteSave(Model_Save save) throws SQLException{
    }

    /**
     * @return the save
     */
    public Model_SaveDAO getSave() {
        return save;
    }

    /**
     * @param save the save to set
     */
    public void setSave(Model_SaveDAO save) {
        this.save = save;
    }
    
}
