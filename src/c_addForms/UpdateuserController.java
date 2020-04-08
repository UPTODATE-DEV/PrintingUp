/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_addForms;

import Elementary.Traitement;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lib.user.ImplementeIUser;
import lib.user.UserDao;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class UpdateuserController implements Initializable {

    @FXML
    private Circle logo;
    @FXML
    private TextField txtnoms;
    @FXML
    private TextField txttelephone;
    @FXML
    private TextField mail;
    @FXML
    private TextField nomUtilisateur;
    @FXML
    private PasswordField motdepasse;
    @FXML
    private PasswordField confrmotdepasse;
    @FXML
    private JFXButton btAdd;
    @FXML
    private Text message;
    @FXML
    private Label icon;

    public static TextField txtnoms_;
    public static TextField mail_;
    public static TextField txttelephone_;
    public static String niveau_;
    @FXML
    private CheckBox l1;
    @FXML
    private CheckBox l2;
    @FXML
    private CheckBox l3;
    @FXML
    private CheckBox l4;
    int x = 1;
    UserDao userdao;
    ImplementeIUser user;
    @FXML
    private Label lb_pwd;
    @FXML
    private Label confpwd;
    boolean bool = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtnoms_ = txtnoms;
        txttelephone_ = txttelephone;
        mail_ = mail;
        user = new ImplementeIUser();
        permission();

    }

    void permission() {
        if (niveau_.equals("Invalide")) {
            l1.setSelected(true);
            l1.setIndeterminate(true);
            l2.setSelected(true);
            l2.setIndeterminate(true);
            l3.setSelected(true);
            l3.setIndeterminate(true);
            l4.setSelected(true);
            l4.setIndeterminate(true);
        } else if (niveau_.equals("4")) {
            l1.setSelected(true);
            l2.setSelected(true);
            l3.setSelected(true);
            l4.setSelected(true);
        } else if (niveau_.equals("3")) {
            l1.setSelected(true);
            l2.setSelected(true);
            l3.setSelected(true);
            l4.setSelected(true);
            l4.setIndeterminate(true);
        } else if (niveau_.equals("2")) {
            l1.setSelected(true);
            l2.setSelected(true);
            l3.setSelected(true);
            l3.setIndeterminate(true);
            l4.setSelected(true);
            l4.setIndeterminate(true);
        } else if (niveau_.equals("1")) {
            l1.setSelected(true);
            l2.setSelected(true);
            l2.setIndeterminate(true);
            l3.setSelected(true);
            l3.setIndeterminate(true);
            l4.setSelected(true);
            l4.setIndeterminate(true);
        }
        motdepasse.setOnKeyReleased((e) -> {
            if (motdepasse.getText().length() >= 4) {
                lb_pwd.setGraphic(Traitement.getInstanceT().font("-fx-fill:#71B171", MaterialDesignIcon.CHECK));
                confpwd.setText(null);
            } else {
                lb_pwd.setGraphic(Traitement.getInstanceT().font("-fx-fill:#DC4F1B", MaterialDesignIcon.CLOSE));
            }
        });
        confrmotdepasse.setOnKeyReleased((e) -> {
            if (Traitement.pwd_crypte_md5(motdepasse.getText()).equals(Traitement.pwd_crypte_md5(confrmotdepasse.getText()))) {
                confpwd.setGraphic(Traitement.getInstanceT().font("-fx-fill:#71B171", MaterialDesignIcon.CHECK));
                bool = true;
            } else {
                confpwd.setGraphic(Traitement.getInstanceT().font("-fx-fill:#DC4F1B", MaterialDesignIcon.CLOSE));
                bool = false;
            }
        });
        motdepasse.setOnMouseClicked((e) -> {
            motdepasse.setText(null);
        });
        confrmotdepasse.setOnMouseClicked((e) -> {
            confrmotdepasse.setText(null);
        });

    }

    @FXML
    private void AddUser(ActionEvent event) {
        userdao = new UserDao(nomUtilisateur.getText()
                , confrmotdepasse.getText()
                , level(), txtnoms.getText()
                , txttelephone.getText()
                , mail.getText());
        
        if (!champs.champs_vide.isFieldsempty(nomUtilisateur, confrmotdepasse, txtnoms, txttelephone, mail)) {
            if (bool) {
                user.ajouter(userdao);
            } else {
                confpwd.setGraphic(Traitement.getInstanceT().font("-fx-fill:#DC4F1B", MaterialDesignIcon.CLOSE));
                lb_pwd.setGraphic(Traitement.getInstanceT().font("-fx-fill:#DC4F1B", MaterialDesignIcon.CLOSE));
                motdepasse.requestFocus();
            }
        } else {

        }

    }

    String level() {
        if (l1.isSelected() == true
                && l2.isSelected() == true
                && l3.isSelected() == true
                && l4.isSelected() == true) {
            return "4";
        } else if (l1.isSelected() == true
                && l2.isSelected() == true
                && l3.isSelected() == true) {
            return "3";
        } else if (l1.isSelected() == true
                && l2.isSelected() == true) {
            return "2";
        } else if (l1.isSelected() == true) {
            return "1";
        }
        return null;
    }

}
