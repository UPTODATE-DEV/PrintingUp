/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.isSaved;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Authentique
 */
public class AddclientController implements Initializable {

    @FXML
    private Label sexe_lbl;
    int x = 0;
    @FXML
    private AnchorPane p1;
    @FXML
    private TextField nomTfd;
    @FXML
    private TextField mailTfd;
    @FXML
    private TextField adresstfd;
    @FXML
    private TextField prenomTfd;
    @FXML
    private JFXButton Btn_save;
    @FXML
    private TextField teleTfd;
    @FXML
    private Label modifierLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sexe_lbl.setText(Mywindows.getInstanceL().sexe_change(0));
        x++;
    }

    @FXML
    private void sexe_change(ActionEvent event) {
        sexe_lbl.setText(Mywindows.getInstanceL().sexe_change(x));
        //  getInstanceL().SelectDataFor(p1);
        if (x == 0) {
            x++;
        } else if (x != 0) {
            x--;
        }

    }
    Integer lab=1;
   

    @FXML
    private void Traitement_client(ActionEvent event) throws Exception {
        if (event.getSource() == Btn_save) {
            if (isSaved("sp_client", "PROCEDURE",modifierLbl, nomTfd, prenomTfd, sexe_lbl, teleTfd, lab, mailTfd, adresstfd) == true) {
                
            }
        }
    }

}
