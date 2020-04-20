/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.user;

import Elementary.Connexion;
import Elementary.View_gui;
import static controllers.PrincipaleController.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListView;

/**
 *
 * @author Akim
 */
public class ImplementeIUser implements IUser {

    PreparedStatement pst;
    ResultSet rst;

    @Override
    public void ajouter(UserDao user) {
        try {
            pst = Connexion.isConnected().prepareCall("Call sp_user_system (?,?,?,?,?,?)");
            pst.setString(1, user.getNom_());
            pst.setString(2, user.getMail_());
            pst.setString(3, user.getTel_());
            pst.setString(4, user.getUsername());
            pst.setString(5, user.getPasswor());
            pst.setString(6, user.getLevel_());
            pst.executeUpdate();
            Connexion.isConnected().commit();
        } catch (SQLException ex) {
            Logger.getLogger(ImplementeIUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(UserDao user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void retire(UserDao user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListView<UserDao> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean connexion(UserDao user) {
        try {
            pst = Connexion.isConnected().prepareStatement("SELECT * FROM `tbl_user_` INNER JOIN tbl_utilisateur ON\n"
                    + "tbl_user_.idUtilisateur=tbl_utilisateur.id WHERE user_name=? AND password_=?");
            pst.setString(1, user.getUsername()); pst.setString(2, user.getPasswor());
            rst = pst.executeQuery();
            if (rst.next()) {
                TestConnexion(user);
                nom_agent = View_gui.getIns().capitalize(rst.getString("nom"));
                id_conne = View_gui.getIns().capitalize(rst.getString("fonction"));

                return true;

            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplementeIUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    boolean TestConnexion(UserDao user) throws SQLException {
        pst = Connexion.isConnected().prepareCall("Call sp_heure_connection (?,?)");
        pst.setString(1, user.getUsername());
        pst.setInt(2, 0);
        pst.executeUpdate();
        return true;
    }

}
