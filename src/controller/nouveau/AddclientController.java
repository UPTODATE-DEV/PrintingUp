/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import static Elementary.Mywindows.Ouput;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.initFields;
import static Elementary.Mywindows.isSaved;
import static Elementary.View_gui.getIns;
import Elementary.references;
import static Elementary.references.PRINT_CLIENT;
import com.jfoenix.controls.JFXButton;
import com.sun.deploy.util.SessionState;
import static controller.commande.AddcommandeController.btn_ok;
import static controller.nouveau.NouveauController.vbx1;
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
import lib.client.ImplemanteClient;
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
    ClientDao client;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sexe_lbl.setText(Mywindows.getInstanceL().sexe_change(0));
        x++;
        imageviw.setVisible(false);

    }

    @FXML
    private void sexe_change(ActionEvent event) {
        sexe_lbl.setText(Mywindows.getInstanceL().sexe_change(x));
        //  getInstanceL().SelectDataFor(p1);
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
            client = new ClientDao(nomTfd.getText(), prenomTfd.getText(), sexe_lbl.getText(), teleTfd.getText(), mailTfd.getText(), adresstfd.getText(), "1", "0");
            if (!getInstanceL().isFieldsempty(nomTfd, prenomTfd, sexe_lbl, teleTfd, mailTfd, adresstfd) == false) {
                Instance().Enregistrer(client);
                Ouput(Text, icon, references.getInstanceE().MESSAGE_SAVE, imageviw, btn_ok, true, false);
                initFields(false, nomTfd, prenomTfd, teleTfd, mailTfd, adresstfd);
                  getInstanceL().ScrollwithHBX(vbx1, getIns().getService(2, "SELECT * FROM tbl_client"), PRINT_CLIENT, 4);

            } else {
                Ouput(Text, icon, references.getInstanceE().MESSAGE_ISMPTY, imageviw, btn_ok, true, true);
            }
        }
    }

}
