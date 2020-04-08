/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_parametre;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Maurice
 */
public class UserController implements Initializable {

    @FXML
    private VBox vbx;
    public static VBox Rvbx_PU;
    @FXML
    private JFXButton btn_call_user;
    @FXML
    private TextField tfd_rechercher;
    @FXML
    private Label rechercher_introble;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Rvbx_PU = vbx;
        try {
            getInstanceL().ScrollwithHBX(Rvbx_PU, View_gui.getIns().getService(8, "SELECT * FROM vs_utilisateur"), LOAD_UTILISATEUR, 2);
            if (getInstanceL().resulta != 0) {
                rechercher_introble.setVisible(false);
            } else {
                rechercher_introble.setVisible(true);
                rechercher_introble.setText("Pas des données disponible " + Integer.toString(getInstanceL().resulta));

            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        evenement();
    }

    public void refrech() throws InterruptedException, IOException {
        Thread.sleep(200);

    }

    static UserController instance;

    public static UserController getPuserIns() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    void evenement() {
        btn_call_user.setOnMouseClicked((e) -> {
            try {
                Mywindows.showFormDialog(getClass().getResource(ENTRER_AGENT), JFXDialog.DialogTransition.CENTER, 347, 520);
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        tfd_rechercher.setOnKeyReleased((e) -> {
            try {
                try {
                    getInstanceL().ScrollwithHBX(Rvbx_PU, View_gui.getIns().getService(8, "SELECT * FROM vs_utilisateur WHERE id LIKE '%" + tfd_rechercher.getText() + "%' OR "
                            + "nom LIKE '%" + tfd_rechercher.getText() + "%' OR sexe LIKE '%" + tfd_rechercher.getText() + "%'"), LOAD_UTILISATEUR, 2);
                    if (getInstanceL().resulta != 0) {
                        rechercher_introble.setVisible(false);
                        if (getInstanceL().resulta > 0 && getInstanceL().resulta <= 4) {
                            rechercher_introble.setVisible(true);
                            rechercher_introble.setText("Les éléments correspond à votre recherche  " + Integer.toString(getInstanceL().resulta) + " .");
                        } else {
                            rechercher_introble.setVisible(false);
                        }
                    } else {
                        rechercher_introble.setVisible(true);
                        rechercher_introble.setText("Aucun élément ne correspond à votre recherche  " + Integer.toString(getInstanceL().resulta) + " .");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
