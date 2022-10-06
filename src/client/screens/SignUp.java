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

public class SignUp {
    myFrame mainFrame;

    SignUp(myFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    void init() {
        mainFrame.getContentPane().removeAll();

        mainFrame.setTitle("Syther - Sign Up");
        
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
        myLabel header = new myLabel("Sign Up", new Font("Impact", Font.PLAIN, 75));
        header.setIcon(logo);
        header.setIconTextGap(25);
        header.setBorder(new EmptyBorder(50, 50, 10, 0));
        headerCont.add(header);

        center.add(headerCont);

        myPanel details = new myPanel(new GridLayout(4, 2, 20, 20));
        details.setBorder(new EmptyBorder(15, 50, 0, 50));

        Font labelFont = new Font("Sans Serif", Font.PLAIN, 20);
        myLabel nameLabel = new myLabel("Enter name", labelFont);
        myLabel emailLabel = new myLabel("Enter email address", labelFont);
        myLabel passwordLabel = new myLabel("Enter password", labelFont);
        myLabel confirmPasswordLabel = new myLabel("Enter password again", labelFont);

        myTextField nameInput = new myTextField("", labelFont);
        myTextField emailInput = new myTextField("", labelFont);
        myPassword passwordInput = new myPassword(labelFont);
        myPassword confirmPasswordInput = new myPassword(labelFont);
        
        details.add(nameLabel);
        details.add(nameInput);
        details.add(emailLabel);
        details.add(emailInput);
        details.add(passwordLabel);
        details.add(passwordInput);
        details.add(confirmPasswordLabel);
        details.add(confirmPasswordInput);
        center.add(details);

        myPanel footerCont = new myPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        footerCont.setBorder(new EmptyBorder(75, 0, 0, 0));
        myButton signupBtn = new myButton("Sign Up", labelFont);
        myButton signinBtn = new myButton("Sign In", labelFont, true);

        signupBtn.addActionListener(e -> {
            if(nameInput.isEmpty() || emailInput.isEmpty() || passwordInput.isEmpty())
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning", JOptionPane.WARNING_MESSAGE);

            else if(!passwordInput.getTextVal().trim().equals(confirmPasswordInput.getTextVal().trim()))
                JOptionPane.showMessageDialog(null, "Passwords don't match", null, JOptionPane.WARNING_MESSAGE);

            else {
                User user = new User(nameInput.getText().trim(), emailInput.getText().trim(), passwordInput.getTextVal().trim());
                Response response = ClientConnector.connectToServer(new Request(Config.SIGNUP_REQUEST, user));
                String respoString = response.getResponse();
                if(respoString.equals(Config.SIGNED_UP)) {
                    System.out.println("Account created successfully");
                    JOptionPane.showMessageDialog(null, "Welcome to the league of Sytherians", "Account created successfully", JOptionPane.INFORMATION_MESSAGE);
                    new SignIn(mainFrame).init();   
                }
                else if(respoString.equals(Config.ERROR)) {
                    System.out.println("Failed to create account");
                    JOptionPane.showMessageDialog(null, "Failed to create account", "Request failed", JOptionPane.ERROR_MESSAGE, null);
                }
                else if(respoString.equals(Config.ALREADY_EXISTS)) {
                    System.out.println("Account exists with the provided email");
                    JOptionPane.showMessageDialog(null, "Please sign in", "Account already exists", JOptionPane.WARNING_MESSAGE, null);
                }
            }
        });

        signinBtn.addActionListener(e -> new SignIn(mainFrame).init());
        
        footerCont.add(signupBtn);
        footerCont.add(signinBtn);
        center.add(footerCont);
        
        mainFrame.add(center, BorderLayout.CENTER);
        mainFrame.add(up, BorderLayout.NORTH);
        mainFrame.add(down, BorderLayout.SOUTH);
        mainFrame.add(left, BorderLayout.WEST);
        mainFrame.add(right, BorderLayout.EAST);
        
        nameInput.requestFocus();
        mainFrame.setVisible(true);
    }
}
