/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parametrer.login;

import static Elementary.references.PRINCIPAL;
import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.gn.GNAvatarView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        
    }

    private boolean validPassword() {
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    private boolean validUsername() {
        return !username.getText().isEmpty() && username.getLength() > 3;
    }

    void login() {
        login.setOnMouseClicked((e) -> {
            if (validPassword() && validUsername()) {
                ((Stage) fenetreLogin.getScene().getWindow()).close();
                CallWindow.Callwindow.GetInstance().call(PRINCIPAL, "UP-PRINT", 0, "/media/Ativo 1@3x.png");
            }

        });

    }

}
