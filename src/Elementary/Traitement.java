/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Akim
 */
public class Traitement extends Connexion {

    public PreparedStatement ps;

    public boolean getprepare(String query) throws SQLException {
        ps = Connexion.isConnected().prepareCall(query);
        int x = ps.executeUpdate();
        isConnected().commit();
        if (x == 1) {
            return true;
        }
        return false;

    }
    private volatile static Traitement traite;

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
            synchronized (Traitement.class) {
                if (traite == null) {
                    traite = new Traitement();
                }
            }
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

    public void chargeOnList(ListView<String> List_view, String tb) {
        List_view.getItems().clear();
        try {
            rst = stm.executeQuery(tb);
            while (rst.next()) {
                List_view.getItems().addAll(rst.getString("x"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Traitement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getValue(String query) {
        try {
            rst = stm.executeQuery(query);
            if (rst.next()) {
                return rst.getString("x");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Traitement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void noSymbols(final TextField field, String exceptions) {
        ChangeListener listener = (ChangeListener<Number>) (observable, oldValue, newValue) -> {
            if (field.getText() != null) {
                if (field.getText().length() > 0) {
                    String value = field.getText();
                    value = value.replaceAll("[^a-zA-Z0-9 " + exceptions + "]", "");
                    field.setText(value);
                }
            }
        };
        field.lengthProperty().addListener(listener);
    }

    public static boolean isEmail(TextField field) { // KeyPressed
        boolean is = false;
        if (!field.getText().isEmpty()) {
            if (field.getText().contains("@") && field.getText().contains(".") && !field.getText().contains(" ")) {

                String user = field.getText().substring(0, field.getText().lastIndexOf('@'));
                String domain = field.getText().substring(field.getText().lastIndexOf('@') + 1, field.getText().length());
                String subdomain = field.getText().substring(field.getText().indexOf(".") + 1, field.getText().length());

                if ((user.length() >= 1) && (!user.contains("@"))
                        && (domain.contains(".")) && (!domain.contains("@"))
                        && (domain.indexOf(".") >= 1)
                        && (domain.lastIndexOf(".") < domain.length() - 1)
                        && subdomain.length() >= 2) {
                    is = true;
                }
            }
        }
        return is;
    }
}
