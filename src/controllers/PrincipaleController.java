/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.popOverMenu;
import static Elementary.references.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.PopOver;

/**
 * FXML Controller class
 *
 * @author Authentique
 */
public class PrincipaleController implements Initializable {

    @FXML
    private StackPane cotent;
    @FXML
    private AnchorPane p2;
    @FXML
    private Label s_new;
    @FXML
    private AnchorPane p3;
    @FXML
    private Label s_Ccommande;
    @FXML
    private AnchorPane p1;
    @FXML
    private AnchorPane p4;
    @FXML
    private Label s_dash;
    @FXML
    private Label s_parametre;
    @FXML
    private AnchorPane pan6;
    public static StackPane Rcotent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Rcotent = cotent;
        Mywindows.makejira(cotent, getClass().getResource(DASHBORD));
        getInstanceL().IsSeleted(s_dash, s_new, s_Ccommande, s_parametre);
        getInstanceL().SelectDataFor(p1, p2, p3, p4);
    }

    @FXML
    private void CallFormArticle(MouseEvent event) {
        getInstanceL().IsSeleted(s_dash, s_new, s_Ccommande, s_parametre);
        getInstanceL().SelectDataFor(p1, p2, p3, p4);
        Mywindows.makejira(cotent, getClass().getResource(DASHBORD));
    }

    @FXML
    private void CallFormEntreprise(MouseEvent event) {
        getInstanceL().IsSeleted(s_parametre, s_dash, s_new, s_Ccommande);
        getInstanceL().SelectDataFor(p4, p1, p2, p3);
        getInstanceL().makejira(cotent, getClass().getResource(PARAMETRE));
    }

    @FXML
    private void CallFormNew(MouseEvent event) {
        getInstanceL().IsSeleted(s_new, s_dash, s_Ccommande, s_parametre);
        getInstanceL().SelectDataFor(p2, p1, p3, p4);
        getInstanceL().makejira(cotent, getClass().getResource(NOUVEAU));
    }

    @FXML
    private void CallFormCommande(MouseEvent event) {
        getInstanceL().IsSeleted(s_Ccommande, s_new, s_dash, s_parametre);
        getInstanceL().SelectDataFor(p3, p1, p2, p4);
        getInstanceL().makejira(cotent, getClass().getResource(COMMANDE));
    }

    @FXML
    private void setMenu(ActionEvent event) throws IOException {
        popOverMenu(pan6, getClass().getResource(OTHERMENU), PopOver.ArrowLocation.TOP_CENTER);
    }


}
