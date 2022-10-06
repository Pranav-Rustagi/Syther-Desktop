package client;

import client.components.myFrame;
import client.screens.Loader;

public class App {
    // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    // static final String server = "remotemysql.com";
    // static final String db = "IbnMZFnbrZ";
    // static final String user = "IbnMZFnbrZ";
    // static final String pswd = "SL2TKOEpj8";
    // static final String url = "jdbc:mysql://" + server + ":3306/" + db;

    public static void main(String[] args) throws Exception {
        myFrame mainFrame = new myFrame();
        new Loader(mainFrame).init(true);
    }
}
