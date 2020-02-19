/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Akim
 */
public class Alert {

    static MaterialDesignIconView mat;
    static Thread loading;
    static Thread out;

    public static void Ouput(Text message, Label icon, String str, ImageView image, Button bt, boolean load, boolean error) {
        if (error) {
            mat = new MaterialDesignIconView(MaterialDesignIcon.ALERT_OUTLINE);
            mat.setGlyphSize(27);
            message.setFill(Color.web("#c95a5a"));
            mat.setStyle("-fx-fill:#c95a5a");
        } else {
            mat = new MaterialDesignIconView(MaterialDesignIcon.CHECKBOX_MULTIPLE_MARKED_OUTLINE);
            mat.setGlyphSize(27);
            message.setFill(Color.web("#6A75CA"));
            mat.setStyle("-fx-fill:#6A75CA");

        }
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(1000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        icon.setGraphic(mat);
                    }
                });
                icon.setVisible(true);
                message.setText(str);
                Thread.sleep(3000);
                message.setText("");
                icon.setVisible(false);
                bt.setDisable(false);

                return null;
            }
        };
        loading = new Thread() {
            @Override
            public void run() {
                try {
                    image.setVisible(true);
                    Thread.sleep(3500);
                    image.setVisible(false);
                    new Thread(task).start();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mywindows.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        out = new Thread() {
            @Override
            public void run() {
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            icon.setGraphic(mat);
                        }
                    });
                    icon.setVisible(true);
                    message.setText(str);
                    Thread.sleep(3000);
                    message.setText("");
                    icon.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mywindows.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        if (load) {
            bt.setDisable(true);
            loading.start();
        } else {
            out.start();
        }

    }
}
