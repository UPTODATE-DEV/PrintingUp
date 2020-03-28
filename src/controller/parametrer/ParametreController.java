/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parametrer;

import static Elementary.Mywindows.getInstanceL;
import static Elementary.references.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class ParametreController implements Initializable {

    @FXML
    private Label b_profil;
    @FXML
    private Label b_entre;
    @FXML
    private Label b_users;
    @FXML
    private AnchorPane pan4;
    @FXML
    private Label b_devise;
    @FXML
    private Label b_abon;
    @FXML
    private VBox vbx;
    @FXML
    private Label indicator;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        indicator.setLayoutY(138);
        getInstanceL().IsSeleted(b_profil, b_users, b_entre, b_abon, b_devise);
        getInstanceL().makejira(vbx, getClass().getResource(PROFIL));
    }

    @FXML
    private void callprofil(MouseEvent event) {
        indicator.setLayoutY(138);
        getInstanceL().IsSeleted(b_profil, b_users, b_devise, b_abon, b_entre);
        getInstanceL().makejira(vbx, getClass().getResource(PROFIL));
    }

    @FXML
    private void Callentreprise(MouseEvent event) {
        indicator.setLayoutY(230);
        getInstanceL().IsSeleted(b_entre, b_users, b_profil, b_abon, b_devise);
        getInstanceL().makejira(vbx, getClass().getResource(ENTRER));

    }

    @FXML
    private void Callusers(MouseEvent event) {
        indicator.setLayoutY(183);
        getInstanceL().IsSeleted(b_users, b_profil, b_entre, b_abon, b_devise);
        getInstanceL().makejira(vbx, getClass().getResource(USER));
    }

    @FXML
    private void Calldevise(MouseEvent event) {
        indicator.setLayoutY(324);
        getInstanceL().IsSeleted(b_devise, b_users, b_profil, b_entre, b_abon);
        getInstanceL().makejira(vbx, getClass().getResource(DEVISE));
    }

    @FXML
    private void CallAbonnement(MouseEvent event) {
        indicator.setLayoutY(277);
        getInstanceL().IsSeleted(b_abon, b_devise, b_users, b_profil, b_entre);
        getInstanceL().makejira(vbx, getClass().getResource(ABON));

    }

}
