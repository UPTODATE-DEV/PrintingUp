/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.popOverMenu;
import Elementary.View_gui;
import static Elementary.references.OTHEINFO;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.PopOver;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class PrintCommandeAllController implements Initializable {

    @FXML
    private Label lbldesignation;
    @FXML
    private Label lblqte;
    @FXML
    private Label lbltotal;
    @FXML
    private Label lblcmd;
    @FXML
    private Label alert_paiement;
    @FXML
    private Label lbl_informa;
    @FXML
    private AnchorPane pan_infor;
    @FXML
    private Label id_commande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initFild();
        lbl_informa.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#16C75D", MaterialDesignIcon.INFORMATION));

    }
    String str, st;

    void initFild() {
        str = View_gui.getIns().list.get(Mywindows.getInstanceL().code);
        // st = View_gui.getIns().list1.get(Mywindows.getInstanceL().code);
        lbldesignation.setText(str.substring(0, str.indexOf("|")));
        lblqte.setText(str.substring(str.indexOf("|") + 1, str.indexOf("#")));
        lbltotal.setText(str.substring(str.indexOf("#") + 1, str.indexOf("$")));
        String payer = str.substring(str.indexOf("$") + 1, str.indexOf("!"));
        id_commande.setText(Integer.toString(Integer.parseInt(str.substring(str.indexOf("!") + 1))));

        if (lbltotal.getText().equals(payer)) {
            alert_paiement.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#A4E3A4", MaterialDesignIcon.CHECKBOX_MARKED));
        } else if (Double.parseDouble(lbltotal.getText()) > Double.parseDouble(payer) && Double.parseDouble(payer) > 0) {
            alert_paiement.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#93D0E1", MaterialDesignIcon.ALERT_BOX));
        } else if (Double.parseDouble(lbltotal.getText()) > Double.parseDouble(payer) && Double.parseDouble(payer) == 0) {
            alert_paiement.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#ED8C67", MaterialDesignIcon.ALERT));
        }
    }

    @FXML
    private void call_informande(MouseEvent event) throws IOException {
        Other_commandeController.lab = id_commande;
        popOverMenu(pan_infor, getClass().getResource(OTHEINFO), PopOver.ArrowLocation.TOP_CENTER);

    }

}
