/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import Elementary.Mywindows;
import static Elementary.references.LOGIN;
import static controllers.PrincipaleController.Rcotent;
import static controllers.PrincipaleController.nom_agent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class DeconnexionController implements Initializable {
    
    @FXML
    private Button btn_deconnexion;
    @FXML
    private Button btn_profil;
    @FXML
    private Label user_connecte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        evenement();
        user_connecte.setText(nom_agent.toUpperCase());
    }
    
    void evenement() {
        btn_deconnexion.setOnMouseClicked((e) -> {
            Mywindows.openWindow(getClass().getResource(LOGIN), "UP-PRINT");
            ((Stage) Rcotent.getScene().getWindow()).close();
            
        });
        
    }
    
}
