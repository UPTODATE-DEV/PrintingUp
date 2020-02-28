/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
    @FXML
    private VBox vb_commande;
    @FXML
    private TextField Tfl_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }

    void init() {
        try {
            recherche();
            try {
                getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "select * from vs_effect"), PRINT_CMD, 4);
            } catch (SQLException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Call_windows(ActionEvent event) {
    }

    @FXML
    private void getadd(ActionEvent event) throws IOException {
        if (event.getSource() == btn_commande_) {
            Mywindows.showFormDialog(getClass().getResource(ADDCOMMANDE), JFXDialog.DialogTransition.CENTER, 360, 490);
        }
    }

    void recherche() {
        Tfl_search.setOnKeyPressed((e) -> {
            try {
                getInstanceL().ScrollwithHBX(vb_commande,
                        View_gui.getIns().getService(3,
                                "select * from vs_effect WHERE nom LIKE '%"
                                + Tfl_search.getText()
                                + "%' OR id LIKE '%" + Tfl_search.getText() + "%'"), PRINT_CMD, 4);

            } catch (SQLException | IOException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

}
