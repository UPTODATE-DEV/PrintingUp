/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commande;

import Elementary.Mywindows;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.View_gui.getIns;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class Orther_v_detteController implements Initializable {

    @FXML
    private Label Tfd_nom;
    @FXML
    private Label Tfddate;
    @FXML
    private Label Tfd_id;
    @FXML
    private MaterialDesignIconView btn_livre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initFild();
    }
    String str;

    void initFild() {
        livrecommande();
        str = getIns().list.get(getInstanceL().code);
        Tfd_id.setText(str.substring(0, str.indexOf("|")));
        Tfd_nom.setText(str.substring(str.indexOf("|") + 1, str.indexOf("^")));
        Tfddate.setText(str.substring(str.indexOf("^") + 1));

    }

    void livrecommande() {
        btn_livre.setOnMouseClicked((e) -> {
            try {
                if (!Tfd_nom.getText().isEmpty()) {
                    Mywindows.isSaved("ps_livrecommande", "PROCEDURE", Tfd_nom);
                }
            } catch (Exception ex) {
                Logger.getLogger(Orther_v_detteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
