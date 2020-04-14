/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import static Elementary.Connexion.isConnected;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.Traitement;
import Elementary.View_gui;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import static controllers.PrincipaleController.bool;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class CommandeController implements Initializable {

    @FXML
    private AnchorPane p2;
    @FXML
    private AnchorPane p3;

    @FXML
    private JFXButton btn_commande_;
    @FXML
    private VBox vb_commande;
    @FXML
    private TextField Tfl_search;
    public static VBox vb_commande1;
    @FXML
    private AnchorPane p31;
    private Label lbl_dette;
    private Label lbl_attente;
    private Label lblEncours;
    private Label lbldisponible;
    @FXML
    private JFXButton btn_dette;
    @FXML
    private JFXButton btn_attent;
    @FXML
    private JFXButton btn_encours;
    @FXML
    private JFXButton btn_disponible;
    @FXML
    private AnchorPane p4;
    @FXML
    private AnchorPane p5;
    int status = 1;
    @FXML
    private MaterialDesignIconView i2;
    @FXML
    private MaterialDesignIconView i3;
    @FXML
    private MaterialDesignIconView i4;
    @FXML
    private MaterialDesignIconView i5;
    @FXML
    private Text s_commande_rappor;
    @FXML
    private GridPane menu_ok;
    @FXML
    private JFXButton btn_attent1;
    @FXML
    private MaterialDesignIconView i31;
    @FXML
    private JFXButton btAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 

        if (status == 1) {
            if (bool == true) {
                s_commande_rappor.setText("Rapport");
                btn_dette.setVisible(false);
                btn_attent.setVisible(false);
                btn_encours.setVisible(false);
                btn_disponible.setVisible(false);
//                getInstanceL().SelectDataFor(p1, p2, p3, p4, p5);
//                getInstanceL().SelectDataFor1(btn_commande1, btn_dette, btn_attent, btn_encours, btn_disponible);
                init(1);
                recherche();
                menu_ok.setVisible(false);
                btn_commande_.setVisible(false);
                //i1.setVisible(false);
            } else {
                s_commande_rappor.setText("Commande");
                menu_ok.setVisible(true);
                btn_dette.setVisible(true);
                btn_attent.setVisible(true);
                btn_encours.setVisible(true);
                btn_disponible.setVisible(true);
                getInstanceL().SelectDataFor(p3, p2, p4, p5);
                getInstanceL().SelectDataFor1(btn_attent, btn_dette, btn_encours, btn_disponible);
                init(3);
                initTread();

            }

        }

    }

    void init(int x) {

        vb_commande1 = vb_commande;
        try {

            try {
                switch (x) {
                    case 1:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 2);
                        break;
                    case 2:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours Where statis='Fin'"), LOAD_PRINT_FIN, 2);
                        break;
                    case 3:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours where statis='Attente'"), LOAD_PRINT_LISTDETTE, 2);
                        break;
                    case 4:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(5, "SELECT * FROM client_dette"), PRINT_PAIEMENT_DETTE, 2);
                        break;
                    case 5:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours where statis='Encours'"), LOAD_PRINT_ENCOURS, 2);
                        break;
                    case 6:

                        break;

                }
            } catch (SQLException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void initTreed() {

        if (isConnected() != null) {

            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Attente'")) > 0) {
                i3.setVisible(true);
            } else {
                i3.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Encours'")) > 0) {
                i4.setVisible(true);

            } else {
                i4.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Fin'")) > 0) {
                i5.setVisible(true);
            } else {
                i5.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM client_dette")) > 0) {
                i2.setVisible(true);
            } else {
                i2.setVisible(false);
            }
        }
    }

    public void initTread() {
        Thread clock;
        clock = new Thread() {
            @Override
            public void run() {
                for (;;) {

                    try {
                        initTreed();
                        System.out.println("En cours...");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();
    }

    @FXML
    private void Call_windows(ActionEvent event) throws IOException {
        if (event.getSource() == btn_dette) {
            //  popOverMenu(p2, getClass().getResource(LOAD_PRINT_DETTE), PopOver.ArrowLocation.TOP_CENTER);
            // getInstanceL().SelectDataFor(p2, p1, p31, p3);
            getInstanceL().SelectDataFor(p2, p3, p4, p5);
            getInstanceL().SelectDataFor1(btn_dette, btn_attent, btn_encours, btn_disponible);
            status = 2;
            init(4);
        } else if (event.getSource() == btn_attent) {
            // popOverMenu(p1, getClass().getResource(PRINT_DETTE), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p3, p2, p4, p5);
            getInstanceL().SelectDataFor1(btn_attent, btn_dette, btn_encours, btn_disponible);
            init(3);
            status = 3;
        } else if (event.getSource() == btn_encours) {
            //  popOverMenu(p31, getClass().getResource(LOAD_ENCOURS), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p4, p3, p2, p5);
            getInstanceL().SelectDataFor1(btn_encours, btn_attent, btn_dette, btn_disponible);
            status = 4;
            init(5);
        } else if (event.getSource() == btn_disponible) {
            // popOverMenu(p3, getClass().getResource(LOAD_PRINT_DISPONIBLE), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p5, p4, p3, p2);
            getInstanceL().SelectDataFor1(btn_disponible, btn_encours, btn_attent, btn_dette);
            status = 5;
            init(2);
        }
//        else if (event.getSource() == btn_commande1) {
//
//            getInstanceL().SelectDataFor(p1, p2, p3, p4, p5);
//            getInstanceL().SelectDataFor1(btn_commande1, btn_dette, btn_attent, btn_encours, btn_disponible);
//            status = 1;
//            init(1);
//        }
    }

    @FXML
    private void getadd(ActionEvent event) throws IOException {
        if (event.getSource() == btn_commande_) {
            Mywindows.showFormDialog(getClass().getResource(ADDCOMMANDE), JFXDialog.DialogTransition.CENTER, 360, 490);
        }
    }

    void recherche() {

        Tfl_search.setOnKeyReleased((e) -> {
            if (bool == true) {
                try {
                    getInstanceL().ScrollwithHBX(vb_commande,
                            View_gui.getIns().getService(3,
                                    "SELECT * FROM new_vs_print2_paiement WHERE nom LIKE '%"
                                    + Tfl_search.getText()
                                    + "%' OR id LIKE '%" + Tfl_search.getText() + "%'"), PRINT_CMD, 4);

                } catch (SQLException | IOException ex) {
                    Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    @FXML
    private void synchro(ActionEvent event) {
    }

}
