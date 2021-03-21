package dao1;

import connection.ConnectionManager;
import entity.Purchase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseService implements PurchaseDao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;

    @Override
    public void add( Purchase purchase ) throws SQLException {
        String sql = "INSERT INTO Purchase (purchase_id, book_id, user_id, purchase_adding," +
                " purchase_deleting,book_count,book_price,book_deleted,book_paid) VALUES( ?, ?, ?, ?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, purchase.getPurchase_id());
            preparedStatement.setInt(2, purchase.getBook_id());
            preparedStatement.setInt(3, purchase.getUser_id());
            preparedStatement.setDate(4, (Date) purchase.getPurchase_adding());
            preparedStatement.setDate(5, (Date) purchase.getPurchase_deleting());
            preparedStatement.setBigDecimal(6, purchase.getBook_price());
            preparedStatement.setInt(7, purchase.getBook_count());
            preparedStatement.setBoolean(8,purchase.isBook_deleted());
            preparedStatement.setBoolean(19, purchase.isBook_paid());
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
    public List<Purchase> getAll() throws SQLException {

        List<Purchase> purchaseArrayList = new ArrayList<>();
        String sql = "SELECT purchase_id, book_id, user_id, purchase_adding,\" +\n" +
                " \" purchase_deleting,book_count,book_price,book_deleted,book_paid FROM `Purchase`";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Purchase purchase = new Purchase();
                purchase.setPurchase_id(resultSet.getInt("purchase_id"));
                purchase.setBook_id(resultSet.getInt("book_id"));
                purchase.setUser_id(resultSet.getInt("user_id"));
                purchase.setPurchase_adding(resultSet.getDate("purchase_adding"));
                purchase.setPurchase_deleting(resultSet.getDate("purchase_deleting"));
                purchase.setBook_count(resultSet.getInt("book_count"));
                purchase.setBook_price(resultSet.getBigDecimal("book_price"));
                purchase.setBook_deleted(resultSet.getBoolean("book_deleted"));
                purchase.setBook_paid(resultSet.getBoolean("book_paid"));
                purchaseArrayList.add(purchase);
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
        System.out.println(purchaseArrayList);
        return purchaseArrayList;
    }

    @Override
    public Purchase getById( Integer id ) throws SQLException {

        String sql = "SELECT purchase_id, book_count FROM Cities WHERE purchase_id=?";

        Purchase purchase = new Purchase();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            purchase.setPurchase_id(resultSet.getInt("purchase_id"));
            purchase.setBook_id(resultSet.getInt("book_count"));

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
        return purchase;
    }

    @Override
    public void update( Purchase purchase ) throws SQLException {

        String sql = "UPDATE Purchase SET book_id=? WHERE purchase_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, purchase.getPurchase_id());
            preparedStatement.setInt(2, purchase.getBook_id());
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
    public void remove( Purchase purchase ) throws SQLException {
        String sql = "DELETE FROM Purchase WHERE purchase_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, purchase.getPurchase_id());

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
