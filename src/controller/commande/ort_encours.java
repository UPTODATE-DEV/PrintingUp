/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.View_gui.getIns;
import static Elementary.references.LOAD_PRINT_LISTDETTE;
import static Elementary.references.OTHEINFO;
import com.jfoenix.controls.JFXDialog;
import static controller.commande.CommandeController.vb_commande1;
import static controller.commande.ort_traitement_encours.vbx_;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lib.testCommande.Dao;
import lib.testCommande.ImplemanteITestCommande;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class ort_encours implements Initializable {

    @FXML
    private Label Tfd_nom;
    @FXML
    private Label lbldateFin;
    @FXML
    private Label Tfddate;
    @FXML
    private Button btn_livre;
    @FXML
    private Label Tfd_id;
    Dao dao;
    @FXML
    private AnchorPane voir_plus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventDetail();
        initFild();
    }
    String str;

    void initFild() {
        livrecommande();
        str = getIns().list.get(getInstanceL().code);
        Tfd_id.setText(str.substring(0, str.indexOf("|")));
        Tfd_nom.setText(str.substring(str.indexOf("|") + 1, str.indexOf("^")));
        Tfddate.setText(str.substring(str.indexOf("^") + 1, str.indexOf("%")));
        lbldateFin.setText(str.substring(str.indexOf("%") + 1, str.indexOf("&")));

    }

    void livrecommande() {
        btn_livre.setOnMouseClicked((e) -> {

            try {
                if (!Tfd_nom.getText().isEmpty()) {
                    dao = new Dao(Tfd_id.getText(), "Fin");
                    if (!Tfd_id.getText().equals("0")) {
                        // if()
                        ImplemanteITestCommande.Instance().save(dao);
                        init();
                    }
//                    Mywindows.isSaved("ps_livrecommande", "PROCEDURE", Tfd_nom);
                }
            } catch (Exception ex) {
                Logger.getLogger(Orther_v_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    void init() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "select * from new_test_encours where statis='Encours'"), LOAD_PRINT_LISTDETTE, 4);
            } catch (IOException ex) {
                Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void eventDetail() {
        voir_plus.setOnMouseClicked((e) -> {
            try {
                Other_commandeController.lab = Tfd_id;
                Mywindows.showFormDialog(getClass().getResource(OTHEINFO), JFXDialog.DialogTransition.CENTER, 264, 525);
            } catch (IOException ex) {
                Logger.getLogger(PrintCommandeAllController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
