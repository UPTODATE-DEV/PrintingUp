/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis.parametrer;

import Elementary.Mask;
import static Elementary.references.LOGIN;
import animatefx.animation.Flash;
import animatefx.animation.Pulse;
import animatefx.animation.SlideInLeft;
import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import static up_priting.Up_priting.stage_;

/**
 * FXML Controller class
 *
 * @author Akim
 */
public class AccountController implements Initializable {

    @FXML
    private GNAvatarView avatar;
    private HBox box_fullname;
    private TextField fullname;
    private HBox box_username;
    private TextField username;
    private HBox box_email;
    private TextField email;
    private HBox box_password;
    private PasswordField password;
    private Label lbl_error;
    private Label lbl_fullname;
    private Label lbl_username;
    private Label lbl_email;
    private Label lbl_password;
    private RotateTransition rotateTransition = new RotateTransition();
    @FXML
    private Circle logo;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtrccm;
    @FXML
    private TextField txtchemin;
    @FXML
    private FontAwesomeIconView chema;
    @FXML
    private TextField txtadresseph;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtmail;
    @FXML
    private JFXButton btAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
 
//        rotateTransition.setNode(avatar);
//        rotateTransition.setByAngle(360);
//        rotateTransition.setDuration(Duration.seconds(1));
//        rotateTransition.setAutoReverse(true);
//
//        addEffect(email);
//        addEffect(fullname);
//        addEffect(username);
//        addEffect(password);
//
//        Mask.nameField(fullname);
//        Mask.noInitSpace(username);
//        Mask.noSpaces(username);
//        setupListeners();
     //
    }

    @FXML
    private void back(ActionEvent event) {

        CallWindow.Callwindow.GetInstance().call(LOGIN, "UP-PRINT", 0, "/icons/uptodate.png");
        ((Stage) txtnom.getScene().getWindow()).close();
       
        

    }

    private void addEffect(Node node) {
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!node.isFocused()) {
                node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            } else {
                node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
            }
        });
    }

    private boolean validPassword() {
        return !password.getText().isEmpty() && password.getLength() > 3;
    }

    private boolean validUsername() {
        return !username.getText().isEmpty() && username.getLength() > 3;
    }

    private boolean validFullName() {
        return !fullname.getText().isEmpty() && fullname.getLength() > 3;
    }

    private boolean validEmail() {
        return Mask.isEmail(email);
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

        email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!validEmail()) {
                if (!newValue) {
                    Flash swing = new Flash(box_email);
                    lbl_email.setVisible(true);
                    new SlideInLeft(lbl_email).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_email.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_email.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        fullname.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!validFullName()) {
                if (!newValue) {
                    Flash swing = new Flash(box_fullname);
                    lbl_fullname.setVisible(true);
                    new SlideInLeft(lbl_fullname).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_fullname.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_fullname.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }

    @FXML
    private void editedate(ActionEvent event) {
    }

    @FXML
    private void editeother(ActionEvent event) {
    }

    @FXML
    private void AddUser(ActionEvent event) {
    }
}
