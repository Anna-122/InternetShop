package dao1;

import connection.ConnectionManager;
import entity.PublishingHouse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublishingHouseService implements PublishingHouse_Dao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;


    @Override
    public void add( PublishingHouse house ) throws SQLException {

        String sql = "INSERT INTO PublishingHouse (publishing_house_id, publishing_house_name," +
                " publishing_house_phone_number, publishing_house_country_id, " +
                "publishing_house_city_id,publishing_house_street,publishing_house_number," +
                "publishing_flat_number,publishing_house_postcode) VALUES(?, ?, ?, ?, ?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, house.getPublishing_house_id());
            preparedStatement.setString(2, house.getPublishing_house_name());
            preparedStatement.setInt(3, house.getPublishing_house_phone_number());
            preparedStatement.setInt(4, house.getPublishing_house_country_id());
            preparedStatement.setInt(5, house.getPublishing_house_city_id());
            preparedStatement.setString(6, house.getPublishing_house_street());
            preparedStatement.setString(7, house.getPublishing_house_number());
            preparedStatement.setString(8, String.valueOf(house.getPublishing_flat_number()));
            preparedStatement.setInt(9, house.getPublishing_house_postcode());
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
    public List<PublishingHouse> getAll() throws SQLException {

        List<PublishingHouse> houseArrayListList = new ArrayList<>();

        String sql = "SELECT publishing_house_id, publishing_house_name,\" +\n" +
                "\" publishing_house_phone_number, publishing_house_country_id, \" +\n" +
                "\"publishing_house_city_id,publishing_house_street,publishing_house_number,\" +\n" +
                "\"publishing_flat_number,publishing_house_postcode FROM PublishingHouse";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                PublishingHouse house = new PublishingHouse();
                house.setPublishing_house_id(resultSet.getInt("publishing_house_id"));
                house.setPublishing_house_name(resultSet.getString("publishing_house_name"));
                house.setPublishing_house_phone_number(resultSet.getInt("publishing_house_phone_number"));
                house.setPublishing_house_country_id(resultSet.getInt("publishing_house_country_id"));
                house.setPublishing_house_city_id(resultSet.getInt("publishing_house_city_id"));
                house.setPublishing_house_street(resultSet.getString("publishing_house_street"));
                house.setPublishing_house_number(resultSet.getString("publishing_house_number"));
                house.setPublishing_flat_number(resultSet.getString("publishing_flat_number"));
                house.setPublishing_house_postcode(resultSet.getInt("publishing_house_postcode"));
                houseArrayListList.add(house);
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
        return houseArrayListList;
    }

    @Override
    public PublishingHouse getById( Integer id ) throws SQLException {

        String sql = "SELECT publishing_house_id, publishing_house_name FROM PublishingHouse WHERE publishing_house_id=?";

        PublishingHouse house = new PublishingHouse();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            house.setPublishing_house_id(resultSet.getInt("publishing_house_id"));
            house.setPublishing_house_name(resultSet.getString("publishing_house_name"));

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
        return house;
    }

    @Override
    public void update( PublishingHouse house ) throws SQLException {

        String sql = "UPDATE PublishingHouse SET publishing_house_name=? WHERE publishing_house_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, house.getPublishing_house_id());
            preparedStatement.setString(2, house.getPublishing_house_name());
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
    public void remove( PublishingHouse house ) throws SQLException {

        String sql = "DELETE FROM PublishingHouse WHERE publishing_house_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, house.getPublishing_house_id());

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
