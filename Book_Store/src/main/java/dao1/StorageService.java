package dao1;

import connection.ConnectionManager;
import entity.Books;
import entity.Cities;
import entity.Storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StorageService implements  StorageDao{

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;

    @Override
    public void add( Storage storage ) throws SQLException {
        String sql = "INSERT INTO Books (storage_id, book_id, book_count," +
                " storage_country_id, storage_city_id,storage_street,storage_house_number," +
                "storage_flat_number) VALUES(?, ?, ?, ?, ?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, storage.getStorage_id());
            preparedStatement.setInt(2, storage.getBook_id());
            preparedStatement.setInt(3, storage.getBook_count());
            preparedStatement.setInt(4, storage.getStorage_country_id());
            preparedStatement.setInt(5, storage.getStorage_city_id());
            preparedStatement.setString(6, storage.getStorage_street());
            preparedStatement.setString(7, String.valueOf(storage.getStorage_house_number()));
            preparedStatement.setString(8, String.valueOf(storage.getStorage_flat_number()));
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
    public List<Storage> getAll() throws SQLException {
        List<Storage> storageArrayList = new ArrayList<>();

        String sql = "SELECT storage_id, book_id, book_count,\" +\n" +
                " \" storage_country_id, storage_city_id,storage_street,storage_house_number,\" +\n" +
                "  \"storage_flat_number FROM Storage";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Storage storage = new Storage();
                storage.setStorage_id(resultSet.getInt("storage_id"));
                storage.setBook_id(resultSet.getInt("book_id"));
                storage.setBook_count(resultSet.getInt("book_count"));
                storage.setStorage_country_id(resultSet.getInt("storage_country_id"));
                storage.setStorage_city_id(resultSet.getInt ("storage_city_id"));
                storage.setStorage_street(resultSet.getString("storage_street"));
                storage.setStorage_house_number(resultSet.getString("storage_house_number"));
                storage.setStorage_flat_number(resultSet.getString("storage_flat_number"));


                storageArrayList.add(storage);
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
        return storageArrayList;
    }

    @Override
    public Storage getById( Integer id ) throws SQLException {

        String sql = "SELECT storage_id, book_count FROM Storage WHERE storage_id=?";

        Storage storage = new Storage();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            storage.setStorage_id(resultSet.getInt("storage_id"));
            storage.setBook_count(resultSet.getInt("book_count"));

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
        return storage;
    }

    @Override
    public void update( Storage storage ) throws SQLException {

        String sql = "UPDATE Storage SET book_count=? WHERE storage_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, storage.getStorage_id());
            preparedStatement.setInt(2, storage.getBook_count());
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
    public void remove( Storage storage ) throws SQLException {

        String sql = "DELETE FROM Storage WHERE storage_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, storage.getStorage_id());

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
