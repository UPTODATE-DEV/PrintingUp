/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.references.PRINT_PAIEMENT_DETTE;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class orther_paiement_detteController implements Initializable {

    @FXML
    private VBox vbox_verifierdette;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void init() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vbox_verifierdette, View_gui.getIns().getService(4, "SELECT * FROM new_valider_commande"), PRINT_PAIEMENT_DETTE, 2);
            } catch (IOException ex) {
                Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
