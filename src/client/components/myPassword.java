package client.components;

import java.awt.*;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class myPassword extends JPasswordField {
    public myPassword() {
        this.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    public myPassword(Font font) {
        this();
        this.setFont(font);
    }

    public String getTextVal() {
        return new String(getPassword());
    }

    public boolean isEmpty() {
        return getTextVal().trim().isEmpty();
    }
}
