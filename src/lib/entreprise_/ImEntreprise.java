/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.entreprise_;

import Elementary.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class ImEntreprise implements IEntreprise {
    
    PreparedStatement ps;
    ResultSet rst;
    
    @Override
    public boolean save(FEntreprise entreprise) {
        try {
            ps = Connexion.isConnected().prepareStatement("");
            ps.setString(1, entreprise.getId());
            ps.setString(2, entreprise.getNom());
            ps.setString(3, entreprise.getRccm());
            ps.setString(4, entreprise.getAdress_physique());
            ps.setString(5, entreprise.getAdress_mail());
            ps.setString(6, entreprise.getNum());
            ps.setString(7, entreprise.getLogos());
            int x = ps.executeUpdate();
            return x == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ImEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean update(FEntreprise entreprise) {
        try {
            ps = Connexion.isConnected().prepareStatement("");
            ps.setString(1, entreprise.getId());
            ps.setString(2, entreprise.getNom());
            ps.setString(3, entreprise.getRccm());
            ps.setString(4, entreprise.getAdress_physique());
            ps.setString(5, entreprise.getAdress_mail());
            ps.setString(6, entreprise.getNum());
            ps.setString(7, entreprise.getLogos());
            int x = ps.executeUpdate();
            return x == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ImEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean delete(FEntreprise entreprise) {
        try {
            ps = Connexion.isConnected().prepareStatement("");
            ps.setString(1, entreprise.getId());
            int x = ps.executeUpdate();
            return x == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ImEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public ArrayList<String> FetchLoading() {
        ArrayList<String> list = new ArrayList<>();
        try {
            rst = Connexion.stm.executeQuery("");
            while (rst.next()) {
                list.add(rst.getString(1) + "<>" + rst.getString(2) + "&&" + rst.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
