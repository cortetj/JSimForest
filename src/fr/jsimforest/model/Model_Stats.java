/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.jsimforest.model;

/**
 *
 * @author raff
 */
public class Model_Stats {
    private int id_stat;
    private int t;
    private int stat_empty;
    private int stat_youngplant;
    private int stat_youngtree;
    private int stat_tree;
    private int stat_fire;
    private int stat_ash;
    private int stat_infecte;
    private int id_save;
    
    public Model_Stats(){}
    
    public Model_Stats(int id, int t, int stat_empty, int stat_youngplant,
            int stat_youngtree,int stat_tree, int stat_fire, int stat_ash, 
            int stat_infecte, int id_save){
        this.id_stat=id;
        this.t=t;
        this.stat_empty=stat_empty;
        this.stat_youngplant=stat_youngplant;
        this.stat_youngtree=stat_youngtree;
        this.stat_tree=stat_tree;
        this.stat_fire=stat_fire;
        this.stat_ash=stat_ash;
        this.stat_infecte=stat_infecte;
        this.id_save=id_save;
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
     * @return the t
     */
    public int getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(int t) {
        this.t = t;
    }

    /**
     * @return the stat_empty
     */
    public int getStat_empty() {
        return stat_empty;
    }

    /**
     * @param stat_empty the stat_empty to set
     */
    public void setStat_empty(int stat_empty) {
        this.stat_empty = stat_empty;
    }

    /**
     * @return the stat_youngplant
     */
    public int getStat_youngplant() {
        return stat_youngplant;
    }

    /**
     * @param stat_youngplant the stat_youngplant to set
     */
    public void setStat_youngplant(int stat_youngplant) {
        this.stat_youngplant = stat_youngplant;
    }

    /**
     * @return the stat_youngtree
     */
    public int getStat_youngtree() {
        return stat_youngtree;
    }

    /**
     * @param stat_youngtree the stat_youngtree to set
     */
    public void setStat_youngtree(int stat_youngtree) {
        this.stat_youngtree = stat_youngtree;
    }

    /**
     * @return the stat_tree
     */
    public int getStat_tree() {
        return stat_tree;
    }

    /**
     * @param stat_tree the stat_tree to set
     */
    public void setStat_tree(int stat_tree) {
        this.stat_tree = stat_tree;
    }

    /**
     * @return the stat_fire
     */
    public int getStat_fire() {
        return stat_fire;
    }

    /**
     * @param stat_fire the stat_fire to set
     */
    public void setStat_fire(int stat_fire) {
        this.stat_fire = stat_fire;
    }

    /**
     * @return the stat_ash
     */
    public int getStat_ash() {
        return stat_ash;
    }

    /**
     * @param stat_ash the stat_ash to set
     */
    public void setStat_ash(int stat_ash) {
        this.stat_ash = stat_ash;
    }

    /**
     * @return the stat_infecte
     */
    public int getStat_infecte() {
        return stat_infecte;
    }

    /**
     * @param stat_infecte the stat_infecte to set
     */
    public void setStat_infecte(int stat_infecte) {
        this.stat_infecte = stat_infecte;
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
    
}
