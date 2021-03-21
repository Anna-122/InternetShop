package dao1;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import entity.Countries;


public class CountriesService implements CountriesDao {



    @Override
    public void add( Countries countries ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO Countries (country_id, country) VALUES(?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, countries.getCountry_id());
            preparedStatement.setString(2, countries.getCountry());
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
    public List<Countries> getAll() throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        List<Countries> countriesArrayList = new ArrayList<>();

        String sql = "SELECT `country_id`, `country` FROM `Countries`";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Countries address = new Countries();
                address.setCountry_id(resultSet.getInt("country_id"));
                address.setCountry(resultSet.getString("country"));

                countriesArrayList.add(address);
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
        System.out.println(countriesArrayList);
        return countriesArrayList;
    }

    @Override
    public Countries getById( Integer id ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT country_id, country FROM Countries WHERE country_id=?";

        Countries countries = new Countries();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            countries.setCountry_id(resultSet.getInt("country_id"));
            countries.setCountry(resultSet.getString("country"));
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
        return countries;
    }

    @Override
    public void update( Countries countries ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Countries SET country=? WHERE country_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, countries.getCountry_id());
            preparedStatement.setString(2, countries.getCountry());
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
    public void remove( Countries countries ) throws SQLException {

        Connection connection = ConnectionManager.getInstance().getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM Countries WHERE country_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, countries.getCountry_id());

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
        }
        ConnectionManager.getInstance().releaseConnection(connection);
    }


    public static void main( String[] args ) throws SQLException {

        CountriesService countriesService = new CountriesService();
        countriesService.getAll();



    }
}

