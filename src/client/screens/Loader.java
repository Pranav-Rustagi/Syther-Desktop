package client.screens;

import java.awt.*;
import javax.swing.*;

import client.ClientConnector;
import client.components.*;
import helpers.Config;
import helpers.Request;
import helpers.Response;

public class Loader {
    myFrame mainFrame;

    public Loader (myFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.mainFrame.setTitle("Syther");
    }


    void showLoadScr(String animationStr) {
        mainFrame.getContentPane().removeAll();
        myLabel label = new myLabel("Loading" + animationStr, new Font("Impact", Font.PLAIN, 100));
        label.setIcon(new ImageIcon("img/logo.png"));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setIconTextGap(50);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        mainFrame.add(label);
        mainFrame.setVisible(true);
    }


    void showErrorScr() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridLayout(3, 1, 20, 20));

        myLabel label1 = new myLabel("Sheeeeet!", new Font("Impact", Font.PLAIN,75));
        label1.setIconTextGap(50);
        label1.setIcon(new ImageIcon("img/logo.png"));
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.BOTTOM);

        myLabel label2 = new myLabel("Server is feeling down", new Font("Impact", Font.PLAIN,30));
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.TOP);
        
        mainFrame.add(new myLabel());
        mainFrame.add(label1);
        mainFrame.add(label2);

        mainFrame.setVisible(true);
    }


    public void init(boolean animation) throws InterruptedException {
        System.out.println("Sending connection request to server...");
        if(animation) {
            for(int i = 0 ; i < 12 ; ++i) {
                String animationStr = "";
                for(int j = (i % 4) ; j > 0 ; --j)
                animationStr += '.';
                showLoadScr(animationStr);
                Thread.sleep(700);
            }
        }
        
        Response response = (Response) ClientConnector.connectToServer(new Request(Config.CONNECTION_REQUEST));
        if(response.getResponse().equals(Config.CONNECTED)) {
            new SignUp(mainFrame).init();
            System.out.println("Connected to server successfully");
        }
        
        else if(response.getResponse().equals(Config.ERROR)) {
            System.out.println("Failed to connect to server");
            JOptionPane.showMessageDialog(null, "Unable to connect to server", "Server down", JOptionPane.ERROR_MESSAGE, null);
            showErrorScr();
        }
    }
}