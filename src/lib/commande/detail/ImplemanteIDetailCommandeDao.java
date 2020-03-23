/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.commande.detail;

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
public class ImplemanteIDetailCommandeDao implements IDetailCommande {

    PreparedStatement preparestatement;
    private volatile static ImplemanteIDetailCommandeDao instance_;

    @Override
    public void Enregistre(DetailCommandeDao detailCommande) {
        try {
            //sp_Dcommande`(IN `code_` INT, IN `pu_` FLOAT, IN `nb_srvc_` INT, IN `codecmd_` BIGINT, IN `Service_` VARCHAR(255), IN `status_` INT, IN `type_service` VARCHAR(80))   \
            preparestatement = isConnected().prepareCall("{CALL sp_Dcommande(?,?,?,?,?,?)}");
            preparestatement.setString(1, detailCommande.getCode());
            preparestatement.setFloat(2, detailCommande.getPu());
            preparestatement.setInt(3, detailCommande.getNb_srvc());
            preparestatement.setString(4, detailCommande.getCodecmd());
            preparestatement.setString(5, detailCommande.getService());
            preparestatement.setString(6, detailCommande.getStatus());
            preparestatement.executeUpdate();
            isConnected().commit();
        } catch (SQLException ex) {
            Logger.getLogger(ImplemanteIDetailCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                isConnected().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ImplemanteIDetailCommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<DetailCommandeDao> detailCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ImplemanteIDetailCommandeDao Instance() {
        if (instance_ == null) {
            synchronized (ImplemanteIDetailCommandeDao.class) {
                if (instance_ == null) {
                    instance_ = instance_ = new ImplemanteIDetailCommandeDao();
                }
            }
        }
        return instance_;
    }

}
