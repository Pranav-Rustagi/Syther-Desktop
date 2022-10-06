package client.screens;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import client.ClientConnector;
import client.components.*;
import helpers.Config;
import helpers.Request;
import helpers.Response;
import helpers.User;

public class SignIn {
    myFrame mainFrame;

    public SignIn(myFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    void init() {
        mainFrame.getContentPane().removeAll();

        mainFrame.setTitle("Syther - Sign In");

        mainFrame.setLayout(new BorderLayout());

        myPanel center = new myPanel(new GridLayout(3, 1, 20, 0), new Dimension(350, 200));
        myPanel up = new myPanel(new Dimension(350, 200));
        myPanel down = new myPanel(new Dimension(350, 200));
        myPanel left = new myPanel(new Dimension(350, 200));
        myPanel right = new myPanel(new Dimension(350, 200));

        center.setBackground(new Color(0x333333));
        center.setOpaque(true);
        
        myPanel headerCont = new myPanel(new BorderLayout());

        ImageIcon logo = new ImageIcon(new ImageIcon("img/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        myLabel header = new myLabel("Sign In", new Font("Impact", Font.PLAIN, 75));
        header.setIcon(logo);
        header.setIconTextGap(25);
        header.setBorder(new EmptyBorder(50, 50, 10, 0));
        headerCont.add(header);

        center.add(headerCont);

        myPanel details = new myPanel(new GridLayout(4, 2, 20, 20));
        details.setBorder(new EmptyBorder(15, 50, 0, 50));

        Font labelFont = new Font("Sans Serif", Font.PLAIN, 20);
        
        myLabel emailLabel = new myLabel("Enter email address", labelFont);
        myLabel passwordLabel = new myLabel("Enter password", labelFont);

        myTextField emailInput = new myTextField(labelFont);
        myPassword passwordInput = new myPassword(labelFont);
        
        details.add(new myLabel());
        details.add(new myLabel());
        details.add(emailLabel);
        details.add(emailInput);
        details.add(passwordLabel);
        details.add(passwordInput);
        center.add(details);
        details.add(new myLabel());
        details.add(new myLabel());

        myPanel footerCont = new myPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        footerCont.setBorder(new EmptyBorder(75, 0, 0, 0));
        myButton signinBtn = new myButton("Sign In", labelFont);
        myButton signupBtn = new myButton("Sign Up", labelFont, true);

        signinBtn.addActionListener(e -> {
            if(emailInput.isEmpty() || passwordInput.isEmpty())
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            else {
                User user = new User(emailInput.getText().trim(), passwordInput.getTextVal().trim());
                Response response = ClientConnector.connectToServer(new Request(Config.LOGIN_REQUEST, user));
                String respoString = response.getResponse();

                if(respoString.equals(Config.CREDENTIALS_NOT_MATCH)) {
                    System.out.println("Incorrect credentials");
                    JOptionPane.showMessageDialog(null, "Incorrect email or password", "Request denied", JOptionPane.ERROR_MESSAGE);
                }
                else if(respoString.equals(Config.LOGGED_IN)) {
                    System.out.println("Credentials verified. Logged in successfully");
                    JOptionPane.showMessageDialog(null, "Welcome back to the league of Sytherians", "Logged in successfully", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(respoString.equals(Config.ERROR)) {
                    System.out.println("Something went wrong");
                    JOptionPane.showMessageDialog(null, "Something went wrong", "Unknown error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signupBtn.addActionListener(e -> new SignUp(mainFrame).init());

        footerCont.add(signinBtn);
        footerCont.add(signupBtn);
        center.add(footerCont);
        
        mainFrame.add(center, BorderLayout.CENTER);
        mainFrame.add(up, BorderLayout.NORTH);
        mainFrame.add(down, BorderLayout.SOUTH);
        mainFrame.add(left, BorderLayout.WEST);
        mainFrame.add(right, BorderLayout.EAST);
        
        emailInput.requestFocus();
        mainFrame.setVisible(true);
    }
}