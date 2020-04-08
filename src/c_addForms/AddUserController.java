/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_addForms;

import static Elementary.Mywindows.getInstanceL;
import static Elementary.Traitement.getDifGenre;
import Elementary.View_gui;
import static Elementary.references.LOAD_UTILISATEUR;
import c_parametre.UserController;
import static c_parametre.UserController.Rvbx_PU;
import champs.champs_vide;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lib.utilisateur.ImplementUtilisateurDao;
import lib.utilisateur.UtilisateurDao;
import static lib.utilisateur.UtilisateurDao.getUtilisateur;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class AddUserController implements Initializable {

    @FXML
    private Text title;
    @FXML
    private Text title1;
    @FXML
    private TextField txtnoms;
    @FXML
    private Label txtgenre;
    @FXML
    private Label genreicon;
    @FXML
    private TextField txttelephone;
    @FXML
    private JFXButton btAdd;
    @FXML
    private Text message;
    @FXML
    private Label icon;
    @FXML
    private ComboBox<String> comboFonction;
    ImplementUtilisateurDao utilisateur;
    UtilisateurDao utilisateurDoa;
    @FXML
    private TextField txtmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        utilisateur = new ImplementUtilisateurDao();
        comboFonction.getItems().addAll("CAISSIER", "COMPTABLE", "RESPONSABLE");
        getUtilisateur().setStat_("0");
        System.out.println(getUtilisateur().getStat_());

    }

    @FXML
    private void changeGenre(ActionEvent event) throws Exception {
        txtgenre.setText(getDifGenre(txtgenre.getText(), genreicon));
    }

    @FXML
    private void AddUser(ActionEvent event) {
        if (!champs_vide.isFieldsempty(txtmail, txtnoms, txttelephone, txtmail)) {
            if (getUtilisateur().getStat_().equals("0")) {
                utilisateurDoa = new UtilisateurDao(txtnoms.getText(), txtgenre.getText(), txttelephone.getText(), txtmail.getText(), comboFonction.getValue(), "0");
            } else {
                utilisateurDoa = new UtilisateurDao(txtnoms.getText(), txtgenre.getText(), txttelephone.getText(), txtmail.getText(), comboFonction.getValue(), getUtilisateur().getStat_());
            }
            utilisateur.Ajouter(utilisateurDoa);
            CallWindow.Callwindow.initFields(txtnoms, txttelephone, txtmail, comboFonction);
             try {
            getInstanceL().ScrollwithHBX(Rvbx_PU, View_gui.getIns().getService(8, "SELECT * FROM vs_utilisateur"), LOAD_UTILISATEUR, 2);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }

}
