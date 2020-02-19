/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Authentique
 */
public class OthermenuController implements Initializable {

    @FXML
    private AnchorPane pan1;
    @FXML
    private Label b_dash;
    @FXML
    private AnchorPane pan2;
    @FXML
    private Label b_profil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CallEntreprise(MouseEvent event) {
    }

    @FXML
    private void CallProfil(MouseEvent event) {
    }
    
}
