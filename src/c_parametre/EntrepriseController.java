/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_parametre;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Maurice
 */
public class EntrepriseController implements Initializable {

    @FXML
    private Circle logo;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtrccm;
    @FXML
    private TextField txtchemin;
    @FXML
    private TextField txtadresseph;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtmail;
    @FXML
    private JFXButton btAdd;
    @FXML
    private FontAwesomeIconView chema;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        d1 = false;
        d2 = false;
        initDataOne();
        initDataTwo();
        logo("/icons/uptodate.png");
    }

    /**
     * Mes variables.
     */
    boolean d1;
    boolean d2;

    /**
     * Mes Methodes & Fonction.
     */
    void initDataOne() {
        txtnom.setEditable(d1);
        txtrccm.setEditable(d1);
        chema.setDisable(d1);

    }

    void initDataTwo() {
        txtadresseph.setEditable(d2);
        txtmail.setEditable(d2);
        txtnum.setEditable(d2);
    }

    void logo(String chema) {
        Image im = new Image(chema,false);
        logo.setFill(new ImagePattern(im));
    }

    /**
     * Mes variables.
     */
    @FXML
    private void editedate(ActionEvent event) {
        if (d1) {
            d1 = false;
        } else {
            d1 = true;
        }
        initDataOne();
    }

    @FXML
    private void editeother(ActionEvent event) {
        if (d2) {
            d2 = false;
        } else {
            d2 = true;
        }
        initDataTwo();
    }

    @FXML
    private void AddUser(ActionEvent event) {
        d1 = false;
        d2 = false;
        initDataOne();
        initDataTwo();
    }

}
