package dao1;

import entity.Cities;


import java.sql.SQLException;
import java.util.List;

public interface CitiesDao {

    //create
    void add( Cities cities) throws SQLException;

    //read
    List<Cities> getAll() throws SQLException;

    Cities getById( Integer id) throws SQLException;

    //update
    void update( Cities cities) throws SQLException;

    //delete
    void remove( Cities cities) throws SQLException;
}
