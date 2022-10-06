package client.components;
import java.awt.*;
import javax.swing.*;
// import javax.swing.border.EmptyBorder;

public class myFrame extends JFrame {
    public myFrame() {
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        this.getContentPane().setBackground(new Color(0x111111));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 1000);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Syther");
    }

    // public void showSignupScr() {
        // this.getContentPane().removeAll();
        // this.setLayout(new BorderLayout());

        // myPanel center = new myPanel(new GridLayout(3, 1, 20, 0), new Dimension(350, 200));
        // myPanel up = new myPanel(new Dimension(350, 200));
        // myPanel down = new myPanel(new Dimension(350, 200));
        // myPanel left = new myPanel(new Dimension(350, 200));
        // myPanel right = new myPanel(new Dimension(350, 200));

        // center.setBackground(new Color(0x333333));
        // center.setOpaque(true);
        
        // myPanel headerCont = new myPanel(new BorderLayout());

        // ImageIcon logo = new ImageIcon(new ImageIcon("img/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        // myLabel header = new myLabel("Sign Up", new Font("Impact", Font.PLAIN, 75));
        // header.setIcon(logo);
        // header.setIconTextGap(25);
        // header.setBorder(new EmptyBorder(50, 50, 10, 0));
        // headerCont.add(header);

        // center.add(headerCont);

        // myPanel details = new myPanel(new GridLayout(4, 2, 20, 20));
        // details.setBorder(new EmptyBorder(15, 50, 0, 50));

        // Font labelFont = new Font("Sans Serif", Font.PLAIN, 20);
        // myLabel nameLabel = new myLabel("Enter name", labelFont);
        // myLabel emailLabel = new myLabel("Enter email address", labelFont);
        // myLabel passwordLabel = new myLabel("Enter password", labelFont);
        // myLabel confirmPasswordLabel = new myLabel("Enter password again", labelFont);

        // myTextField nameInput = new myTextField("", labelFont);
        // myTextField emailInput = new myTextField("", labelFont);
        // myTextField passwordInput = new myTextField("", labelFont);
        // myTextField confirmPasswordInput = new myTextField("", labelFont);
        
        // details.add(nameLabel);
        // details.add(nameInput);
        // details.add(emailLabel);
        // details.add(emailInput);
        // details.add(passwordLabel);
        // details.add(passwordInput);
        // details.add(confirmPasswordLabel);
        // details.add(confirmPasswordInput);
        // center.add(details);

        // myPanel footerCont = new myPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        // footerCont.setBorder(new EmptyBorder(75, 0, 0, 0));
        // myButton signupBtn = new myButton("Sign Up", labelFont);
        // myButton signinBtn = new myButton("Sign In", labelFont, true);

        // signupBtn.addActionListener(e -> {
        //     if(nameInput.isEmpty() || emailInput.isEmpty() || passwordInput.isEmpty())
        //         JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning", JOptionPane.WARNING_MESSAGE);

        //     else if(!passwordInput.getText().equals(confirmPasswordInput.getText()))
        //         JOptionPane.showMessageDialog(null, "Passwords don't match", null, JOptionPane.WARNING_MESSAGE);

        //     else {
        //         JOptionPane.showMessageDialog(null, "Welcome to the league of Sytherians", "Account created successfully", JOptionPane.INFORMATION_MESSAGE);
        //         showSigninScr();
        //     }
        // });

        // signinBtn.addActionListener(e -> showSigninScr());
        // footerCont.add(signupBtn);
        // footerCont.add(signinBtn);
        // center.add(footerCont);
        
        // this.add(center, BorderLayout.CENTER);
        // this.add(up, BorderLayout.NORTH);
        // this.add(down, BorderLayout.SOUTH);
        // this.add(left, BorderLayout.WEST);
        // this.add(right, BorderLayout.EAST);
        
        // nameInput.requestFocus();
        // this.setVisible(true);
    // }

    // public void showSigninScr() {
        // this.getContentPane().removeAll();
        // this.setLayout(new BorderLayout());

        // myPanel center = new myPanel(new GridLayout(3, 1, 20, 0), new Dimension(350, 200));
        // myPanel up = new myPanel(new Dimension(350, 200));
        // myPanel down = new myPanel(new Dimension(350, 200));
        // myPanel left = new myPanel(new Dimension(350, 200));
        // myPanel right = new myPanel(new Dimension(350, 200));

        // center.setBackground(new Color(0x333333));
        // center.setOpaque(true);
        
        // myPanel headerCont = new myPanel(new BorderLayout());

        // ImageIcon logo = new ImageIcon(new ImageIcon("img/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        // myLabel header = new myLabel("Sign In", new Font("Impact", Font.PLAIN, 75));
        // header.setIcon(logo);
        // header.setIconTextGap(25);
        // header.setBorder(new EmptyBorder(50, 50, 10, 0));
        // headerCont.add(header);

        // center.add(headerCont);

        // myPanel details = new myPanel(new GridLayout(4, 2, 20, 20));
        // details.setBorder(new EmptyBorder(15, 50, 0, 50));

        // Font labelFont = new Font("Sans Serif", Font.PLAIN, 20);
        
        // myLabel emailLabel = new myLabel("Enter email address", labelFont);
        // myLabel passwordLabel = new myLabel("Enter password", labelFont);

        // myTextField emailInput = new myTextField(labelFont);
        // myTextField passwordInput = new myTextField(labelFont);
        
        // details.add(new myLabel());
        // details.add(new myLabel());
        // details.add(emailLabel);
        // details.add(emailInput);
        // details.add(passwordLabel);
        // details.add(passwordInput);
        // center.add(details);
        // details.add(new myLabel());
        // details.add(new myLabel());

        // myPanel footerCont = new myPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        // footerCont.setBorder(new EmptyBorder(75, 0, 0, 0));
        // myButton signinBtn = new myButton("Sign In", labelFont);
        // myButton signupBtn = new myButton("Sign Up", labelFont, true);

        // signupBtn.addActionListener(e -> showSignupScr());

        // footerCont.add(signinBtn);
        // footerCont.add(signupBtn);
        // center.add(footerCont);
        
        // this.add(center, BorderLayout.CENTER);
        // this.add(up, BorderLayout.NORTH);
        // this.add(down, BorderLayout.SOUTH);
        // this.add(left, BorderLayout.WEST);
        // this.add(right, BorderLayout.EAST);
        
        // emailInput.requestFocus();
        // this.setVisible(true);
    // }
}
