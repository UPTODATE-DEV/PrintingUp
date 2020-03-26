/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Connexion;
import static Elementary.Mywindows.getInstanceL;
import Elementary.Traitement;
import static Elementary.Traitement.alerteAvertissement;
import static Elementary.Traitement.getInstanceT;
import Elementary.View_gui;
import static Elementary.View_gui.getIns;
import Elementary.references;
import static controller.commande.CommandeController.vb_commande1;
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
import lib.testCommande.Dao;
import lib.testCommande.ImplemanteITestCommande;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class orther_printDisponible implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                    if (getTest(Tfd_id.getText()) == true) {
                        dao = new Dao(Tfd_id.getText(), "Livraison");
                        if (!Tfd_id.getText().equals("0")) {
                            ImplemanteITestCommande.Instance().save(dao);
                            init();
                        }
                    } else {

                        alerteAvertissement("Attention", "Payer d'abord avant de livrai...");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Orther_v_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    void init() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours WHERE statis='Fin'"), references.LOAD_PRINT_FIN, 2);
            } catch (IOException ex) {
                Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean getTest(String code) throws SQLException {
        getInstanceL().ps = Connexion.isConnected().prepareStatement("SELECT codecmdE x FROM `view_testvalidation` WHERE (m_paiement=montant) AND (codecmdE='" + code + "')");
        Connexion.rst = getInstanceL().ps.executeQuery();
        if (Connexion.rst.next()) {
            return true;
        } else {
            return false;
        }

    }

}
