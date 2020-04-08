/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.user;

import lib.utilisateur.UtilisateurDao;

/**
 *
 * @author Akim
 */
public class UserDao extends UtilisateurDao {

    private String username;
    private String passwor;
    private String level_;

    public UserDao(String username, String passwor, String level_, String nom_, String tel_, String mail_) {
        super(nom_, tel_, mail_);
        this.username = username;
        this.passwor = passwor;
        this.level_ = level_;
    }

    public UserDao() {
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passwor
     */
    public String getPasswor() {
        return passwor;
    }

    /**
     * @param passwor the passwor to set
     */
    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    /**
     * @return the level_
     */
    public String getLevel_() {
        return level_;
    }

    /**
     * @param level_ the level_ to set
     */
    public void setLevel_(String level_) {
        this.level_ = level_;
    }

}
