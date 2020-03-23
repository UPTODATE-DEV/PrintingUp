/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import static Elementary.Connexion.*;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.View_gui.getIns;
import static Elementary.references.ADDSERVICE;
import static Elementary.references.LOADCOMMANDE;
import com.jfoenix.controls.JFXDialog;
import static controller.nouveau.AddserviceController.Tfdpunitaire1;
import static controller.nouveau.AddserviceController.Tfdservice1;
import static controller.nouveau.AddserviceController.Tfdtype_service1;
import static controller.nouveau.AddserviceController.btn_save1;
import static controller.nouveau.AddserviceController.service;
import static controller.nouveau.NouveauController.vbx1;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lib.service.ImplementeService;
import lib.service.ServiceDao;

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
    public static int x;

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
        evenement();
    }

    void evenement() {
        updatebtn.setOnMouseClicked((e) -> {
            try {
                x = Integer.parseInt(id_lab.getText());
                rst = stm.executeQuery("SELECT * FROM vs_aff_service WHERE id='" + x + "'");
                if (rst.next()) {
                    Mywindows.showFormDialog(getClass().getResource(ADDSERVICE), JFXDialog.DialogTransition.CENTER, 375, 366);
                    Tfdservice1.setText(rst.getString("service"));
                    Tfdtype_service1.setText(rst.getString("type"));
                    Tfdpunitaire1.setText(rst.getString("pu"));
                    btn_save1.setText("Modifier");
                }
            } catch (SQLException | IOException ex) {
                Logger.getLogger(PrintServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        deletebtn.setOnMouseClicked((e) -> {
            try {
                x = Integer.parseInt(id_lab.getText());
                ServiceDao service1 = new ServiceDao(Integer.toString(x), "", 0, "", "3");
                new ImplementeService().Enregistrer(service1);
                getInstanceL().ScrollwithHBX(vbx1, getIns().getService(1, "SELECT * FROM vs_aff_service"), LOADCOMMANDE, 4);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(PrintServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
