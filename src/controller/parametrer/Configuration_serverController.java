/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parametrer;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class Configuration_serverController implements Initializable {

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
    private Label message;
    @FXML
    private FontAwesomeIconView icon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
