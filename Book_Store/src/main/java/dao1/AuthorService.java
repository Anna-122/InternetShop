package dao1;

import connection.ConnectionManager;
import entity.Author;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorService implements AuthorDao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;


    @Override
    public void add( Author author ) throws SQLException {

        String sql = "INSERT INTO Author (author_id,author_name, author_surname," +
                "author_middle_name,author_birthday_date) VALUES(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, author.getAuthor_id());
            preparedStatement.setString(2, author.getAuthor_name());
            preparedStatement.setString(3, author.getAuthor_surname());
            preparedStatement.setString(4, author.getAuthor_middle_name());
            preparedStatement.setDate(5, (Date) author.getAuthor_birthday_date());

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
    public List<Author> getAll() throws SQLException {

        List<Author> booksList = new ArrayList<>();

        String sql = "SELECT author_id,author_name, author_surname,\" +\n" +
                " \"author_middle_name,author_birthday_date FROM Author";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Author author = new Author();
                author.setAuthor_id(resultSet.getInt("author_id"));
                author.setAuthor_name(resultSet.getString("author_name"));
                author.setAuthor_surname(resultSet.getString("author_surname"));
                author.setAuthor_middle_name(resultSet.getString("author_middle_name"));
                author.setAuthor_birthday_date(resultSet.getDate("author_birthday_date"));
                booksList.add(author);
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
        return booksList;
    }

    @Override
    public Author getById( Integer id ) throws SQLException {
        String sql = "SELECT author_id, author_surname FROM Author WHERE author_id=?";

        Author author = new Author();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            author.setAuthor_id(resultSet.getInt("author_id"));
            author.setAuthor_surname(resultSet.getString("author_surname"));

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
        return author;
    }

    @Override
    public void update( Author author ) throws SQLException {

        String sql = "UPDATE Author SET author_surname=? WHERE author_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, author.getAuthor_id());
            preparedStatement.setString(2, author.getAuthor_surname());
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
    public void remove( Author author ) throws SQLException {

        String sql = "DELETE FROM Author WHERE author_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, author.getAuthor_id());

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
