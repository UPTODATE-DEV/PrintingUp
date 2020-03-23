/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Akim
 */
public class Preparedsta {

    private static PreparedStatement ps;

    public Preparedsta() throws SQLException {
        ps.executeUpdate();
    }

    public static PreparedStatement Prepare() throws SQLException {
        if (ps == null) {
            new Preparedsta();
        }
        return ps;
    }
    
   
    

}
