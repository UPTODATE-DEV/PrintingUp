/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.Ouput;
import static Elementary.Mywindows.isSaved;
import Elementary.references;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class AddcommandeController implements Initializable {

    @FXML
    private TextField Tfdservice;
    @FXML
    private TextField TfdQuantite;
    @FXML
    private JFXButton btn_commande;
    @FXML
    private TextField Tfdtype_service;
    @FXML
    private TextField TfdPunitaire;
    @FXML
    private Label Tfd_code;
    @FXML
    private Label id_commande;
    @FXML
    private TextField Tfdclient;
    @FXML
    private JFXButton btn_test_;
    @FXML
    private Label icon;
    @FXML
    private Text Text;
    @FXML
    private ImageView imageviw;

    public static Button btn_ok = new Button();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Init();
    }

    void Init() {
        imageviw.setVisible(false);
       
        btn_ok.setVisible(false);
        Mywindows.getInstanceL().ChargememtCompression(Tfdservice, "tbl_svc", "designation", null);
        Mywindows.getInstanceL().ChargememtCompression(Tfdtype_service, "tbl_type", "designation", null);
        Mywindows.getInstanceL().ChargememtCompression(Tfdclient, "tbl_client", "nom", null);
        mouci();
    }

    @FXML
    private void Traitement_commande(ActionEvent event) throws Exception {
        if (event.getSource() == btn_commande) {
            if (!id_commande.getText().equals("0")) {
                if (!Mywindows.getInstanceL().isFieldsempty(Tfdservice, TfdPunitaire, Tfdtype_service, Tfdclient)) {
                    if (Double.parseDouble(TfdQuantite.getText()) > 0) {
                        save(1);
                    }
                }
            }
        }
    }
    private String query = "SELECT MAX(id) x FROM tbl_entecommande";

    public int isIdcommande(String client) throws Exception {
        if (isSaved("sp_commande", "PROCEDURE", Tfd_code, Tfdclient, 1) == true) {
            return Integer.parseInt(Mywindows.getInstanceL().ismac_up(query));
        }
        return 0;
    }

    @FXML
    private void getadd(ActionEvent event) throws Exception {
        if (event.getSource() == btn_test_) {
            getClient();
        }
    }

    void mouci() {
        try {
            TfdQuantite.setOnMousePressed((e) -> {
                String qry = "select SR.pu x FROM tbl_svc s INNER JOIN tbl_service SR ON s.id=SR.designation INNER JOIN tbl_type t ON\n"
                        + "t.id=SR.type_ WHERE s.designation='" + Tfdservice.getText() + "' AND t.designation='" + Tfdtype_service.getText() + "'";
                if (Double.parseDouble(Mywindows.getInstanceL().ismac_up(qry)) == 0.0) {
                    TfdPunitaire.setText("0.0");
                } else {
                    TfdPunitaire.setText(Double.toString(Double.parseDouble(Mywindows.getInstanceL().ismac_up(qry))));
                }

            });
            Tfdclient.setOnKeyReleased((e) -> {
                if (e.getCode() == KeyCode.ENTER) {
                    getClient();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void save(int c) throws Exception {
        if (isSaved("sp_Dcommande", "PROCEDURE", Tfd_code, TfdPunitaire, TfdQuantite, id_commande, Tfdservice, c, Tfdtype_service) == true) {
            Ouput(Text, icon, references.getInstanceE().MESSAGE_SAVE, imageviw, btn_ok, true, false);
        }
    }

    void getClient() {
        if (!Mywindows.getInstanceL().isFieldsempty(Tfdclient)) {
            try {
                if (Integer.parseInt(id_commande.getText()) == 0) {
                    id_commande.setText(Integer.toString(isIdcommande(Tfdclient.getText())));
                }
            } catch (Exception ex) {
                Logger.getLogger(AddcommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Cree d'abord le numero commande");
        }
    }

}
