/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.View_gui.getIns;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
    @FXML
    private VBox vbx;
    @FXML
    private TextField tfd_sercher;
    public static VBox vbx1;
//  Alerts.info("Info", "Lorem ipsum dolor color.");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status = 1;
        vbx1 = vbx;
        if (status == 1) {
            getInstanceL().SelectDataFor1(btn_client, btn_agent, btn_service);
            getInstanceL().SelectDataFor(p1, p2, p3);
            search_new("client");
            init(2);  
        }
    }

    void init(int c) {
        try {
            try {
                switch (c) {
                    case 1:
                        getInstanceL().ScrollwithHBX(vbx1, getIns().getService(1, "SELECT * FROM vs_aff_service"), LOADCOMMANDE, 4);
                        break;
                    case 2:
                        getInstanceL().ScrollwithHBX(vbx1, getIns().getService(2, "SELECT * FROM tbl_client"), PRINT_CLIENT, 4);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(NouveauController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouveauController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void Call_windows(ActionEvent event) throws IOException {
        if (event.getSource() == btn_client) {
            getInstanceL().SelectDataFor1(btn_client, btn_agent, btn_service);
            getInstanceL().SelectDataFor(p1, p2, p3);
            init(2);
            search_new("client");
            status = 1;
        } else if (event.getSource() == btn_agent) {
            getInstanceL().SelectDataFor1(btn_agent, btn_client, btn_service);
            getInstanceL().SelectDataFor(p2, p1, p3);
            status = 2;
            search_new("agent");
             
        } else if (event.getSource() == btn_service) {
            getInstanceL().SelectDataFor1(btn_service, btn_agent, btn_client);
            getInstanceL().SelectDataFor(p3, p2, p1);
            init(1);
            search_new("service");
            status = 3;
        }

    }

    void search_new(String str) {
        try {
            tfd_sercher.setOnKeyReleased((KeyEvent value) -> {
                switch (str) {
                    case "service":
                        try {
                            try {
                                getInstanceL().ScrollwithHBX(vbx, getIns().getService(1,
                                        "SELECT * FROM vs_aff_service"
                                        + " WHERE service LIKE '%" + tfd_sercher.getText() + "%' OR id LIKE '%"
                                        + tfd_sercher.getText() + "%'"), LOADCOMMANDE, 4);
                            } catch (IOException ex) {
                                Logger.getLogger(NouveauController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(NouveauController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    break;
                    case "agent":
                        System.out.println("Pas encore implementer");
                        break;
                    case "client":
                        try {
                            try {
                                getInstanceL().ScrollwithHBX(vbx, getIns().getService(2,
                                        "SELECT * FROM tbl_client"
                                        + " WHERE nom LIKE '%" + tfd_sercher.getText() + "%' OR id LIKE '%"
                                        + tfd_sercher.getText() + "%'"), PRINT_CLIENT, 4);
                            } catch (IOException ex) {
                                Logger.getLogger(NouveauController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(NouveauController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                }
            });
        } catch (Exception e) {
        }
    }
}
