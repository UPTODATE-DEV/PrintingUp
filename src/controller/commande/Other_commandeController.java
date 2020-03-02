/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.references.LOAD_DETAIL;
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
public class Other_commandeController implements Initializable {

    @FXML
    private VBox vb_detail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    String str = "SELECT codecmd,service,type_,Punitaire,qte FROM vs_facture";

    void initData() {
        try {
            Mywindows.getInstanceL().ScrollwithHBX(vb_detail, View_gui.getIns().getService(6, str), LOAD_DETAIL, 1);
        } catch (IOException ex) {
            Logger.getLogger(AddcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Other_commandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
