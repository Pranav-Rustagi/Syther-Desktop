package server;

import java.sql.*;

// import client.screens.SignUp;
import helpers.Config;
import helpers.User;

public class DatabaseConnector {
    Connection connection;
    Statement statement;

    DatabaseConnector() {
        connection = null;
        statement = null;
    }

    void setupDatabaseConnection() {
        try {
            String url = "jdbc:mysql://" + Config.dbServer + ":" + Config.dbPortNo + "/" + Config.dbName;
            connection = DriverManager.getConnection(url, Config.dbUser, Config.dbPassword);
            statement = connection.createStatement();
            System.out.println("Database connection formed successfully!");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    String registerUser(User user) {
        try {
            String query = "SELECT * FROM users WHERE email = '" + user.getEmail() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            
            if(resultSet.isBeforeFirst())
                return Config.ALREADY_EXISTS;

            query = "INSERT INTO users VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "')";
            statement.execute(query);
            return Config.SIGNED_UP;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Config.ERROR;
    }

    String verifyCredentials(User user) {
        try {
            String query = "SELECT * FROM users where email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.isBeforeFirst())
                return Config.LOGGED_IN;
            return Config.CREDENTIALS_NOT_MATCH;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Config.ERROR;
    }
}
