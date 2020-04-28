/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parametrer.login;

import Elementary.Configuration;
import Elementary.Connexion;
import Elementary.Mywindows;
import static Elementary.Mywindows.openWindow;
import Elementary.Service_widows;
import Elementary.references;
import static Elementary.references.PRINCIPAL;
import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.gn.GNAvatarView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.user.ImplementeIUser;
import lib.user.UserDao;
import static up_priting.Up_priting.stage_;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class login implements Initializable {

    @FXML
    private HBox box_username;
    @FXML
    private TextField username;
    @FXML
    private HBox box_password;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label lbl_error;
    @FXML
    private Label lbl_username;
    @FXML
    private Label lbl_password;
    @FXML
    private GNAvatarView avatar;
    @FXML
    private StackPane fenetreLogin;
    private RotateTransition rotateTransition = new RotateTransition();
    @FXML
    private Hyperlink createrUser;
    private UserDao user;
    ImplementeIUser Iuser;
    @FXML
    private Label message;
    @FXML
    private FontAwesomeIconView icon;
    Configuration conf = new Configuration();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        login();
        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);
        addEffect(password);
        addEffect(username);
        setupListeners();
        Iuser = new ImplementeIUser();
        icon.setVisible(false);
        //conf.setDate(LocalDateTime.now());
        System.out.println(conf.getDate());

        // ((Stage) username.getScene().getWindow()).close();
//            CallWindow.Callwindow.GetInstance().call(references.LOAD_CLE_PRODUIT, "Saisir une clé de produit", 2, "/icons/uptodate.png");
        // Mywindows.createWindow(getClass().getResource(references.LOAD_CLE_PRODUIT), "Saisir une clé de produit", new Stage(), false);
//        ((Stage) username.getScene().getWindow()).getFullScreenExitKeyCombination();
    }

    private void addEffect(Node node) {
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -c; -fx-border-color : -primary");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!node.isFocused()) {
                node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            } else {
                node.getParent().setStyle("-icon-color : -primary; -fx-border-color : -primary");
            }
        });
    }

    private void setupListeners() {
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!validPassword()) {
                if (!newValue) {
                    Flash swing = new Flash(box_password);
                    lbl_password.setVisible(true);
                    new SlideInLeft(lbl_password).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_password.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_password.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        username.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!validUsername()) {
                if (!newValue) {
                    Flash swing = new Flash(box_username);
                    lbl_username.setVisible(true);
                    new SlideInLeft(lbl_username).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_username.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_username.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }

    @FXML
    private void switchCreate(MouseEvent event) {
        CallWindow.Callwindow.GetInstance().call("/guis/parametrer/account.fxml", "UP-PRINT", 0, "/icons/uptodate.png");
        ((Stage) username.getScene().getWindow()).close();

    }

    private boolean validPassword() {
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    private boolean validUsername() {
        return !username.getText().isEmpty() && username.getLength() > 3;
    }
    boolean bol = true;

    void login() {
        login.setOnMouseClicked((e) -> {
            testLogin();
        });
        username.setOnKeyReleased((e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (username.getText().isEmpty()) {
                    username.requestFocus();
                } else {
                    if (!password.getText().isEmpty()) {
                        testLogin();
                    } else {
                        password.requestFocus();

                    }
                }
            } else if (e.getCode() == KeyCode.ESCAPE) {
                if (bol == true) {
                    stage_.setFullScreen(bol);
                    bol = false;
                } else {
                    stage_.setFullScreen(bol);
                    bol = true;
                }
            }
        });

        password.setOnKeyReleased((e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (password.getText().isEmpty()) {
                    password.requestFocus();
                } else {
                    if (!username.getText().isEmpty()) {
                        testLogin();
                    } else {
                        username.requestFocus();

                    }
                }
            } else if (e.getCode() == KeyCode.ESCAPE) {
                if (bol == true) {
                    stage_.setFullScreen(bol);
                    bol = false;
                } else {
                    stage_.setFullScreen(bol);
                    bol = true;
                }
            }
        });

    }
    boolean bool = false;

    void testLogin() {
        if (validPassword() && validUsername()) {
            user = new UserDao(username.getText(), password.getText());

            if (Iuser.connexion(user) == true) {
                ((Stage) fenetreLogin.getScene().getWindow()).close();
                openWindow(getClass().getResource(PRINCIPAL), "UP-PRINT");
                //  CallWindow.Callwindow.GetInstance().call(PRINCIPAL, "UP-PRINT", 0, "/icons/uptodate.png");
            } else {
                new Service_widows().showMssge(message, icon, "Mot de passe ou Nom d'utilisateur incorrect ", 0);
            }
        } else {

        }
    }

//    private void Login() {
////        if (bool != false) {
////            Traitement.getInstanceT().showDialog(fenetreLogin, "/up_priting/loadprincipal.fxml", 49, 49);
////        }
//        final Service<Void> calculateService = new Service<Void>() {
//            @Override
//            protected Task<Void> createTask() {
//                return new Task<Void>() {
//
//                    @Override
//                    protected Void call() throws Exception {
//                        return null;
//                    }
//                };
//            }
//        };
//        calculateService.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
//            switch (newValue) {
//                case FAILED:
//
//                    if (bool == true) {
//                        ((Stage) fenetreLogin.getScene().getWindow()).close();
//                        CallWindow.Callwindow.GetInstance().call(PRINCIPAL, "UP-PRINT", 0, "/icons/uptodate.png");
//                    }
//                    break;
//                case CANCELLED:
//                    Traitement.dialog.close();
//                    break;
//                case SUCCEEDED:
//                    System.out.println("Correct traitement \nRelance en cours.....");
//                    if (bool == true) {
//                        ((Stage) fenetreLogin.getScene().getWindow()).close();
//                        CallWindow.Callwindow.GetInstance().call(PRINCIPAL, "UP-PRINT", 0, "/icons/uptodate.png");
//                    }
//                    break;
//            }
//        });
//        calculateService.start();
//    }
}
