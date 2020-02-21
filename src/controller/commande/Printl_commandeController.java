/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
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
        if (Mywindows.isSaved("sp_annuler", "PROCEDURE", id_)) {
        }
    }

}
