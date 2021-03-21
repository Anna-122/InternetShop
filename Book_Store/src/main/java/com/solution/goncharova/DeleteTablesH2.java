package com.solution.goncharova;


import org.apache.logging.log4j.LogManager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Class {@code DeleteTablesH2}
 * Was created to delete tables from schema (H2)
 *
 * @author Goncharova Anna
 * @version 1.2
 */
public class DeleteTablesH2 {
    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(DeleteTablesH2.class);
    private static Statement stmt;

    /**
     * Method reads file
     * @return prop - loaded file
     */
    public static Properties loadPropertiesFile() throws Exception {

        Properties prop = new Properties();
        InputStream in = new FileInputStream("/home/anna/IdeaProjects/Book_Store/src/main/resources/jdbc.properties");
        prop.load(in);
        in.close();
        return prop;
    }

    public static void main( String[] args ) {
        LOG4j2.info("create jdbc connection using properties file");
        Connection con = null;

        try {
            Properties prop1 = loadPropertiesFile();
            String H2DriverClass = prop1.getProperty("H2.name");
            String H2Url = prop1.getProperty("H2.url");
            String H2Username = prop1.getProperty("H2.user");
            String H2Password = prop1.getProperty("H2.password");
            LOG4j2.info(H2DriverClass);
            LOG4j2.info(H2Url);
            LOG4j2.info(H2Username);
            LOG4j2.info(H2Password);

            Class.forName(H2DriverClass);

            con = DriverManager.getConnection(H2Url, H2Username, H2Password);
            if (con != null) {
                LOG4j2.info("connection to H2 created successfully using properties file");
            } else {
                LOG4j2.info("unable create connection to H2");
            }

            stmt = con.createStatement();
            deleteTables();

        }catch (SQLException e) {
            e.printStackTrace();
            LOG4j2.info(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            LOG4j2.info(e.getMessage());
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                LOG4j2.info(ex.getMessage());
            }
        }
    }

    /**
     * Method deletes tables from Schema
     * @exception SQLException
     */
    private static void deleteTables() {

        try {
           // stmt.execute("USE Book_Store_goncharova");
            stmt.execute("SET REFERENTIAL_INTEGRITY FALSE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Access_rights_list` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS  `Storage` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Author` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Books` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Cities`CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Countries` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Publishing_house` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Purchase` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Registered_User_Role` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Users` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `User_type` CASCADE");
            stmt.execute("SET REFERENTIAL_INTEGRITY TRUE");
        } catch (Exception ex) {
            ex.printStackTrace();
            LOG4j2.info(ex.getMessage());
        }
    }
}
