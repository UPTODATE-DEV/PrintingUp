/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static Elementary.Alerts.warning;
import Elementary.Mywindows;
import static Elementary.Mywindows.createWindow;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.popOverMenu;
import Elementary.Traitement;
import static Elementary.Traitement.dateB;
import static Elementary.Traitement.getInstanceT;
import static Elementary.View_gui.getIns;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import static controllers.Dashbord_1Controller.vb_serce;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    
    public static DatePicker dteFin2;
    public static DatePicker dteP1;
    @FXML
    private Label alerter_retrait;
    @FXML
    private AnchorPane p7;
    @FXML
    private Label txtCopyRigth;
    @FXML
    private Label lbl_attente;
    @FXML
    private Label lbl_encours;
    @FXML
    private Label lbl_disponible;
    @FXML
    private Label lbl_livraison;
    @FXML
    private JFXButton config;
    public static String nom_agent;
    public static String id_conne;
    @FXML
    private Text Lblfonction;
    @FXML
    private Label lbl_user_;
    @FXML
    private MaterialDesignIconView strech;
    @FXML
    private JFXButton btn_disponible;
    @FXML
    private AnchorPane p1_sign_in;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Rcotent = cotent;
        dteP1 = dteP;
        dteFin2 = dteFin;
        mainAcces();
        lbl_user_.setText(nom_agent);
        Lblfonction.setText(id_conne);
        getInstanceT().Ecart(dteP, dteFin);
        dteP.setValue(LocalDate.now());
        dteFin.setValue(LocalDate.now());
        Mywindows.makejira(cotent, getClass().getResource(DASHBORD_1));
        getInstanceL().IsSeleted(s_dash, s_new, s_Ccommande, s_parametre);
        getInstanceL().SelectDataFor(p1, p2, p3, p4, p5);
        evenememet();
        config.setTooltip(getInstanceT().Titre("Deconnexion"));
        //loadContentPopup() ;
    }
    
    @FXML
    private void CallFormArticle(MouseEvent event) {
        getInstanceL().IsSeleted(s_dash, s_new, s_Ccommande, s_parametre, s_Rapport);
        getInstanceL().SelectDataFor(p1, p2, p3, p4, p5);
        Mywindows.makejira(cotent, getClass().getResource(DASHBORD_1));
        //warning("Enregistrement","");

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
                InitData();
                getInstanceL().ScrollwithHBX(vb_serce, getIns().getService(7, "SELECT * FROM new_print_dashboard_2 WHERE date_ BETWEEN '" + dateB(dteP) + "' AND '" + dateB(dteFin) + "'"), PRINT_SERVICE, 3);
                // new Dashbord_1Controller().pieChat(2, dteP, dteP1);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(PrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        strech.setOnMouseClicked((e) -> {
            up_priting.Up_priting.stage_.setFullScreen(true);
        });
        config.setOnMouseClicked((e) -> {
            try {
                popOverMenu(p1_sign_in, getClass().getResource(LOAD_DECONNEXION), PopOver.ArrowLocation.TOP_CENTER);
            } catch (IOException ex) {
                Logger.getLogger(PrincipaleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        InitData();
    }
    
    @FXML
    private void CallFormRapport(MouseEvent event) {
        bool = true;
        getInstanceL().IsSeleted(s_Rapport, s_Ccommande, s_new, s_dash, s_parametre);
        getInstanceL().SelectDataFor(p5, p3, p1, p2, p4);
        getInstanceL().makejira(cotent, getClass().getResource(LOAD_RAPPORT));
        
    }
    
    void InitData() {
        
        lbl_attente.setText("" + Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM vs_exe_commande WHERE (statis='Attente') AND (date_ BETWEEN '" + dteP.getValue() + "' AND '" + dteFin.getValue() + "')")));
        lbl_encours.setText("" + Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM vs_exe_commande WHERE (statis='Encours') AND (date BETWEEN '" + dteP.getValue() + "' AND '" + dteFin.getValue() + "')")));
        lbl_disponible.setText("" + Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM vs_exe_commande WHERE (statis='Fin')  AND (date BETWEEN '" + dteP.getValue() + "' AND '" + dteFin.getValue() + "')")));
        lbl_livraison.setText("" + Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM vs_exe_commande WHERE (statis='Livraison') AND (date BETWEEN '" + dteP.getValue() + "' AND '" + dteFin.getValue() + "')")));
        System.out.println("La date d'aujourd'hui est " + dteFin.getValue() + "");
        
    }
    public static final PopOver popConfig = new PopOver();
    public static final PopOver popup = new PopOver();
    private Parent popContent;
    
    private void loadContentPopup() {
        try {
            popContent = FXMLLoader.load(getClass().getResource("/conf/Config.fxml"));
            popConfig.getRoot().getStylesheets().add(getClass().getResource("/css/poplight.css").toExternalForm());
            popConfig.setContentNode(popContent);
            popConfig.setArrowLocation(PopOver.ArrowLocation.TOP_RIGHT);
            popConfig.setArrowIndent(0);
            popConfig.setArrowSize(0);
            popConfig.setCornerRadius(0);
            popConfig.setAutoFix(true);
            popConfig.setAnimated(false);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openConfig(MouseEvent event) {
//        if (popConfig.isShowing()) {
//            popConfig.hide();
//        } else {
//            popConfig.show(config, 0);
//            popConfig.getRoot().setFocusTraversable(true);
//        }
    }
    
    void mainAcces() {
        btn_disponible.setOnMouseClicked((e) -> {
            createWindow(getClass().getResource(LOAD_DIALOGUE_DISPONIBLE), "COMMANDE DISPONIBLE", new Stage(), false);
        });
    }
    
}
