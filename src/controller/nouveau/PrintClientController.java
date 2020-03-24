/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import static Elementary.Connexion.stm;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.View_gui.getIns;
import static Elementary.references.ADDCLIENT;
import static Elementary.references.PRINT_CLIENT;
import com.jfoenix.controls.JFXDialog;
import static controller.nouveau.AddclientController.client;
import static controller.nouveau.NouveauController.vbx1;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lib.client.ClientDao;
import static lib.client.ImplemanteClient.Instance;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class PrintClientController implements Initializable {

    @FXML
    private Label lbl_prenom;
    @FXML
    private Label lbl_mail;
    @FXML
    private Label lbl_adrss;
    private String str;
    @FXML
    private Label lbl_tel;
    @FXML
    private Label Lfb_position;
    @FXML
    private Label id_modifier;
    @FXML
    private MaterialDesignIconView updatebtn;
    @FXML
    private FontAwesomeIconView deletebtn;
    public static Label id_modifier1;
    private ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }

    void init() {
        deleteClient();
        str = View_gui.getIns().list.get(Mywindows.getInstanceL().code);
        id_modifier.setText(str.substring(0, str.indexOf("#")));
        lbl_prenom.setText(str.substring(str.indexOf("#") + 1, str.indexOf("^")));
        lbl_tel.setText(str.substring(str.indexOf("^") + 1, str.indexOf("*")));
        lbl_mail.setText(str.substring(str.indexOf("*") + 1, str.indexOf("&&")));
        lbl_adrss.setText(str.substring(str.indexOf("&&") + 2));
        Lfb_position.setText(str.substring(str.indexOf("#") + 1, str.indexOf("^")).substring(0, 1));

    }

    void deleteClient() {
        deletebtn.setOnMouseClicked((e) -> {
            id_modifier1 = id_modifier;
            int x = Integer.parseInt(id_modifier1.getText());
            client = new ClientDao("", "", "", "", "", "", "3", Integer.toString(x));
            if (!getInstanceL().isFieldsempty(id_modifier1) == false) {
                Instance().Enregistrer(client);
                try {
                    getInstanceL().ScrollwithHBX(vbx1, getIns().getService(2, "SELECT * FROM tbl_client"), PRINT_CLIENT, 4);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(PrintClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        // id, nom, prenom, sexe, tel, mail, adress
        updatebtn.setOnMouseClicked((e) -> {
            id_modifier1 = id_modifier;
            try {
                rs = stm.executeQuery("SELECT * FROM tbl_client WHERE id='" + Integer.parseInt(id_modifier1.getText()) + "'");
                if (rs.next()) {
                    Mywindows.showFormDialog(getClass().getResource(ADDCLIENT), JFXDialog.DialogTransition.CENTER, 391, 554);
                    AddclientController.sexe_lbl1.setText(rs.getString("sexe"));
                    AddclientController.nomTfd1.setText(rs.getString("nom"));
                    AddclientController.prenomTfd1.setText(rs.getString("prenom"));
                    AddclientController.mailTfd1.setText(rs.getString("mail"));
                    AddclientController.teleTfd1.setText(rs.getString("tel"));
                    AddclientController.adresstfd1.setText(rs.getString("adress"));
                    AddclientController.Btn_save1.setText("Modifier");
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(PrintClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
