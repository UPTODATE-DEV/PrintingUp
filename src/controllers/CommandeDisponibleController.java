/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Elementary.Pagination_;
import Elementary.View_gui;
import Elementary.references;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class CommandeDisponibleController implements Initializable {

    @FXML
    private Label lbl_numberRegisters211;
    @FXML
    private VBox vb_box;
    @FXML
    private Pagination pgi;
    @FXML
    private TextField Tfdsearch;

    Pagination_ page;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Pagination_.vb_ = vb_box;
        Pagination_.index = 1;
        Pagination_.index_aff = 2;
        Pagination_.rqte = "SELECT * FROM tbl_exe_commande";
        Pagination_.url_ = references.LOAD_DIALOGUE_DISPONIBLE;
        page = new Pagination_(pgi, "SELECT COUNT(code_commande) FROM tbl_exe_commande");
    }

    String str;

    void init() {
        str = View_gui.getIns().list.get(Pagination_.getInstancePage().code);
    }
}
