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
 * Class {@code DataH2}
 * Was created to parse properties file and create BD (H2)
 *
 * @author Goncharova Anna
 * @version 1.1
 */
public class DataH2 {
    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(DataH2.class);
    private static Statement stmt;

    /**
     * Method reads file
     * @return prop - loaded file
     */
    public static Properties loadPropertiesFile() throws Exception {

        Properties prop = new Properties();
        //InputStream in = new FileInputStream("./JDBC2/src/main/resources/jdbc.properties");
        InputStream in = new FileInputStream("/home/anna/IdeaProjects/Book_Store/src/main/resources/jdbc.properties");
      // InputStream in = new FileInputStream("./jdbc.properties");
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
            }
            else {
                LOG4j2.info("unable create connection to H2");
            }
            stmt = con.createStatement();
            createDB();

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
          //  stmt.execute("USE Book_Store_goncharova");
            stmt.execute("SET REFERENTIAL_INTEGRITY FALSE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Access_rights_list` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS  `Storage` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Author` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Books` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Cities` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Countries` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Publishing_house` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Purchase`CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Registered_User_Role`CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `Users` CASCADE");
            stmt.executeUpdate("DROP TABLE IF EXISTS `User_type` CASCADE");
            stmt.execute("SET REFERENTIAL_INTEGRITY TRUE");

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            LOG4j2.info(sqlEx.getMessage());
        }
    }

    /**
     * Method creates Schema
     * @exception SQLException
     */
    private static void createDB(){
        try{
            deleteTables();
            //stmt.executeUpdate("DROP SCHEMA IF EXISTS Book_Store_goncharova");
           // stmt.executeUpdate("CREATE SCHEMA Book_Store_goncharova");
           // stmt.execute("USE Book_Store_goncharova");

            stmt.executeUpdate("CREATE TABLE `Access_rights_list` (\n" +
                    "  `user_right_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `user_type_id` int NOT NULL,\n" +
                    "  `rights` text NOT NULL\n" +
                    ")");

            stmt.executeUpdate("CREATE TABLE `Author` (\n" +
                    "  `author_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `author_name` varchar NOT NULL,\n" +
                    "  `author_surname` varchar NOT NULL,\n" +
                    "  `author_middle_name` varchar NOT NULL,\n" +
                    "  `author_birthday` date NOT NULL\n" +
                    ") ");
            stmt.executeUpdate("CREATE TABLE `Books` (\n" +
                    "  `book_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `author_id` int NOT NULL,\n" +
                    "  `publishing_house_id` int NOT NULL,\n" +
                    "  `count_of_pages` int NOT NULL,\n" +
                    "  `book_price` bigint NOT NULL,\n" +
                    "  `book_title` varchar NOT NULL,\n" +
                    "  `book_ISBN` char(20) NOT NULL,\n" +
                    "  `book_hide` tinyint(1) NOT NULL,\n" +
                    "  `book_genre` varchar NOT NULL,\n" +
                    "  `year_of_publishing` date NOT NULL\n" +
                    ") ");

            stmt.executeUpdate("CREATE TABLE `Cities` (\n" +
                    "  `city_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `city` varchar NOT NULL,\n" +
                    "  `country_id` int NOT NULL\n" +
                    ")");

            stmt.executeUpdate("CREATE TABLE `Countries` (\n" +
                    "  `country_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `country` varchar NOT NULL\n" +
                    ") ");
            stmt.executeUpdate("CREATE TABLE `Publishing_house` (\n" +
                    "  `publishing_house_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `publishing_house_name` varchar NOT NULL,\n" +
                    "  `publishing_house_phone_number` int NOT NULL,\n" +
                    "  `publishing_house_country_id` int NOT NULL,\n" +
                    "  `publishing_house_city_id` int NOT NULL,\n" +
                    "  `publishing_house_street` varchar NOT NULL,\n" +
                    "  `publishing_house_number` char(5) NOT NULL,\n" +
                    "  `publishing_house_flat_number` char(5) NOT NULL,\n" +
                    "  `publishing_house_postcode` int NOT NULL\n" +
                    ")");
            stmt.executeUpdate("CREATE TABLE `Purchase` (\n" +
                    "  `purchase_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `book_id` int NOT NULL,\n" +
                    "  `user_id` int NOT NULL,\n" +
                    "  `purchase_adding` date NOT NULL,\n" +
                    "  `purchase_deleting` date NOT NULL,\n" +
                    "  `purchase_payment` date NOT NULL,\n" +
                    "  `book_count` int NOT NULL,\n" +
                    "  `book_price` bigint NOT NULL,\n" +
                    "  `book_deleted` tinyint(1) NOT NULL,\n" +
                    "  `book_paid` tinyint(1) NOT NULL\n" +
                    ")");
            stmt.executeUpdate("CREATE TABLE `Registered_User_Role` (\n" +
                    "  `register_user_role_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `user_id` int NOT NULL,\n" +
                    "  `user_type_id` int NOT NULL\n" +
                    ") ");
            stmt.executeUpdate("CREATE TABLE `Storage` (\n" +
                    "  `storage_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `book_id` int NOT NULL,\n" +
                    "  `book_count` int NOT NULL,\n" +
                    "  `storage_country_id` int NOT NULL,\n" +
                    "  `storage_city_id` int NOT NULL,\n" +
                    "  `storage_street` varchar NOT NULL,\n" +
                    "  `storage_house_number` char(5) NOT NULL,\n" +
                    "  `storage_flat_number` char(5) NOT NULL\n" +
                    ")");
            stmt.executeUpdate("CREATE TABLE `Users` (\n" +
                    "  `user_id` int  PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `user_name` varchar NOT NULL,\n" +
                    "  `user_surname` varchar NOT NULL,\n" +
                    "  `user_middle_name` varchar NOT NULL,\n" +
                    "  `user_sex` char(1) NOT NULL,\n" +
                    "  `user_email` char(50) NOT NULL,\n" +
                    "  `user_username` char(20) NOT NULL,\n" +
                    "  `user_password` char(255) NOT NULL,\n" +
                    "  `user_birthday` date NOT NULL,\n" +
                    "  `user_country_id` int NOT NULL,\n" +
                    "  `user_city_id` int NOT NULL,\n" +
                    "  `user_street` varchar NOT NULL,\n" +
                    "  `user_house_number` char(5) NOT NULL,\n" +
                    "  `user_flat_number` char(5) NOT NULL,\n" +
                    "  `user_type_id` int NOT NULL\n" +
                    ")");
            stmt.executeUpdate("CREATE TABLE `User_type` (\n" +
                    "  `user_type_id` int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                    "  `user_type` varchar NOT NULL\n" +
                    ") ");
            stmt.executeUpdate("ALTER TABLE `Cities`\n" +
                    "  ADD CONSTRAINT `Cities_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `Countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;\n");
            stmt.executeUpdate("ALTER TABLE `Users`\n" +
                    "  ADD CONSTRAINT `Users_ibfk_1` FOREIGN KEY (`user_country_id`) REFERENCES `Countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT");
            stmt.executeUpdate("ALTER TABLE `Users`\n" +
                    "  ADD CONSTRAINT `Users_ibfk_2` FOREIGN KEY (`user_city_id`) REFERENCES `Cities` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;");
            stmt.executeUpdate("ALTER TABLE `Storage`\n" +
                    "  ADD CONSTRAINT `Storage_ibfk_1` FOREIGN KEY (`storage_country_id`) REFERENCES `Countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Storage`\n" +
                    "  ADD CONSTRAINT `Storage_ibfk_2` FOREIGN KEY (`storage_city_id`) REFERENCES `Cities` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Access_rights_list`\n" +
                    "  ADD CONSTRAINT `Access_rights_list_ibfk_1` FOREIGN KEY (`user_type_id`) REFERENCES `User_type` (`user_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;\n ");
            stmt.executeUpdate("ALTER TABLE `Books`\n" +
                    "  ADD CONSTRAINT `Books_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `Author` (`author_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Books`\n" +
                    "  ADD CONSTRAINT `Books_ibfk_2` FOREIGN KEY (`publishing_house_id`) REFERENCES `Publishing_house` (`publishing_house_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Publishing_house`\n" +
                    "  ADD CONSTRAINT `Publishing_house_ibfk_1` FOREIGN KEY (`publishing_house_country_id`) REFERENCES `Countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;");
            stmt.executeUpdate("ALTER TABLE `Publishing_house`\n" +
                    "  ADD CONSTRAINT `Publishing_house_ibfk_2` FOREIGN KEY (`publishing_house_country_id`) REFERENCES `Countries` (`country_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;");
            stmt.executeUpdate("ALTER TABLE `Publishing_house`\n" +
                    "  ADD CONSTRAINT `Publishing_house_ibfk_3` FOREIGN KEY (`publishing_house_city_id`) REFERENCES `Cities` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;");
            stmt.executeUpdate("ALTER TABLE `Purchase`\n" +
                    "  ADD CONSTRAINT `Purchase_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Purchase`\n" +
                    "  ADD CONSTRAINT `Purchase_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `Books` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Registered_User_Role`\n" +
                    "  ADD CONSTRAINT `Registered_User_Role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ");
            stmt.executeUpdate("ALTER TABLE `Registered_User_Role`\n" +
                    "  ADD CONSTRAINT `Registered_User_Role_ibfk_2` FOREIGN KEY (`user_type_id`) REFERENCES `User_type` (`user_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;\n");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            LOG4j2.info(sqlEx.getMessage());
        }
    }
}
