/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.commande.entete;

import Elementary.*;
import static Elementary.Connexion.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class ImplementeEntete implements IEnteteCommande {

    private volatile static ImplementeEntete implementeEntete;
    PreparedStatement preparestatement;

    @Override
    public void Enregistrer(EnteteCommendeDao commande) {
        try {
            preparestatement = isConnected().prepareCall("{Call sp_commande (?,?,?)}");
            preparestatement.setString(1, commande.getCode_());
            preparestatement.setString(2, commande.getNomClient());
            preparestatement.setString(3, commande.getStatus());
            preparestatement.executeUpdate();
            isConnected().commit();
        } catch (SQLException ex) {
            Logger.getLogger(ImplementeEntete.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                isConnected().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ImplementeEntete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<EnteteCommendeDao> commande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ImplementeEntete Instance() {
        if (implementeEntete == null) {
            synchronized (ImplementeEntete.class) {
                if (implementeEntete == null) {
                    implementeEntete = new ImplementeEntete();
                }
            }
        }
        return implementeEntete;
    }

}
