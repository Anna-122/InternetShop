package dao1;


import connection.ConnectionManager;
import entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserService  implements UsersDao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;

    @Override
    public void add( entity.Users users ) throws SQLException {


        String sql = "INSERT INTO Users (user_id, user_name,user_surname," +
                "user_middle_name,user_sex,user_email,user_username,user_password,user_birthday,user_country_id," +
                "user_city_id,user_street,user_house_number,user_flat_number,user_type_id)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,users.getUser_id());
            preparedStatement.setString(2,users.getUser_name());
            preparedStatement.setString(3,users.getUser_surname());
            preparedStatement.setString(4,users.getUser_middle_name());
            preparedStatement.setString(5, String.valueOf(users.getUser_sex()));
            preparedStatement.setString(6, String.valueOf(users.getUser_email()));
            preparedStatement.setString(7, String.valueOf(users.getUser_username()));
            preparedStatement.setString(8, String.valueOf(users.getUser_password()));
            preparedStatement.setString(9,  users.getUser_birthday());
            preparedStatement.setInt(10,users.getUser_country_id());
            preparedStatement.setInt(11,users.getUser_city_id());
            preparedStatement.setString(12,users.getUser_street());
            preparedStatement.setString(13, String.valueOf(users.getUser_house_number()));
            preparedStatement.setString(14, String.valueOf(users.getUser_flat_number()));
            preparedStatement.setInt(15,users.getUser_type_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            ConnectionManager.getInstance().releaseConnection(connection);
        }
    }


    @Override
    public List<Users> getAll() throws SQLException {

        List<Users> usersArrayList = new ArrayList<>();


        String sql = ("SELECT user_id, user_name,user_surname,\" +\n" +
                "\"user_middle_name,user_sex,user_email,user_username,user_password,user_birthday,user_country_id,\" +\n" +
                " \"user_city_id,user_street,user_house_number,user_flat_number,user_type_id FROM Users");

        try {


            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Users users = new Users(1, "Anna", "Goncharova", "Sergeevna", "F", "@eerrrr", "an123", "12345", "12.08.2001", 1, 1, "Green_Street", "12f", "1", 1);
                users.setUser_id(resultSet.getInt("user_id"));
                users.setUser_name(resultSet.getString("user_name"));
                users.setUser_surname(resultSet.getString("user_surname"));
                users.setUser_middle_name(resultSet.getString("user_middle_name"));
                users.setUser_sex(resultSet.getString("user_sex"));
                users.setUser_email(resultSet.getString("user_email"));
                users.setUser_username(resultSet.getString("user_username"));
                users.setUser_password(resultSet.getString("user_password"));
                users.setUser_birthday(resultSet.getString("user_birthday"));
                users.setUser_country_id(resultSet.getInt("user_country_id"));
                users.setUser_city_id(resultSet.getInt("user_city_id"));
                users.setUser_street(resultSet.getString("user_street"));
                users.setUser_house_number(resultSet.getString("user_house_number"));
                users.setUser_flat_number(resultSet.getString("user_flat_number"));
                users.setUser_type_id(resultSet.getInt("user_type_id"));


                usersArrayList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return usersArrayList;
    }

    @Override
    public entity.Users getByUserId( Integer user_id ) throws SQLException {
        String sql = "SELECT user_id, user_name,user_surname,\" +\n" +
                " \"user_middle_name,user_sex,user_email,user_username,user_password,user_birthday,user_country_id,\" +\n" +
                " \"user_city_id,user_street,user_house_number,user_flat_number,user_type_id FROM Users WHERE user_id=?";

        Users users = new Users(1, "Anna", "Goncharova", "Sergeevna", "F", "@eerrrr", "an123", "12345", "12.08.2001", 1, 1, "Green_Street", "12f", "1", 1);
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, user_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            users.setUser_id(resultSet.getInt("user_id"));
            users.setUser_name(resultSet.getString("user_name"));
            users.setUser_surname(resultSet.getString("user_surname"));
            users.setUser_middle_name(resultSet.getString("user_middle_name"));
            users.setUser_sex(resultSet.getString ("user_sex"));
            users.setUser_email(resultSet.getString("user_email"));
            users.setUser_username(resultSet.getString("user_username"));
            users.setUser_password(resultSet.getString("user_password"));
            users.setUser_birthday(resultSet.getString("user_birthday"));
            users.setUser_country_id(resultSet.getInt("user_country_id"));
            users.setUser_city_id(resultSet.getInt("user_city_id"));
            users.setUser_street(resultSet.getString("user_street"));
            users.setUser_house_number(resultSet.getString("user_house_number"));
            users.setUser_flat_number(resultSet.getString("user_flat_number"));
            users.setUser_type_id(resultSet.getInt("user_type_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            ConnectionManager.getInstance().releaseConnection(connection);
        }
        return users;
    }

    @Override
    public void update( Users users ) throws SQLException {
        String sql = "UPDATE Users SET user_username=? WHERE user_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, users.getUser_id());
            preparedStatement.setString(2, users.getUser_username());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            ConnectionManager.getInstance().releaseConnection(connection);
        }

    }

    @Override
    public void remove( entity.Users users ) throws SQLException {

        String sql = "DELETE FROM Users WHERE user_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, users.getUser_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            ConnectionManager.getInstance().releaseConnection(connection);
        }

    }
}
