/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Alerts;
import Elementary.Mywindows;
import static Elementary.Mywindows.Ouput;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.initFields;
import Elementary.Traitement;
import static Elementary.View_gui.getIns;
import Elementary.references;
import static Elementary.references.PRINT_CLIENT;
import com.jfoenix.controls.JFXButton;
import static controller.commande.AddcommandeController.btn_ok;
import static controller.nouveau.NouveauController.vbx1;
import static controller.nouveau.PrintClientController.id_modifier1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lib.client.ClientDao;
import static lib.client.ImplemanteClient.Instance;

/**
 * FXML Controller class
 *
 * @author Authentique
 */
public class AddclientController implements Initializable {

    @FXML
    private Label sexe_lbl;
    int x = 0;
    @FXML
    private AnchorPane p1;
    @FXML
    private TextField nomTfd;
    @FXML
    private TextField mailTfd;
    @FXML
    private TextField adresstfd;
    @FXML
    private TextField prenomTfd;
    @FXML
    private JFXButton Btn_save;
    @FXML
    private TextField teleTfd;
    @FXML
    private Label modifierLbl;
    @FXML
    private Label icon;
    @FXML
    private Text Text;
    @FXML
    private ImageView imageviw;
    public static ClientDao client;

    public static Label sexe_lbl1;
    public static TextField nomTfd1;
    public static TextField mailTfd1;
    public static TextField adresstfd1;
    public static TextField prenomTfd1;
    public static JFXButton Btn_save1;
    public static TextField teleTfd1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sexe_lbl.setText(Mywindows.getInstanceL().sexe_change(0));
        x++;
        imageviw.setVisible(false);
        init();
    }

    void init() {
        sexe_lbl1 = sexe_lbl;
        nomTfd1 = nomTfd;
        prenomTfd1 = prenomTfd;
        mailTfd1 = mailTfd;
        adresstfd1 = adresstfd;
        teleTfd1 = teleTfd;
        Btn_save1 = Btn_save;
        //  isEmail1();
    }

    @FXML
    private void sexe_change(ActionEvent event) {
        sexe_lbl.setText(Mywindows.getInstanceL().sexe_change(x));
        if (x == 0) {
            x++;
        } else if (x != 0) {
            x--;
        }

    }
    Integer lab = 1;

    @FXML
    private void Traitement_client(ActionEvent event) throws Exception {
        if (event.getSource() == Btn_save) {
            if (Btn_save1.getText().equals("Modifier")) {
                client = new ClientDao(nomTfd.getText(), prenomTfd.getText(), sexe_lbl.getText(), teleTfd.getText(), mailTfd.getText(), adresstfd.getText(), "2", Integer.toString(Integer.parseInt(id_modifier1.getText())));
            } else {
                client = new ClientDao(nomTfd.getText(), prenomTfd.getText(), sexe_lbl.getText(), teleTfd.getText(), mailTfd.getText(), adresstfd.getText(), "1", "0");
            }
            if (!getInstanceL().isFieldsempty(nomTfd, prenomTfd, sexe_lbl, teleTfd, mailTfd, adresstfd) == false) {
                Instance().Enregistrer(client);
                if (Btn_save1.getText().equals("Modifier")) {
                    Ouput(Text, icon, references.getInstanceE().MESSAGE_MODIFY, imageviw, btn_ok, true, false);
                } else {
                    Ouput(Text, icon, references.getInstanceE().MESSAGE_SAVE, imageviw, btn_ok, true, false);
                }
                initFields(false, nomTfd, prenomTfd, teleTfd, mailTfd, adresstfd);
                getInstanceL().ScrollwithHBX(vbx1, getIns().getService(2, "SELECT * FROM tbl_client"), PRINT_CLIENT, 4);

            } else {
                Ouput(Text, icon, references.getInstanceE().MESSAGE_ISMPTY, imageviw, btn_ok, true, true);
            }

        }
    }

    void isEmail1() {
        mailTfd.setOnKeyPressed((e) -> {
            Traitement.isEmail(mailTfd);
        });
    }

}
