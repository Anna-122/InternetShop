package dao1;

import entity.Countries;

import java.sql.SQLException;
import java.util.List;

public interface CountriesDao {
    //create
    void add( Countries countries) throws SQLException;

    //read
    List<Countries> getAll() throws SQLException;

    Countries getById( Integer id) throws SQLException;

    //update
    void update( Countries countries) throws SQLException;

    //delete
    void remove( Countries countries) throws SQLException;
}
