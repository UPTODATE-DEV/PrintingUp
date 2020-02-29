/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class PrintCommandeController implements Initializable {

    @FXML
    private Label id_lab;
    @FXML
    private Label service;
    @FXML
    private Label quantite_;
    @FXML
    private Label prix_unitaire;
    @FXML
    private Button btn_annuler;

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
        str = getInstanceL().list.get(getInstanceL().code);
        id_lab.setText(str.substring(0, str.indexOf("#")));
        service.setText(str.substring(str.indexOf("#")+1, str.indexOf("|")));

        //AddcommandeController.id_lab1 = id_lab;
        // idservice.setText(getInstanceL().service1);
        //AddcommandeController.quantite_1 = quantite_;
        //AddcommandeController.prix_unitaire1 = prix_unitaire;
    }

}
