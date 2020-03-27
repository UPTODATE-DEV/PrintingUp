/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parametrer;

import Elementary.Mywindows;
import static Elementary.references.*;
import com.jfoenix.controls.JFXDialog;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class ParametrerController implements Initializable {

    @FXML
    private TextField Tfdserveur;
    @FXML
    private TextField Tfdbasededonne;
    @FXML
    private TextField TfdUtilisateur;
    @FXML
    private TextField TfdMotdepasse;
    @FXML
    private TextField TfdChemin;
    @FXML
    private Label fullName;
    @FXML
    private Label note;
    @FXML
    private Rating rating;
    @FXML
    private Button btn_config;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        evenement();
    }    
void evenement(){
btn_config.setOnMouseClicked((e)->{
    try {
        Mywindows.showFormDialog(getClass().getResource(CONF), JFXDialog.DialogTransition.CENTER, 349, 427);
    } catch (IOException ex) {
        Logger.getLogger(ParametrerController.class.getName()).log(Level.SEVERE, null, ex);
    }

});

}
    
}
