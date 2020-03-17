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
public class ClientDao {

    //INSERT INTO `tbl_client`(`id`, `nom`, `prenom`, `sexe`, `tel`, `mail`, `adress`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7])
    private String nom;
    private String prenom;
    private String sexe;
    private String tel;
    private String mail;
    private String adress;
    private String statis;
    private String code_;

    public ClientDao(String nom, String prenom, String sexe, String tel, String mail, String adress, String statis, String code_) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.tel = tel;
        this.mail = mail;
        this.adress = adress;
        this.statis = statis;
        this.code_ = code_;
    }

    public String getStatis() {
        return statis;
    }

    public void setStatis(String statis) {
        this.statis = statis;
    }

    public String getCode_() {
        return code_;
    }

    public void setCode_(String code_) {
        this.code_ = code_;
    }


    public ClientDao() {
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

}
