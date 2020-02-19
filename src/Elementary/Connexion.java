/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class Connexion {

    private static Connection cnx;
    private String url = "jdbc:mysql://localhost:3306/printing_up";
    private String usename = "root";
    private String password = "root";

    public Connexion() {
        try {
            cnx = DriverManager.getConnection(url, usename, password);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection isConnected() {
        int x = 0;
        if (cnx == null) {
            new Connexion();
            x++;
            System.out.println("Connexion initialiser !!!  " + x);
        }
        x++;
        System.out.println("Connexion disponible déjà  " + x);
        return cnx;

    }

}
