/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import static Elementary.Mywindows.isSaved;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class AddserviceController implements Initializable {

    @FXML
    private TextField Tfdservice;
    @FXML
    private TextField Tfdtype_service;
    @FXML
    private TextField Tfdpunitaire;
    @FXML
    private JFXButton btn_save;
    @FXML
    private Label Tfd_code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Mywindows.getInstanceL().ChargememtCompression(Tfdservice, "tbl_svc", "designation",null);
        Mywindows.getInstanceL().ChargememtCompression(Tfdtype_service, "tbl_type", "designation",null);
    }

    @FXML
    private void Traitement_service(ActionEvent event) throws Exception {
        if (event.getSource() == btn_save) {
            if (isSaved("sp_service", "PROCEDURE", Tfd_code, Tfdservice, Tfdpunitaire, Tfdtype_service, 1) == true) {
            }
        }
    }

}
