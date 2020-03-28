/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_parametre;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Maurice
 */
public class UserController implements Initializable {

    @FXML
    private VBox vbx;
    public static VBox Rvbx_PU;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            Rvbx_PU = vbx;
//            if (rstage.isMaximized()) {
//                touIndex = 5;
//
//            } else {
//                touIndex = 4;
//
//            }
//            try {
//                ev.ScrollwithHBX(Rvbx_PU, 21, LOADUSER);
//            } catch (IOException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void refrech() throws InterruptedException, IOException {
        Thread.sleep(200);

    }

    static UserController instance;

    public static UserController getP_UserIns() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    @FXML
    private void showDialog(ActionEvent event) throws IOException {
        //  ev.ShowDialog(ADDUSER, 347, 467);
    }

}
