/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class CommandeController implements Initializable {

    @FXML
    private AnchorPane p1;
    @FXML
    private JFXButton btn_client;
    @FXML
    private AnchorPane p2;
    @FXML
    private JFXButton btn_agent;
    @FXML
    private AnchorPane p3;
    @FXML
    private JFXButton btn_service;
    private JFXButton btn_commande;
    @FXML
    private JFXButton btn_commande_;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Call_windows(ActionEvent event) {
    }

    @FXML
    private void getadd(ActionEvent event) throws IOException {
        if(event.getSource()==btn_commande_){
           Mywindows.showFormDialog(getClass().getResource(ADDCOMMANDE), JFXDialog.DialogTransition.CENTER, 360,490);
        }
    }
    
}
