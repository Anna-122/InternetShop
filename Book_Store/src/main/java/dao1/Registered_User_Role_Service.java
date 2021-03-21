package dao1;

import connection.ConnectionManager;
import entity.Registered_User_Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Registered_User_Role_Service implements Registered_User_RoleDao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;

    @Override
    public void add( Registered_User_Role role ) throws SQLException {


        String sql = "INSERT INTO Registered_User_Role (register_user_role_id,user_id, user_type_id) VALUES(?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, role.getRegister_user_role_id());
            preparedStatement.setInt(2, role.getUser_id());
            preparedStatement.setInt(3, role.getUser_type_id());

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
    public List<Registered_User_Role> getAll() throws SQLException {

        List<Registered_User_Role> roleArrayList = new ArrayList<>();

        String sql = "SELECT register_user_role_id,user_id, user_type_id FROM `Registered_User_Role`";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Registered_User_Role role = new Registered_User_Role();
                role.setRegister_user_role_id(resultSet.getInt("register_user_role_id"));
                role.setUser_id(resultSet.getInt("user_id"));
                role.setUser_type_id(resultSet.getInt("user_type_id"));

                roleArrayList.add(role);
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
        System.out.println(roleArrayList);
        return roleArrayList;
    }

    @Override
    public Registered_User_Role getById( Integer id ) throws SQLException {

        String sql = "SELECT register_user_role_id, user_type_id FROM Registered_User_Role WHERE user_id=?";

        Registered_User_Role role = new Registered_User_Role();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            role.setRegister_user_role_id(resultSet.getInt("register_user_role_id"));
            role.setUser_type_id(resultSet.getInt("user_type_id"));
            role.setUser_id(resultSet.getInt("user_id"));

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
        return role;
    }

    @Override
    public void update( Registered_User_Role role ) throws SQLException {

        String sql = "UPDATE Registered_User_Role SET user_type_id=? WHERE register_user_role_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, role.getUser_type_id());
            preparedStatement.setInt(2, role.getRegister_user_role_id());
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
    public void remove( Registered_User_Role role ) throws SQLException {
        String sql = "DELETE FROM Registered_User_Role WHERE register_user_role_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, role.getRegister_user_role_id());

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
