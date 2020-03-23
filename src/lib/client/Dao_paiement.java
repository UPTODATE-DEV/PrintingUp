/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.client;

/**
 *
 * @author Akim
 */
public class Dao_paiement {

    private String id;
    private double montant;
    private String statis;

    public Dao_paiement(String id, double montant, String statis) {
        this.id = id;
        this.montant = montant;
        this.statis = statis;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * @return the statis
     */
    public String getStatis() {
        return statis;
    }

    /**
     * @param statis the statis to set
     */
    public void setStatis(String statis) {
        this.statis = statis;
    }
    
    

}
