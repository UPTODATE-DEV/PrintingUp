/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import Elementary.Connexion;
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
public class ImplementeService implements IService {

    PreparedStatement pst;
    ResultSet rs;

    @Override
    public boolean Enregistrer(ServiceDao service) {
        try {
            pst = Connexion.isConnected().prepareCall("{Call sp_service (?,?,?,?,?)}");
            pst.setString(1, service.getCode_());
            pst.setString(2, service.getDesignation().toUpperCase());
            pst.setDouble(3, service.getPu_());
            pst.setString(4, service.getType_o().toUpperCase());
            pst.setString(5, service.getStatus());
            pst.executeUpdate();
            Connexion.isConnected().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImplementeService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Connexion.isConnected().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ImplementeService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public List<ServiceDao> service() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
