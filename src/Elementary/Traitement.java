/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import static Elementary.Mywindows.mat;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author Akim
 */
public class Traitement extends Query {

    public PreparedStatement ps;
    public ResultSet rs;
    public Statement stm;

    public Traitement() {
        try {
            if (stm == null) {
                stm = Connexion.isConnected().createStatement();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Traitement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Traitement traite;

    public boolean isNumerique(TextField text) {
        try {
            if (text.getText().contains("D") || text.getText().contains("d")) {
                text.setText(null);
            }
            double c = Double.parseDouble(text.getText());
        } catch (Exception e) {
            text.setText(null);
        }
        return false;

    }

    public static Traitement getInstanceT() {
        if (traite == null) {
            traite = new Traitement();
        }
        return traite;
    }
    static MaterialDesignIconView font;

    public MaterialDesignIconView font(String style, MaterialDesignIcon om) {
        font = new MaterialDesignIconView(om);
        font.setGlyphSize(15);
        font.setStyle(style);
        return font;
    }

}
