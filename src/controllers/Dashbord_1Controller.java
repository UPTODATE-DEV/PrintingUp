/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static Elementary.Connexion.*;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.Traitement.dateB;
import static Elementary.View_gui.getIns;
import static Elementary.references.PRINT_SERVICE;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class Dashbord_1Controller implements Initializable {

    @FXML
    private VBox vbx;
    @FXML
    private VBox vb_service;
    public static VBox vb_serce;
    private StackedBarChart<String, Integer> stackedBar;
    XYChart.Series<String, Integer> series = new XYChart.Series<>();
    @FXML
    private PieChart staticView;
    ObservableList<PieChart.Data> data;
    private PreparedStatement pst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            vb_serce = vb_service;
            vb_service.setSpacing(45);
            pieChat(1, null, null);
            staticView.setData(data);
            //  stackedBar.getData().add(series);
              getInstanceL().ScrollwithHBX(vb_serce, getIns().getService(7, "SELECT * FROM new_print_dashboard_2 "), PRINT_SERVICE, 3);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Dashbord_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pieChat(int c, DatePicker d1, DatePicker d2) throws SQLException {
        data = FXCollections.observableArrayList();
        if (c != 1) {
            pst = isConnected().prepareStatement("SELECT * FROM new_print_dashboard_2 WHERE date_ BETWEEN '" + dateB(d1) + "' AND '" + dateB(d2) + "'");
        } else {
            pst = isConnected().prepareStatement("SELECT * FROM new_print_dashboard_2 WHERE date_ ='" + LocalDate.now().toString() + "'");
        }
        rst = pst.executeQuery();
        while (rst.next()) {
            data.add(new PieChart.Data(rst.getString("service"), rst.getInt("nbre")));
            System.out.println("Evenement clic");
        }
    }

}
