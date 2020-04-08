/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.utilisateur;

import static Elementary.Connexion.isConnected;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class ImplementUtilisateurDao implements IUtilisateur {

    PreparedStatement pst;
    ResultSet rs;

    @Override
    public void Ajouter(UtilisateurDao utilisateur) {
        try {
            pst = isConnected().prepareCall("call sp_utilisateur (?,?,?,?,?,?)");
            pst.setString(1, utilisateur.getNom_());
            pst.setString(2, utilisateur.getSexe_());
            pst.setString(3, utilisateur.getTel_());
            pst.setString(4, utilisateur.getMail_());
            pst.setString(5, utilisateur.getFonction_());
            pst.setString(6, utilisateur.getStat_());
            pst.executeUpdate();
            isConnected().commit();
        } catch (SQLException ex) {
            Logger.getLogger(ImplementUtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                isConnected().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ImplementUtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
