/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import static Elementary.Mywindows.getInstanceL;
import static Elementary.View_gui.getIns;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class Orther_v_detteController implements Initializable {

    @FXML
    private Label Tfd_nom;
    @FXML
    private Label Tfddate;
    @FXML
    private Label Tfd_id;
    @FXML
    private Label Tfd_montant_a_paye;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initFild();
    }
    String str;

    void initFild() {

        str = getIns().list.get(getInstanceL().code);
        Tfd_id.setText(str.substring(0, str.indexOf("|")));
        Tfd_nom.setText(str.substring(str.indexOf("|") + 1, str.indexOf("^")));
        Tfddate.setText(str.substring(str.indexOf("^") + 1));

    }
}
