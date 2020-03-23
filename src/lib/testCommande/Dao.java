/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.testCommande;

/**
 *
 * @author Akim
 */
public class Dao {

    private String commande;
    private String statis_;

    public Dao(String commande, String statis_) {
        this.commande = commande;
        this.statis_ = statis_;
    }

    public Dao() {
    }

    public String getCommande() {
        return commande;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public String getStatis_() {
        return statis_;
    }

    public void setStatis_(String statis_) {
        this.statis_ = statis_;
    }

}
