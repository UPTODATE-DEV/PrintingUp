/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
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
public class Orher_detteController implements Initializable {

    @FXML
    private TextField tbl_client;
    @FXML
    private TextField Tfd_montnt;
    @FXML
    private Label icon;
    @FXML
    private Text message;
    @FXML
    private JFXButton btn_valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Mywindows.getInstanceL().ChargememtCompression(tbl_client, "client_dette", "nom1", null);
    }

    void init() {
        btn_valider.setOnAction((value) -> {
            try {
                if (Tfd_montnt.getText().equals("0.0") || Tfd_montnt.getText().isEmpty() || tbl_client.getText().isEmpty() || Double.parseDouble(Tfd_montnt.getText()) <= 0.0) {
                    Mywindows.OuputText(message, "Paiement échoue", icon, true);
                } else {
                    if (Mywindows.isSaved("sp_paiement", "PROCEDURE", Tfd_montnt, tbl_client, "1") == true) {
                        Mywindows.OuputText(message, "Paiement réussi ", icon, false);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Other_paiementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
