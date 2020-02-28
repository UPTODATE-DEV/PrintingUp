/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import Elementary.View_gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import sun.security.util.Length;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class PrintClientController implements Initializable {

    @FXML
    private Label lbl_prenom;
    @FXML
    private Label lbl_mail;
    @FXML
    private Label lbl_adrss;
    private String str;
    @FXML
    private Label lbl_tel;
    @FXML
    private Label Lfb_position;
    @FXML
    private Label id_modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }
    void init() {
        str = View_gui.getIns().list.get(Mywindows.getInstanceL().code);
        id_modifier.setText(str.substring(0, str.indexOf("#")));
        lbl_prenom.setText(str.substring(str.indexOf("#") + 1, str.indexOf("^")));
        lbl_tel.setText(str.substring(str.indexOf("^") + 1, str.indexOf("*")));
        lbl_mail.setText(str.substring(str.indexOf("*") + 1, str.indexOf("&&")));
        lbl_adrss.setText(str.substring(str.indexOf("&&") + 2));
        Lfb_position.setText(str.substring(str.indexOf("#") + 1, str.indexOf("^")).substring(0, 1));

    }

}
