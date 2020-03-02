/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.Ouput;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Mywindows.isSaved;
import static Elementary.Mywindows.popOverMenu;
import static Elementary.Traitement.getInstanceT;
import Elementary.View_gui;
import static Elementary.View_gui.getIns;
import Elementary.references;
import static Elementary.references.LOAD_COMMANDE;
import static Elementary.references.LOAD_DETTE;
import static Elementary.references.OTHEPAIEMENT;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.controlsfx.control.PopOver;

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
    private VBox grideview;
    public static Label id_lab1;
    public static Label service1;
    public static Label quantite_1;
    public static Label prix_unitaire1;
    private GridPane tat_grid;
    @FXML
    private VBox vb_;
    @FXML
    private JFXButton btn_print;
    @FXML
    private Label lbl_frac;
    @FXML
    private Label lbl_dollars;
    @FXML
    private Label lbl_paiement;
    private AnchorPane pan1;
    @FXML
    private AnchorPane pan1_;
    @FXML
    private AnchorPane pan1_1;
    @FXML
    private Label lbl_paiement1;
    public static VBox vb_1;

    public static Label lbl_frac1;
    public static Label lbl_dollars1;
    public static Label id_commande1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Init();
        vb_1 = vb_;
        lbl_dollars1 = lbl_dollars;
        lbl_frac1 = lbl_frac;
    }

    void Init() {
        //initInitial();
        id_commande1 = id_commande;
        imageviw.setVisible(false);
        btn_ok.setVisible(false);
        Mywindows.getInstanceL().ChargememtCompression(Tfdservice, "tbl_svc", "designation", null);
        Mywindows.getInstanceL().ChargememtCompression(Tfdtype_service, "tbl_type", "designation", null);
        Mywindows.getInstanceL().ChargememtCompression(Tfdclient, "vs_clientConcat", "nom", null);
        mouci();
        TfdPunitaire.setEditable(false);
        //Other_paiementController.getId1 = id_commande;
        Other_paiementController.getOther().setId(id_commande);
        call_dette();
    }

    void initData() {
        try {
            Mywindows.getInstanceL().ScrollwithHBX(vb_1, getInstanceL().getCommande(), LOAD_COMMANDE, 1);
        } catch (IOException ex) {
            Logger.getLogger(AddcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Traitement_commande(ActionEvent event) throws Exception {
        if (event.getSource() == btn_commande) {
            if (!id_commande.getText().equals("0")) {
                if (!Mywindows.getInstanceL().isFieldsempty(Tfdservice, TfdPunitaire, Tfdtype_service, Tfdclient)) {
                    if (Double.parseDouble(TfdQuantite.getText()) > 0) {
                        save(1);
                        initInitial();
                        init();
                    }
                } else {
                    //OuputText(Text, icon, references.getInstanceE().MESSAGE_ISMPTY, imageviw, btn_ok, true, true);
                    Mywindows.OuputText(Text, references.getInstanceE().MESSAGE_ISMPTY, icon, true);

                }
            } else {
                Mywindows.OuputText(Text, references.getInstanceE().MESSAGE_FACT, icon, true);
            }
        }
    }

    public int isIdcommande(String client) throws Exception {
        if (isSaved("sp_commande", "PROCEDURE", Tfd_code, Tfdclient, 1) == true) {
            return Integer.parseInt(getInstanceL().ismac_up(getIns().query));
        }
        return 0;
    }

    void initInitial() {
        double mtant = Double.parseDouble(getInstanceL().ismac_up(getIns().montant + "='" + id_commande.getText() + "'"));
        lbl_frac1.setText(Double.toString(mtant));
        lbl_dollars1.setText(Double.toString(mtant / 1600));
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

                if (!Tfdtype_service.getText().isEmpty()) {
                    String qry = "select SR.pu x FROM tbl_svc s INNER JOIN tbl_service SR ON s.id=SR.designation INNER JOIN tbl_type t ON\n"
                            + "t.id=SR.type_ WHERE s.designation='" + Tfdservice.getText() + "' AND t.designation='" + Tfdtype_service.getText() + "'";
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
            Mywindows.OuputText(Text, references.getInstanceE().MESSAGE_SAVE, icon, false);
            Mywindows.initFields(true, TfdPunitaire, TfdQuantite, Tfdservice, Tfdtype_service);
            initData();
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
            Ouput(Text, icon, references.getInstanceE().MESSAGE_FACT, imageviw, btn_ok, true, true);
        }
    }

    @FXML
    private void key_testcaracteur(KeyEvent event) {
        getInstanceT().isNumerique(TfdQuantite);

    }

    @FXML
    private void callpaiement(MouseEvent event) {
        try {
            popOverMenu(pan1_, getClass().getResource(OTHEPAIEMENT), PopOver.ArrowLocation.TOP_CENTER);
        } catch (IOException ex) {
            Logger.getLogger(AddcommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void call_dette() {
        lbl_paiement1.setOnMouseClicked((value) -> {
            try {
                popOverMenu(pan1_1, getClass().getResource(LOAD_DETTE), PopOver.ArrowLocation.TOP_CENTER);
            } catch (IOException ex) {
                Logger.getLogger(AddcommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    void init() {
        try {
            try {
                getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 4);
            } catch (SQLException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
