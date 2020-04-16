/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import static javafx.concurrent.Worker.State.CANCELLED;
import static javafx.concurrent.Worker.State.FAILED;
import static javafx.concurrent.Worker.State.SUCCEEDED;

/**
 *
 * @author Akim
 */
public class Service_widows {

    private void DOSynchro() {
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
                    DOSynchro();
                    break;
                case CANCELLED:
                    System.out.println("cancelled traitement \nRelance en cours.....");
                    DOSynchro();
                    break;
                case SUCCEEDED:
                    System.out.println("Correct traitement \nRelance en cours.....");
                    DOSynchro();
                    break;
            }
        });
        calculateService.start();
    }
}
