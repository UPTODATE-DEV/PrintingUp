/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Akim
 */
public class Traitement extends Connexion {

    public PreparedStatement ps;
    public static final int status = 0;

    public boolean getprepare(String query) throws SQLException {
        ps = Connexion.isConnected().prepareCall(query);
        int x = ps.executeUpdate();
        isConnected().commit();
        if (x == 1) {
            return true;
        }
        return false;

    }

    public static String pwd_crypte_md5(String password) {
        byte[] uniquekey = password.getBytes();
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(uniquekey);
        } catch (NoSuchAlgorithmException e) {
        }
        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.charAt(hex.length() - 2));
            }
        }
        return hashString.toString();

    }
    private volatile static Traitement traite;

    public boolean isNumerique(TextField text) {
        try {
            if (text.getText().contains("D") || text.getText().contains("d")) {
                text.setText(null);
            }
            double c = Double.parseDouble(text.getText());
        } catch (NumberFormatException e) {
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

    public static String dateB(DatePicker c) {
        String j, a, m;
        String date1;
        j = c.getEditor().getText().substring(0, 2);
        m = c.getEditor().getText().substring(3, 5);
        a = c.getEditor().getText().substring(6, 10);
        date1 = a + "-" + m + "-" + j;
        return date1;
    }

    public static String convertDate(String c) {
        String j, a, m;
        String date1;
        j = c.substring(0, 2);
        m = c.substring(3, 5);
        a = c.substring(6, 10);
        date1 = a + "-" + m + "-" + j;
        return date1;
    }

    public static void alerteAvertissement(String titre, String message) {

        Notifications notificationAvertissement;
        notificationAvertissement = Notifications.create()
                .title(titre)
                .text("\n                                 " + message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT)
                .onAction((ActionEvent event) -> {
                });
        notificationAvertissement.showWarning();
    }

    public void Ecart(DatePicker d1, DatePicker d2) {
        final Callback<DatePicker, DateCell> dayCellFactory
                = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(
                                d1.getValue().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        d2.setDayCellFactory(dayCellFactory);
    }

    static String genre;
    static MaterialDesignIconView designIcon;

    /**
     * Fonctions & Methodes
     *
     * @param str2
     * @param lab
     * @return
     * @throws java.lang.Exception
     */
    //#1
    public static String getDifGenre(String str2, Label lab) throws Exception {

        if ("Féminin".equals(str2)) {

            designIcon = new MaterialDesignIconView(MaterialDesignIcon.HUMAN_MALE);
            designIcon.setGlyphSize(20);
            designIcon.setStyle("-fx-fill:#1875F0");
            genre = "Masculin";
        } else {
            designIcon = new MaterialDesignIconView(MaterialDesignIcon.HUMAN_FEMALE);
            designIcon.setGlyphSize(20);
            designIcon.setStyle("-fx-fill:#1875F0");
            genre = "Féminin";
        }

        lab.setGraphic(designIcon);

        return genre;
    }
}
