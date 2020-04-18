/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Connexion;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Traitement.getInstanceT;
import Elementary.View_gui;
import static Elementary.references.LOAD_COMMANDE;
import static Elementary.references.PRINT_CMD;
import static controller.commande.AddcommandeController.lbl_dollars1;
import static controller.commande.AddcommandeController.lbl_frac1;
import static controller.commande.AddcommandeController.vb_1;
import static controller.commande.CommandeController.vb_commande1;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class Printl_commandeController implements Initializable {

    @FXML
    private Label id_;
    @FXML
    private Label service;
    @FXML
    private Label qte_;
    @FXML
    private Label punite;
    @FXML
    private Button btn_ok;

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
        str = getInstanceL().list.get(getInstanceL().code);
        id_.setText(str.substring(0, str.indexOf("#")));
        service.setText(str.substring(str.indexOf("#") + 1, str.indexOf("|")));
        punite.setText(str.substring(str.indexOf("|") + 1, str.indexOf("'")));
        qte_.setText(str.substring(str.indexOf("'") + 1));

    }
// id_lab.setText(str.substring(0, str.indexOf("#")));
//        service.setText(str.substring( str.indexOf("#")+1, str.indexOf("|")));

    @FXML
    private void Traitement(ActionEvent event) throws Exception {
        getInstanceT().ps = Connexion.isConnected().prepareCall("Call sp_delete_service (?)");
        getInstanceT().ps.setString(1, id_.getText());
        System.err.println("##########"+id_.getText());
        getInstanceT().ps.executeUpdate();
        initData();
        AddcommandeController.initInitial(lbl_frac1, lbl_dollars1);

//        }
    }

    void initData() {
        try {
            Mywindows.getInstanceL().ScrollwithHBX(vb_1, getInstanceL().getCommande(), LOAD_COMMANDE, 1);
            getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 4);

        } catch (IOException ex) {
            Logger.getLogger(AddcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Printl_commandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
