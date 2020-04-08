/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControllers;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class EntrepriseController implements Initializable {

    @FXML
    private Text txttitle;
    @FXML
    private Circle logo;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtrccm;
    @FXML
    private TextField txtchemin;
    @FXML
    private FontAwesomeIconView chema;
    @FXML
    private TextField txtadresseph;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtmail;
    @FXML
    private TextField txtAdmin;
    @FXML
    private PasswordField txtpasswd;
    @FXML
    private PasswordField txtpasswd1;
    @FXML
    private JFXButton btsave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setname(KeyEvent event) {
    }

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
    }
    
}
