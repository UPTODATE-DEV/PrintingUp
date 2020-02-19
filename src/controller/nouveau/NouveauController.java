/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Authentique
 */
public class NouveauController implements Initializable {

    @FXML
    private JFXButton btn_client;
    @FXML
    private JFXButton btn_agent;
    @FXML
    private JFXButton btn_service;
    @FXML
    private AnchorPane p1;
    @FXML
    private AnchorPane p2;
    @FXML
    private AnchorPane p3;
    private int status = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status = 1;
        if (status == 1) {
            getInstanceL().SelectDataFor1(btn_client, btn_agent, btn_service);
            getInstanceL().SelectDataFor(p1, p2, p3);
        }
    }

    @FXML
    private void getadd(ActionEvent event) throws Exception {
        switch (status) {
            case 1:
                Mywindows.showFormDialog(getClass().getResource(ADDCLIENT), JFXDialog.DialogTransition.CENTER, 391, 554);
                break;
            case 2:
                Mywindows.showFormDialog(getClass().getResource(ADDAGENT), JFXDialog.DialogTransition.CENTER, 391, 554);
                break;
            case 3:
                Mywindows.showFormDialog(getClass().getResource(ADDSERVICE), JFXDialog.DialogTransition.CENTER, 391, 388);
                break;
            default:
                throw new AssertionError();
        }

    }

    @FXML
    private void Call_windows(ActionEvent event) {
        if (event.getSource() == btn_client) {
            getInstanceL().SelectDataFor1(btn_client, btn_agent, btn_service);
            getInstanceL().SelectDataFor(p1, p2, p3);
            status = 1;
        } else if (event.getSource() == btn_agent) {
            getInstanceL().SelectDataFor1(btn_agent, btn_client, btn_service);
            getInstanceL().SelectDataFor(p2, p1, p3);
            status = 2;
        } else if (event.getSource() == btn_service) {
            getInstanceL().SelectDataFor1(btn_service, btn_agent, btn_client);
            getInstanceL().SelectDataFor(p3, p2, p1);
            status = 3;
        }
     
    }
}
