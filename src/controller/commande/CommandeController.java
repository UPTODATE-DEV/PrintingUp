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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class CommandeController implements Initializable {

    @FXML
    private AnchorPane p1;
    private JFXButton btn_client;
    @FXML
    private AnchorPane p2;
    private JFXButton btn_agent;
    @FXML
    private AnchorPane p3;
    private JFXButton btn_service;
    private JFXButton btn_commande;
    @FXML
    private JFXButton btn_commande_;
    @FXML
    private VBox vb_commande;
    @FXML
    private TextField Tfl_search;
    public static VBox vb_commande1;
    private JFXButton btn_service1;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        //initTread();
        init(1);
    }

    void init(int x) {

        vb_commande1 = vb_commande;
        try {
            recherche();
            try {
                switch (x) {
                    case 1:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 4);
                        break;
                    case 2:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours Where statis='Fin'"), LOAD_PRINT_FIN, 4);
                        break;
                    case 3:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours where statis='Attente'"), LOAD_PRINT_LISTDETTE, 4);
                        break;
                    case 4:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(5, "SELECT * FROM client_dette"), PRINT_PAIEMENT_DETTE, 4);
                        break;
                    case 5:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "select * from new_test_encours where statis='Encours'"), LOAD_PRINT_LISTDETTE, 4);
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
                lbl_attente.setVisible(true);
                lbl_attente.setText(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Attente'"));
            } else {
                lbl_attente.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Encours'")) > 0) {
                lblEncours.setVisible(true);

                lblEncours.setText(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Encours'"));
            } else {
                lblEncours.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Fin'")) > 0) {
                lbldisponible.setVisible(true);
                lbldisponible.setText(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Fin'"));
            } else {
                lbldisponible.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM client_dette")) > 0) {
                lbl_dette.setVisible(true);
                lbl_dette.setText(Traitement.getInstanceT().getValue("SELECT count(id) x FROM client_dette"));
            } else {
                lbl_dette.setVisible(false);
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
            getInstanceL().SelectDataFor(p2, p1, p31, p3);
            init(4);
        } else if (event.getSource() == btn_attent) {
            // popOverMenu(p1, getClass().getResource(PRINT_DETTE), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p1, p2, p31, p3);
            init(3);
        } else if (event.getSource() == btn_encours) {
            //  popOverMenu(p31, getClass().getResource(LOAD_ENCOURS), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p31, p3, p1, p2);
            init(5);
        } else if (event.getSource() == btn_disponible) {
            // popOverMenu(p3, getClass().getResource(LOAD_PRINT_DISPONIBLE), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p3, p31, p1, p2);
            init(2);
        } else if (event.getSource() == btn_commande) {
            getInstanceL().SelectDataFor(p3, p31, p1, p2);
            init(1);
        }
    }

    @FXML
    private void getadd(ActionEvent event) throws IOException {
        if (event.getSource() == btn_commande_) {
            Mywindows.showFormDialog(getClass().getResource(ADDCOMMANDE), JFXDialog.DialogTransition.CENTER, 360, 490);
        }
    }

    void recherche() {
        Tfl_search.setOnKeyPressed((e) -> {
            try {
                getInstanceL().ScrollwithHBX(vb_commande,
                        View_gui.getIns().getService(3,
                                "SELECT * FROM new_vs_print2_paiement WHERE nom LIKE '%"
                                + Tfl_search.getText()
                                + "%' OR id LIKE '%" + Tfl_search.getText() + "%'"), PRINT_CMD, 4);

            } catch (SQLException | IOException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

}
