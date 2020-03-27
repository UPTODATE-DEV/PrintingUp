/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.popOverMenu;
import static Elementary.Traitement.dateB;
import static Elementary.View_gui.getIns;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import static controllers.Dashbord_1Controller.vb_serce;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
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
    @FXML
    private DatePicker dteP;
    @FXML
    private DatePicker dteFin;
    @FXML
    private AnchorPane pan61;
    @FXML
    private JFXButton btn_refresh;
    @FXML
    private Label s_Rapport;
    @FXML
    private AnchorPane p5;
    public static boolean bool;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Rcotent = cotent;
        dteP.setValue(LocalDate.now());
        dteFin.setValue(LocalDate.now());
        Mywindows.makejira(cotent, getClass().getResource(DASHBORD_1));
        getInstanceL().IsSeleted(s_dash, s_new, s_Ccommande, s_parametre);
        getInstanceL().SelectDataFor(p1, p2, p3, p4, p5);
        evenememet();
    }

    @FXML
    private void CallFormArticle(MouseEvent event) {
        getInstanceL().IsSeleted(s_dash, s_new, s_Ccommande, s_parametre, s_Rapport);
        getInstanceL().SelectDataFor(p1, p2, p3, p4, p5);
        Mywindows.makejira(cotent, getClass().getResource(DASHBORD_1));
    }

    @FXML
    private void CallFormEntreprise(MouseEvent event) {
        getInstanceL().IsSeleted(s_parametre, s_dash, s_new, s_Ccommande, s_Rapport);
        getInstanceL().SelectDataFor(p4, p1, p2, p3, p5);
        getInstanceL().makejira(cotent, getClass().getResource(PARAMETRE));
    }

    @FXML
    private void CallFormNew(MouseEvent event) {
        getInstanceL().IsSeleted(s_new, s_dash, s_Ccommande, s_parametre, s_Rapport);
        getInstanceL().SelectDataFor(p2, p1, p3, p4, p5);
        getInstanceL().makejira(cotent, getClass().getResource(NOUVEAU));
    }

    @FXML
    private void CallFormCommande(MouseEvent event) {
        bool = false;
        getInstanceL().IsSeleted(s_Ccommande, s_new, s_dash, s_parametre, s_Rapport);
        getInstanceL().SelectDataFor(p3, p1, p2, p4, p5);
        getInstanceL().makejira(cotent, getClass().getResource(COMMANDE));
    }

    @FXML
    private void setMenu(ActionEvent event) throws IOException {
        popOverMenu(pan6, getClass().getResource(OTHERMENU), PopOver.ArrowLocation.TOP_CENTER);
    }

    void evenememet() {
        btn_refresh.setOnMouseClicked((e) -> {
            try {
                getInstanceL().ScrollwithHBX(vb_serce, getIns().getService(7, "SELECT * FROM new_print_dashboard_2 WHERE date_ BETWEEN '" + dateB(dteP) + "' AND '" + dateB(dteFin) + "'"), PRINT_SERVICE, 4);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(PrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void CallFormRapport(MouseEvent event) {

        bool = true;
        getInstanceL().IsSeleted(s_Rapport, s_Ccommande, s_new, s_dash, s_parametre);
        getInstanceL().SelectDataFor(p5, p3, p1, p2, p4);
        getInstanceL().makejira(cotent, getClass().getResource(COMMANDE));

    }

}
