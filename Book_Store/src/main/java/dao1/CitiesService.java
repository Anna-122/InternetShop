package dao1;

import connection.ConnectionManager;
import entity.Cities;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CitiesService implements CitiesDao{


    @Override
    public void add( Cities cities ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO Cities (city_id,country_id, city) VALUES(?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, cities.getCity_id());
            preparedStatement.setInt(2, cities.getCountry_id());
            preparedStatement.setString(3, cities.getCity());

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
    public List<Cities> getAll() throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        List<Cities> citiesArrayList = new ArrayList<>();

        String sql = "SELECT `city_id`, `country_id`,`city` FROM `Cities`";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cities cities = new Cities();
                cities.setCity_id(resultSet.getInt("city_id"));
                cities.setCountry_id(resultSet.getInt("country_id"));
                cities.setCity(resultSet.getString("city"));

                citiesArrayList.add(cities);
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
        System.out.println(citiesArrayList);
        return citiesArrayList;

    }

    @Override
    public Cities getById( Integer id ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT city_id, city FROM Cities WHERE city_id=?";

        Cities cities = new Cities();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            cities.setCity_id(resultSet.getInt("city_id"));
            cities.setCity(resultSet.getString("city"));

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
        return cities;
    }

    @Override
    public void update( Cities cities ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Cities SET city=? WHERE city_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cities.getCity_id());
            preparedStatement.setString(2, cities.getCity());
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
    public void remove( Cities cities ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM Cities WHERE city_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, cities.getCity_id());

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

    public static void main( String[] args ) {


        CitiesService citiesService = new CitiesService();
        try {
            citiesService.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}


//    InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream("properties/jdbc.properties");
//            PROPERTIES.load(inputStream);