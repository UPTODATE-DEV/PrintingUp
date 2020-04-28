/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.OuputText;
import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.references.OTHEINFO;
import static Elementary.references.PRINT_PAIEMENT_DETTE;
import com.jfoenix.controls.JFXDialog;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lib.client.Dao_paiement;
import static lib.client.ImpletantionPaiement.getInstance;

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
    private Button btn_valider;
    @FXML
    private TextField Tfd_montant;
    @FXML
    private Text massage;
    @FXML
    private Label alert_paiement;
    private Dao_paiement dao;
    @FXML
    private AnchorPane voir_plus;

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
                        || Double.parseDouble(Tfd_montant.getText()) <= 0.0) {
                    OuputText(massage, "", alert_paiement, true);
                } else {
                    if (Double.parseDouble(Tfd_montant.getText()) <= Double.parseDouble(Tfd_montant_a_paye.getText())) {
                        dao = new Dao_paiement(Tfd_id.getText(), Double.parseDouble(Tfd_montant.getText()), "1");
                        getInstance().save(dao);
                        Tfd_montant.setText("0.0");
                        init1();
                    } else {
                        OuputText(massage, "", alert_paiement, true);
                    }

                }
            } catch (NumberFormatException ex) {
                Logger.getLogger(Other_paiementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    void init1() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(5, "SELECT * FROM client_dette"), PRINT_PAIEMENT_DETTE, 4);
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
