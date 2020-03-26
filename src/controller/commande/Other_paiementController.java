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
import static Elementary.references.PRINT_CMD;
import com.jfoenix.controls.JFXButton;
import static controller.commande.AddcommandeController.lbl_frac1;
import static controller.commande.CommandeController.vb_commande1;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class Other_paiementController implements Initializable {

    @FXML
    private TextField Tfd_montant;
    @FXML
    private JFXButton btn_paiement;
    private int getId;
    public static Label getId1;
    public static Label Montant;

    @FXML
    private Label alert_paiement;
    @FXML
    private Text massage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        paiement();

    }

    void paiement() {
        testCaract();
        btn_paiement.setOnMouseClicked((value) -> {
            if (Integer.parseInt(getId().getText()) != 0) {
                switch (Tfd_montant.getText()) {
                    case "0.0":
                        Mywindows.OuputText(massage, "Paiement échouer", alert_paiement, true);
                        break;
                    case "":
                        Mywindows.OuputText(massage, "Paiement échoue", alert_paiement, true);
                        break;
                    default:
                        try {
                            if ((Double.parseDouble(Tfd_montant.getText()) <= 0.0) || (Double.parseDouble(Tfd_montant.getText()) > Double.parseDouble(lbl_frac1.getText()))) {
                                Mywindows.OuputText(massage, "Montant invalider", alert_paiement, true);
                            } else {
                                if (getInstanceT().getprepare("Call sp_paiement ('" + Tfd_montant.getText() + "','" + getId().getText() + "'," + 1 + ")") == true) {
                                    Tfd_montant.setText("0.0");
                                    getId().setText("00");
                                    Mywindows.OuputText(massage, "Paiement réussi ", alert_paiement, false);
                                    init();
                                } else {
                                    Mywindows.OuputText(massage, "Paiement échouer ", alert_paiement, true);
                                }
                            }
                        } catch (NumberFormatException | SQLException ex) {
                            Logger.getLogger(Other_paiementController.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                Connexion.isConnected().rollback();
                            } catch (SQLException ex) {
                                Logger.getLogger(Other_paiementController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                }
            } else {
                Mywindows.OuputText(massage, "Commande invalider", alert_paiement, true);
            }
        });
    }

    void testCaract() {
        Tfd_montant.setOnKeyReleased((value) -> {
            Traitement.getInstanceT().isNumerique(Tfd_montant);

        });

    }

    private Label getId() {
        return getId1;
    }

    public void setId(Label id) {
        this.getId1 = id;
    }

    private Label getMontant() {
        return getId1;
    }

    public void setMontant(Label id) {
        this.getId1 = id;
    }
    private volatile static Other_paiementController getOther;

    public static Other_paiementController getOther() {
        if (getOther == null) {
            synchronized (Other_paiementController.class) {
                if (getOther == null) {
                    getOther = new Other_paiementController();
                }
            }

        }
        return getOther;
    }

    void init() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 4);
            } catch (SQLException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(orther_paiement_detteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
