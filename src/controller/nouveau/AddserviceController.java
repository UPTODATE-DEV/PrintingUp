/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nouveau;

import Elementary.Mywindows;
import static Elementary.Mywindows.Ouput;
import static Elementary.Mywindows.initFields;
import static Elementary.Mywindows.isSaved;
import Elementary.references;
import com.jfoenix.controls.JFXButton;
import static controller.commande.AddcommandeController.btn_ok;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import lib.service.ImplementeService;
import lib.service.ServiceDao;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class AddserviceController implements Initializable {

    @FXML
    private TextField Tfdservice;
    @FXML
    private TextField Tfdtype_service;
    @FXML
    private TextField Tfdpunitaire;
    @FXML
    private JFXButton btn_save;
    @FXML
    private Label Tfd_code;
    @FXML
    private Label icon;
    @FXML
    private Text Text;
    @FXML
    private ImageView imageviw;
    public static ServiceDao service;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Mywindows.getInstanceL().ChargememtCompression(Tfdservice, "tbl_svc", "designation", null);
        Mywindows.getInstanceL().ChargememtCompression(Tfdtype_service, "tbl_type", "designation", null);
        imageviw.setVisible(false);
    }

    @FXML
    private void Traitement_service(ActionEvent event) throws Exception {
        if (event.getSource() == btn_save) {
            if (!Mywindows.getInstanceL().isFieldsempty(Tfdservice, Tfdpunitaire, Tfdtype_service)) {
                service = new ServiceDao(Tfd_code.getText(), Tfdservice.getText(), Float.parseFloat(Tfdpunitaire.getText()), Tfdtype_service.getText(), "1");
                if (Double.parseDouble(Tfdpunitaire.getText()) > 0) {
                    new ImplementeService().Enregistrer(service);
                    Ouput(Text, icon, references.getInstanceE().MESSAGE_SAVE, imageviw, btn_ok, true, false);
                    initFields(false, Tfdservice, Tfdpunitaire, Tfdtype_service);

                } else {
                    Ouput(Text, icon, references.getInstanceE().MESSAGE_INFERIEUR, imageviw, btn_ok, true, true);
                }

            } else {
                Ouput(Text, icon, references.getInstanceE().MESSAGE_ISMPTY, imageviw, btn_ok, true, true);
            }
        }
    }

}
