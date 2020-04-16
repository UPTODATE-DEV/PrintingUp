/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import static Elementary.Mywindows.getInstanceL;
import Elementary.View_gui;
import static Elementary.references.PRINT_CMD;
import com.jfoenix.controls.JFXButton;
import static controller.commande.CommandeController.vb_commande1;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class rapport_vente implements Initializable {

    @FXML
    private Text s_commande_rappor;
    @FXML
    private RadioButton all_;
    @FXML
    private RadioButton solder;
    @FXML
    private RadioButton Avance;
    @FXML
    private RadioButton dette;
    @FXML
    private TextField Tfl_search;
    @FXML
    private VBox vb_commande;
    @FXML
    private JFXButton btAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isEvent();
        if (checkSelected().equals("Tous")) {
            try {
                getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 2);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void synchro(ActionEvent event) {
    }

    String checkSelected() {
        if (all_.isSelected()) {
            return "Tous";
        } else if (solder.isSelected()) {
            return "Solder";
        } else if (Avance.isSelected()) {
            return "Avance";
        } else {
            return "Dette";
        }
    }

    void isEvent() {
        all_.setOnMouseClicked((e) -> {
            Init();
        });
        solder.setOnMouseClicked((e) -> {
            Init();
        });
        Avance.setOnMouseClicked((e) -> {
            Init();
        });
        dette.setOnMouseClicked((e) -> {
            Init();
        });
    }

    void Init() {
        switch (checkSelected()) {
            case "Tous":
                try {
                    // TODO
                    getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 2);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Solder":
                try {
                    // TODO
                    getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE (payer=a_payer)"), PRINT_CMD, 2);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Avance":
                try {
                    // TODO
                    getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE (payer <a_payer)"), PRINT_CMD, 2);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Dette":
                try {
                    // TODO
                    getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE (payer is null) or (payer <a_payer)"), PRINT_CMD, 2);

                } catch (IOException | SQLException ex) {
                    Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
        isSearch();
    }

    void isSearch() {
        Tfl_search.setOnKeyReleased((KeyEvent e) -> {
            switch (checkSelected()) {
                case "Tous":
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE  Nom Like '%" + Tfl_search.getText() + "%' OR id like '%" + Tfl_search.getText() + "%'"), PRINT_CMD, 2);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Solder":
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE (payer=a_payer) AND (Nom Like '%" + Tfl_search.getText() + "%' OR id like '%" + Tfl_search.getText() + "%')"), PRINT_CMD, 2);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Avance":
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE (payer <a_payer) AND (Nom Like '%" + Tfl_search.getText() + "%' OR id like '%" + Tfl_search.getText() + "%')"), PRINT_CMD, 2);
                    } catch (IOException | SQLException ex) {
                        Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement "
                                + "WHERE ((payer is null) or (payer < a_payer)) AND (Nom like '%" + Tfl_search.getText() + "%' OR id like '%" + Tfl_search.getText() + "%')"), PRINT_CMD, 2);
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(rapport_vente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        });
    }

}
