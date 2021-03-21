package dao1;

import entity.PublishingHouse;

import java.sql.SQLException;
import java.util.List;

public interface PublishingHouse_Dao {
    //create
    void add( PublishingHouse house) throws SQLException;

    //read
    List<PublishingHouse> getAll() throws SQLException;

    PublishingHouse getById( Integer id) throws SQLException;

    //update
    void update( PublishingHouse house) throws SQLException;

    //delete
    void remove( PublishingHouse house) throws SQLException;
}

