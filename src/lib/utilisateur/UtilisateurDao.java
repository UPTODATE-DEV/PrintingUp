/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.utilisateur;

/**
 *
 * @author Akim
 */
public class UtilisateurDao {

    private String nom_;
    private String sexe_;
    private String tel_;
    private String mail_;
    private String fonction_;
    private String stat_;

    public UtilisateurDao(String nom_, String sexe_, String tel_, String mail_, String fonction_, String stat_) {
        this.nom_ = nom_;
        this.sexe_ = sexe_;
        this.tel_ = tel_;
        this.mail_ = mail_;
        this.fonction_ = fonction_;
        this.stat_ = stat_;
    }

    public UtilisateurDao(String nom_, String tel_, String mail_) {
        this.nom_ = nom_;
        this.tel_ = tel_;
        this.mail_ = mail_;

    }

    public UtilisateurDao() {
    }

    /**
     * @return the nom_
     */
    public String getNom_() {
        return nom_;
    }

    /**
     * @param nom_ the nom_ to set
     */
    public void setNom_(String nom_) {
        this.nom_ = nom_;
    }

    /**
     * @return the sexe_
     */
    public String getSexe_() {
        return sexe_;
    }

    /**
     * @param sexe_ the sexe_ to set
     */
    public void setSexe_(String sexe_) {
        this.sexe_ = sexe_;
    }

    /**
     * @return the tel_
     */
    public String getTel_() {
        return tel_;
    }

    /**
     * @param tel_ the tel_ to set
     */
    public void setTel_(String tel_) {
        this.tel_ = tel_;
    }

    /**
     * @return the mail_
     */
    public String getMail_() {
        return mail_;
    }

    /**
     * @param mail_ the mail_ to set
     */
    public void setMail_(String mail_) {
        this.mail_ = mail_;
    }

    /**
     * @return the fonction_
     */
    public String getFonction_() {
        return fonction_;
    }

    /**
     * @param fonction_ the fonction_ to set
     */
    public void setFonction_(String fonction_) {
        this.fonction_ = fonction_;
    }

    /**
     * @return the stat_
     */
    public String getStat_() {
        return stat_;
    }

    /**
     * @param stat_ the stat_ to set
     */
    public void setStat_(String stat_) {
        this.stat_ = stat_;
    }

    public int length() {
        return mail_.length();
    }

    public int compareTo(String anotherString) {
        return mail_.compareTo(anotherString);
    }

    static UtilisateurDao _instance;

    public static UtilisateurDao getUtilisateur() {
        if (_instance == null) {
            _instance = new UtilisateurDao();
        }
        return _instance;
    }
}
