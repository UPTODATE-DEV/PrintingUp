/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.client;

import Elementary.Connexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class ImpletantionPaiement implements IPaiement {

    PreparedStatement pst;
    private volatile static ImpletantionPaiement _instance;

    @Override
    public void save(Dao_paiement paiement) {
        try {
            pst = Connexion.isConnected().prepareCall("{Call sp_paiement (?,?,?)}");
            pst.setDouble(1, paiement.getMontant()); 
            pst.setString(2, paiement.getId());
            pst.setString(3, paiement.getStatis());
            pst.executeUpdate();
            Connexion.isConnected().commit();

        } catch (SQLException ex) {
            Logger.getLogger(ImpletantionPaiement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Connexion.isConnected().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ImpletantionPaiement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ImpletantionPaiement getInstance() {
        if (_instance == null) {
            synchronized (ImpletantionPaiement.class) {
                if (_instance == null) {
                    _instance = new ImpletantionPaiement();
                }
            }
        }
        return _instance;
    }

}
