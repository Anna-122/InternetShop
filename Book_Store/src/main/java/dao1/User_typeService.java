package dao1;


import connection.ConnectionManager;
import entity.User_type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_typeService implements User_typeDao {




    @Override
    public void add( User_type user_type ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO User_type (user_type_id,user_type) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_type.getUser_type_id());
            preparedStatement.setString(2, user_type.getUser_type());

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
    public List<User_type> getAll() throws SQLException {


        Connection connection = ConnectionManager.getInstance().getConnection();

        List<User_type> user_typeArrayList = new ArrayList<>();

        String sql = "SELECT `city_id`, `country_id`,`city`, FROM `Cities`";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User_type user_type = new User_type();
                user_type.setUser_type_id(resultSet.getInt("user_type_id"));
                user_type.setUser_type(resultSet.getString("user_type"));

                user_typeArrayList.add(user_type);
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
            ConnectionManager.getInstance().releaseConnection(connection);
        }
        System.out.println(user_typeArrayList);
        return user_typeArrayList;

    }

    @Override
    public entity.User_type getById( Integer id ) throws SQLException {
        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT city_id, city FROM Cities WHERE city_id=?";

        User_type user_type = new User_type();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            user_type.setUser_type_id(resultSet.getInt("user_type_id"));
            user_type.setUser_type(resultSet.getString("user_type"));

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
        return user_type;
    }

    @Override
    public void update( entity.User_type user_type ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Cities SET city=? WHERE city_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_type.getUser_type_id());
            preparedStatement.setString(2, user_type.getUser_type());
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
    public void remove( entity.User_type user_type ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM Cities WHERE city_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, user_type.getUser_type_id());

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
