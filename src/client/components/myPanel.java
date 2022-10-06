package client.components;

import java.awt.*;
import javax.swing.JPanel;

public class myPanel extends JPanel {
    public myPanel() {
        this.setOpaque(false);
    }

    public myPanel(LayoutManager mgr) {
        this();
        this.setLayout(mgr);
    }

    public myPanel(Dimension preferredSize) {
        this();
        this.setPreferredSize(preferredSize);
    }

    public myPanel(LayoutManager mgr, Dimension preferredSize) {
        this(mgr);
        this.setPreferredSize(preferredSize);
    }
}
