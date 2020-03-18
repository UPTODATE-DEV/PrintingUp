/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    public static Statement stm;

    public Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, usename, password);
            if (stm == null) {
                stm = cnx.createStatement();
            }
            cnx.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection isConnected() {
        if (cnx == null) {
            new Connexion();

        }
        System.out.println("Connexion disponible déjà  ");
        return cnx;

    }

}
