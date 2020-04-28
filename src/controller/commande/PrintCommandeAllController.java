/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Connexion;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.Traitement;
import static Elementary.Traitement.getInstanceT;
import Elementary.View_gui;
import Elementary.references;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import static controller.commande.CommandeController.stackPane_;
import static controller.commande.CommandeController.vb_commande1;
import controllers.PrincipaleController;
import static controllers.PrincipaleController.Rcotent;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

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
    private Label lbl_informa;
    @FXML
    private Label id_commande;
    @FXML
    private Label id_commande1;
    @FXML
    private Label lbl_annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initFild();
        if (PrincipaleController.bool == true) {
            lbl_annuler.setVisible(false);
        }
    }
    String str;

    void initFild() {
        eventDetail();
        str = View_gui.getIns().list.get(getInstanceL().code);
        // st = View_gui.getIns().list1.get(Mywindows.getInstanceL().code);
        lbldesignation.setText(str.substring(0, str.indexOf("|")));
        lblqte.setText(str.substring(str.indexOf("|") + 1, str.indexOf("#")));
        lbltotal.setText(str.substring(str.indexOf("#") + 1, str.indexOf("$")));
        String payer = str.substring(str.indexOf("$") + 1, str.indexOf("!"));
        id_commande.setText(Integer.toString(Integer.parseInt(str.substring(str.indexOf("!") + 1))));
        //SELECT * FROM tbl_exe_commande
        if (Traitement.getInstanceT().getValue("SELECT statis x FROM tbl_exe_commande WHERE code_commande='" + id_commande.getText() + "'").equals("Attente")) {
            lbl_annuler.setVisible(true);
            System.out.println(Traitement.getInstanceT().getValue("SELECT statis x FROM tbl_exe_commande WHERE code_commande='" + id_commande.getText() + "'"));
        } else {
            lbl_annuler.setVisible(false);
        }

        if (lbltotal.getText().equals(payer)) {
            alert_paiement.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#A4E3A4", MaterialDesignIcon.CHECKBOX_MARKED));
        } else if (Double.parseDouble(lbltotal.getText()) > Double.parseDouble(payer) && Double.parseDouble(payer) > 0) {
            alert_paiement.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#93D0E1", MaterialDesignIcon.ALERT_BOX));
        } else if (Double.parseDouble(lbltotal.getText()) > Double.parseDouble(payer) && Double.parseDouble(payer) == 0) {
            alert_paiement.setGraphic(Mywindows.getInstanceT().font("-fx-fill:#ED8C67", MaterialDesignIcon.ALERT));
        }
    }

    void eventDetail() {
        lblcmd.setOnMouseClicked((e) -> {
            try {
                Other_commandeController.lab = id_commande;
                Mywindows.showFormDialog(getClass().getResource(OTHEINFO), JFXDialog.DialogTransition.CENTER, 264, 525);
            } catch (IOException ex) {
                Logger.getLogger(PrintCommandeAllController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        lbl_annuler.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                showExitDialog(Rcotent, JFXDialog.DialogTransition.CENTER, new references().MESSAGE_QUESTION_DELETE, 0);
            }
        });
    }
    private static JFXDialog dialog;

    public void showExitDialog(StackPane rootPane, JFXDialog.DialogTransition transition, String tile, int x) {
        try {
            JFXDialogLayout dl = new JFXDialogLayout();
            dl.setHeading(new Label("Quitter"));
            dl.setBody(new Label(tile));
            dialog = new JFXDialog(rootPane, dl, transition, false);
            JFXButton ok = new JFXButton("Oui");
//            ok.getStyleClass().add("loginButton");
            ok.setOnAction((ActionEvent e) -> {
                try {
                    if (getInstanceT().getprepare("Call annuler_commande ('" + id_commande.getText() + "')") == true) {
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 2);
                    } else {
                        System.out.println("le commende en cours");
                    }
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(PrintCommandeAllController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            JFXButton no = new JFXButton("Non");
//            no.getStyleClass().add("btnDialog");
            no.setOnAction(e -> {
                dialog.close();
            });
            dl.setActions(ok, no);
            dialog.show(rootPane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
