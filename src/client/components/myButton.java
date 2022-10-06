package client.components;
import java.awt.*;
import javax.swing.JButton;

public class myButton extends JButton {
    public myButton() {
        this.setForeground(new Color(0x111111));
        this.setBackground(new Color(0xAAAAAA));
        this.setPreferredSize(new Dimension(125, 50));
    }

    public myButton(String msg) {
        this();
        this.setText(msg);
    }

    public myButton(String msg, Font font) {
        this(msg);
        this.setFont(font);
    }

    public myButton(String msg, Font font, Boolean plain) {
        this(msg, font);
        if(plain) {
            this.setForeground(new Color(0xAAAAAA));
            this.setOpaque(false);
        }
    }
}
