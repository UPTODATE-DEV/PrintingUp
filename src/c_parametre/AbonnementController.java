/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_parametre;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;


/**
 * FXML Controller class
 *
 * @author Maurice
 */
public class AbonnementController implements Initializable {

    @FXML
    private Circle logo;
    @FXML
    private JFXButton btlogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void abonner(ActionEvent event) throws IOException {
      //  ev.ShowDialog(S_ABONNER, 440, 493);
    }

}
