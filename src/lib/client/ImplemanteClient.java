/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.client;

import static Elementary.Connexion.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class ImplemanteClient implements IClient {

    PreparedStatement pst;
    ResultSet rs;
    static ImplemanteClient instance_;
    // IN `code_` INT, IN `nom_` VARCHAR(50), IN `prenom_` VARCHAR(50), IN `sexe_` VARCHAR(10), IN `tel_` VARCHAR(15), IN `status_` INT, IN `email_` VARCHAR(255), IN `adress_` VARCHAR(255)

    @Override
    public void Enregistrer(ClientDao client) {
        try {
            pst = isConnected().prepareCall("{Call sp_client (?,?,?,?,?,?,?,?)}");
            pst.setString(1, client.getCode_());
            pst.setString(2, client.getNom().toUpperCase());
            pst.setString(3, client.getPrenom().toUpperCase());
            pst.setString(4, client.getSexe().toUpperCase());
            pst.setString(5, client.getTel());
            pst.setString(6, client.getStatis());
            pst.setString(7, client.getMail().toLowerCase());
            pst.setString(8, client.getAdress().toUpperCase());
            int x = pst.executeUpdate();
            System.out.println(Integer.toString(x));
            if (x == 1) {
                isConnected().commit();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplemanteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Object> client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ImplemanteClient Instance() {
        if (instance_ == null) {
            instance_ = new ImplemanteClient();
        }
        return instance_;
    }

}
