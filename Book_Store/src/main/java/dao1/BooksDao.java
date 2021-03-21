package dao1;

import entity.Books;

import java.sql.SQLException;
import java.util.List;

public interface BooksDao {

    //create
    void add( Books books) throws SQLException;

    //read
    List<entity.Books> getAll() throws SQLException;

    entity.Books getById( Integer id) throws SQLException;

    //update
    void update( Books books) throws SQLException;

    //delete
    void remove( Books books) throws SQLException;

}
