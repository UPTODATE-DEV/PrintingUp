/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import static Elementary.Connexion.isConnected;
import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import Elementary.Traitement;
import static Elementary.Traitement.dateB;
import Elementary.View_gui;
import static Elementary.references.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import static controllers.PrincipaleController.bool;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class CommandeController implements Initializable {

    @FXML
    private AnchorPane p2;
    @FXML
    private AnchorPane p3;

    @FXML
    private JFXButton btn_commande_;
    @FXML
    private VBox vb_commande;
    @FXML
    private TextField Tfl_search;
    public static VBox vb_commande1;
    private Label lbl_dette;
    private Label lbl_attente;
    private Label lblEncours;
    private Label lbldisponible;
    @FXML
    private JFXButton btn_dette;
    @FXML
    private JFXButton btn_attent;
    @FXML
    private JFXButton btn_encours;
    @FXML
    private JFXButton btn_disponible;
    @FXML
    private AnchorPane p4;
    @FXML
    private AnchorPane p5;
    int status = 1;
    @FXML
    private MaterialDesignIconView i2;
    @FXML
    private MaterialDesignIconView i3;
    @FXML
    private MaterialDesignIconView i4;
    @FXML
    private MaterialDesignIconView i5;
    @FXML
    private Text s_commande_rappor;
    @FXML
    private GridPane menu_ok;
    @FXML
    private MaterialDesignIconView i31;
    @FXML
    private JFXButton btAdd;
    @FXML
    private AnchorPane p_commande;
    @FXML
    private JFXButton btn_commande;
    private StackPane stackPane_commande;
    public static StackPane stackPane_;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private Label dette;
    @FXML
    private Label caisse;
    @FXML
    private Label total;
    private ImageView emojis;
    @FXML
    private AnchorPane emojis_;
    @FXML
    private TextField lab_search;
    @FXML
    private AnchorPane emojis_all;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        stackPane_ = stackPane_commande;
        if (status == 1) {
            recherche();
            s_commande_rappor.setText("Commande");
            getInstanceL().SelectDataFor(p_commande, p3, p2, p4, p5);
            getInstanceL().SelectDataFor1(btn_commande, btn_attent, btn_dette, btn_encours, btn_disponible);
            init(1);
            if (getInstanceL().resulta != 0) {
                emojis_.setVisible(false);
            } else {
                emojis_.setVisible(true);
            }
            emojis_all.setVisible(false);
            // DOSynchro();
            initTread1();
            isSearch();
            date_fin.setValue(LocalDate.now());
            date_debut.setValue(LocalDate.now());

        }

    }

    void init(int x) {

        vb_commande1 = vb_commande;
        try {

            try {
                switch (x) {
                    case 1:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement"), PRINT_CMD, 2);
                        break;
                    case 2:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours Where statis='Fin'"), LOAD_PRINT_FIN, 2);
                        break;
                    case 3:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours where statis='Attente'"), LOAD_PRINT_LISTDETTE, 2);
                        break;
                    case 4:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(5, "SELECT * FROM client_dette"), PRINT_PAIEMENT_DETTE, 2);
                        break;
                    case 5:
                        getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(4, "SELECT * FROM new_test_encours where statis='Encours'"), LOAD_PRINT_ENCOURS, 2);
                        break;
                    case 6:

                        break;

                }
            } catch (SQLException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void initTreed() {
        if (isConnected() != null) {
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Attente'")) > 0) {
                i3.setVisible(true);
            } else {
                i3.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Encours'")) > 0) {
                i4.setVisible(true);

            } else {
                i4.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM tbl_exe_commande where statis='Fin'")) > 0) {
                i5.setVisible(true);
            } else {
                i5.setVisible(false);
            }
            if (Integer.parseInt(Traitement.getInstanceT().getValue("SELECT count(id) x FROM client_dette")) > 0) {
                i2.setVisible(true);
            } else {
                i2.setVisible(false);
            }
        }
    }

    public void initTread1() {
        Thread clock;
        clock = new Thread() {
            @Override
            public void run() {
                for (;;) {

                    try {
                        initTreed();
                        System.out.println("En cours...");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();
    }

//    private void DOSynchro() {
//        final Service<Void> calculateService = new Service<Void>() {
//
//            @Override
//            protected Task<Void> createTask() {
//                return new Task<Void>() {
//
//                    @Override
//                    protected Void call() throws Exception {
//                        while (true) {
//                            try {
//                                initTreed();
//                                System.out.println("En cours...");
//                            } catch (Exception ex) {
//                                System.out.println(ex.getMessage());
//                            }
//
//                        }
//                    }
//                };
//            }
//        };
//        calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
//            switch (newValue) {
//                case FAILED:
//                    System.out.println("Interrupu traitement \nRelance en cours.....");
//                    DOSynchro();
//                    break;
//                case CANCELLED:
//                    System.out.println("cancelled traitement \nRelance en cours.....");
//                    DOSynchro();
//                    break;
//                case SUCCEEDED:
//                    System.out.println("Correct traitement \nRelance en cours.....");
//                    DOSynchro();
//                    break;
//            }
//        });
//        calculateService.start();
//    }
    @FXML
    private void Call_windows(ActionEvent event) throws IOException {
        if (event.getSource() == btn_dette) {
            //  popOverMenu(p2, getClass().getResource(LOAD_PRINT_DETTE), PopOver.ArrowLocation.TOP_CENTER);
            // getInstanceL().SelectDataFor(p2, p1, p31, p3);
            getInstanceL().SelectDataFor(p2, p3, p4, p5, p_commande);
            getInstanceL().SelectDataFor1(btn_dette, btn_attent, btn_encours, btn_disponible, btn_commande);
            status = 2;
            init(4);
            if (getInstanceL().resulta == 0) {
                emojis_.setVisible(true);
            } else {
                emojis_.setVisible(false);
            }
        } else if (event.getSource() == btn_attent) {
            // popOverMenu(p1, getClass().getResource(PRINT_DETTE), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p3, p2, p4, p5, p_commande);
            getInstanceL().SelectDataFor1(btn_attent, btn_dette, btn_encours, btn_disponible, btn_commande);
            init(3);
            status = 3;
            if (getInstanceL().resulta == 0) {
                emojis_.setVisible(true);
            } else {
                emojis_.setVisible(false);
            }
        } else if (event.getSource() == btn_encours) {
            //  popOverMenu(p31, getClass().getResource(LOAD_ENCOURS), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p4, p3, p2, p5, p_commande);
            getInstanceL().SelectDataFor1(btn_encours, btn_attent, btn_dette, btn_disponible, btn_commande);
            status = 4;
            init(5);
            if (getInstanceL().resulta == 0) {
                emojis_.setVisible(true);
            } else {
                emojis_.setVisible(false);
            }
        } else if (event.getSource() == btn_disponible) {
            // popOverMenu(p3, getClass().getResource(LOAD_PRINT_DISPONIBLE), PopOver.ArrowLocation.TOP_CENTER);
            getInstanceL().SelectDataFor(p5, p4, p3, p2, p_commande);
            getInstanceL().SelectDataFor1(btn_disponible, btn_encours, btn_attent, btn_dette, btn_commande);
            status = 5;
            init(2);
            if (getInstanceL().resulta == 0) {
                emojis_.setVisible(true);
            } else {
                emojis_.setVisible(false);
            }
        } else if (event.getSource() == btn_commande) {
            getInstanceL().SelectDataFor(p_commande, p2, p3, p4, p5);
            getInstanceL().SelectDataFor1(btn_commande, btn_dette, btn_attent, btn_encours, btn_disponible);
            status = 1;
            init(1);
            if (getInstanceL().resulta == 0) {
                emojis_.setVisible(true);
            } else {
                emojis_.setVisible(false);
            }
        }
//        else if (event.getSource() == btn_commande1) {
//

//        }
    }

    @FXML
    private void getadd(ActionEvent event) throws IOException {
        if (event.getSource() == btn_commande_) {
            Mywindows.showFormDialog(getClass().getResource(ADDCOMMANDE), JFXDialog.DialogTransition.CENTER, 360, 490);
        }
    }

    void recherche() {

        Tfl_search.setOnKeyReleased((e) -> {
            switch (status) {
                case 1:
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(3,
                                        "SELECT * FROM new_vs_print2_paiement WHERE nom LIKE '%"
                                        + Tfl_search.getText()
                                        + "%' OR id LIKE '%" + Tfl_search.getText() + "%'"), PRINT_CMD, 2);

                        if (getInstanceL().resulta == 0) {
                            emojis_.setVisible(true);
                        } else {
                            emojis_.setVisible(false);
                        }

                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(5,
                                        "SELECT * FROM client_dette WHERE (nom LIKE '%"
                                        + Tfl_search.getText()
                                        + "%' OR id LIKE '%" + Tfl_search.getText() + "%')"), PRINT_PAIEMENT_DETTE, 2);
                        if (getInstanceL().resulta == 0) {
                            emojis_.setVisible(true);
                        } else {
                            emojis_.setVisible(false);
                        }
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(4,
                                        "SELECT * FROM new_test_encours Where (statis='Attente') AND (nom LIKE '%"
                                        + Tfl_search.getText()
                                        + "%' OR id LIKE '%" + Tfl_search.getText() + "%')"), LOAD_PRINT_DETTE, 2);
                        if (getInstanceL().resulta == 0) {
                            emojis_.setVisible(true);
                        } else {
                            emojis_.setVisible(false);
                        }
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 4:
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(4,
                                        "SELECT * FROM new_test_encours Where (statis='Encours') AND (nom LIKE '%"
                                        + Tfl_search.getText()
                                        + "%' OR id LIKE '%" + Tfl_search.getText() + "%')"), LOAD_PRINT_ENCOURS, 2);
                        if (getInstanceL().resulta == 0) {
                            emojis_.setVisible(true);
                        } else {
                            emojis_.setVisible(false);
                        }
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 5:
                    try {
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(4,
                                        "SELECT * FROM new_test_encours Where (statis='Fin') AND (nom LIKE '%"
                                        + Tfl_search.getText()
                                        + "%' OR id LIKE '%" + Tfl_search.getText() + "%')"), LOAD_PRINT_FIN, 2);
                        if (getInstanceL().resulta == 0) {
                            emojis_.setVisible(true);
                        } else {
                            emojis_.setVisible(false);
                        }
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    break;
            }

        });
    }
    String id_co, id_co1;

    @FXML
    private void synchro(ActionEvent event) {
        try {
            dette.setText(getInstanceL().ismac_up("SELECT sum(rester) x FROM vs_paiement_date_01 WHERE date_format(date_,'%Y-%m-%d') BETWEEN '" + dateB(date_debut) + "' AND '" + dateB(date_fin) + "'"));
            total.setText(getInstanceL().ismac_up("SELECT sum(montant) x FROM vs_paiement_date_01 WHERE date_format(date_,'%Y-%m-%d') BETWEEN '" + dateB(date_debut) + "' AND '" + dateB(date_fin) + "'"));
            caisse.setText(getInstanceL().ismac_up("SELECT sum(payer) x FROM vs_paiement_date_01 WHERE date_format(date_,'%Y-%m-%d') BETWEEN '" + dateB(date_debut) + "' AND '" + dateB(date_fin) + "'"));
            id_co = getInstanceL().ismac_up("SELECT min(id) x FROM vs_paiement_date_01 WHERE date_format(date_,'%Y-%m-%d') BETWEEN '" + dateB(date_debut) + "' AND '" + dateB(date_fin) + "'");
            id_co1 = getInstanceL().ismac_up("SELECT max(id) x FROM vs_paiement_date_01 WHERE date_format(date_,'%Y-%m-%d') BETWEEN '" + dateB(date_debut) + "' AND '" + dateB(date_fin) + "'");
            getInstanceL().ScrollwithHBX(vb_commande1, View_gui.getIns().getService(3, "SELECT * FROM new_vs_print2_paiement WHERE id BETWEEN '" + id_co + "' AND '" + id_co1 + "'"), PRINT_CMD, 2);
            if (getInstanceL().resulta != 0) {
                emojis_.setVisible(false);
            } else {
                emojis_.setVisible(true);
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    int t = 0;

    void isSearch() {
        lab_search.setOnKeyReleased((e) -> {
            emojis_all.setVisible(true);

            try {
                switch (t) {
                    case 0:
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(3,
                                        "SELECT * FROM new_vs_print2_paiement WHERE nom LIKE '%"
                                        + lab_search.getText()
                                        + "%' OR id LIKE '%" + lab_search.getText() + "%'"), PRINT_CMD, 2);
                        if (getInstanceL().resulta == 0) {
                            t = 1;
                        }
                        break;
                    case 1:
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(5,
                                        "SELECT * FROM client_dette WHERE (nom LIKE '%"
                                        + lab_search.getText()
                                        + "%' OR id LIKE '%" + lab_search.getText() + "%')"), PRINT_PAIEMENT_DETTE, 2);
                        if (getInstanceL().resulta == 0) {
                            t = 2;
                        }
                        break;
                    case 2:
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(4,
                                        "SELECT * FROM new_test_encours Where (statis='Attente') AND (nom LIKE '%"
                                        + lab_search.getText()
                                        + "%' OR id LIKE '%" + lab_search.getText() + "%')"), LOAD_PRINT_DETTE, 2);
                        if (getInstanceL().resulta == 0) {
                            t = 3;
                        }
                        break;
                    case 3:
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(4,
                                        "SELECT * FROM new_test_encours Where (statis='Encours') AND (nom LIKE '%"
                                        + lab_search.getText()
                                        + "%' OR id LIKE '%" + lab_search.getText() + "%')"), LOAD_PRINT_ENCOURS, 2);
                        if (getInstanceL().resulta == 0) {
                            t = 4;
                        }
                        break;
                    case 4:
                        getInstanceL().ScrollwithHBX(vb_commande,
                                View_gui.getIns().getService(4,
                                        "SELECT * FROM new_test_encours Where (statis='Fin') AND (nom LIKE '%"
                                        + lab_search.getText()
                                        + "%' OR id LIKE '%" + lab_search.getText() + "%')"), LOAD_PRINT_FIN, 2);
                        if (getInstanceL().resulta == 0) {
                            t = 5;
                        }
                        break;
                    case 5:
                        if (getInstanceL().resulta == 0) {
                            emojis_.setVisible(true);
                        } else {
                            emojis_.setVisible(false);
                        }
                        emojis_all.setVisible(false);
                        t = 0;
                        break;
                    default:
                        break;
                }

            } catch (SQLException | IOException ex) {
                Logger.getLogger(CommandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

//    private void Login() {
//        emojis_all.setVisible(true);
//        final Service<Void> calculateService = new Service<Void>() {
//            @Override
//            protected Task<Void> createTask() {
//                return new Task<Void>() {
//                    @Override
//                    protected Void call() throws Exception {
//                        isSearch();
//                        return null;
//                    }
//                };
//            }
//        };
//        calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
//            switch (newValue) {
//                case FAILED:
//                    emojis_all.setVisible(false);
//                    break;
//                case CANCELLED:
//                    emojis_all.setVisible(false);
//
//                case SUCCEEDED:
//                    if (getInstanceL().resulta == 0) {
//                        emojis_.setVisible(true);
//                    } else {
//                        emojis_.setVisible(false);
//                    }
//                    break;
//            }
//        });
//        calculateService.start();
//    }
}
