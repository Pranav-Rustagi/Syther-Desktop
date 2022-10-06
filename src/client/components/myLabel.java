package client.components;
import java.awt.*;
import javax.swing.JLabel;

public class myLabel extends JLabel {
    public myLabel() {
        this.setOpaque(false);
        this.setForeground(Color.WHITE);
    }

    public myLabel(String msg) {
        this();
        this.setText(msg);
    }

    public myLabel(String msg, Font font) {
        this(msg);
        this.setFont(font);
    }
}
