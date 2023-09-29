package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/pavel";
    private static final String USERNAME = "Pavel Dzhazga";
    private static final String PASSWORD = "25814789632GfGf";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            if (!connection.isClosed()) {
                System.out.println("Connection good");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Connection ERROR");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Connection ERROR");
        }
        return connection;
    }


    //Hibarnate



}
