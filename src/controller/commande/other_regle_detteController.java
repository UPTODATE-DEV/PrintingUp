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
import static Elementary.references.PRINT_PAIEMENT_DETTE;
import static controller.commande.orther_paiement_detteController.vbox_verifierdette1;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class other_regle_detteController implements Initializable {

    @FXML
    private Label Tfd_nom;
    @FXML
    private Label Tfddate;
    @FXML
    private Label Tfd_montant_a_paye;
    @FXML
    private Label Tfd_id;
    @FXML
    private MaterialDesignIconView btn_valider;
    @FXML
    private TextField Tfd_montant;
    @FXML
    private Text massage;
    @FXML
    private Label alert_paiement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
        initValider();
    }
    String str;

    void init() {
        str = View_gui.getIns().list.get(getInstanceL().code);
        Tfd_id.setText(str.substring(0, str.indexOf("&")));
        Tfddate.setText(str.substring(str.indexOf("&") + 1, str.indexOf("^")));
        Tfd_nom.setText(str.substring(str.indexOf("^") + 1, str.indexOf("#")));
        Tfd_montant_a_paye.setText(str.substring(str.indexOf("#") + 1));
    }

    void initValider() {
        btn_valider.setOnMouseClicked((e) -> {
            try {
                if (Tfd_montant.getText().equals("0.0")
                        || Tfd_montant.getText().isEmpty()
                        || Double.parseDouble(Tfd_montant.getText()) <= 0.0
                        || (Double.parseDouble(Tfd_montant.getText()) > Double.parseDouble(Tfddate.getText()))) {
                    Mywindows.OuputText(massage, "", alert_paiement, true);

                } else {
                    if (Mywindows.isSaved("sp_paiement", "PROCEDURE", Tfd_montant, Tfd_id, "1") == true) {
                        Mywindows.OuputText(massage, "", alert_paiement, false);
                        Tfd_montant.setText("0.0");
                        init1();

                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Other_paiementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    void init1() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vbox_verifierdette1, View_gui.getIns().getService(5, "SELECT * FROM client_dette"), PRINT_PAIEMENT_DETTE, 2);
            } catch (IOException ex) {
                Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
