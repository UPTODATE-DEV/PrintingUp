/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import static Elementary.Mywindows.getInstanceL;
import static Elementary.View_gui.getIns;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
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
public class PrintServiceController implements Initializable {

    @FXML
    private Label id_lab;
    @FXML
    private Label service;
    @FXML
    private Label type;
    @FXML
    private Label prix_unitaire;
    @FXML
    private MaterialDesignIconView deletebtn;
    @FXML
    private MaterialDesignIconView updatebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }
    String str;

    void init() {
        str = getIns().list.get(getInstanceL().code);
        id_lab.setText(str.substring(0, str.indexOf("#")));
        service.setText(str.substring(str.indexOf("#") + 1, str.indexOf("%")));
        type.setText(str.substring(str.indexOf("%") + 1, str.indexOf("$")));
        prix_unitaire.setText(str.substring(str.indexOf("$") + 1));

    }

}
