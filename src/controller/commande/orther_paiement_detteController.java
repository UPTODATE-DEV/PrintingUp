/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.references.PRINT_DETTE;
import static Elementary.references.PRINT_PAIEMENT_DETTE;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class orther_paiement_detteController implements Initializable {

    @FXML
    private VBox vbox_verifierdette;

    public static VBox vbox_verifierdette1;
    @FXML
    private TextField Tfd_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vbox_verifierdette1 = vbox_verifierdette;
        init();
    }

    void init() {
        search();
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

    void search() {
        Tfd_search.setOnKeyReleased((e) -> {
            try {
                try {
                    getInstanceL().ScrollwithHBX(vbox_verifierdette1, View_gui.getIns().getService(5, "SELECT * FROM client_dette WHERE id like '%" + Tfd_search.getText() + "%' OR nom like '%" + Tfd_search.getText() + "%'"), PRINT_PAIEMENT_DETTE, 2);
                } catch (IOException ex) {
                    Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Orther_verifier_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }
}
