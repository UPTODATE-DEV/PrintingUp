/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class PrintRealisationController implements Initializable {

    @FXML
    private Label service_;
    @FXML
    private Label total_sortier;

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
        total_sortier.setText(str.substring(0, str.indexOf("^")));
        service_.setText(str.substring(str.indexOf("^") + 1, str.indexOf("#")));

    }

}
