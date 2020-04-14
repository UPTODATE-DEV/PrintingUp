/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChargementControllers;

import static Elementary.Connexion.*;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.Traitement;
import static Elementary.View_gui.getIns;
import static Elementary.references.LOAD_USER;
import static c_addForms.UpdateuserController.*;
import com.jfoenix.controls.JFXDialog;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lib.utilisateur.UtilisateurDao;
import static lib.utilisateur.UtilisateurDao.getUtilisateur;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class LoadUsersController implements Initializable {

    @FXML
    private Label txtFonction;
    @FXML
    private Label txtTel;
    @FXML
    private Label txtSexe;
    @FXML
    private Label nom;
    @FXML
    private Label niveau;
    @FXML
    private MaterialDesignIconView btn_update;
    @FXML
    private FontAwesomeIconView btn_delete;
    @FXML
    private Label mail;
    @FXML
    private Label id;
    private Label id_u;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initFild();
        evenement();

    }

    String str;

    void initFild() {
        str = getIns().list.get(getInstanceL().code);
        id.setText(str.substring(0, str.indexOf("#>")));
        nom.setText(str.substring(str.indexOf("#>") + 2, str.indexOf("<#")));
        txtSexe.setText(str.substring(str.indexOf("<#") + 2, str.indexOf("<&")));
        txtTel.setText(str.substring(str.indexOf("<&") + 2, str.indexOf("&>")));
        mail.setText(str.substring(str.indexOf("&>") + 2, str.indexOf("<$")));
        txtFonction.setText(str.substring(str.indexOf("<$") + 2, str.indexOf("$>")));
        niveau.setText(str.substring(str.indexOf("$>") + 2));
    }

    void evenement() {
        btn_update.setOnMouseClicked((e) -> {
            id_u = id;
            niveau_ = this.niveau.getText();
            System.out.println(id_u.getText());
            try {
                rst = stm.executeQuery(" SELECT * FROM vs_utilisateur WHERE id='" + id_u.getText() + "'");
                if (rst.next()) {
                    Mywindows.showFormDialog(getClass().getResource(LOAD_USER), JFXDialog.DialogTransition.CENTER, 529, 660);
                    txtnoms_.setText(rst.getString("nom"));
                    mail_.setText(rst.getString("mail"));
                    txttelephone_.setText(rst.getString("tel"));
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(LoadUsersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
