/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import Elementary.Traitement;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
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
public class Other_paiementController implements Initializable {

    @FXML
    private TextField Tfd_montant;
    @FXML
    private JFXButton btn_paiement;
    private int getId;
    public static Label getId1;
    @FXML
    private Label alert_paiement;
    @FXML
    private Text massage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        paiement();

    }

    void paiement() {
        testCaract();
        btn_paiement.setOnMouseClicked((value) -> {
            try {
                if (Tfd_montant.getText().equals("0.0") || Tfd_montant.getText().isEmpty() || Double.parseDouble(Tfd_montant.getText()) <= 0.0) {
                    Mywindows.OuputText(massage, "Paiement échoue", alert_paiement, true);
                } else {
                    if (Mywindows.isSaved("sp_paiement", "PROCEDURE", Tfd_montant, getId().getText(), "1") == true) {
                        Mywindows.OuputText(massage, "Paiement réussi ", alert_paiement, false);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Other_paiementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    void testCaract() {
        Tfd_montant.setOnKeyReleased((value) -> {
            Traitement.getInstanceT().isNumerique(Tfd_montant);
        });

    }

    private Label getId() {
        return getId1;
    }

    public void setId(Label id) {
        this.getId1 = id;
    }
    static Other_paiementController getOther;

    public static Other_paiementController getOther() {
        if (getOther == null) {
            getOther = new Other_paiementController();
        }
        return getOther;
    }

}
