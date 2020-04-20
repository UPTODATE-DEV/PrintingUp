/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.entreprise_;

/**
 *
 * @author Akim
 */
public class FEntreprise {
      private String id, nom, rccm, adress_physique, adress_mail, num, logos;
//insert into monEntreprise(id,nom,rccm,adress_physique,adress_mail,num,logos) 
//	values
//(id,nom,rccm,adress_physique,adress_mail,num,logos);

    public FEntreprise() {
    }

    public FEntreprise(String id, String nom, String rccm, String adress_physique, String adress_mail, String num, String logos) {
        this.id = id;
        this.nom = nom;
        this.rccm = rccm;
        this.adress_physique = adress_physique;
        this.adress_mail = adress_mail;
        this.num = num;
        this.logos = logos;
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the rccm
     */
    public String getRccm() {
        return rccm;
    }

    /**
     * @param rccm the rccm to set
     */
    public void setRccm(String rccm) {
        this.rccm = rccm;
    }

    /**
     * @return the adress_physique
     */
    public String getAdress_physique() {
        return adress_physique;
    }

    /**
     * @param adress_physique the adress_physique to set
     */
    public void setAdress_physique(String adress_physique) {
        this.adress_physique = adress_physique;
    }

    /**
     * @return the adress_mail
     */
    public String getAdress_mail() {
        return adress_mail;
    }

    /**
     * @param adress_mail the adress_mail to set
     */
    public void setAdress_mail(String adress_mail) {
        this.adress_mail = adress_mail;
    }

    /**
     * @return the num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * @return the logos
     */
    public String getLogos() {
        return logos;
    }

    /**
     * @param logos the logos to set
     */
    public void setLogos(String logos) {
        this.logos = logos;
    }

}
