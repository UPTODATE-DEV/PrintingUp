/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up_priting;

import static Elementary.references.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Authentique
 */
public class Up_priting extends Application {

    public static Stage stage_;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(LOGIN));
        Scene scene = new Scene(root);
        stage_ = stage;
        stage.setScene(scene);
        stage.getFullScreenExitKeyCombination();
        stage.setMaximized(true);
        //  stage.isFullScreen();
        stage.getIcons().add(new javafx.scene.image.Image("/icons/uptodate.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
