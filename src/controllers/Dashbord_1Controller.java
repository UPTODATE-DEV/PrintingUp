/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static Elementary.Connexion.*;
import Elementary.DoughnutChat;
import static Elementary.Mywindows.getInstanceL;
import static Elementary.View_gui.getIns;
import static Elementary.references.PRINT_SERVICE;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            pieChat();
            staticView.setData(data);
            //  stackedBar.getData().add(series);
            getInstanceL().ScrollwithHBX(vb_serce, getIns().getService(7, "SELECT * FROM new_print_dashboard_2"), PRINT_SERVICE, 4);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Dashbord_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    void pieChat() throws SQLException {
        data = FXCollections.observableArrayList();
        pst = isConnected().prepareStatement("SELECT * FROM new_print_dashboard_2 WHERE date_ BETWEEN ");
        rst = pst.executeQuery();
        while (rst.next()) {
            data.add(new PieChart.Data(rst.getString("service"), rst.getInt("nbre")));

        }
    }

}
