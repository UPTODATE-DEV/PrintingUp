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
public class Detail_cmdController implements Initializable {

    @FXML
    private Label lbl_service;
    @FXML
    private Label lbl_type;
    @FXML
    private Label lbl_pu;
    @FXML
    private Label lbl_qte;
    public static String code_1;

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
        code_1 = str.substring(0, str.indexOf("^"));
        lbl_service.setText(str.substring(str.indexOf("^") + 1, str.indexOf("#")));
        lbl_type.setText(str.substring(str.indexOf("#") + 1, str.indexOf("&")));
        lbl_pu.setText(str.substring(str.indexOf("&") + 1, str.indexOf("%")));
        lbl_qte.setText(str.substring(str.indexOf("%") + 1));

    }

}
