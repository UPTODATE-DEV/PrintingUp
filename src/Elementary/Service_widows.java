/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import animatefx.animation.ZoomInLeft;
import animatefx.animation.ZoomInRight;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import static javafx.concurrent.Worker.State.CANCELLED;
import static javafx.concurrent.Worker.State.FAILED;
import static javafx.concurrent.Worker.State.SUCCEEDED;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Akim
 */
public class Service_widows {

    private void Login() {
        final Service<Void> calculateService = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {
                        while (true) {
                            //Synchro();
                        }
                    }
                };
            }
        };
        calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue) {
                case FAILED:
                    System.out.println("Interrupu traitement \nRelance en cours.....");
                    Login() ;
                    break;
                case CANCELLED:
                    System.out.println("cancelled traitement \nRelance en cours.....");
                Login() ;
                    break;
                case SUCCEEDED:
                    System.out.println("Correct traitement \nRelance en cours.....");
                 Login() ;
                    break;
            }
        });
        calculateService.start();
    }
     public void showMssge(Label lab, FontAwesomeIconView icon, String mssg, int etat) {
        if (etat == 1) {
            lab.setVisible(true);
            icon.setVisible(true);
            icon.setIcon(FontAwesomeIcon.CHECK);
            icon.setFill(Paint.valueOf("#05abf2"));
            lab.setTextFill(Color.web("#05abf2"));
            lab.setText(mssg);
            new ZoomInRight(lab).play();
            new ZoomInRight(icon).play();
        } else {
            lab.setVisible(true);
            icon.setVisible(true);
            icon.setIcon(FontAwesomeIcon.EXCLAMATION_TRIANGLE);
            icon.setFill(Paint.valueOf("#ff0000"));
            lab.setTextFill(Color.RED);
            lab.setText(mssg);
            new ZoomInRight(lab).play();
            new ZoomInRight(icon).play();
        }
        try {
            lab.setVisible(true);

            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        new ZoomInLeft(lab).play();
                        new ZoomInLeft(icon).play();
                        lab.setVisible(false);
                        icon.setVisible(false);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Service_widows.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            th.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
