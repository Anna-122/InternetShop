package dao1;

import entity.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {

    //create
    void add( Author author) throws SQLException;

    //read
    List<Author> getAll() throws SQLException;

    Author getById( Integer id) throws SQLException;

    //update
    void update( Author author) throws SQLException;

    //delete
    void remove( Author author) throws SQLException;
}
