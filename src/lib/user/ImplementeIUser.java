/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.user;

import Elementary.Connexion;
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

}
