package dao1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import entity.Books;

public class BooksService implements BooksDao {

    Connection connection = ConnectionManager.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    private Statement statement = null;


    @Override
    public void add( Books books ) throws SQLException {

        String sql = "INSERT INTO Books (book_id, author_id, publishing_house_id, count_of_pages, book_price,book_title,book_ISBN,book_hide,book_genre,year_of_publishing) VALUES(?, ?, ?, ?, ?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, books.getBook_id());
            preparedStatement.setInt(2, books.getAuthor_id());
            preparedStatement.setInt(3, books.getPublishing_house_id());
            preparedStatement.setString(4, books.getBook_genre());
            preparedStatement.setDate(5, (Date) books.getYear_of_publishing());
            preparedStatement.setBigDecimal(6, books.getBook_price());
            preparedStatement.setString(7, books.getBook_title());
            preparedStatement.setString(8, String.valueOf(books.getBook_ISBN()));
            preparedStatement.setBoolean(9,books.isBook_hide());
            preparedStatement.setInt(10, books.getCount_of_pages());
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
    public List<Books> getAll() throws SQLException {

        List<Books> booksList = new ArrayList<>();

        String sql = "SELECT book_id, author_id, publishing_house_id, count_of_pages, book_price,book_title,book_ISBN,book_hide,book_genre,year_of_publishing FROM Books";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Books books = new Books();
                books.setBook_id(resultSet.getInt("book_id"));
                books.setAuthor_id(resultSet.getInt("author_id"));
                books.setPublishing_house_id(resultSet.getInt("publishing_house_id"));
                books.setBook_genre(resultSet.getString("book_genre"));
                books.setYear_of_publishing(resultSet.getDate ("year_of_publishing"));
                books.setBook_price(resultSet.getBigDecimal("book_price"));
                books.setBook_title(resultSet.getString("book_title"));
                books.setBook_ISBN(resultSet.getString("book_ISBN"));
                books.setBook_hide(resultSet.getBoolean("book_hide"));
                books.setCount_of_pages(resultSet.getInt("count_of_pages"));

                booksList.add(books);
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
    public Books getById( Integer id) throws SQLException {


        String sql = "SELECT book_id, author_id, publishing_house_id, count_of_pages, book_price,book_title,book_ISBN,book_hide,book_genre,year_of_publishing FROM Books WHERE book_id=?";

        Books books = new Books();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            books.setBook_id(resultSet.getInt("book_id"));
            books.setAuthor_id(resultSet.getInt("author_id"));
            books.setPublishing_house_id(resultSet.getInt("publishing_house_id"));
            books.setBook_genre(resultSet.getString("book_genre"));
            books.setYear_of_publishing(resultSet.getDate ("year_of_publishing"));
            books.setBook_price(resultSet.getBigDecimal("book_price"));
            books.setBook_title(resultSet.getString("book_title"));
            books.setBook_ISBN(resultSet.getString("book_ISBN"));
            books.setBook_hide(resultSet.getBoolean("book_hide"));
            books.setCount_of_pages(resultSet.getInt("count_of_pages"));

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
        return books;
    }

    @Override
    public void update( Books books) throws SQLException {


        String sql = "UPDATE Books SET book_title=? WHERE book_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, books.getBook_id());
            preparedStatement.setString(2, books.getBook_title());
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
    public void remove( Books books) throws SQLException {


        String sql = "DELETE FROM Books WHERE book_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, books.getBook_id());

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
