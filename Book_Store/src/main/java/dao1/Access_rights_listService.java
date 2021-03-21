package dao1;

import connection.ConnectionManager;
import entity.Access_rights_list;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Access_rights_listService implements Access_rights_list_Dao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;


    @Override
    public void add( Access_rights_list access_rights_list ) throws SQLException {
        String sql = "INSERT INTO Access_rights_list (user_right_id,user_type_id, rights) VALUES(?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, access_rights_list.getUser_right_id());
            preparedStatement.setInt(2, access_rights_list.getUser_type_id());
            preparedStatement.setString(3, access_rights_list.getRights());

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
    public List<Access_rights_list> getAll() throws SQLException {

        List<Access_rights_list> access_rights_listArrayList = new ArrayList<>();

        String sql = "SELECT user_right_id,user_type_id, rights FROM `Access_rights_list`";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Access_rights_list access_rights_list = new Access_rights_list();
                access_rights_list.setUser_right_id(resultSet.getInt("user_right_id"));
                access_rights_list.setUser_type_id(resultSet.getInt("user_type_id"));
                access_rights_list.setRights(resultSet.getString("rights"));

                access_rights_listArrayList.add(access_rights_list);
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
        System.out.println(access_rights_listArrayList);
        return access_rights_listArrayList;
    }

    @Override
    public Access_rights_list getById( Integer id ) throws SQLException {
        String sql = "SELECT user_right_id, rights FROM Access_rights_list WHERE user_type_id=?";


        Access_rights_list access_rights_list = new Access_rights_list();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            access_rights_list.setUser_right_id(resultSet.getInt("user_right_id"));
            access_rights_list.setRights(resultSet.getString("rights"));

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
        return access_rights_list;
    }

    @Override
    public void update( Access_rights_list access_rights_list ) throws SQLException {
        String sql = "UPDATE Access_rights_list SET rights=? WHERE user_type_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, access_rights_list.getUser_type_id());
            preparedStatement.setString(2, access_rights_list.getRights());
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
    public void remove( Access_rights_list access_rights_list ) throws SQLException {
        String sql = "DELETE FROM Access_rights_list WHERE user_type_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, access_rights_list.getUser_type_id());

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
