/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.jsimforest.model.Model_SaveDAO;
import fr.jsimforest.model.Model_Save;
import fr.jsimforest.model.DAO;
import fr.jsimforest.model.Model_Singleton;
import fr.jsimforest.tools.Utils;
/**
 *
 * @author raff
 */
public class Controller_Save {
    private DAO<Model_Save> connectSaveDAO;
    private ArrayList<Model_Save> saves;
    
    public Controller_Save(){
        this.connectSaveDAO = new Model_SaveDAO(Model_Singleton.connectToDB());
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
        System.out.println(len);
        int i=0;
        Model_Save Saves;
        while(++i <len +1){
           if((Saves=this.connectSaveDAO.find(i))!=null){
               this.saves.add(Saves);
           }
        }
    }
    
}
