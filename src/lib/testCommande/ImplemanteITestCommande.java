/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.testCommande;

import Elementary.Connexion;
import static Elementary.Connexion.isConnected;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class ImplemanteITestCommande implements ITestCommande {
    
    PreparedStatement pst;
    private volatile static ImplemanteITestCommande _instance;
    
    @Override
    public void save(Dao test) {
        try {
            pst = isConnected().prepareCall("{Call new_exeCommende(?,?)}");
            pst.setString(1, test.getCommande());
            pst.setString(2, test.getStatis_());
            int x = pst.executeUpdate();
            isConnected().commit();
            System.out.println(Integer.toString(x));
        } catch (SQLException ex) {
            Logger.getLogger(ImplemanteITestCommande.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                isConnected().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ImplemanteITestCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ImplemanteITestCommande Instance() {
        if (_instance == null) {
            synchronized (ImplemanteITestCommande.class) {
                if (_instance == null) {
                    _instance = new ImplemanteITestCommande();
                }
            }
        }
        return _instance;
    }
    
}
