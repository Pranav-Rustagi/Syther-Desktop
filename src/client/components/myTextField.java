package client.components;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class myTextField extends JTextField {
    public myTextField() {
        this.setBorder(new EmptyBorder(5, 10, 5, 10));
        this.setText("");
    }

    public myTextField(String defaultVal) {
        this();
        this.setText(defaultVal);
    }

    public myTextField(Font font) {
        this();
        this.setFont(font);
    }

    public myTextField(String defaultVal, Font font) {
        this(defaultVal);
        this.setFont(font);
    }

    public boolean isEmpty() {
        return this.getText().trim().isEmpty();
    }
}
