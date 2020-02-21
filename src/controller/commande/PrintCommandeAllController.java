/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import controllers.DashbordController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class PrintCommandeAllController implements Initializable {

    @FXML
    private Label lbldesignation;
    @FXML
    private Label lbltype;
    @FXML
    private Label lblqte;
    @FXML
    private Label lblprix;
    @FXML
    private Label lbltotal;
    @FXML
    private Label lblcmd;

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
        str = Mywindows.getInstanceL().list.get(Mywindows.getInstanceL().code);
        lbldesignation.setText(str.substring(0, str.indexOf("|")));
        lbltype.setText(str.substring(str.indexOf("|") + 1, str.indexOf("#")));
        lblprix.setText(str.substring(str.indexOf("#") + 1, str.indexOf("*")));
        lblqte.setText(str.substring(str.indexOf("*") + 1, str.indexOf("@")));
        lbltotal.setText(str.substring(str.indexOf("@") + 1, str.indexOf("!")));
        lblcmd.setText(str.substring(str.indexOf("!") + 1));

    }

}
