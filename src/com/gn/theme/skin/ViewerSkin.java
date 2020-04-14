package com.gn.theme.skin;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/11/2018
 * Version 1.0
 */
public class ViewerSkin extends SkinAction1 {

    private boolean shouldMaskText = true;

    public ViewerSkin(PasswordField textField) {
        super(textField);
    }

    @Override
    void mouseReleased() {
        TextField textField = getSkinnable();
        textField.setText(textField.getText());
        textField.end();
    }

    @Override
    void textChanged() {
        if (!getPasswordField().isFocused() && getPasswordField().getText() == null) {
            return;
        }
        getButton().setVisible(getPasswordField().isFocused() && !getPasswordField().getText().isEmpty());
    }

    @Override
    void focusChanged() {
        if (!getPasswordField().isFocused() && getPasswordField().getText() == null) {
            return;
        }
        getButton().setVisible(getPasswordField().isFocused() && !getPasswordField().getText().isEmpty());
    }

    @Override
    void mousePressed() {
        TextField textField = getSkinnable();
        shouldMaskText = false;
        textField.setText(textField.getText());
        shouldMaskText = true;
    }

    @Override
    protected String maskText(String txt) {
        if (getSkinnable() instanceof PasswordField && shouldMaskText) {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                passwordBuilder.append(BULLET);
            }
            return passwordBuilder.toString();
        } else {
            return txt;
        }
    }
}

