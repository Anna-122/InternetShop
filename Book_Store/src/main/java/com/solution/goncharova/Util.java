package com.solution.goncharova;

import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    /**
     * org.apache.logging.log4j.Logger
     */

    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Util.class);
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            LOG4j2.info("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            LOG4j2.info(e.getMessage());
        }
        return connection;
    }
}
